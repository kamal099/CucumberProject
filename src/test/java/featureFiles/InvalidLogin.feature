Feature: Boost Mobile Website 
Scenario: Boost Mobile User Login
Given when user enterd  boost mobile website"https://www.boostmobile.com/"
And  put invalide cridintial 
When I clicked Login  button
Then I will see error message