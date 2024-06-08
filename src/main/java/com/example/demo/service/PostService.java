package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post createPost(Long userId, Post post) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(post::setUser);
        return postRepository.save(post);

    }
}
