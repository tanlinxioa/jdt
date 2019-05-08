package com.facebook.jdt.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_info")
@IdClass(UserInfoPk.class)
public class UserInfo implements Serializable {

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "password")
    private String password;

}
