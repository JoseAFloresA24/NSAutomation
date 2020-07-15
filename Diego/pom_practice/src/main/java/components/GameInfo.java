package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class GameInfo extends BasePage {

    @FindBy(xpath = "//div[@class='block_content_inner']/div[1]")
    private WebElement gameinfo;

    @FindBy(css = ".pageheader")
    private WebElement gametitle;

    public GameInfo(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getGameInfo(){
        return (gameinfo.getText());
    }

    public String getGameTitle(){
        return (gametitle.getText());
    }
}