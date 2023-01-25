@eBooks
Feature: Check console errors on eBooks

  @withoutLogin
  Scenario: Check console errors on eBooks pages
  Given user is the on home page
  Then click on eBooks text and check console error
  Then select option from sort By and check the console error
  Then click on buy now button and check console error

 
  @withLogin
  Scenario: Check console errors on eBooks pages withlogin
  Given user is the on home page 
  Then Enter paid user name "sumit.kumar@slidetech.in" and password "redhat2090"
  And verify that user should be on suscription page
  Then click on eBooks text and check console error
  Then select option from sort By and check the console error
  Then Logout from the application and verify the page
