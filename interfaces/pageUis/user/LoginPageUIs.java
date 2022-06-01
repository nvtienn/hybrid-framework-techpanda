package pageUis.user;

public class LoginPageUIs {
    public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@name='email']";
    public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//div[@class='card-group']//button[text()='Login']";
    public static final String EMAIL_ERROR_MESSAGE = "//input[@name='email']/following-sibling::div[@class='invalid-feedback']";
    public static final String PASSWORD_ERROR_MESSAGE = "//input[@name='password']/following-sibling::div[@class='invalid-feedback']";
}
