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

public class GamePageTests extends BaseTest {

    private NavBar navBar;
    private GamePage gamePage;
    private GameInfo gameInfo;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
        gamePage = new GamePage(this.driver);
        gameInfo = new GameInfo(this.driver);
    }

    @Test
    public void CheckGameData(){
        String details = "TITLE: Age of Empires II: Definitive Edition\n" +
                "GENRE: Strategy\n" +
                "DEVELOPER: Forgotten Empires, Tantalus Media, Wicked Witch\n" +
                "PUBLISHER: Xbox Game Studios\n" +
                "FRANCHISE: Age of Empires\n" +
                "RELEASE DATE: 14 Nov, 2019";
        System.out.println(details);
        navBar.deleteGameSearchInput();
        String game_name = "Age of Empires II: Definitive Edition";
        navBar.writeGameIntoSearchInput(game_name);
        String game = navBar.getFirstOptionTitle();
        navBar.clickFirstOption();
        gamePage.waitForDetailsBlock();
        String game_info = gameInfo.getGameInfo();
        System.out.println(game_info);
        Assert.assertTrue(game_info.equals(details), "Game Info does not match");
    }
    @Test
    public void CheckGame(){
        navBar.deleteGameSearchInput();
        String game_name = "Portal Bundle";
        navBar.writeGameIntoSearchInput(game_name);
        String game = navBar.getFirstOptionTitle();
        if (game.equals(game_name)){
            navBar.clickFirstOption();
        }
        gamePage.waitForDetailsBlock();
        String game_title = gameInfo.getGameTitle();
        System.out.println(game_title);
        game_title = game_title.toLowerCase();
        game_name = game_name.toLowerCase();
        Assert.assertTrue(game_name.equals(game_title), "Game Title does not match");
    }




}

