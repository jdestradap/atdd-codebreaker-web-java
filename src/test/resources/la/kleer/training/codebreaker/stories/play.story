Scenario: User plays all wrong

Given the secret code is "1234"
When I try with "5555"
Then I should see "Your Last Result Was: []"

Scenario: User plays all ok

Given the secret code is "1234"
When I try with "1234"
Then I should see "Your Last Result Was: [XXXX]"
