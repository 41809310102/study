package com.example.myblog.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
public class Tag {
    @Id
    @GeneratedValue
    private  Long id;
    @NotBlank(message = "分类名称不能为空！")
    private  String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
