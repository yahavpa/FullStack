package PageObjects.nop4youMobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class leftSideMenu
{
    @FindBy(how = How.XPATH, using = "//*[@text='Settings']")
    public WebElement btn_settings;
}
