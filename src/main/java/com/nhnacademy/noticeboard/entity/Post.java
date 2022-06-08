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
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private long postId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    private String title;

    @Column(name = "create_date")
    private Date createDate;

    private long hits;

    private String content;

    @Column(name = "is_inactive", columnDefinition = "default 0")
    private boolean isInactive;

}
