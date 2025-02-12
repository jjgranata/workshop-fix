package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyRightOf;
import static androidx.test.espresso.assertion.PositionAssertions.isRightOf;
import static androidx.test.espresso.assertion.PositionAssertions.isTopAlignedWith;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anyOf;
import static java.util.EnumSet.allOf;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewAndRankJobsActivityTest {

    @Rule
    public ActivityScenarioRule<ViewAndRankJobsActivity> viewAndRankJobsActivityRule =
            new ActivityScenarioRule<>(ViewAndRankJobsActivity.class);

    @Test
    public void ShouldConfirmWidgetsAreAlignedCorrectly() {
        onView(withId(R.id.compare_two_jobs_button)).check(matches(isDisplayed()));
        onView(withId(R.id.return_to_main)).check(matches(isDisplayed()));

        onView(withId(R.id.return_to_main)).check(isCompletelyBelow(withId(R.id.compare_two_jobs_button)));
    }
    /** Works in isolation but not in the whole test suite no due to data persisting
     * Uncomment and try it in isolation if you want
    @Test
    public void ShouldNotBeAbleToCompareJobsIfThereAreLessThanTwo() {
        onView(withId(R.id.return_to_main)).perform(click());
        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).perform(click());
        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));

        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("A"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("B"));
        onView(withId(R.id.editTextCity)).perform(replaceText("C"));
        onView(withId(R.id.editTextState)).perform(replaceText("VA"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("100"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("1000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("1000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("100"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("10"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("1"));

        onView(withId(R.id.save_and_return_button)).perform(click());

        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).perform(click());
        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));

        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("A"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("B"));
        onView(withId(R.id.editTextCity)).perform(replaceText("C"));
        onView(withId(R.id.editTextState)).perform(replaceText("VA"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("500"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("5000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("5000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("500"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("50"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("5"));

        onView(withId(R.id.save_and_return_button)).perform(click());

        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).perform(click());

        onView(withId(R.id.compare_two_jobs_button)).check(matches(isDisplayed()));
        onView(withId(R.id.return_to_main)).check(matches(isDisplayed()));

        onView(withId(R.id.return_to_main)).check(isCompletelyBelow(withId(R.id.compare_two_jobs_button)));
    }**/

    @Test
    public void ShouldBeAbleToDeleteJobs() {
        onView(withId(R.id.return_to_main)).perform(click());
        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("testTitle"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("testCompany"));
        onView(withId(R.id.editTextCity)).perform(replaceText("testCity"));
        onView(withId(R.id.editTextState)).perform(replaceText("testState"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("100"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("1000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("1000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("100"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("10"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("1"));

        onView(withId(R.id.save_and_return_button)).perform(click());
        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("testTitleagain"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("testCompanyagain"));
        onView(withId(R.id.editTextCity)).perform(replaceText("testCityagain"));
        onView(withId(R.id.editTextState)).perform(replaceText("testStateagain"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("500"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("5000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("5000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("500"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("50"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("5"));

        onView(withId(R.id.save_and_return_button)).perform(click());

        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).perform(click());

        onView(withIndex(withId(R.id.delete_button), 0)).perform(click());
        onView(withIndex(withId(R.id.delete_button), 0)).perform(click());
    }

    @Test
    public void ShouldBeAbleToCompareJobs() {
        onView(withId(R.id.return_to_main)).perform(click());
        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("testCompareTitle"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("testCompareCompany"));
        onView(withId(R.id.editTextCity)).perform(replaceText("testCompareCity"));
        onView(withId(R.id.editTextState)).perform(replaceText("testCompareState"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("499"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("99999"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("4999"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("499"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("49"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("4"));

        onView(withId(R.id.save_and_return_button)).perform(click());
        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("testCompareTitleAgain"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("testCompareCompanyAgain"));
        onView(withId(R.id.editTextCity)).perform(replaceText("testCompareCityAgain"));
        onView(withId(R.id.editTextState)).perform(replaceText("testCompareStateAgain"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("500"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("100000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("5000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("500"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("50"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("5"));

        onView(withId(R.id.save_and_return_button)).perform(click());

        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).perform(click());

        onView(withIndex(withId(R.id.job_checkbox), 0)).perform(click());
        onView(withIndex(withId(R.id.job_checkbox), 1)).perform(click());

        onView(withId(R.id.compare_two_jobs_button)).perform(click());

        onView(withText("Job 1")).check(matches(isDisplayed()));
        onView(withText("Job 2")).check(matches(isDisplayed()));

        onView(withText("testCompareTitleAgain")).check(matches(isDisplayed()));
        onView(withText("testCompareTitle")).check(matches(isDisplayed()));
        onView(withText("testCompareTitleAgain")).check(isCompletelyLeftOf(withText("testCompareTitle")));

        onView(withId(R.id.return_button)).perform(click());
    }

    @Test
    public void ShouldBeAbleToSelectAndDeselectJobs() {
        onView(withId(R.id.return_to_main)).perform(click());
        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("testSelectTitle"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("testSelectCompany"));
        onView(withId(R.id.editTextCity)).perform(replaceText("testSelectCity"));
        onView(withId(R.id.editTextState)).perform(replaceText("testSelectState"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("100"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("1000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("1000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("100"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("10"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("1"));

        onView(withId(R.id.save_and_return_button)).perform(click());
        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("testSelectTitleAgain"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("testSelectCompanyAgain"));
        onView(withId(R.id.editTextCity)).perform(replaceText("testSelectCityAgain"));
        onView(withId(R.id.editTextState)).perform(replaceText("testSelectVirginiaAgain"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("500"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("5000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("5000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("500"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("50"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("5"));

        onView(withId(R.id.save_and_return_button)).perform(click());

        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).perform(click());

        onView(withIndex(withId(R.id.job_checkbox), 0)).perform(click());
        onView(withIndex(withId(R.id.job_checkbox), 1)).perform(click());
        onView(withIndex(withId(R.id.job_checkbox), 0)).check(matches(isChecked()));
        onView(withIndex(withId(R.id.job_checkbox), 1)).check(matches(isChecked()));
        onView(withIndex(withId(R.id.job_checkbox), 0)).perform(click());
        onView(withIndex(withId(R.id.job_checkbox), 1)).perform(click());
        onView(withId(R.id.compare_two_jobs_button)).perform(click());

        onView(withIndex(withId(R.id.job_checkbox), 0)).check(matches(isDisplayed()));
    }

    /* BEGIN SOURCE CODE FROM https://stackoverflow.com/questions/29378552/in-espresso-how-to-avoid-ambiguousviewmatcherexception-when-multiple-views-matc*/
    private static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
    /* END SOURCE CODE FROM https://stackoverflow.com/questions/29378552/in-espresso-how-to-avoid-ambiguousviewmatcherexception-when-multiple-views-matc*/
}
