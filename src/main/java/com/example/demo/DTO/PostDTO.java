package com.example.demo.DTO;

import com.example.demo.entity.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class PostDTO {
    private long id;
    private String title;
    private String content;
    @Builder
    public PostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
