package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import settings.BasePage;

public class GameInfo extends BasePage {

    @FindBy(className = "details_block")
    private WebElement genero;

    @FindBy(css = ".pageheader")
    private WebElement gametitle;

    public GameInfo(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String[] getGameInfo(){
        String game_info = genero.getText();
        String lines[] = game_info.split("\\r?\\n");
        return (lines);
    }

    public String getGameTitle(){
        return (gametitle.getText());
    }
}