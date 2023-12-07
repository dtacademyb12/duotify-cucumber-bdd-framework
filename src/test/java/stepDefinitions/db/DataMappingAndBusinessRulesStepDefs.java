package stepDefinitions.db;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utils.ConfigReader;
import utils.DBUtils;

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
}
