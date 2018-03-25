package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Student extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String tgUsername;

    @Column(unique = true)
    private Long tgId;

    @OneToMany
    private List<Step> steps;

    @ManyToOne
    @JoinColumn
    private Step currentStep;

    @OneToMany
    private List<Bot> bots;

    @Column
    private Timestamp visited;

    @OneToMany
    private List<UserAttachment> attachments;

}
