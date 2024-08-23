package demo_pro1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {

	 public static void main(String[] args) {
	        RestAssured.baseURI = "https://rahulshettyacademy.com";

	        String response= given().log().all()
	                .queryParam("key", "qaclick123")
	                .header("Content-Type", "application/json")
	                .body("{\n" +
	                        "  \"location\": {\n" +
	                        "    \"lat\": -38.383494,\n" +
	                        "    \"lng\": 33.427362\n" +
	                        "  },\n" +
	                        "  \"accuracy\": 50,\n" +
	                        "  \"name\": \"Frontline house\",\n" +
	                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
	                        "  \"address\": \"29, side layout, cohen 09\",\n" +
	                        "  \"types\": [\n" +
	                        "    \"shoe park\",\n" +
	                        "    \"shop\"\n" +
	                        "  ],\n" +
	                        "  \"website\": \"http://google.com\",\n" +
	                        "  \"language\": \"French-IN\"\n" +
	                        "}")
	                .when().post("maps/api/place/add/json")
	                .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
	                .header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
	       
	       System.out.println(response);
	       
	       JsonPath js = new JsonPath(response);
	    String placeId =   js.getString("place_id");
	    System.out.println(placeId);
	    
	    //update place
	    
	    String newAddress = "70 winter walk, USA";
	   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	   .body(" {\n"
	   		+ "    \"place_id\": \""+placeId+"\",\n"
	   		+ "    \"address\": \""+newAddress+"\",\n"
	   		+ "    \"key\": \"qaclick123\"\n"
	   		+ "}\n"
	   		+ "")
	   .when().put("maps/api/place/update/json")
	   .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	    
	    //get place
	   
	String getPlaceResponse =  given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
	   .when().get("maps/api/place/get/json")
	   .then().log().all().statusCode(200).extract().response().asString();
	  

	
	JsonPath js1 = new JsonPath(getPlaceResponse);
	String actualAddress =js1.getString("address");

	System.out.println(actualAddress);
	
	Assert.assertEquals(actualAddress, newAddress);
	    }
	 
}
