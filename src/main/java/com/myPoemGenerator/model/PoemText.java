package com.myPoemGenerator.model;

import com.myPoemGenerator.validator.FirstSentenceValidator;
import com.myPoemGenerator.validator.ForthSentenceValidator;
import com.myPoemGenerator.validator.SecondSentenceValidator;
import com.myPoemGenerator.validator.ThirdSentenceValidator;
import org.hibernate.validator.constraints.NotEmpty;

public class PoemText {

    @NotEmpty(groups=FirstSentenceValidator.class)
    private String firstSentence;

    @NotEmpty(groups=SecondSentenceValidator.class)
    private String secondSentence;

    @NotEmpty(groups=ThirdSentenceValidator.class)
    private String thirdSentence;

    @NotEmpty(groups=ForthSentenceValidator.class)
    private String forthSentence;

    public String getFirstSentence() {
        return firstSentence;
    }

    public void setFirstSentence(String firstSentence) {
        this.firstSentence = firstSentence;
    }

    public String getSecondSentence() {
        return secondSentence;
    }

    public void setSecondSentence(String secondSentence) {
        this.secondSentence = secondSentence;
    }

    public String getThirdSentence() {
        return thirdSentence;
    }

    public void setThirdSentence(String thirdSentence) {
        this.thirdSentence = thirdSentence;
    }

    public String getForthSentence() {
        return forthSentence;
    }

    public void setForthSentence(String forthSentence) {
        this.forthSentence = forthSentence;
    }
}
