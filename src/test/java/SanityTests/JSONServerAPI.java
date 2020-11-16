package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class JSONServerAPI extends commonOps
{


    @Test(description = "Test01: Add Section And Verify it")
    @Description("Test Description: Add section to JSON server and verify it")
    public void test01_addSectionAndVerify()
    {
        apiFlows.postSection("Server", "ATeam");
        verifications.text(String.valueOf(response.getStatusCode()), "201");
    }

    @Test(description = "Test02: Get Property From JSON Server")
    @Description("Test Description: Get property from list JSON server")
    public void test02_GetProperty()
    {
        verifications.text(apiFlows.getListProperty("title[0]"), "Server");
        System.out.println(apiFlows.getListProperty("title[0]").toString());
    }

    @Test(description = "Test03: Update Section And Verify it")
    @Description("Test Description: Update section in JSON server and verify it")
    public void test03_updateSectionAndVerify()
    {
        apiFlows.updateSection("updatedTitle", "updatedAuthor", "1");
        verifications.text(apiFlows.getListProperty("author[0]"), "updatedAuthor");
    }

    @Test(description = "Test04: Delete Section And Verify it")
    @Description("Test Description: Delete section in JSON server and verify it")
    public void test04_deleteSection()
    {
        apiFlows.deleteSection("1");
        verifications.text(String.valueOf(response.getStatusCode()), "200");

    }
}
