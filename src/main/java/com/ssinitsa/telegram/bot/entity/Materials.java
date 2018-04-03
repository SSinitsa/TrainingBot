package com.ssinitsa.telegram.bot.entity;

import com.mysql.cj.jdbc.Blob;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Materials extends AbstractEntity {

    @Column
    private String title;

    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] file;

}
