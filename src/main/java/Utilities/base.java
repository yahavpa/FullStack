package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static Select sortItem;
    public static Alert popup;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static String Platform;

    public static PageObjects.nopCommerce.upperBarPage nopCommerceUpperBarPage;
    public static PageObjects.nopCommerce.registerPage nopCommerceRegisterPage;
    public static PageObjects.nopCommerce.headerMenu nopCommerceHeaderMenu;
    public static PageObjects.nopCommerce.cellPhonesPage nopCommerceCellPhonesPage;
    public static PageObjects.nopCommerce.shoppingCartPage nopCommerceShoppingCartPage;

    public static PageObjects.nop4youMobile.headerBar nop4youMobileHeaderBar;
    public static PageObjects.nop4youMobile.searchResultsPage nop4youMobileSearchResultsPage;
    public static PageObjects.nop4youMobile.leftSideMenu nop4youMobileLeftSideMenu;
    public static PageObjects.nop4youMobile.settingsPage nop4youMobileSettingsPage;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;
}
