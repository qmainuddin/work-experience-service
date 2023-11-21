package com.example.workexperienceservice.common.enums;

public enum NewsType {

    NEWS_TYPE("NEWS_TYPE"),
    UPDATES("UPDATES"),
    ANNOUNCEMENT("ANNOUNCEMENT");

    private final String label;
    NewsType(String label) {
        this.label = label;
    }

}
