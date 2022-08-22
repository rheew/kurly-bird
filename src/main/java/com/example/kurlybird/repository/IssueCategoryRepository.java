package com.example.kurlybird.repository;

import com.example.kurlybird.domain.category.IssueCategory;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Long> {

}
