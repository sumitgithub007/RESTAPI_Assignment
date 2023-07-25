package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import pojo.Address;
import pojo.Company;
import pojo.Geo;
import pojo.GetPosts;
import pojo.Root;
import pojo.GetAlbums;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	public String url;
	public ObjectMapper objectMapper;

	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		// res=given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		url = Utils.getGlobalValue("baseUrl") + resourceAPI.getResource();

		System.out.println(url);
		String jsonarray = given().queryParam("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
				.when().get(url).asString();

		objectMapper = new ObjectMapper();

		List<Root> listData = objectMapper.readValue(jsonarray, new TypeReference<List<Root>>() {
		});

		for (int i = 0; i < listData.size(); ++i) {
			Root root = listData.get(i);
			System.out.println("id =" + root.getId());
			System.out.println("name =" + root.getName());

			System.out.println("username =" + root.getUsername());
			System.out.println(root.getEmail());
			System.out.println(root.getPhone());
			System.out.println(root.getWebsite());

			Address add = root.getAddress();
			System.out.println(add.getStreet());
			System.out.println(add.getSuite());
			System.out.println(add.getCity());
			System.out.println(add.getZipcode());

			Company c = root.getCompany();
			System.out.println(c.getName());
			System.out.println(c.getCatchPhrase());
			System.out.println(c.getBs());

			Geo geo = add.getGeo();
			System.out.println(geo.getLat());
			System.out.println(geo.getLng());

			System.out.println("-------------------------------------------------");

		}

	}

	
	
	 
	@When("user calls  the request {string} with {string} http request along with {int}")
	public void user_calls_the_request_with_http_request_along_with(String resource, String string2, Integer id) throws IOException {
	    
		  APIResources resourceAPI = APIResources.valueOf(resource);
			System.out.println(resourceAPI.getResource());
			  url = Utils.getGlobalValue("baseUrl") + resourceAPI.getResource() + id + "/albums";
			
			System.out.println(url);
			String jsonarray = given().queryParam("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
					.when().get(url).asString();

			  objectMapper = new ObjectMapper();
			  
			  
			  
				String jsonval = given().queryParam("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
						.when().get(url).asString();

				
				  objectMapper = new ObjectMapper();


				  List<GetAlbums> albums = objectMapper.readValue(jsonarray, new TypeReference<List<GetAlbums>>() {
					});
		 
				  
				  
				  
				  for(int i=0;i<albums.size();++i) {
					  
					  
					  
					  System.out.println("user id  is = " +albums.get(i).userId);
					  System.out.println("id is = " +albums.get(i).id);
					  System.out.println("album title  = " +albums.get(i).title);
					   
					  System.out.println("-------------------------------------------");
					  
					  
					  
				  }

		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions

		int code = given().queryParam("Content-Type", "application/json").when().get(url).statusCode();
		assertEquals(code, 200);

	}

	@When("user calls {string} with {string} http request and with {int}")
	public void user_calls_with_http_request_and_with(String resource, String string2, int id) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		url = Utils.getGlobalValue("baseUrl") + resourceAPI.getResource() + id;

		System.out.println(url);
		String jsonval = given().queryParam("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
				.when().get(url).asString();

		objectMapper = new ObjectMapper();

		Root root = objectMapper.readValue(jsonval, Root.class);

		System.out.println("id =" + root.getId());
		System.out.println("name =" + root.getName());

		System.out.println("username =" + root.getUsername());
		System.out.println(root.getEmail());
		System.out.println(root.getPhone());
		System.out.println(root.getWebsite());

		Address add = root.getAddress();
		System.out.println(add.getStreet());
		System.out.println(add.getSuite());
		System.out.println(add.getCity());
		System.out.println(add.getZipcode());

		Company c = root.getCompany();
		System.out.println(c.getName());
		System.out.println(c.getCatchPhrase());
		System.out.println(c.getBs());

		Geo geo = add.getGeo();
		System.out.println(geo.getLat());
		System.out.println(geo.getLng());
		
		System.out.println("=======================================");

	}

	@When("user calls {string} with {string} http request along with {int}")
	public void user_calls_with_http_request_along_with(String resource, String string2, Integer id) throws IOException {
	    
		 //Get posts
		   APIResources resourceAPI = APIResources.valueOf(resource);
			System.out.println(resourceAPI.getResource());
			  url = Utils.getGlobalValue("baseUrl") + resourceAPI.getResource() + id + "/posts";
			
			System.out.println(url);
			String jsonarray = given().queryParam("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
					.when().get(url).asString();

			  objectMapper = new ObjectMapper();
			  
			  
			  
				String jsonval = given().queryParam("Content-Type", "application/json").expect().defaultParser(Parser.JSON)
						.when().get(url).asString();

				
				  objectMapper = new ObjectMapper();


					List<GetPosts> post = objectMapper.readValue(jsonarray, new TypeReference<List<GetPosts>>() {
					});

				  
				  for(int i=0;i<post.size();++i) {
					  
					  
					  
					  System.out.println("user id  is = " +post.get(i).userId);
					  System.out.println("id is = " +post.get(i).id);
					  System.out.println("posts title  = " +post.get(i).title);
					  System.out.println("posts body = "+ post.get(i).body);
					  
					  System.out.println("-------------------------------------------");
					  
					  
					  
				  }
  			  
			  

		 
		 
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, keyValue), Expectedvalue);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {

		// requestSpec
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedName);

	}

}
