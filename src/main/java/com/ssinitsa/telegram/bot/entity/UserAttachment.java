package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name ="user_attachment")
@Entity
public class UserAttachment extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private Step step;

    @Column
    private String text;

    @Column
    private String video;

    @Column
    private String image;

}
