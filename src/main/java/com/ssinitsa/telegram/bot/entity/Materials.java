package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Materials extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private MaterialsGroup group;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    private String image;

    @Column
    private String video;

}
