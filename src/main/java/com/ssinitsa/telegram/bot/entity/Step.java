package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Step extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Bot bot;

    @Enumerated(EnumType.STRING)
    private StepType type;

    @ManyToOne
    @JoinColumn
    private Test test;

    @ManyToOne
    @JoinColumn
    private MaterialsGroup materialsGroup;

    @ManyToOne
    @JoinColumn
    private TGMessage tgMessage;

}
