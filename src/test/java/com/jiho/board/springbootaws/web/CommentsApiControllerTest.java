package com.jiho.board.springbootaws.web;

import com.jiho.board.springbootaws.domain.comments.CommentsRepository;
import com.jiho.board.springbootaws.domain.posts.Posts;
import com.jiho.board.springbootaws.domain.posts.PostsRepository;
import com.jiho.board.springbootaws.web.dto.comments.CommentsSaveRequestDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void Comments_등록된다() throws Exception {
        Posts testPosts = postsRepository
                .save(Posts.builder().title("title").content("content").author("author").build());

        String content = "comment content";
        String author = "author";
        Long postsId = testPosts.getId();

        CommentsSaveRequestDto requestDto = CommentsSaveRequestDto.builder().content(content).author(author)
                .postsId(postsId).build();

    }
}
