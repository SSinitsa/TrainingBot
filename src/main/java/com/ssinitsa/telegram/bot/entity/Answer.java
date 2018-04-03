package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name="answer")
@Entity
public class Answer extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Question question;

    @Column
    private Boolean correct;

    @Column
    private String button;

    @Column
    private String value;

    @Column
    private Integer score;

}
