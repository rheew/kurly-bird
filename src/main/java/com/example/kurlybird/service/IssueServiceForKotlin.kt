package com.example.kurlybird.service

import com.example.kurlybird.domain.category.IssueCategory
import com.example.kurlybird.domain.issue.Issue
import com.example.kurlybird.domain.news.NaverNewsInfo
import com.example.kurlybird.repository.IssueCategoryRepository
import com.example.kurlybird.repository.IssueRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.TimeUnit

@Service
class IssueServiceForKotlin(
    private val issueCategoryRepository: IssueCategoryRepository,
    private val newsService: NewsService,
    private val issueRepository: IssueRepository,
) {
    private val logger = LoggerFactory.getLogger(IssueServiceForKotlin::class.java)

    @Transactional
    fun saveIssue() = runBlocking<Unit> {
        coroutineScope {
            issueCategoryRepository.findAll().stream()
                .map { category: IssueCategory ->
                    launch {
                        val naverNewsInfo = newsService.getNaverNewsInfo(category.getName(), 1)
                        save(category, naverNewsInfo)
                    }
                }
        }
    }

    //이슈 초기화 등록 메서드
    @Transactional
    fun saveInitIssue() {
        issueCategoryRepository.findAll().stream()
            .forEach { category: IssueCategory ->
                val naverNewsInfo = NaverNewsInfo()
                addNaverNewsInfo(category, naverNewsInfo)
                save(category, naverNewsInfo)
            }
    }

    private fun save(category: IssueCategory, naverNewsInfo: NaverNewsInfo) {
        val news = newsService.saveAll(newsService.findIssueNews(naverNewsInfo, category.id))

        if (news.size > 0) {
            val issues = issueRepository.saveAll(Issue.createIssues(news, category))
            logger.debug("저장된 이슈 갯수: {}", issues.size)
        }
    }

    private fun addNaverNewsInfo(category: IssueCategory, naverNewsInfo: NaverNewsInfo) {
        for (i in 1..5) {
            naverNewsInfo.addItems(newsService.getNaverNewsInfo(category.getName(), i))
            delay()
        }
    }

    private fun delay() {
        try {
            // naver api 정책으로 1초에 10건 이상 호출 불가능
            TimeUnit.SECONDS.sleep(1)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
