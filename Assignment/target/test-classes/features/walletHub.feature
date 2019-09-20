Feature: Rate the walletHub site

	Scenario Outline: Test case for wallethub site
	Given Navigate to the "<login_URL>"
	When Enter Credentials "<emailId>" and "<password>"
	When Navigate to the trust insurance company "<URL>"
	When Writing a Review with rating and selecting the section "<index>" and entering the comments "<comments>"
	Then Check the review feed in profile "<profile_url>"

Examples:
|login_URL| |emailId| |password| |URL| |index| |comments| |profile_url|
|https://wallethub.com/join/login| |divya.sampagavi@gmail.com| |Sm9obm55QDEyMw==| |https://wallethub.com/profile/test_insurance_company| |2| |Health insurance is an insurance that covers the whole or a part of the risk of a person incurring medical expenses, spreading the risk over a large number of persons.The benefit is administered by a central organization such as a government agency, private business, or not-for-profit entity.| |https://wallethub.com/profile/divya_sampagavi/reviews/|

