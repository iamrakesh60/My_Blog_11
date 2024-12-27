package com.myblog.myblog11.service;

import com.myblog.myblog11.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
}
