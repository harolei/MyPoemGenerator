package com.myPoemGenerator.model;

import org.hibernate.validator.constraints.NotEmpty;

public class PoemSentence {

    @NotEmpty(message = "Please enter the sentence of the poem!")
    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
