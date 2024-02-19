@smoke
Feature:F01_Login | users could Login successfully

  Scenario: user got to voda page then login then add products to cart
    When user go to shop page then go back to main page
    And select product to add to cart
    And go to login page and login successfully with MobileNum "01006424428" and Password "Nada_1991"
    And select another product to add them to cart
    Then another product from search bar


