package com.busanit.service;

import com.busanit.domain.BlogReplyDTO;
import com.busanit.entity.BlogReply;
import com.busanit.repository.BlogReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogReplyService {

    private final BlogReplyRepository blogReplyRepository;

    public Long writeBlogReply(BlogReplyDTO replyDTO) {
        BlogReply blogReply = BlogReply.toEntity(replyDTO);
        blogReplyRepository.save(blogReply);
        return blogReply.getRIdx();
    }

    public List<BlogReplyDTO> getBlogReplyList(Long idx) {
        List<BlogReply> blogReplyList = blogReplyRepository.findByBlog_Idx(idx);
        return blogReplyList.stream().map(blogReply -> BlogReplyDTO.toDTO(blogReply)).collect(Collectors.toList());
    }

    public void deleteBlogReply(Long rIdx) {
        blogReplyRepository.deleteById(rIdx);
    }
}
