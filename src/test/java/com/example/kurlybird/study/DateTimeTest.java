package com.example.kurlybird.study;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeTest {
    @Test
    void localdatetime으로_형식변환() {
        String date = "Tue, 16 Aug 2022 21:37:40 +0900";
//        final ZonedDateTime parse1 = ZonedDateTime.parse("Tuesday, 18 June, 2002 8:30:00 PM KST", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
//        final LocalDateTime parse = LocalDateTime.parse(format, "");


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

        System.out.println(LocalDateTime.parse(date, formatter));
    }

    @Test
    void 날짜_스트링변환() {
        assertThat(LocalDate.of(2020,1,1).toString()).isEqualTo("2020-01-01");
    }
}
