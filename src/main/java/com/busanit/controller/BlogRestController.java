package com.busanit.controller;

import com.busanit.domain.BlogDTO;
import com.busanit.domain.BlogReplyDTO;
import com.busanit.entity.BlogReply;
import com.busanit.repository.BlogReplyRepository;
import com.busanit.repository.BlogRepository;
import com.busanit.service.BlogReplyService;
import com.busanit.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogRestController {

    private final BlogService blogService;
    private final BlogReplyService blogReplyService;


    // 프론트에서 params로 넘긴 내용을 @RequestParam로 받아 if문의 조회 기준으로 사용
    @GetMapping("/list")
    public List<BlogDTO> getBlogList(
            @RequestParam(defaultValue = "") String searchType,
            @RequestParam(defaultValue = "") String keyword)
    {
        List<BlogDTO> blogDTOList = null;

        if(searchType.equals("title") && !"".equals(keyword)) {
            blogDTOList = blogService.getBlogTitleList(keyword);
        } else if(searchType.equals("content") && !"".equals(keyword)) {
            blogDTOList = blogService.getBlogContentList(keyword);
        } else {
            blogDTOList = blogService.getBlogList();
        }

        return blogDTOList;
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
        Long RIdx = blogReplyService.writeBlogReply(replyDTO);

        return RIdx;
    }

    @GetMapping("/replyList/{idx}")
    public List<BlogReplyDTO> getBlogReplyList(@PathVariable Long idx) {
        List<BlogReplyDTO> list = blogReplyService.getBlogReplyList(idx);
        return list;

    }

    @GetMapping("/replyDelete/{rIdx}")
    public void deleteBlogReply(@PathVariable("rIdx") Long rIdx) {
        blogReplyService.deleteBlogReply(rIdx);
    }





}
