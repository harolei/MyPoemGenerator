package com.myPoemGenerator.validator;


import com.myPoemGenerator.model.PoemText;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PoemTextVadidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PoemText.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sentenceText",
                                                 "required.sentenceText",
                                                 "Field name is required.");
    }
}
