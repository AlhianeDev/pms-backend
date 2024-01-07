package com.global.pmsbackend.repositories;

import com.global.pmsbackend.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
}
