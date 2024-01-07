package com.global.pmsbackend.mapper;

import com.global.pmsbackend.dto.PostDto;

import com.global.pmsbackend.model.Post;

public class PostMapper {

    public static PostDto mapToDto(Post post) {

        return PostDto.builder()

            .name(post.getName())

            .content(post.getContent())

            .noOfLikes(post.getNoOfLikes())

            .isDisplay(post.isDisplay())

        .build();

    }

    public static Post mapToEntity(PostDto postDto) {

        return Post.builder()

            .name(postDto.getName())

            .content(postDto.getContent())

            .noOfLikes(postDto.getNoOfLikes())

            .isDisplay(postDto.isDisplay())

        .build();

    }

}
