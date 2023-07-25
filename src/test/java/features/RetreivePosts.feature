Feature: Retreive the posts of user
Scenario Outline:  Verify if Retreive posts of  user functionality is working

	#Given The BaseURL Payload
	When user calls "getPosts" with "GET" http request along with <id>
Then the API call got success with status code 200
	#And "status" in response body is "OK"
	 
	Examples:
	|id|
	|6|
	 
	 