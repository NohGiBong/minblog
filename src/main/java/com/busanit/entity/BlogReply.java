package com.busanit.entity;

import com.busanit.domain.BlogDTO;
import com.busanit.domain.BlogReplyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
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
    public static BlogReply toEntity(BlogReplyDTO replyDTO) {
        Blog blog = Blog.builder().idx(replyDTO.getIdx()).build();

        BlogReply blogReply = BlogReply.builder()
                .rIdx(replyDTO.getRIdx())
                .content(replyDTO.getContent())
                .blog(blog)
                .build();

        return blogReply;
    }
}
