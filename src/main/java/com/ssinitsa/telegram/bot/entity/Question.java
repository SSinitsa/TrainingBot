package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @Column
    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private List<Materials> materials;

    @Column
    private int number;

    @ManyToOne
    @JoinColumn
    private Materials attachment;

    @OneToMany
    private List<Answer> answers;

}
