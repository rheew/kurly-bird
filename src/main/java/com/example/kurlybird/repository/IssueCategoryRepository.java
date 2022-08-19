package com.example.kurlybird.repository;

import com.example.kurlybird.domain.category.IssueCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Long> {
}
