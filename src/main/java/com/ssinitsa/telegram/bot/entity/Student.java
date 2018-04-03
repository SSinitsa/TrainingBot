package com.ssinitsa.telegram.bot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Table
@Entity
public class Student extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private Long tgId;

    @ManyToOne
    @JoinColumn
    private Test currentTest;

    @ManyToOne
    @JoinColumn
    private Question currentQuestion;

    @Column
    private Timestamp visited;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private Set<UserAttachment> attachments;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private Set<Result> results;

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", tgId=" + tgId +
                ", currentTest=" + currentTest +
                ", currentQuestion=" + currentQuestion +
                ", visited=" + visited +
                ", attachments=" + attachments +
                ", results=" + results +
                '}';
    }
}
