package com.spring.mvc.enumeration;

public enum ReportType {

    ECCD_REPORT(0, "Eccd"),
    ECCD2_REPORT(1, "example"),
    ECCD3_REPORT(2, "example1");

    private final Integer value;
    private final String text;

    ReportType(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
