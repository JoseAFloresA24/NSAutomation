package tests;

import components.GameInfo;
import components.NavBar;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GamePage;
import settings.BaseTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchGame extends BaseTest {

    private NavBar navBar;
    private GamePage gamePage;
    private GameInfo gameInfo;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
        gamePage = new GamePage(this.driver);
        gameInfo = new GameInfo(this.driver);
    }

    @Test(groups = {"search", "regression"})
    public void searchGameTest(){
        String game_name = "Age";
        navBar.writeGameIntoSearchInput(game_name);
        ArrayList<String> games = navBar.getSuggestedGames();
        Assert.assertTrue(games.size() == 5, "The number of suggested games is not correct");
        for(String game: games){
            Assert.assertTrue(game.indexOf("Age") >= 0, "The game " + game + " is not correct. Not contains Search String " + game_name);
        }
    }





}

