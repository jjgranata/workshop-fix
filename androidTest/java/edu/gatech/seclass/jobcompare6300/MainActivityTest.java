package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyRightOf;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void ShouldConfirmWidgetsAreAlignedCorrectly() {
        onView(withId(R.id.editTextText)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextText)).check(isCompletelyAbove(withId(R.id.textView4)));
        onView(withId(R.id.editTextText)).check(isCompletelyAbove(withId(R.id.textViewCurJobEntered)));

        onView(withId(R.id.textView4)).check(matches(isDisplayed()));
        onView(withId(R.id.textView4)).check(isCompletelyLeftOf(withId(R.id.textViewCurJobEntered)));
        onView(withId(R.id.textView4)).check(isCompletelyAbove(withId(R.id.textView5)));

        onView(withId(R.id.textViewCurJobEntered)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewCurJobEntered)).check(isCompletelyRightOf(withId(R.id.textView4)));
        onView(withId(R.id.textViewCurJobEntered)).check(isCompletelyAbove(withId(R.id.textViewNumOfJobOffers)));

        onView(withId(R.id.textView5)).check(matches(isDisplayed()));
        onView(withId(R.id.textView5)).check(isCompletelyLeftOf(withId(R.id.textViewNumOfJobOffers)));
        onView(withId(R.id.textView5)).check(isCompletelyAbove(withId(R.id.update_or_create_current_job)));

        onView(withId(R.id.textViewNumOfJobOffers)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewNumOfJobOffers)).check(isCompletelyRightOf(withId(R.id.textView5)));
        onView(withId(R.id.textViewNumOfJobOffers)).check(isCompletelyAbove(withId(R.id.update_or_create_current_job)));

        onView(withId(R.id.update_or_create_current_job)).check(matches(isDisplayed()));
        onView(withId(R.id.update_or_create_current_job)).check(isCompletelyBelow(withId(R.id.textView5)));
        onView(withId(R.id.update_or_create_current_job)).check(isCompletelyBelow(withId(R.id.textViewNumOfJobOffers)));
        onView(withId(R.id.update_or_create_current_job)).check(isCompletelyAbove(withId(R.id.create_job_offer_button)));

        onView(withId(R.id.create_job_offer_button)).check(matches(isDisplayed()));
        onView(withId(R.id.create_job_offer_button)).check(isCompletelyBelow(withId(R.id.update_or_create_current_job)));
        onView(withId(R.id.create_job_offer_button)).check(isCompletelyAbove(withId(R.id.view_and_rank_job_button)));

        onView(withId(R.id.view_and_rank_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.view_and_rank_job_button)).check(isCompletelyBelow(withId(R.id.create_job_offer_button)));
        onView(withId(R.id.view_and_rank_job_button)).check(isCompletelyAbove(withId(R.id.adjust_comparison_settings_button)));

        onView(withId(R.id.adjust_comparison_settings_button)).check(matches(isDisplayed()));
        onView(withId(R.id.adjust_comparison_settings_button)).check(isCompletelyBelow(withId(R.id.view_and_rank_job_button)));
    }

    @Test
    public void ShouldSuccessfullyNavigateToCreateOrUpdateCurrentJobActivity() {
        onView(withId(R.id.update_or_create_current_job)).check(matches(isDisplayed()));
        onView(withId(R.id.update_or_create_current_job)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(withText("Create Or Update New Job")));
    }

    @Test
    public void ShouldSuccessfullyNavigateToCreateNewJobOfferActivity() {
        onView(withId(R.id.create_job_offer_button)).check(matches(isDisplayed()));
        onView(withId(R.id.create_job_offer_button)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(withText("Create New Job Offer")));
    }

    @Test
    public void ShouldSuccessfullyNavigateToAdjustComparisonsActivity() {
        onView(withId(R.id.adjust_comparison_settings_button)).check(matches(isDisplayed()));
        onView(withId(R.id.adjust_comparison_settings_button)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(withText("Adjust Comparison Settings")));
    }

    @Test
    public void ShouldSuccessfullyNavigateToOtherActivityMakeChangeAndSeeChangeInMain() {
        ViewInteraction tv = onView(withId(R.id.textViewNumOfJobOffers));
        String text = getTextFromViewInteraction(tv);
        int num = Integer.parseInt(text);
        text = Integer.toString(num + 1);

        onView(withId(R.id.create_job_offer_button)).check(matches(isDisplayed()));
        onView(withId(R.id.create_job_offer_button)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(withText("Create New Job Offer")));

        onView(withId(R.id.editTextTitle)).perform(typeText("A"));
        onView(withId(R.id.editTextCompany)).perform(typeText("B"));
        onView(withId(R.id.editTextCity)).perform(typeText("C"));
        onView(withId(R.id.editTextState)).perform(typeText("VA"));
        onView(withId(R.id.editTextCostOfLiving)).perform(typeText("100"));
        onView(withId(R.id.editTextYearlySalary)).perform(typeText("1000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(typeText("1000"));
        onView(withId(R.id.editTextTrainingFund)).perform(typeText("100"));
        onView(withId(R.id.editTextLeaveTime)).perform(typeText("10"));
        onView(withId(R.id.editTextTeleworkDays)).perform(typeText("1"));

        onView(withId(R.id.save_and_return_button)).perform(click());
        onView(withId(R.id.create_job_offer_button)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewNumOfJobOffers)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewNumOfJobOffers)).check(matches(withText(text)));
    }

    /*BEGIN SOURCE CODE FROM https://stackoverflow.com/questions/23381459/how-to-get-text-from-textview-using-espresso */
    private String getTextFromViewInteraction(ViewInteraction matcher) {
        final String[] stringHolder = { null };
        matcher.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }
    /*END SOURCE CODE FROM https://stackoverflow.com/questions/23381459/how-to-get-text-from-textview-using-espresso */

}
