package com.example.restaurantreview.domain;

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

    public String getDisplayName() {
        return displayName;
    }
}
