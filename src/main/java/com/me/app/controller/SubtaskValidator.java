package com.me.app.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.app.pojo.User;

@Component
public class SubtaskValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		// TODO Auto-generated method stub
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		User user=(User)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subtaskTitle", "error.invalid.story", "UserName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subtaskDescription", "error.invalid.story", "UserName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comments", "error.invalid.story", "UserName Required");
		
	}
}
