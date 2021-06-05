package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

//数据库使用，前后端ajax，session保存时基于对象和二进制数据转换（这里要实现串行化接口）
@Getter
@Setter
@ToString
public class User extends Response implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer userId;
    private String name;
    private String password;
    private String iconPath;
    private String signature;
    private java.util.Date lastLogout;

}
