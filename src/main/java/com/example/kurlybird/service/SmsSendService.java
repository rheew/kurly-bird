package com.example.kurlybird.service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsSendService {

    private static final Logger logger = LoggerFactory.getLogger(SmsSendService.class);

    private static String API_KEY;
    private static String API_SECRET;
    private static String smsSendDomain;
    private static String sender;
    private static DefaultMessageService messageService;

    public SmsSendService(@Value("${sms-api.key}") String API_KEY,
                          @Value("${sms-api.secret}") String API_SECRET,
                          @Value("${sms-api.domain}") String smsSendDomain,
                          @Value("${sms-api.sender}") String sender) {
        this.API_KEY = API_KEY;
        this.API_SECRET = API_SECRET;
        this.smsSendDomain = smsSendDomain;
        this.sender = sender;
        messageService = NurigoApp.INSTANCE.initialize(API_KEY, API_SECRET, smsSendDomain);
    }


    public void sendOne(String receiver) {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject("[컬리버드 소식]");
        message.setText("[컬리버드 소식]\n" +
                "안녕하세요, 컬리버드 알림 구독을 신청해주셔서 감사합니다.\n\n" +
                "컬리버드가 예측하기 어려운 가격의 상승 변동을 쉽게 확인 할 수 있도록 중요한 소식만 쏙쏙 골라서 바로 알려드릴게요! \n\n" +
                "지금 컬리버드와 함께 구매 시작하러가기 \n\n http://3.34.2.197:3000/");

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        logger.debug("SMS 전송 요청 응답 : {}", response);
    }
}
