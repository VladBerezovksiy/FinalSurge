package finalsurge.constants.credantials;

import finalsurge.utils.PropertiesUtils;

public class LoginDataConstant {

    public static final String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    public static final String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    public static final String INVALID_LOGIN = PropertiesUtils.getEnv("invalid_login");
    public static final String INVALID_PASSWORD = PropertiesUtils.getEnv("invalid_password");

}
