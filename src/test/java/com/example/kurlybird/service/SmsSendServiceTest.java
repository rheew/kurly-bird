package com.example.kurlybird.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmsSendServiceTest {

    @Autowired
    private SmsSendService service;

    //전송 테스트시 과금 됌
    @Test
    void 발송테스트() {

//        service.sendOne("01086893037");
//        System.out.println(response);
    }
}
