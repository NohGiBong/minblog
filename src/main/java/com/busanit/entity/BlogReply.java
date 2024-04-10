package com.busanit.entity;

import com.busanit.domain.BlogReplyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rIdx;

    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_idx")
    private Blog blog;

    // DTO -> Entity
    public static BlogReply toEntity(BlogReplyDTO blogReplyDTO) {
        Blog blog = Blog.builder().idx(blogReplyDTO.getBlog_idx()).build();

        BlogReply blogReply = BlogReply.builder()
                .rIdx(blogReplyDTO.getRIdx())
                .content(blogReplyDTO.getContent())
                .blog(blog)
                .build();

        return blogReply;
    }
}
