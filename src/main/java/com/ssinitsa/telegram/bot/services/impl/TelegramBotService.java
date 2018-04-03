package com.ssinitsa.telegram.bot.services.impl;

import com.ssinitsa.telegram.bot.entity.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Setter
public class TelegramBotService extends TelegramLongPollingBot {

    private String botName;
    private String token;
    private static final String NEXT_BUTTON = "Продолжить".toUpperCase();
    private static final String START_BUTTON = "Начать тест".toUpperCase();
    private static final String TRY_AGAIN_BUTTON = "Пройти тест заново".toUpperCase();

    private StudentService studentService;
    private TgMessageService tgMessageService;
    private ResultService resultService;
    private QuestionService questionService;
    private BotService botService;
    private MaterialsService materialsService;

    @Override
    public void onUpdateReceived(Update update) {
        String callerName = update.getMessage().getFrom().getUserName();
        Student student = studentService.findByUsername(callerName);
        if (!hasAccess(student)) {
            log.warn("Попытка подключения неавторизованного пользователя {}", callerName);
            return;
        }
        String request = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        try {
            buildResponse(chatId, student, request);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void buildResponse(long chatId, Student student, String request) throws TelegramApiException {
        switch (request) {
            case ("/start"):
                getHelpMessage(chatId);
                break;
            case ("/help"):
                getHelpMessage(chatId);
                break;
            case ("/test"):
                getCurrentQuestion(chatId, student);
                break;
            case ("/materials"):
                getAllMaterials(chatId, student);
            default:
                processAnswer(chatId, student, request);
        }
    }

    private void processAnswer(long chatId, Student student, String request) throws TelegramApiException {
        List<Answer> expectedAnswers = student.getCurrentQuestion().getAnswers();
        List<String> buttons = expectedAnswers.stream()
                .map(Answer::getButton)
                .collect(Collectors.toList());
        if (!buttons.contains(request)) return;
        SendMessage sendMessage = new SendMessage(chatId, "Нажмите кнопку чтобы продолжить...");
        sendMessage = setButtons(sendMessage, Collections.singletonList(NEXT_BUTTON));
        Result result = new Result();
        for (Answer answer : expectedAnswers) {
            if (request.equals(answer.getButton())) {
                result.setStudent(student);
                result.setAnswer(answer);
                result.setQuestion(student.getCurrentQuestion());
                resultService.save(result);
            }
        }
        sendMessage(sendMessage);
        student.setCurrentQuestion(questionService.nextQuestion(student.getCurrentQuestion(), student.getCurrentTest()));
        getCurrentQuestion(chatId, student);
    }

    private void getAllMaterials(long chatId, Student student) throws TelegramApiException {
        List<Question> allQuestions = student.getCurrentTest().getQuestions();
        Question currentQuestion = student.getCurrentQuestion();
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        List<Question> materialsQuestions = allQuestions.stream()
                .filter(question -> question.getType().equals(QuestionType.MATERIALS))
                .filter(question -> question.getNumber() <= currentQuestion.getNumber())
                .collect(Collectors.toList());
        for (Question question : materialsQuestions) {
            question.getMaterials()
                    .forEach(materials -> sendDocument.setNewDocument(materials.getTitle(), new ByteArrayInputStream(materials.getFile())));
        }
        sendDocument(sendDocument);
    }

    private void getCurrentQuestion(long chatId, Student student) throws TelegramApiException {
        Question currentQuestion = student.getCurrentQuestion();
        if (currentQuestion.getType().equals(QuestionType.MATERIALS)) {
            buildMaterials(chatId, currentQuestion);
        } else {
            buildTest(chatId, currentQuestion);
        }
    }

    private void buildTest(long chatId, Question currentQuestion) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage(chatId, currentQuestion.getText());
        List<String> buttons = currentQuestion.getAnswers().stream().map(Answer::getButton).collect(Collectors.toList());
        sendMessage = setButtons(sendMessage, buttons);
        sendMessage(sendMessage);
        if (currentQuestion.getAttachment() == null) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setNewPhoto(currentQuestion.getAttachment().getTitle(),
                    new ByteArrayInputStream(currentQuestion.getAttachment().getFile()));
            sendPhoto(sendPhoto);
        }
    }

    private void buildMaterials(long chatId, Question currentQuestion) throws TelegramApiException {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        for (Materials materials : currentQuestion.getMaterials()) {
            sendDocument.setNewDocument(materials.getTitle(), new ByteArrayInputStream(materials.getFile()));
        }
        sendDocument(sendDocument);
        sendMessage(new SendMessage(chatId, currentQuestion.getText()));
    }

    private SendMessage getHelpMessage(long chatId) {
        String message = tgMessageService.getHelpMessage();
        return new SendMessage(chatId, message);
    }

    private boolean hasAccess(Student student) {
        return student != null;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public String getBotUsername() {
        return this.botName;
    }

    public SendMessage setButtons(SendMessage sendMessage, List<String> buttons) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        for (String button : buttons) {
            KeyboardButton keyboardButton = new KeyboardButton();
            row.add(new KeyboardButton(button));
            keyboard.add(row);
        }
        replyKeyboardMarkup.setKeyboard(keyboard);
        return sendMessage;
    }
}
