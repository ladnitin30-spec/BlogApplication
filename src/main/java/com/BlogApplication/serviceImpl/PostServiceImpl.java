package com.BlogApplication.serviceImpl;

import com.BlogApplication.entity.Post;
import com.BlogApplication.repository.PostRepository;
import com.BlogApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
      private  PostRepository postRepository;
    @Override
    public Post createPost(Post post) {
        Post savepost = postRepository.save(post);
        return savepost;
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public Post updatePostById(long id, Post post) {
        Post existpost = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post Is not found for the Id"));

    existpost.setContent(post.getContent());
    existpost.setTitle(post.getTitle());
        Post savedPost = postRepository.save(existpost);
    return savedPost;
    }
}
