package stepDefinations;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

public class GetAlluser extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	static String place_id;
}
	
