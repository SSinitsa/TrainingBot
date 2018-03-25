package com.ssinitsa.telegram.bot.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Authority extends AbstractEntity implements GrantedAuthority {

    @Column
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
