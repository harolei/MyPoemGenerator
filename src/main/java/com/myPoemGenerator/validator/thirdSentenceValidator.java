package com.myPoemGenerator.validator;

import com.myPoemGenerator.model.PoemText;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ThirdSentenceValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PoemText.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String errorInfo = "Please enter the sentence of the poem!";

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "thirdSentence",
                "required.thirdSentence",
                errorInfo);

    }
}
