package com.jiho.board.springbootaws.web.dto.common;

import com.jiho.board.springbootaws.domain.posts.Posts;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class PageInfoDto {
    private int totalPage;
    private int pageSize;
    private int page;

    public PageInfoDto(Page<Posts> pagableEntity) {
        this.totalPage = pagableEntity.getTotalPages();
        this.pageSize = pagableEntity.getSize();
        this.page = pagableEntity.getPageable().getPageNumber();
    }

}
