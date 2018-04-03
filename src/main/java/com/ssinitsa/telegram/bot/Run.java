package com.ssinitsa.telegram.bot;

import com.ssinitsa.telegram.bot.entity.Materials;
import com.ssinitsa.telegram.bot.entity.MessageType;
import com.ssinitsa.telegram.bot.entity.Student;
import com.ssinitsa.telegram.bot.entity.TgMessage;
import com.ssinitsa.telegram.bot.services.impl.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Run {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        StudentService studentService = context.getBean(StudentService.class);
        TgMessageService messageService = context.getBean(TgMessageService.class);
        MaterialsService materialsService = context.getBean(MaterialsService.class);
        ResultService resultService = context.getBean(ResultService.class);
        QuestionService questionService = context.getBean(QuestionService.class);

        ///////////////////////////////////////

        Student student = new Student();
        student.setUsername("mosskin");
        studentService.save(student);

        //////////////////////////////////////////

        TgMessage tgMessage = new TgMessage();
        tgMessage.setType(MessageType.START);
        tgMessage.setText("Привет!\n Список команд:\n 1 \t 2 \t 3");
        messageService.save(tgMessage);

        /////////////////////////////////////////

        Materials materials = new Materials();
        materials.setTitle("windows");
        Path path = Paths.get("src/main/resources/files/windows.png");
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        materials.setFile(data);
        materialsService.save(materials);

        /////////////////////////////////////////////

        ApiContextInitializer.init();
        TelegramBotService telegramBot = new TelegramBotService();
        telegramBot.setBotName("Mosbot");
        telegramBot.setToken("428691775:AAE4qgM6hScN6YegMUTbEiA9fWaeLseqCmc");
        telegramBot.setStudentService(studentService);
        telegramBot.setTgMessageService(messageService);
        telegramBot.setMaterialsService(materialsService);
        telegramBot.setResultService(resultService);
        telegramBot.setQuestionService(questionService);
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(telegramBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

}
