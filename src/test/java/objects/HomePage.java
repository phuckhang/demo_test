package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.AbstractComponent;

public class HomePage extends AbstractComponent {

    @FindBy(xpath = "//*[@href='/logout']")
    public WebElement btnLogout;

    public HomePage(final WebDriver driver) {
        super(driver);
    }

}
