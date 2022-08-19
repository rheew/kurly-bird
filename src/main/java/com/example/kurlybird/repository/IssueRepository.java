package com.example.kurlybird.repository;

import com.example.kurlybird.domain.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
