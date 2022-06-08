package com.nhnacademy.noticeboard.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name = "comment_no")
    private long commentId;

    @ManyToOne
    @JoinColumn(name = "post_no", referencedColumnName = "post_no")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    private String comment;

    private Date createDate;

}
