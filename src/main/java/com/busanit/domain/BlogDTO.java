package com.busanit.domain;

import com.busanit.entity.Blog;
import com.busanit.entity.BlogReply;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Long idx;
    private String title;
    private String content;
    private List<BlogReply> blogReplyList;

    // Entity -> DTO 변환
    public static BlogDTO toDTO(Blog blog) {
        return BlogDTO.builder()
                .idx(blog.getIdx())
                .title(blog.getTitle())
                .content(blog.getContent())
                .blogReplyList(blog.getBlogReplyList())
                .build();
    }


}
