package com.matthew.linkshortener.repository;

import com.matthew.linkshortener.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
