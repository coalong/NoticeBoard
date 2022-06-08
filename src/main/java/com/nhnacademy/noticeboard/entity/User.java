package com.nhnacademy.noticeboard.entity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String password;

    private String name;

    @Column(name = "user_separate_code")
    private int userSeparateCode;
}
