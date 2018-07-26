package com.shelby.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shelby.project.models.Constit;

@Component
public class ConstValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Constit.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Constit constit = (Constit) object;

		if (!constit.getPasswordConfirmation().equals(constit.getPassword())) {

			errors.rejectValue("passwordConfirmation", "Match");
		}
	}

}
