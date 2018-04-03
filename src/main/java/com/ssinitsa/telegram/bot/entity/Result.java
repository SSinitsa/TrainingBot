package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Result extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Question question;

    @ManyToMany
    private List<Answer> answer;

    @ManyToOne
    @JoinColumn
    private Student student;

}
