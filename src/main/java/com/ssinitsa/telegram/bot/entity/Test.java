package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Test extends AbstractEntity {

    @Column
    private String title;

    @OneToMany
    private List<Question> questions;

    @Column
    private Integer passingScore;

}
