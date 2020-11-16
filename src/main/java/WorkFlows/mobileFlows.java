package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mobileFlows extends commonOps
{
    @Step("Search For Item")
    public static void searchForItems()
    {
        uiActions.click(nop4youMobileHeaderBar.btn_magnifyingGlass);
        uiActions.updateText(nop4youMobileHeaderBar.txt_searchInput, getData("SearchInput"));
        uiActions.click(nop4youMobileHeaderBar.btn_search);
    }
}
