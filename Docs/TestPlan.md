

# Test Plan v2


**Author**: Team097
Version 2 fleshes out testing more with unit testing, automatic testing, and removes manual testing.

## 1 Testing Strategy

### 1.1 Overall strategy

The QE will unit/system test where possible and develop unit tests for each individual class. The QE will also conduct integration testing at highest class setting to ensure proper main class function. The QE will develop integration tests that boot the app and interact with the GUI. Each developer will be responsible for regression testing their new additions.  


### 1.2 Test Selection

We will use white box and black box unit testing at the class level and component level. We will utilize white box testing to unit test specific functionality and black box testing to test the flow of the program, via the form of an automatic test suite.

### 1.3 Adequacy Criterion

We will use code coverage for unit testing to qualify the quality of the test cases.  At the system integration level, the QE will build tests that utilize every possible GUI element and function.


### 1.4 Bug Tracking

Bugs and new feature requests will be issued in team meetings/chats.  Developers will be responsible for identifying the 'Issue' related to their personal responsibilities and trace deliverables to the 'Issue'.

### 1.5 Technology

We intend to use JUnit for class and component testing. We will use Espresso for GUI testing.

## 2 Test Cases

### 2.1 Unit Tests

| Test Name         | Purpose     | Steps to perform | Expected Result | Actual Result | Pass/Fail | Additional | 
|--------------|-----------|------------|------------|------------|------------|------------|
| CompareJobsSingletonTest.ShouldMakeNewInstanceIfInstanceIsNull |     To confirm new instance can be made    |       Right click (test) package and click "Run Tests"     |  Should Make New Instance If Instance Is Null         |     Can Successfully Make New Instance If Instance Is Null      |    Pass      |           |
| CompareJobsSingletonTest.ShouldGetExistingInstanceIfExists|     To confirm existing instance persists to be used    |       Right click (test) package and click "Run Tests"     |  Should Get Existing Instance If Exists         |     Can Successfully Get Existing Instance If Exists      |    Pass      |           |
| CompareJobsSingletonTest.ShouldReturnScoreForValidInputJob|     To confirm score can be returned    |       Right click (test) package and click "Run Tests"     |  Should Return Score For Valid Input Job         |     Can Successfully Return Score For Valid Input Job      |    Pass      |           |
| CompareJobsSingletonTest.ShouldThrowExceptionOnInvalidJobInput|     To confirm invalid input job is handled appropriately    |       Right click (test) package and click "Run Tests"     |  Should Throw Exception On Invalid Job Input         |     Can Successfully Throw Exception On Invalid Job Input      |    Pass      |           |
| CompareJobsSingletonTest.ShouldReturnEmptyListWhenSortingZeroJobs|     To confirm empty list is handled appropriately    |       Right click (test) package and click "Run Tests"     |  Should Return Empty List When Sorting Zero Jobs         |     Can Successfully Return Empty List When Sorting Zero Jobs      |    Pass      |           |
| CompareJobsSingletonTest.ShouldSortJobsOfSizeOne|     To confirm list of size 1 is handled appropriately    |       Right click (test) package and click "Run Tests"     |  Should Sort Jobs Of Size One         |     Can Successfully Sort Jobs Of Size One      |    Pass      |           |
| CompareJobsSingletonTest.ShouldSortJobsAccordingToScore|     To confirm jobs are sorted by score appropriately    |       Right click (test) package and click "Run Tests"     |  Should Sort Jobs According To Score         |     Can Successfully Sort Jobs According To Score      |    Pass      |           |
| CompareJobsSingletonTest.ShouldSuccessfullyAssignWeights|     To confirm jobs are successfully assigned weights    |       Right click (test) package and click "Run Tests"     |  Should Successfully Assign Weights         |     Can Successfully Assign Weights      |    Pass      |           |
| CompareJobsSingletonTest.ShouldNotAssignNegativeWeights|     To confirm jobs are not assigned negative weights    |       Right click (test) package and click "Run Tests"     |  Should Not Assign Negative Weights         |     Can Successfully Not Assign Negative Weights     |    Pass      |           |
| CompareJobsSingletonTest.ShouldNotAssignWeightsGreaterThanNine|     To confirm jobs are not assigned weights greater than 9   |       Right click (test) package and click "Run Tests"     |  Should Not Assign Weights Greater Than Nine         |     Can Successfully Not Assign Weights Greater Than Nine     |    Pass      |           |
| CurrentJobSingletonTest.ShouldMakeNewInstanceIfInstanceIsNull|     To confirm new instance can be made   |       Right click (test) package and click "Run Tests"     |  Should Make New Instance If Instance Is Null         |     Can Successfully Make New Instance If Instance Is Null     |    Pass      |           |
| CurrentJobSingletonTest.ShouldGetExistingInstanceIfExists|     To confirm instance persists if already made   |       Right click (test) package and click "Run Tests"     |  Should Get Existing Instance If Exists         |     Can Successfully Get Existing Instance If Exists     |    Pass      |           |
| CurrentJobSingletonTest.ShouldUpdateCurrentJobWithValidInput|     To confirm job can be updated with valid input   |       Right click (test) package and click "Run Tests"     |  Should Update Current Job With Valid Input       |     Can Successfully Update Current Job With Valid Input     |    Pass      |           |
| CurrentJobSingletonTest.ShouldConfirmJobIsNotValid|     To confirm job is not valid   |       Right click (test) package and click "Run Tests"     |  Should Confirm Job Is Not Valid       |     Can Successfully Confirm Job Is Not Valid     |    Pass      |           |
| JobOffersSingletonTest.ShouldMakeNewInstanceIfInstanceIsNull|     To confirm new instance can be made  |       Right click (test) package and click "Run Tests"     |  Should Make New Instance If Instance Is Null       |     Can Successfully Make New Instance If Instance Is Null     |    Pass      |           |
| JobOffersSingletonTest.ShouldGetExistingInstanceIfExists|     To confirm instance persists if already made  |       Right click (test) package and click "Run Tests"     |  Should Get Existing Instance If Exists       |     Can Successfully Get Existing Instance If Exists     |    Pass      |           |
| JobOffersSingletonTest.ShouldRemoveJobOffer|     To confirm job offer can be removed  |       Right click (test) package and click "Run Tests"     |  Should Remove Job Offer       |     Can Successfully Remove Job Offer  |    Pass      |           |
| JobOfferTest.ShouldCreateNewJobWithValidInput|     To confirm job can be made  |       Right click (test) package and click "Run Tests"     |  Should Create New Job With Valid Input       |     Can Successfully Create New Job With Valid Input  |    Pass      |           |
| LocationTest.ShouldCreateNewLocationWithValidInput|     To confirm location can be made  |       Right click (test) package and click "Run Tests"     |  Should Create New Location With Valid Input       |     Can Successfully Create New Location With Valid Input  |    Pass      |           |
| JobForComparisonTest.ShouldComputeDynamicBonusAdjustedForCostOfLiving|     To confirm bonus with cost of living can be computed dynamically  |       Right click (test) package and click "Run Tests"     |  Should Compute Dynamic Bonus Adjusted For Cost Of Living       |     Can Successfully Compute Dynamic Bonus Adjusted For Cost Of Living  |    Pass      |           |
| DatabaseHelperJobOffersTest.ShouldCreateAndDropDatabase|     To confirm database can be created and deleted  |       Right click (test) package and click "Run Tests"     | Should Create And Drop Database       |     Can Successfully Create And Drop Database  |    Pass      |           |
| DatabaseHelperJobOffersTest.ShouldInsertDataAndVerifyCorrect|     To confirm database can insert and verify correctness of data  |       Right click (test) package and click "Run Tests"     | Should Insert Data And Verify Correct       |     Can Successfully Insert Data And Verify Correct  |    Pass      |           |
| DatabaseHelperTest.ShouldCreateAndDropDatabase|     To confirm database can be created and deleted  |       Right click (test) package and click "Run Tests"     | Should Create And Drop Database       |     Can Successfully Create And Drop Database  |    Pass      |           |
| DatabaseHelperTest.ShouldInsertDataAndVerifyCorrect|     To confirm database can insert and verify correctness of data  |       Right click (test) package and click "Run Tests"     | Should Insert Data And Verify Correct       |     Can Successfully Insert Data And Verify Correct  |    Pass      |           |
| JobDatabaseTest.ShouldCreateAndDropDatabase|     To confirm database can be created and deleted  |       Right click (test) package and click "Run Tests"     | Should Create And Drop Database       |     Can Successfully Create And Drop Database  |    Pass      |           |
| JobDatabaseTest.ShouldInsertData |     To confirm database can insert data  |       Right click (test) package and click "Run Tests"     | Should Insert Data      |     Can Successfully Insert Data  |    Pass      |           |
| SettingsSaverTest.ShouldSaveSettings|     To confirm database can save settings  |       Right click (test) package and click "Run Tests"     | Should Save Settings     |     Can Successfully Save Settings  |    Pass      |           |
| SettingsSaverTest.ShouldGetSettings|     To confirm database can get settings  |       Right click (test) package and click "Run Tests"     | Should Get Settings     |     Can Successfully Get Settings  |    Pass      |           |

### 2.2 Espresso Tests
Note: To ensure the success of this automatic test suite, it is essential no data is pre-loaded into the app prior to running the test suite. If there is, be sure to delete pre-existing data and start from a clean slate of the app.

| Test Name         | Purpose     | Steps to perform | Expected Result | Actual Result | Pass/Fail | Additional | 
|--------------|-----------|------------|------------|------------|------------|------------|
| MainActivityTest.ShouldConfirmWidgetsAreAlignedCorrectly |     Test Main Menu GUI displays correctly    |       Right click (androidTest) package and click "Run Tests"     |  Test confirms Main Menu GUI is formatted correctly         |      Main Menu GUI is correctly aligned     |     Pass      |           |
| MainActivityTest.ShouldSuccessfullyNavigateToCreateOrUpdateCurrentJobActivity|     Test Main Menu GUI can navigate to create or update current job screen    |       Right click (androidTest) package and click "Run Tests"     |  Should Successfully Navigate To Create Or Update Current Job Activity   |      Main Menu GUI can Successfully Navigate To Create Or Update Current Job Screen |     Pass      |           |
| MainActivityTest.ShouldSuccessfullyNavigateToCreateNewJobOfferActivity|     Test Main Menu GUI can navigate to create new job offer screen    |       Right click (androidTest) package and click "Run Tests"     |  Should Successfully Navigate To Create New Job Offer Activity   |      Main Menu GUI can Successfully Navigate To Create New Job Offer Activity |     Pass      |           |
| MainActivityTest.ShouldSuccessfullyNavigateToAdjustComparisonsActivity|     Test Main Menu GUI can navigate to adjust comparisons activity screen    |       Right click (androidTest) package and click "Run Tests"     |  Should Successfully Navigate To Adjust Comparisons Activity   |      Main Menu GUI can Successfully Navigate To Adjust Comparisons Activity |     Pass |           |
| MainActivityTest.ShouldSuccessfullyNavigateToOtherActivityMakeChangeAndSeeChangeInMain |     Test Main Menu GUI can navigate to other activities, make changes, and confirm changes on main menu    |       Right click (androidTest) package and click "Run Tests"     |  Should Successfully Navigate To Other Activity Make Change And See Change In Main    |      Main Menu GUI can Successfully Navigate To Other Activity Make Change And See Change In Main  |     Pass |           |
| AdjustComparisonSettingsActivityTest.ShouldConfirmWidgetsAreAlignedCorrectly|     To Confirm Widgets Are Aligned Correctly On Adjust Comparison Settings Activity    |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm Widgets Are Aligned Correctly    |      Adjust Comparison Settings Gui is correctly aligned  |     Pass |           |
| AdjustComparisonSettingsActivityTest.ShouldBeAbleToSaveAndReturnInfoAndConfirmSettingsPersist|     To Confirm One Is Able To Save And Return Info And Confirm Settings Persist    |       Right click (androidTest) package and click "Run Tests"     |  Should Be Able To Save And Return Info And Confirm Settings Persist    |      Adjust Comparison Settings Gui Is Able To Save And Return Info And Confirm Settings Persist  |     Pass |           |
| AdjustComparisonSettingsActivityTest.ShouldConfirmOnCancelSettingsAreNotSaved|     To Confirm On Cancel Settings Are Not Saved    |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm On Cancel Settings Are Not Saved    |      Adjust Comparison Settings Gui Can Confirm On Cancel Settings Are Not Saved  |     Pass |           |
| CreateNewJobOfferActivityTest.ShouldConfirmWidgetsAreAlignedCorrectly|     To Confirm Widgets Are Aligned Correctly On Create New Job Offer Activity    |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm Widgets Are Aligned Correctly    |      Create New Job Offer Activity Gui Can Confirm Widgets Are Aligned Correctly  |     Pass |           |
| CreateNewJobOfferActivityTest.ShouldEnterJobAndSaveAndReturn|     To Confirm One Can Enter Job And Save And Return    |       Right click (androidTest) package and click "Run Tests"     |  Should Enter Job And Save And Return    |      Create New Job Offer Activity Gui Can Enter Job And Save And Return  |     Pass |           |
| CreateNewJobOfferActivityTest.ShouldEnterJobAndSaveAndCreateAnotherOne|     To Confirm One Can Enter Job And Save And Create Another One    |       Right click (androidTest) package and click "Run Tests"     |  Should Enter Job And Save And Create Another One   |      Create New Job Offer Activity Gui Can Enter Job And Save And Create Another One  |     Pass |           |
| CreateNewJobOfferActivityTest.ShouldNotCompareWithCurrentJobIfThereIsNone|     To Confirm One Can Not Compare With Current Job If There Is None    |       Right click (androidTest) package and click "Run Tests"     |  Should Not Compare With Current Job If There Is None   |      Create New Job Offer Activity Gui Can Not Compare With Current Job If There Is None  |     Pass |           |
| CreateNewJobOfferActivityTest.ShouldCompareWithCurrentJobIfExists|     To Confirm One Can Compare With Current Job If Exists    |       Right click (androidTest) package and click "Run Tests"     |  Should Compare With Current Job If Exists  |      Create New Job Offer Activity Gui Can Compare With Current Job If Exists  |     Pass |           |
| CreateNewJobOfferActivityTest.ShouldConfirmCancel|     To Confirm One Can Cancel   |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm Cancel |      Create New Job Offer Activity Gui Can Cancel  |     Pass |           |
| CreateOrUpdateCurrentJobActivityTest.ShouldConfirmWidgetsAreAlignedCorrectly|      To Confirm Widgets Are Aligned Correctly On Create Or Update Current Job Activity   |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm Widgets Are Aligned Correctly |      Create New Job Offer Activity Gui Can Confirm Widgets Are Aligned Correctly |     Pass |           |
| CreateOrUpdateCurrentJobActivityTest.ShouldEnterAndSaveJob|      To Confirm One Can Enter And Save Job   |       Right click (androidTest) package and click "Run Tests"     |  Should Enter And Save Job |      Create New Job Offer Activity Gui Can Enter And Save Job |     Pass |           |
| CreateOrUpdateCurrentJobActivityTest.ShouldConfirmCancel|      To Confirm One Can Cancel   |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm Cancel |      Create New Job Offer Activity Gui Can Cancel |     Pass |           |
| ViewAndRankJobsActivityTest.ShouldConfirmWidgetsAreAlignedCorrectly|      To Confirm Widgets Are Aligned Correctly on View And Rank Jobs Activity Gui  |       Right click (androidTest) package and click "Run Tests"     |  Should Confirm Widgets Are Aligned Correctly |      View And Rank Jobs Activity Gui Can Confirm Widgets Are Aligned Correctly|     Pass |           |
| ViewAndRankJobsActivityTest.ShouldBeAbleToDeleteJobs|      To Confirm One Is Able To Delete Jobs  |       Right click (androidTest) package and click "Run Tests"     |  Should Be Able To Delete Jobs |      View And Rank Jobs Activity Gui Can Delete Jobs|     Pass |           |
| ViewAndRankJobsActivityTest.ShouldBeAbleToCompareJobs|      To Confirm One Is Able To Compare Jobs  |       Right click (androidTest) package and click "Run Tests"     |  Should Be Able To Compare Jobs |      View And Rank Jobs Activity Gui Can Compare Jobs|     Pass |           |
| ViewAndRankJobsActivityTest.ShouldBeAbleToSelectAndDeselectJobs|      To Confirm One Is Able To Select And Deselect Jobs  |       Right click (androidTest) package and click "Run Tests"     |  Should Be Able To Select And Deselect Jobs |      View And Rank Jobs Activity Gui Can Select And Deselect Jobs|     Pass |           |

