package com.busanit.domain;

import com.busanit.entity.BlogReply;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Slice;

import javax.swing.plaf.PanelUI;

@Getter
@Setter
@Builder
public class BlogReplyDTO {

    private Long rIdx;
    private String content;
    private Long blog_idx; // 게시글 번호


    // Entity -> DTO
    public static BlogReplyDTO toDTO(BlogReply blogReply) {
        BlogReplyDTO dto = BlogReplyDTO.builder()
                .rIdx(blogReply.getRIdx())
                .content(blogReply.getContent())
                .build();

        return dto;
    }
}

