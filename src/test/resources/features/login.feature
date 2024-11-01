Feature: Login functionality

  Scenario Outline: Manage products in the cart
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the homepage
    And the user verifies they are on the products page
    When the user adds "<firstProduct>" and "<secondProduct>" to the cart
    Then the user verifies the products are successfully added to the cart
    When the user removes "<firstProduct>" and "<secondProduct>" from the cart
    Then the user verifies the products are successfully removed from the cart
    When the user adds "<thirdProduct>" and "<fourthProduct>" to the cart
    Then the user verifies the products are successfully added to the cart
    When the user goes to the cart
    Then the user verifies the products "<thirdProduct>" and "<fourthProduct>" are displayed in the cart

    Examples:
      | firstProduct        | secondProduct         | thirdProduct            | fourthProduct           |
      | sauce-labs-backpack | sauce-labs-bike-light | sauce-labs-bolt-t-shirt | sauce-labs-fleece-jacket |
