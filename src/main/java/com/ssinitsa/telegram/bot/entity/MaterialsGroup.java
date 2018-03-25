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
@Table(name = "materials_group")
@Entity
public class MaterialsGroup extends AbstractEntity{

    @Column
    private String title;

    @OneToMany
    private List<Materials> materials;

}
