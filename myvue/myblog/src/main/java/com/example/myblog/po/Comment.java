package com.example.myblog.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String avatar;
    private String contect;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @ManyToOne()
    private Blog blog;
    @OneToMany(mappedBy = "parentcommet")
    private List<Comment> childcomments = new ArrayList<>();
    @ManyToOne()
    private Comment parentcommet;
}
