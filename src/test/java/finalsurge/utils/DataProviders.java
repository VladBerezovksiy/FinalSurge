package finalsurge.utils;

import models.VitalsModel;
import org.testng.annotations.DataProvider;

public class DataProviders {

    private static final String FIRSTNAME_PARAM = PropertiesUtils.getEnv("firstname_param");
    private static final String LASTNAME_PARAM = PropertiesUtils.getEnv("lastname_param");
    private static final int random = (int) (Math.random() * 1000);
    private static final String EMAIL_PARAM = PropertiesUtils.getEnv("email_login_param") + random + PropertiesUtils.getEnv("email_domain_param");
    private static final String PASSWORD_PARAM = PropertiesUtils.getEnv("password_param");
    private static final String RETYPE_PASSWORD_PARAM = PropertiesUtils.getEnv("retype_password_param");
    private static final String WRONG_PASSWORD_PARAM = PropertiesUtils.getEnv("wrong_password_param");
    private static final String WRONG_RETYPE_PASSWORD_PARAM = PropertiesUtils.getEnv("wrong_retype_password_param");
    private static final String REQUIRED_FIELD_MESSAGE = "This field is required.";
    private static final String WRONG_PASSWORD_MESSAGE = "Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length.";
    private static final String WRONG_RETYPE_PASSWORD_MESSAGE = "Error: The passwords you entered did not match.";
    private static final String DATE_REQUIRED_MESSAGE = "×\n" + "Please fix the following errors:\n" + "*Please enter a value for Vitals Date.";
    private static final String WRONG_DATE_MESSAGE = "×\n" + "Please fix the following errors:\n" + "*Please enter a valid Vitals Date.";
    private static final String NEGATIVE_STEPS_MESSAGE= "×\n" + "Please fix the following errors:\n" + "*Steps cannot be less than 0.";
    private static final String LETTER_IN_STEPS_MESSAGE= "×\n" + "Please fix the following errors:\n" + "*Please enter a valid Integer for Steps (no decimals).";

    @DataProvider(name = "Input data for auth")
    public Object[][] inputForSignUpTask() {
        return new Object[][]{

                {"", LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when firstname is absent  is not correct"},
                {FIRSTNAME_PARAM, "", EMAIL_PARAM, PASSWORD_PARAM, RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, "", PASSWORD_PARAM, RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, "", RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, "", REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
        };
    }

    @DataProvider(name = "Input data for checking password and retypePassword")
    public Object[][] inputForCheckPasswordTask() {
        return new Object[][]{

                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, WRONG_PASSWORD_PARAM, WRONG_PASSWORD_PARAM, WRONG_PASSWORD_MESSAGE, "The text message when password is incorrect  is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, WRONG_RETYPE_PASSWORD_PARAM, WRONG_RETYPE_PASSWORD_MESSAGE, "The text message when password isn't matched retype password  is not correct"},
        };
    }

    @DataProvider(name = "Input data for valid reg")
    public Object[][] inputForValidRegTask() {
        return new Object[][]{

                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, RETYPE_PASSWORD_PARAM},
         };
    }

    @DataProvider(name = "Input data for vitals")
    public Object[][] inputForVitalsTask() {
        return new Object[][]{

                {new VitalsModel().getEmptydate(), new VitalsModel().getSteps(), DATE_REQUIRED_MESSAGE, "The text is different"},
                {new VitalsModel().getWrongdate(), new VitalsModel().getSteps(), WRONG_DATE_MESSAGE, "The text is different"},
                {new VitalsModel().getDate(), new VitalsModel().getNegativesteps(), NEGATIVE_STEPS_MESSAGE, "The text is different"},
                {new VitalsModel().getDate(), new VitalsModel().getNotnumbersteps(), LETTER_IN_STEPS_MESSAGE, "The text is different"}
        };
    }
}
