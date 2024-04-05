package com.busanit.controller;

import com.busanit.domain.BlogDTO;
import com.busanit.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogRestController {

    private final BlogService blogService;

    @GetMapping("/list")
    public List<BlogDTO> getBlogList() {
        return blogService.getBlogList();
    }

    @GetMapping("/get/{idx}")
    public BlogDTO getBlog(@PathVariable("idx") Long idx) {
        return blogService.getBlog(idx);
    }

    @PostMapping("/write")
    public void writeBlog(@RequestBody BlogDTO blogDTO) {
        blogService.writeBlog(blogDTO);
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



}
