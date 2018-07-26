package com.shelby.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shelby.project.models.Candidate;

@Component
public class CandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Candidate.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Candidate cand = (Candidate) object;

		if (!cand.getPasswordConfirmation().equals(cand.getPassword())) {

			errors.rejectValue("passwordConfirmation", "Match");
		}
	}

}
