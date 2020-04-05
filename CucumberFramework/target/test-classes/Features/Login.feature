Feature: Login to account at webdriveruniversity.com using login portal

@important
Scenario Outline: Login with credentials
	Given user navigates to "<url>"
	When user clicks on the login portal button
	And user enters the "<username>" username
	And user enters the "<password>" password
	When user clicks the login button
	Then the user should be presented with the following alert "<message>"	
	 
	Examples:
		| 	 				url					|	username	|	password		| 	message					|
		| 	http://www.webdriveruniversity.com	|	user1		|	pass1			|	validation failed		|
		| 	http://www.webdriveruniversity.com	|	webdriver	|	webdriver123	| 	validation succeeded	|
		 
		
		