package com.example.demo.controller;

import com.example.demo.DTO.PostDTO;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final PostService postService;
    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        List<PostDTO> postDTOs = posts.stream().map(post -> PostDTO.builder().post(post).build()).toList();
        return ResponseEntity.ok(postDTOs);
    }
    @PostMapping ("/write")
    public ResponseEntity<PostDTO> createPost(@RequestParam long userId, @RequestBody Post post) {
        Post createdPost = postService.createPost(userId,post);
        return ResponseEntity.ok(PostDTO.builder().post(createdPost).build());
    }
}

