package com.example.kurlybird.repository;

import com.example.kurlybird.domain.category.IssueCategory;
import com.example.kurlybird.domain.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    Optional<Issue> findTopByIssueCategory_IdOrderByNewsDesc(Long issueCategoryId);
}
