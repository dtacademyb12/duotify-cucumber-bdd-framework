package stepDefinitions.db;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utils.ConfigReader;
import utils.DBUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DataMappingAndBusinessRulesStepDefs {

    SharedData sharedData;

    public DataMappingAndBusinessRulesStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("the data should be mapped correctly in the corresponding table")
    public void theDataShouldBeMappedCorrectlyInTheCorrespondingTable() {

        String query = "SELECT name,owner from playlists where name='"+sharedData.getPlaylistName()+"' and owner='"+ ConfigReader.getProperty("username") +"'";
        System.out.println(query);
        List<List<Object>> resultAsListOfLists = DBUtils.getQueryResultAsListOfLists(query);

        Assert.assertTrue(!resultAsListOfLists.isEmpty());

        Assert.assertEquals(sharedData.getPlaylistName(),resultAsListOfLists.get(0).get(0) );
        Assert.assertEquals(ConfigReader.getProperty("username"),resultAsListOfLists.get(0).get(1) );




    }

    List<String> actualColumnNames;
    @When("I retrieve the column names from the {string} table")
    public void iRetrieveTheColumnNamesFromTheTable(String table) {

       actualColumnNames = DBUtils.getColumnNames("SELECT * from songs limit 1");


    }

    @Then("it should have the following")
    public void itShouldHaveTheFollowing( List<String> expectedColumnNames) {

        Assert.assertEquals(expectedColumnNames, actualColumnNames);

    }
    List<String> columnData;
    @When("I retrieve the emails from {string} table")
    public void iRetrieveTheEmailsFromTable(String table) {
        List<List<Object>> resultAsListOfLists = DBUtils.getQueryResultAsListOfLists("SELECT email from " + table + "");
        columnData = DBUtils.getColumnData(resultAsListOfLists, 0);



    }

    @Then("it should not contain duplicates")
    public void itShouldNotContainDuplicates() {

        // Find the duplicate (sort and compare adjacent element) using Java

        Collections.sort(columnData);

        boolean noDuplicate = true;
        for (int i = 0; i < columnData.size()-1; i++) {

            if(columnData.get(i).equals(columnData.get(i+1))){
                noDuplicate = false;
                break;
            }
        }


        System.out.println(columnData);
//        Assert.assertTrue(noDuplicate);
        
        
        // Send a query that returns the table of duplicate emails

        List<List<Object>> resultAsListOfLists = DBUtils.getQueryResultAsListOfLists("SELECT email, count(*) from users group by email having count(*)>1");
        Assert.assertTrue(resultAsListOfLists.isEmpty()); // if the query returns any result, it should fail

    }
}
