@MultiRoleUser
Feature: Multi Role User

  @regression @MOB-3601 @MultiRoleUser @MultiRole
  Scenario Outline: user has only one enabled organization with multiple roles within that organization including substitute
    When The substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the role picker
    Examples:
      | userName   | userPassword   |
      | alexaOrgMultirole | FLultra1! |

  @regression @MOB-3601 @MultiRoleUser @MultiOrg
  Scenario Outline: user has multiple organization with multiple roles within these organizations
    When The substitute user launches the app
    Then the substitute user click on Get Started Button and enter the pin
    And Enter username"<userName>" and password"<userPassword>" and click on Sign In button
    Then the user is presented with the org picker
    Examples:
      | userName   | userPassword   |
      | stageMultiMulti | FLultra1! |
