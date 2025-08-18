package com.example.restaurantreview.domain;

import lombok.Getter;

@Getter
public enum CuisineType {
    ITALIAN("Italian"),
    FRENCH("French"),
    CHINESE("Chinese"),
    JAPANESE("Japanese"),
    INDIAN("Indian"),
    MEXICAN("Mexican"),
    THAI("Thai"),
    MEDITERRANEAN("Mediterranean"),
    AMERICAN("American"),
    TURKISH("Turkish"),
    KOREAN("Korean"),
    VIETNAMESE("Vietnamese"),
    SPANISH("Spanish"),
    GREEK("Greek"),
    OTHER("Other");

    private final String displayName;

    CuisineType(String displayName) {
        this.displayName = displayName;
    }

}
