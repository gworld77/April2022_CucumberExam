Feature: check sky color

background : Given User is on techfios test page 

Scenario:1  Sky Blue Background
Given Set SkyBlue Background button exists
When I click on the button
Then the background color will change to sky blue

Scenario:2 White Background Change
Given Set SkyWhite Background button exists
When I click on the button
Then the background color will change to white
