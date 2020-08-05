package tests;

import components.GameInfo;
import components.NavBar;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GamePage;
import settings.BaseTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CheckGameData extends BaseTest {

    private NavBar navBar;
    private GamePage gamePage;
    private GameInfo gameInfo;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
        gamePage = new GamePage(this.driver);
        gameInfo = new GameInfo(this.driver);
    }

    @Test(groups = {"regression", "smoke"})
    public void checkGameDataTest(){
        String [] details = {"TITLE: Age of Empires II: Definitive Edition",
                "GENRE: Strategy",
                "DEVELOPER: Forgotten Empires, Tantalus Media, Wicked Witch",
                "PUBLISHER: Xbox Game Studios",
                "FRANCHISE: Age of Empires",
                "RELEASE DATE: 14 Nov, 2019"};
        String game_name = "Age of Empires II: Definitive Edition";
        navBar.writeGameIntoSearchInput(game_name);
        navBar.clickFirstOption();
        gamePage.waitForDetailsBlock();
        String [] game_info = gameInfo.getGameInfo();
        int a = 0;
        for(String detail: details){
            Assert.assertTrue(detail.equals(game_info[a]), "The info " + detail + " does not match with the game info " + game_info[a]);
            a = a + 1;
        }
    }

}

