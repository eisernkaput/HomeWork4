package Util;

public enum Gender {

    MALE("Мужской", "Male"),
    FEMALE("Женский", "Female");

    private final String russianTitle;

    private final String englishTitle;

    Gender(String russianTitle, String englishTitle) {
        this.russianTitle = russianTitle;
        this.englishTitle = englishTitle;
    }

    public String getRussianTitle() {
        return russianTitle;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }
}
