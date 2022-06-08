package com.nhnacademy.noticeboard.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    @EmbeddedId
    private Like.Pk pk;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

    @MapsId("postId")
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_no")
    private Post post;

    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    public static class Pk implements Serializable {

        private String id;

        private long postId;
    }
}
