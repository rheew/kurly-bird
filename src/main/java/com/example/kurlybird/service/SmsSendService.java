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
        message.setText("한글 45자, 영자 90자 이하 입력되면 자동으로 SMS타입의 메시지가 추가됩니다.");

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        logger.debug("SMS 전송 요청 응답 : {}", response);
    }
}
