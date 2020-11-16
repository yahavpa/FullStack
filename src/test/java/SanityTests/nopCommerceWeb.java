package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Random;

@Listeners(Utilities.listeners.class)
public class nopCommerceWeb extends commonOps
{
    @Test(description = "Test01: Register to nopCommerce")
    @Description("Test Description: Create a new user in nopCommerce web application")
    public void test01_register() throws InterruptedException
    {
        webFlows.register(getData("FirstName"), getData("LastNmae"), new Random().nextInt() + "@gmail.com", getData("Password"));
        verifications.visibleText(nopCommerceRegisterPage.txt_registrationConfirmation, "Your registration completed");
    }

    @Test(description = "Test02: Add Item to Cart")
    @Description("Test Description: Add a new item to nopCommerce web application shopping cart")
    public void test02_addToCart() throws InterruptedException
    {
        webFlows.addItemToCart();
        verifications.numberOfElements(nopCommerceShoppingCartPage.rows, 1);
    }

    @Test(description = "Test03: Remove Item from Cart")
    @Description("Test Description: Remove item from nopCommerce web application shopping cart")
    public void test03_removeFromCart() throws InterruptedException
    {
        webFlows.addItemToCart();
        uiActions.mouseHoverElements(nopCommerceUpperBarPage.lnk_shoppingCart, nopCommerceUpperBarPage.btn_goToCart);
        uiActions.click(nopCommerceShoppingCartPage.box_removeProductBox);
        uiActions.click(nopCommerceShoppingCartPage.btn_updateShoppingCart);
        verifications.visibleText(nopCommerceShoppingCartPage.txt_emptyShoppingCart, "Your Shopping Cart is empty!");
    }

    @Test(description = "Test04: Sorting items")
    @Description("Test Description: Sorting items in nopCommerce web application shopping cart")
    public void test04_sortBy() throws InterruptedException
    {
        String[] expItems = new String[]{getData("expItem1"), getData("expItem2"), getData("expItem3")};
        webFlows.sortItemsBy(getData("SortingMethod"));
        for (int i = 0; i < nopCommerceCellPhonesPage.lst_itemGrid.size(); i++)
        {
            assertEquals(expItems[i], nopCommerceCellPhonesPage.lst_itemGrid.get(i).getText());
        }
    }

    @Test(description = "Test05: Empty Search Popup Alert")
    @Description("Test Description: Verify empty search popup alert when search field is empty")
    public void test05_emptySearchPopup() throws InterruptedException
    {
        uiActions.clearText(nopCommerceUpperBarPage.txt_searchStore);
        uiActions.click(nopCommerceUpperBarPage.btn_search);
        popup = driver.switchTo().alert();
        String popupText = popup.getText();
        try
        {
            verifications.visibleTextString(popupText, "Please enter some search keyword");
        }
        catch (Exception e)
        {
            fail();
        }
        finally
        {
            popup.accept();
        }
    }

    @Test(description = "Test06: Verify nopCommerce Logo")
    @Description("Test Description: Verify nopCommerce default Logo")
    public void test06_VerifyLogo() throws InterruptedException
    {
        verifications.visualElement(nopCommerceUpperBarPage.img_logo, "nopCommerceLogo_ver01");
    }

    @Test(description = "Test07: Verify Elements Location By Y Axis")
    @Description("Test Description: Verify nopCommerce top-menu elements location by Y axis")
    public void test07_VerifyYAxis() throws InterruptedException
    {
        for (int i = 1; i < nopCommerceHeaderMenu.lnk_topMenu.size(); i++)
        {
            assertEquals(nopCommerceHeaderMenu.lnk_topMenu.get(i-1).getLocation().getY(), nopCommerceHeaderMenu.lnk_topMenu.get(i).getLocation().getY());
        }
    }
}
