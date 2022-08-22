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

    @Test
    void 문자열_필터테스트() {
        String str = "&quot;폭염·폭우에 金값 채소 직접 심어먹어요&quot;…&apos;홈파밍&apos; 인기 <b>시금치</b>가 아니라";

        assertThat(str.replaceAll("&quot;|&apos;|<b>|</b>", "")).isEqualTo("폭염·폭우에 金값 채소 직접 심어먹어요…홈파밍 인기 시금치가 아니라");

    }
}
