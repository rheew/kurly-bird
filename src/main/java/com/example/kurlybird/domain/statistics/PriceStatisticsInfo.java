package com.example.kurlybird.domain.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PriceStatisticsInfo {

    private static final String SUCCESS_CODE = "000";

    @JsonProperty("condition")
    private List<Condition> condition;
    @JsonProperty("data")
    private Data data;

    public List<Data.Item> getItems() {
        return data.getItem().stream()
                .filter(item -> !item.countryName.matches("평년||평균"))
                .collect(Collectors.toList());
    }

    public boolean isSuccess() {
        return data.getErrorCode().equals(SUCCESS_CODE);
    }

    static class Condition {
        private String p_startday;
        private String p_endday;
        private String p_itemcategorycode;
        private String p_itemcode;
        private String p_kindcode;
        private String p_productrankcode;
        private String p_countycode;
        private String p_convert_kg_yn;
        private String p_key;
        private String p_id;
        private String p_returntype;
    }

    @Getter
    public static class Data {
        @JsonProperty("error_code")
        private String errorCode;
        @JsonProperty("item")
        private List<Item> item;

        @Getter
        public static class Item {
            public static final String DELIMITER = "/";
            public static final int MONTH_INDEX = 0;
            public static final int DAY_INDEX = 1;
//            @JsonProperty("itemname")
//            private String[] itemName;
//            @JsonProperty("kindname")
//            private String[] kindName;
            @JsonProperty("countyname")
            private String countryName;
//            @JsonProperty("marketname")
//            private String[] marketName;
            @JsonProperty("yyyy")
            private String yyyy;
            @JsonProperty("regday")
            private String regDay;
            @JsonProperty("price")
            private String price;

            public LocalDate getRegDate() {
                final String[] regDays = regDay.split(DELIMITER);
                return LocalDate.of(Integer.parseInt(yyyy), Integer.parseInt(regDays[MONTH_INDEX]), Integer.parseInt(regDays[DAY_INDEX]));
            }
        }
    }
}
