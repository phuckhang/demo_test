package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.AbstractComponent;

public class LoginPage extends AbstractComponent {

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginEmail")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@value='login']/..//input[@id='password']")
    public WebElement txtPass;

    @FindBy(xpath = "//button[@id='submit' and text()='Login']")
    public WebElement btnLogin;

    @FindBy(css = ".alert-danger > strong")
    public WebElement lblErrorMsg;
}
