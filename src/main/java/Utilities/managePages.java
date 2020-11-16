package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        nopCommerceUpperBarPage = PageFactory.initElements(driver, PageObjects.nopCommerce.upperBarPage.class);
        nopCommerceRegisterPage = PageFactory.initElements(driver, PageObjects.nopCommerce.registerPage.class);
        nopCommerceHeaderMenu = PageFactory.initElements(driver, PageObjects.nopCommerce.headerMenu.class);
        nopCommerceCellPhonesPage = PageFactory.initElements(driver, PageObjects.nopCommerce.cellPhonesPage.class);
        nopCommerceShoppingCartPage = PageFactory.initElements(driver, PageObjects.nopCommerce.shoppingCartPage.class);

        nop4youMobileHeaderBar = PageFactory.initElements(driver, PageObjects.nop4youMobile.headerBar.class);
        nop4youMobileSearchResultsPage = PageFactory.initElements(driver, PageObjects.nop4youMobile.searchResultsPage.class);
        nop4youMobileLeftSideMenu = PageFactory.initElements(driver, PageObjects.nop4youMobile.leftSideMenu.class);
        nop4youMobileSettingsPage = PageFactory.initElements(driver, PageObjects.nop4youMobile.settingsPage.class);
    }
}
