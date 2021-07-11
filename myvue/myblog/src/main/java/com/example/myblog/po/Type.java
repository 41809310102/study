package com.example.myblog.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
public class Type {
    @Id
    @GeneratedValue
    private  Long id;
    @NotBlank(message = "分类名称不能为空！")
    private String name;

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
