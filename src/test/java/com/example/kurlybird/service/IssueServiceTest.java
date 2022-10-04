package com.example.kurlybird.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class IssueServiceTest {

    @Autowired
    IssueServiceForKotlin serviceForKotlin;

    @Autowired
    IssueService service;

    @Test
    void issue_저장_성능테스트_no_coroutine() {
        long startTime = System.currentTimeMillis();
        service.saveIssue();
        long finishTime = System.currentTimeMillis();

        System.out.println("startTime: " + startTime);
        System.out.println("finishTime: " + finishTime);
        System.out.println("useTime: " + (finishTime - startTime));
        //2488 소요
    }

    @Test
    void issue_저장_성능테스트_coroutine() {
        long startTime = System.currentTimeMillis();
        serviceForKotlin.saveIssue();
        long finishTime = System.currentTimeMillis();

        System.out.println("startTime: " + startTime);
        System.out.println("finishTime: " + finishTime);
        System.out.println("useTime: " + (finishTime - startTime));
        // 240 소요
    }
}
