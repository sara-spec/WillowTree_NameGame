Feature:

  @display
  Scenario:
    Given user is on the homepage
    Then verify title is present
    #Verifies name game title is shown

  @counter
  Scenario:
    Given user is on the homepage
    Then verify clicking first picture increases tries counter
    #Verifies "attempts" counter is incremented

  Scenario:
    Given user is on the homepage
    Then verify "streak" counter is incrementing on correct selections

  Scenario:
    Given user is on the homepage
    Then verify the multiple "streak" counter resets after getting an incorrect answer

  Scenario:
    Given user is on the homepage
    Then Verify name and displayed photos change after selecting the correct answer





