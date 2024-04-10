package com.busanit.repository;

import com.busanit.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findByIdx(Long idx);

    List<Blog> findAllByOrderByIdxDesc();

    List<Blog> findByTitleContainingOrderByIdxDesc(String keyword);
    List<Blog> findByContentContainingOrderByIdxDesc(String keyword);
}
