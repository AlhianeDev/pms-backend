package com.global.pmsbackend.services;

import com.global.pmsbackend.dto.PostDto;

import com.global.pmsbackend.exceptions.ResourceNotFoundException;

import com.global.pmsbackend.mapper.PostMapper;

import com.global.pmsbackend.model.Post;

import com.global.pmsbackend.repositories.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public Post getPost(Integer postId) {

        Post post = new Post();

        Optional<Post> findPost = postRepo.findById(postId);

        if (findPost.isEmpty()) {

            throw new ResourceNotFoundException(

                404, "Unable to find post with given post id :" + postId

            );

        }

        return findPost.get();

    }

    public List<Post> allPosts() {

        return postRepo.findAll();

    }

    public Post createPost(PostDto postDto) {

        return postRepo.save(PostMapper.mapToEntity(postDto));

    }

    public void deletePost(Integer postId) {

        Optional<Post> findPost = postRepo.findById(postId);

        if (findPost.isPresent()) {

            postRepo.deleteById(postId);

        } else {

            throw new ResourceNotFoundException(

                404, "Unable to find post with given post id :"+ postId

            );

        }

    }

}
