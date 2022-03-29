package constants;

public class SignUpPageConstants {
    public static final String FIRSTNAME_CONST = "Tom";
    public static final String LASTNAME_CONST = "Rich";
    public static final int random = (int) (Math.random() * 1000);
    public static final String EMAIL_CONST = "test" + random + "@gmail.com";
    public static final String PASSWORD_CONST = "1qaz2WSX";
    public static final String RETYPE_PASSWORD_CONST = "1qaz2WSX";
    public static final String WRONG_PASSWORD_CONST = "12345678";
    public static final String WRONG_RETYPE_PASSWORD_CONST = "1qaz22345";

    public static final String REQUIRED_FIELD_MESSAGE = "This field is required.";
    public static final String WRONG_PASSWORD_MESSAGE = "Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length.";
    public static final String WRONG_RETYPE_PASSWORD_MESSAGE = "Error: The passwords you entered did not match.";

}
