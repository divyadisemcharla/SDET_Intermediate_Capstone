Feature: F1

@Sample
Scenario: Search Hyderabad to MAA flights
Given MakeMyTrip application is launched
When User click Flights and select RoundTrip
And User select fromCity "Hyderabad" and toCity "MAA"
And User select Departure and Return dates
And User clicks on Search button
And User validate search page is displayed
Then User quits from the browser
