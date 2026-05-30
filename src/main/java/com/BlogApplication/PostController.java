package com.BlogApplication;

import com.BlogApplication.entity.Post;
import com.BlogApplication.service.PostService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
  public ResponseEntity<?> createPost(@RequestBody Post post){
      return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
  }

  //http://localhost:8080/api/post/all
  @GetMapping("/all")
  public List<Post>getAllPost(){
        return postService.getAllPost();
  }

//http://localhost:8080/api/post/id
  @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
    return new ResponseEntity<>("Post is deleted By the:"+id,HttpStatus.OK);
  }

  @PutMapping("/{id}")
    public ResponseEntity<Post>updatePostById(@PathVariable long id,@RequestBody Post post){
      Post post1 = postService.updatePostById(id, post);
      return new ResponseEntity<>(post1,HttpStatus.OK);

    // this is the comment123
    }
}