package com.global.pmsbackend.repositories;

import com.global.pmsbackend.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
