Feature: Post status in facebook

	Scenario Outline: Test case for facebook site
	Given Navigate to the facebook url "<fb_URL>"
	When Enter Credentials of facebook "<userName>" and "<password>"
	Then Post the status message Hello World"<message>"

Examples:
|fb_URL| |userName| |password| |message|
|https://facebook.com/| |divya.sampagavi@gmail.com| |Sm9obm55QDEyMw==| |Hello World|