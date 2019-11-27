Feature: Boost Mobile User Login
Scenario Outline:: Boost Login Parametrazition
Given when customer put boost url in browser
And  clicked sing in link 
When customer put phone <number> and pin <pin>
Then customer will see the account dashboard

Examples:

|number        | pin  |
|7573587255    |1987  |
|7573101127    |1969  | 
