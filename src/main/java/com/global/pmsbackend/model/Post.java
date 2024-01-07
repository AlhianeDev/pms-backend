package com.global.pmsbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String content;

    @JsonProperty("noOfLikes")
    private int noOfLikes;

    @JsonProperty("isDisplay")
    private boolean isDisplay;

    @OneToMany(

        cascade = CascadeType.ALL,

        orphanRemoval = true,

        fetch = FetchType.EAGER

    )
    @JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();

}
