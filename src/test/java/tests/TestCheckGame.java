package tests;

import components.GameInfo;
import components.NavBar;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GamePage;
import settings.BaseTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestCheckGame extends BaseTest {

    private NavBar navBar;
    private GamePage gamePage;
    private GameInfo gameInfo;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
        gamePage = new GamePage(this.driver);
        gameInfo = new GameInfo(this.driver);
    }

    @Test(groups = {"search", "smoke"})
    public void checkGameTest(){
        navBar.deleteGameSearchInput();
        String game_name = "Portal Bundle";
        navBar.writeGameIntoSearchInput(game_name);
        String game = navBar.getFirstOptionTitle();
        if (game.equals(game_name)){
            navBar.clickFirstOption();
        }
        gamePage.waitForDetailsBlock();
        String game_title = gameInfo.getGameTitle();
        game_title = game_title.toLowerCase();
        game_name = game_name.toLowerCase();
        Assert.assertTrue(game_name.equals(game_title), "Game Title does not match");
    }

}

