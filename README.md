# NoFluffJobs---testing

Simple UI testing for nofluffjobs.com

Page objects:
1)Framework:
  1.1)	Base - 
        it has a WebDriver that is used by others page objects;
  1.2)	IConstans.
2)Pages:
  2.1)	CompaniesProfile - 
        Using the company search filter, is selected a specific letter from the filter list and then is selected the company that the tester is interested;
  2.2)	Employers - 
        Tests are conducted with the counting of elements in tabs: price, clients, events;
  2.3)	MainPage - 
        We check, if we are actually on the NFJ page, using the corresponding NFJ logo. Also, tests conducted for changing the language, changing the country, and the number of           job offers;
  2.4)	MasterClass - 
        When we go to the MasterClass page, it opens in a new window. Therefore, a simple test is performed on the "child" page with a return to the "parent" page;
  2.5)	PricingList - price comparison, the test is written at an elementary level
        The prices that are compared must match with prices shown on the web-page. Method checkValueResults compared  methods getExpectedResults with actualResults, their values           must match each other;
  2.6)	PricingList2 - price comparison, the test is written at an intermediate level. 
        The PricingList was modified;
  2.7)	PricingList3 - price comparison, the test is written at an advanced level. 
        The PricingList2 was modified;
3)uitest:
  3.1)	TestNFJ - 
        Tests suite;

