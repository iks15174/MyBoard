package com.jiho.board.springbootaws.web.dto.comments;

import com.jiho.board.springbootaws.domain.comments.Comments;
import com.jiho.board.springbootaws.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private String content;
    private String author;
    private Long postsId;

    @Builder
    public CommentsSaveRequestDto(String content, String author, Long postsId) {
        this.content = content;
        this.author = author;
        this.postsId = postsId;
    }

    public Comments toEntity(Posts posts) {
        return Comments.builder().content(this.content).author(this.author).posts(posts).build();
    }
}
