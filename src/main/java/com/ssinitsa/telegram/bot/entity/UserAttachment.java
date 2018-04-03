package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "user_attachment")
@Entity
public class UserAttachment extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    private Question question;

    @Column
    private String text;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany
    private List<Materials> materials;
}
