Feature: GetAll Users List
Scenario Outline: Verify if Get Single user  functionality is working

	#Given The BaseURL Payload
	When user calls "getSingleUser" with "GET" http request and with <id>
	Then the API call got success with status code 200
	#And "status" in response body is "OK"
	
	Examples:
	|id|
	|8|
	 
