package com.busanit.controller;

import com.busanit.domain.BlogDTO;
import com.busanit.domain.BlogReplyDTO;
import com.busanit.entity.BlogReply;
import com.busanit.service.BlogReplyService;
import com.busanit.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogRestController {

    private final BlogService blogService;
    private final BlogReplyService blogReplyService;

    @GetMapping("/list")
    public List<BlogDTO> getBlogList() {
        return blogService.getBlogList();
    }

    @GetMapping("/get/{idx}")
    public BlogDTO getBlog(@PathVariable("idx") Long idx) {
        return blogService.getBlog(idx);
    }

    @GetMapping("/edit/{idx}")
    public BlogDTO editBlog(@PathVariable("idx") Long idx) {
        return blogService.getBlog(idx);
    }

    @PostMapping("/edit/{idx}")
    public void editBlog(@RequestBody BlogDTO blogDTO) {
        blogService.writeBlog(blogDTO);
    }

    @GetMapping("/delete/{idx}")
    public void deleteBlog(@PathVariable Long idx) {
        blogService.deleteBlog(idx);
    }

    @PostMapping("/write")
    public void writeBlog(@RequestBody BlogDTO blogDTO) {
        blogService.writeBlog(blogDTO);
    }

    @PostMapping("/replyWrite")
    public Long writeBlogReply(@RequestBody BlogReplyDTO replyDTO) {
        Long rIdx = blogReplyService.writeBlogReply(replyDTO);

        return rIdx;
    }

    @GetMapping(value ="/reply/list/{idx}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BlogReplyDTO> getBlogReplyList(
            @PathVariable("idx") Long idx) {
        return blogReplyService.getBlogReplyList(idx);
    }

}
