package com.example.kurlybird.Repository;

import com.example.kurlybird.domain.IssueCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Long> {
}
