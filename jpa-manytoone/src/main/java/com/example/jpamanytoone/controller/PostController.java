package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.exception.ResourceNotFoundException;
import com.example.jpamanytoone.model.Post;
import com.example.jpamanytoone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {

        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

    }

    @PutMapping("/posts/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setContent(postDetails.getContent());
        post.setDescription(postDetails.getDescription());
        post.setTitle(postDetails.getTitle());
        return postRepository.save(post);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {

        return postRepository.findById(id).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

    }
}
