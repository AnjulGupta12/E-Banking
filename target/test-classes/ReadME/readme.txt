FUNCTIONAL TESTING

EBANK -> banking application -> service related 
		Access -> http://10.82.180.36/Common/Login.aspx
		create mannual testcases(use off assert)
		convert mannual testcase into automation test scripts (use of test suite)
		
1. Login and logout 
				LOGIN
				a. access to all
				b. first login 
				c. .click signup -> "Register" page 
				d. .click forget password -> "Unlock account/ forgot password" page 
				e. .click login -> validate and  authentication
									if assert is true -> user homepage acc to role 
									if assert is equal customer -> account home page 
									if credential invalid -> acc blocked\ locked\inactive -> display app msg (data inconsistent)
				f. validation
						all field -> mandatory 
						password field -> masked 
						
				LOGOUT 
				a. access for all login user 
				b. everyone has to logout (logout on each page)
				c. .click logout -> values cleared
									redirected to login page 
				d. after logout -> not able to access old data from back button
			
			
2. Accounts
	TRANSACTIONS
				
				MINI RADIO BUTTON
				1. 10 rows of table visible on clicking view transaction
				
				DETAILED BUTTON 
				1. drop down is visible 
				2. --All-- is selected by default and must be at 1st position of drop down
				3. "To Date" and "From Date" is visible 
				
				
3.Services
	Service home page 
		1. A static page is visible 