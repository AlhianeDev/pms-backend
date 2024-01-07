package com.global.pmsbackend.resolvers;

import com.global.pmsbackend.model.Post;

import com.global.pmsbackend.services.PostService;

import graphql.kickstart.tools.GraphQLQueryResolver;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostQueryResolver implements GraphQLQueryResolver {

    private final PostService postService;

    public List<Post> allPosts() {

        return postService.allPosts();

    }

    public Post getPost(Integer postId) {

        return postService.getPost(postId);

    }

}
