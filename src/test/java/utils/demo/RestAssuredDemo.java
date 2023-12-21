package utils.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import utils.ConfigReader;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {


    static {
        baseURI = "https://api.github.com";
    }


    @Test
    public void demo1() {

        //Send a GET request to /users/{username} endpoint with a specific username and verify that username's details are returned


        // Set the base URI


        String username = "dtacademyb11";

        given().
                pathParam("username", username).
                when().log().all().
                get("/users/{username}").
                then().log().all().
                statusCode(200).
                body("login", equalTo(username)).
                body("id", equalTo(134797000)).
                body("public_repos", equalTo(13)).
                header("Server", "GitHub.com").
                time(lessThan(2000L));


    }


    @Test
    public void demo2() {


        given().
                queryParam("per_page", 2).
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                when().log().all().
                get("/users").
                then().log().all().
                statusCode(200);


    }


    @Test
    public void demoPost() {


        // Add a new email for a specific user account
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\":[\"dtacademyb6@gmail.com\"]\n" +
                        "}").
                // simple json body can be added as a String
                        when().log().all().
                post("/user/emails").
                then().log().all().
                statusCode(201).
                header("X-RateLimit-Limit", "5000").
                time(lessThan(2000L));

        // Cleanup the email that was created in the previous step

        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\":[\"dtacademyb6@gmail.com\"]\n" +
                        "}").

                when().log().all().
                delete("/user/emails").
                then().log().all().
                statusCode(204).
                header("X-RateLimit-Limit", "5000").
                time(lessThan(2000L));


    }


    @Test
    public void demoDelete() {


        // Create the email first

        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\":[\"dtacademyb6@gmail.com\"]\n" +
                        "}").
                // simple json body can be added as a String
                        when().log().all().
                post("/user/emails").
                then().log().all().
                statusCode(201);


        // Delete the same email

        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"emails\":[\"dtacademyb6@gmail.com\"]\n" +
                        "}").

                when().log().all().
                delete("/user/emails").
                then().log().all().
                statusCode(204).
                header("X-RateLimit-Limit", "5000").
                time(lessThan(2000L));

    }


    @Test
    public void demoPatchEmailVisibility() {

        // Extract the current visibility with the GET request

        String cuurentVisibility = given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                header("Content-Type", "application/json").

                when().log().all().
                get("/user/emails").
                then().log().all().
                statusCode(200).extract().jsonPath().getString("[0].visibility");

        System.out.println("Current visibility: " + cuurentVisibility);

        // Send PATCH request to update the visibility to the corresponding one

        String visibility = cuurentVisibility.equals("private") ? "public" : "private";
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"visibility\":\"" + visibility + "\"\n" +
                        "}").
//                body("""
//        {
//            "visibility":"private"
//        }
//                        """).


        when().log().all().
                patch("/user/email/visibility").
                then().log().all().
                statusCode(200).
                time(lessThan(2000L));

    }


    @Test
    public void demoBasicGpathExpressions() {

//        Response response = given().
//        String loginValue = given().
        JsonPath jsonPathObject = given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                when().log().all().
                patch("/user").
                then().log().all().
                assertThat().
                body("login", equalTo("dtacademyb12")).
                and().
//                statusCode(200).extract().response();
//                statusCode(200).extract().path("login");
        statusCode(200).extract().jsonPath();
//
//
//        String loginValue = response.path("login");
//
//        System.out.println("EXTRACTED LOGIN VALUE: " +  loginValue);
//        GPath expressions can be used in body()

        String loginValue = jsonPathObject.getString("login");
        System.out.println(loginValue);

        Map<String, Object> plan = jsonPathObject.get("plan");
        System.out.println(plan);

        Integer b = jsonPathObject.getInt("disk_usage");
        System.out.println(b);

        // To access a nested json use .
        System.out.println(jsonPathObject.getString("plan.name"));
        System.out.println(jsonPathObject.getString("plan.private_repos"));


    }

//


    @Test
    public void demoBasicGpathExpressions2() {

        JsonPath jsonPathObject = given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                queryParam("subject_type", "repository").
                queryParam("subject_id", "699617236").
                pathParam("username", "dtacademyb12").
                when().log().all().
                get("/users/{username}/hovercard").
                then().log().all().

//
        statusCode(200).extract().jsonPath();

        System.out.println(jsonPathObject.getMap("contexts[0]"));
        System.out.println(jsonPathObject.getString("contexts[0].message"));
        System.out.println(jsonPathObject.getString("contexts[0].octicon"));
        System.out.println(jsonPathObject.getMap("$")); // root element in this case is a json object


    }


    @Test
    public void demoBasicGpathExpressions3() {

        JsonPath jsonPathObject = given().
                when().log().all().
                get("/users").
                then().log().all().
                statusCode(200).
                body("[0].login", equalTo("mojombo")).
                body("[0]", hasKey("site_admin")).
                body("", hasSize(30)).
                extract().jsonPath();


//        List<Map<String, Object>> entireResponse = jsonPathObject.get("");
        List<Map<String, Object>> entireResponse = jsonPathObject.get("$"); // $ or an empty string represents the root element, in this case an array
        System.out.println(entireResponse);

        Map<Object, Object> firstElement = jsonPathObject.getMap("[0]"); // gives access to array's first element
        Map<Object, Object> lastElement = jsonPathObject.getMap("[29]");

        System.out.println(firstElement);
        System.out.println(lastElement);

        int idOfFirst = jsonPathObject.getInt("[0].id");
        System.out.println(idOfFirst);


        List<Integer> allIds = jsonPathObject.getList("id");

        System.out.println(allIds);

    }


    @Test
    public void demoBasicGpathExpressions4() {

        Response response = given().header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer " + ConfigReader.getProperty("github.bearer.token")).
                when().log().all().
                get("/user").
                then().log().all().
                body("plan.collaborators", equalTo(0)).
                statusCode(200).extract().response();


        int collaborators = response.path("plan.collaborators");

        Assert.assertEquals(0, collaborators);

        // Verify keys { "name", "space", "collaborators", "private_repos" }

        Map<String, Object> plan = response.path("plan");

        System.out.println(plan);

        // Grab the keys of the map

        Set<String> strings = plan.keySet();

        System.out.println(strings);

        List<String> expected = List.of("name", "space", "collaborators", "private_repos");

        List<String> actual = new ArrayList<>(strings);

        Assert.assertEquals(expected, actual);


    }


    @Test
    public void demoProcessComplexJson() {

        Response response = given().
                pathParam("username", "dtacademyb12").
                when().log().all().
                get("/users/{username}/events").
                then().log().all().
                statusCode(200).extract().response();


        // Find out the number of events returned in the response

        List<Object> list = response.path("$");
        System.out.println(list.size());

        Map firstEvent = response.path("[0]");

        System.out.println(firstEvent);

        String idOfFirst = response.path("[0].id");
        System.out.println(idOfFirst);

        List idOfAll = response.path("id");
        System.out.println(idOfAll);

        List allEvents = response.path("type");
        System.out.println(allEvents);

        String loginOfFirstEventActor = response.path("[0].actor.login");
        System.out.println(loginOfFirstEventActor);

        String nestedValue = response.path("[0].payload.commits[0].author.email");
        System.out.println(nestedValue);

        List allNestedValue = response.path("payload.commits[0].author.email");
        System.out.println(allNestedValue);


    }


    @Test
    public void demoHamcrestMatchers() {

        JsonPath jsonPath = given().
                pathParam("username", "dtacademyb12").
                when().log().all().
                get("/users/{username}/events").
                then().log().all().
                statusCode(200).
                body("[0].actor.id", equalTo(146788956)).
                body("[0].actor.id", is(146788956)).
                body("[0].actor.id", not(equalTo(0))).
                body("[6].payload.pull_request.head.repo.owner.type", not(nullValue())).
                body("[0].id", instanceOf(String.class)).
                body("[0].actor.id", instanceOf(Integer.class)).
                body("[0].public", instanceOf(Boolean.class)).
                body("$", hasSize(30)).
                body("type", hasItem("DeleteEvent")).
                body("type", hasItems("DeleteEvent", "PushEvent")).
                body("type", not(empty())).
//                body("type", contains("DeleteEvent", "PushEvent")).
                body("[6].payload.pull_request.assignees", empty()).
                body("type", everyItem(containsString("Event"))).
                body("type", everyItem(endsWith("Event"))).
                body("[0]", hasKey("actor") ).
                body("[0]", hasKey("type") ).
                body("[0]", allOf( hasKey("type"), hasKey("actor")) ).
//                body("[0]", hasKey("hello") ).
                body("[0]", hasValue("PushEvent") ).
                body("[0]", hasEntry("public", true) ).
                body("[0]", not(equalTo(Collections.EMPTY_MAP)) ).
                body("[0]", not(empty()) ).
                time(lessThan(2000L)).



                extract().jsonPath();


        List<Object> list = jsonPath.getList("repo.name");

        System.out.println(list);

        for (Object object : list) {
            Assert.assertNotNull(object);
        }

    }




}
