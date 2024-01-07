package com.global.pmsbackend.resolvers;

import com.global.pmsbackend.dto.PostDto;

import com.global.pmsbackend.model.Post;

import com.global.pmsbackend.services.PostService;

import graphql.kickstart.tools.GraphQLMutationResolver;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMutationResolver implements GraphQLMutationResolver {

    private final PostService postService;

    public Post createPost(PostDto postDto) {

        return postService.createPost(postDto);

    }

    public void deletePost(Integer postId) {

        postService.deletePost(postId);

    }

}
