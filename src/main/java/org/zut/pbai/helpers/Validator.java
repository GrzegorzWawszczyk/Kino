package org.zut.pbai.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator{

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	private static final String CARD_NUMBER_PATTERN = 
			"[0-9]{16}";
	private static final String CVV_PATTERN = 
			"[0-9]{3}";
	public Validator() {
		
	}

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validateEmail(final String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
	
	public boolean validatePassword(final String hex) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
	
	public boolean validateCardNumber(final String hex) {
		pattern = Pattern.compile(CARD_NUMBER_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
	
	public boolean validateCVV(final String hex) {
		pattern = Pattern.compile(CVV_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}
