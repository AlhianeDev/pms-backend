package com.global.pmsbackend.dto;

import lombok.AllArgsConstructor;

import lombok.Builder;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private String name;

    private String content;

    private int noOfLikes;

    private boolean isDisplay;

}
