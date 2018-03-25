package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table
@Entity
public class Bot extends AbstractEntity {

    @Column (unique = true, nullable = false)
    private String name;

    @OneToMany
    private List<Step> steps;

}
