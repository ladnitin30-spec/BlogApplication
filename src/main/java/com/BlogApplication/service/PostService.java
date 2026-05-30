package com.BlogApplication.service;

import com.BlogApplication.entity.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    public Post createPost(Post post);

    public List<Post> getAllPost();

    public void deletePostById(Long id);

   public Post updatePostById(long id,Post post);
}
