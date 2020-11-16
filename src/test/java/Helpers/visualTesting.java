package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import org.testng.annotations.Test;

public class visualTesting extends commonOps
{
    @Test
    public void createScreenshot()
    {
        helperMethods.takeElementScreenshot(nopCommerceUpperBarPage.img_logo, "nopCommerceLogo_ver01");
    }
}
