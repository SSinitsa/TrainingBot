package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Question extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Test test;

    @Column
    private String title;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Column
    private int number;

    @Column
    private String video;

    @Column
    private String image;

    @ManyToOne
    @JoinColumn
    private TGMessage rightMessage;

    @ManyToOne
    @JoinColumn
    private TGMessage wrongMessage;

    @OneToMany
    private List<Answer> answers;

}
