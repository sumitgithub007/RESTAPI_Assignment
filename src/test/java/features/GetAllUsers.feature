Feature: GetAll Users List
Scenario: Verify if GetAll user functionality is working

	#Given The BaseURL Payload
	When user calls "getListUser" with "GET" http request 
	Then the API call got success with status code 200
	#And "status" in response body is "OK"
	 
