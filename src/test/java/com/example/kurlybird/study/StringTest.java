package com.example.kurlybird.study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void 키워드매칭테스트() {
        String keywordMatches = "(.*)상승(.*)||(.*)생산량 뚝(.*)||(.*)인상(.*)||(.*)껑충(.*)";
        String contents = "폭우에 배추값 77% 뛰고, 사과 생산량 인상… ‘팍팍한 한가위’ 되나";

        assertThat(contents.matches(keywordMatches)).isTrue();
    }
}
