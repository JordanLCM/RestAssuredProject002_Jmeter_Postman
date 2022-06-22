Feature: Cucumber with rest assured

#Scenario: Sample Scene 1
#Given A base URL "http://reqres.in"
#And A sample step
#And path is "/api/users?page=2"
#When User send get request
#Then print response
#Then test "total" equals 12
#Then test "data[1].id" equals 8
#Then test "data.email" has "lindsay.ferguson@reqres.in"
#Then test "data[0]" has key "first_name"
#
#Scenario: Sample Scene 2
#Given A base URL "http://reqres.in"
#And path is "/api/users?page=3"
#When User send get request
#Then print response

Scenario: Sample Scene 3
Given A base URL "https://reqres.in"
And path is "/api/users"
And payload file is "payload_cu.json"
When User send post request
Then print response
And status code is 201