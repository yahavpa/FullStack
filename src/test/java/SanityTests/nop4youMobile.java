package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

@Listeners(Utilities.listeners.class)
public class nop4youMobile extends commonOps
{
    @Test(description = "Test01: Verify Search Results")
    @Description("Test Description: Enter search item and verify its apparel in the search results")
    public void test01_VerifySearchResults()
    {
        mobileFlows.searchForItems();
        String[] MobileExpItems = new String[]{getData("MobileExp1"), getData("MobileExp2"), getData("MobileExp3")};
        for (int i = 0; i < nop4youMobileSearchResultsPage.lst_searchResults.size(); i++)
        {
            assertEquals(MobileExpItems[i], nop4youMobileSearchResultsPage.lst_searchResults.get(i).getText());
        }
    }

    @Test(description = "Test02: Verify Currency Change")
    @Description("Test Description: Change the currency of products")
    public void test02_VerifyCurrencyChange()
    {
        uiActions.click(nop4youMobileHeaderBar.btn_menu);
        uiActions.click(nop4youMobileLeftSideMenu.btn_settings);
        uiActions.click(nop4youMobileSettingsPage.currencyField);
        for (int i = 0; i < nop4youMobileSettingsPage.lst_currency.size(); i++)
        {
            if(nop4youMobileSettingsPage.lst_currency.get(i).getText().equalsIgnoreCase(getData("expCurrency")))
                uiActions.click(nop4youMobileSettingsPage.lst_currency.get(i));
        }
        uiActions.click(nop4youMobileHeaderBar.btn_menu);
        mobileFlows.searchForItems();
        verifications.visibleText(nop4youMobileSearchResultsPage.priceItem, getData("priceCurrency"));
    }
}
