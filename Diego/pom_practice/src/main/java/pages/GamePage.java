package pages;

import settings.BasePage;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamePage extends BasePage {

    @FindBy(className = "details_block")
    private WebElement detailsblock;

    public GamePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForDetailsBlock(){
        this.waitForElementToAppear(detailsblock);
    }

}
