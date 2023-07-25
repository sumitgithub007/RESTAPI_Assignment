Feature:  Retrieve a list of albums for a specific user.
Scenario Outline:  Verify if Retreive albums of  user functionality is working

	#Given The BaseURL Payload
	When user calls  the request "getAlbums" with "GET" http request along with <id>
Then the API call got success with status code 200
	#And "status" in response body is "OK"
	 
	Examples:
	|id|
	|7|
	 
	 


 