package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateNewJobOfferActivityTest {

    @Rule
    public ActivityScenarioRule<CreateNewJobOfferActivity> createNewJobOfferActivityRule =
            new ActivityScenarioRule<>(CreateNewJobOfferActivity.class);

    @Test
    public void ShouldConfirmWidgetsAreAlignedCorrectly() {
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(isCompletelyAbove(withId(R.id.textViewTitle)));
        onView(withId(R.id.textView)).check(isCompletelyAbove(withId(R.id.editTextTitle)));

        onView(withId(R.id.textViewTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTitle)).check(isCompletelyLeftOf(withId(R.id.editTextTitle)));
        onView(withId(R.id.textViewTitle)).check(isCompletelyAbove(withId(R.id.textViewCompany)));

        onView(withId(R.id.editTextTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTitle)).check(isCompletelyRightOf(withId(R.id.textViewTitle)));
        onView(withId(R.id.editTextTitle)).check(isCompletelyAbove(withId(R.id.editTextCompany)));

        onView(withId(R.id.textViewCompany)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewCompany)).check(isCompletelyLeftOf(withId(R.id.editTextCompany)));
        onView(withId(R.id.textViewCompany)).check(isCompletelyAbove(withId(R.id.textViewState)));

        onView(withId(R.id.editTextCompany)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextCompany)).check(isCompletelyRightOf(withId(R.id.textViewCompany)));
        onView(withId(R.id.editTextCompany)).check(isCompletelyAbove(withId(R.id.editTextState)));

        onView(withId(R.id.textViewState)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewState)).check(isCompletelyLeftOf(withId(R.id.editTextState)));
        onView(withId(R.id.textViewState)).check(isCompletelyAbove(withId(R.id.textViewCity)));

        onView(withId(R.id.editTextState)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextState)).check(isCompletelyRightOf(withId(R.id.textViewState)));
        onView(withId(R.id.editTextState)).check(isCompletelyAbove(withId(R.id.editTextCity)));

        onView(withId(R.id.textViewCity)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewCity)).check(isCompletelyLeftOf(withId(R.id.editTextCity)));
        onView(withId(R.id.textViewCity)).check(isCompletelyAbove(withId(R.id.textViewCostOfLiving)));

        onView(withId(R.id.editTextCity)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextCity)).check(isCompletelyRightOf(withId(R.id.textViewCity)));
        onView(withId(R.id.editTextCity)).check(isCompletelyAbove(withId(R.id.editTextCostOfLiving)));

        onView(withId(R.id.textViewCostOfLiving)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewCostOfLiving)).check(isCompletelyLeftOf(withId(R.id.editTextCostOfLiving)));
        onView(withId(R.id.textViewCostOfLiving)).check(isCompletelyAbove(withId(R.id.textViewYearlySalary)));

        onView(withId(R.id.editTextCostOfLiving)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextCostOfLiving)).check(isCompletelyRightOf(withId(R.id.textViewCostOfLiving)));
        onView(withId(R.id.editTextCostOfLiving)).check(isCompletelyAbove(withId(R.id.editTextYearlySalary)));

        onView(withId(R.id.textViewYearlySalary)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewYearlySalary)).check(isCompletelyLeftOf(withId(R.id.editTextYearlySalary)));
        onView(withId(R.id.textViewYearlySalary)).check(isCompletelyAbove(withId(R.id.textViewYearlyBonus)));

        onView(withId(R.id.editTextYearlySalary)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlySalary)).check(isCompletelyRightOf(withId(R.id.textViewYearlySalary)));
        onView(withId(R.id.editTextYearlySalary)).check(isCompletelyAbove(withId(R.id.editTextYearlyBonus)));

        onView(withId(R.id.textViewYearlyBonus)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewYearlyBonus)).check(isCompletelyLeftOf(withId(R.id.editTextYearlyBonus)));
        onView(withId(R.id.textViewYearlyBonus)).check(isCompletelyAbove(withId(R.id.textViewTrainingFund)));

        onView(withId(R.id.editTextYearlyBonus)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlyBonus)).check(isCompletelyRightOf(withId(R.id.textViewYearlyBonus)));
        onView(withId(R.id.editTextYearlyBonus)).check(isCompletelyAbove(withId(R.id.editTextTrainingFund)));

        onView(withId(R.id.textViewTrainingFund)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTrainingFund)).check(isCompletelyLeftOf(withId(R.id.editTextTrainingFund)));
        onView(withId(R.id.textViewTrainingFund)).check(isCompletelyAbove(withId(R.id.textViewLeaveTime)));

        onView(withId(R.id.editTextTrainingFund)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTrainingFund)).check(isCompletelyRightOf(withId(R.id.textViewTrainingFund)));
        onView(withId(R.id.editTextTrainingFund)).check(isCompletelyAbove(withId(R.id.editTextLeaveTime)));

        onView(withId(R.id.textViewLeaveTime)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewLeaveTime)).check(isCompletelyLeftOf(withId(R.id.editTextLeaveTime)));
        onView(withId(R.id.textViewLeaveTime)).check(isCompletelyAbove(withId(R.id.textViewTeleworkDays)));

        onView(withId(R.id.editTextLeaveTime)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextLeaveTime)).check(isCompletelyRightOf(withId(R.id.textViewLeaveTime)));
        onView(withId(R.id.editTextLeaveTime)).check(isCompletelyAbove(withId(R.id.editTextTeleworkDays)));

        onView(withId(R.id.textViewTeleworkDays)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTeleworkDays)).check(isCompletelyLeftOf(withId(R.id.editTextTeleworkDays)));
        onView(withId(R.id.textViewTeleworkDays)).check(isCompletelyAbove(withId(R.id.save_and_return_button)));

        onView(withId(R.id.editTextTeleworkDays)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTeleworkDays)).check(isCompletelyRightOf(withId(R.id.textViewTeleworkDays)));
        onView(withId(R.id.editTextTeleworkDays)).check(isCompletelyAbove(withId(R.id.save_and_return_button)));

        onView(withId(R.id.save_and_return_button)).check(matches(isDisplayed()));
        onView(withId(R.id.save_and_return_button)).check(isCompletelyAbove(withId(R.id.save_and_create_another_button)));

        onView(withId(R.id.save_and_create_another_button)).check(matches(isDisplayed()));
        onView(withId(R.id.save_and_create_another_button)).check(isCompletelyAbove(withId(R.id.compare_with_cur_job_button)));

        onView(withId(R.id.compare_with_cur_job_button)).check(matches(isDisplayed()));
        onView(withId(R.id.compare_with_cur_job_button)).check(isCompletelyAbove(withId(R.id.cancel_button)));

        onView(withId(R.id.cancel_button)).check(matches(isDisplayed()));
    }

    @Test
    public void ShouldEnterJobAndSaveAndReturn() {
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
        onView(withId(R.id.create_job_offer_button)).check(matches(isDisplayed()));
    }

    @Test
    public void ShouldEnterJobAndSaveAndCreateAnotherOne() {
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

        onView(withId(R.id.save_and_create_another_button)).perform(click());
        onView(withId(R.id.editTextTitle)).check(matches(isDisplayed()));

        ViewInteraction tv = onView(withId(R.id.editTextTitle));
        String text = getTextFromViewInteraction(tv);
        assertEquals("", text);
    }

    @Test
    public void ShouldNotCompareWithCurrentJobIfThereIsNone() {
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

        onView(withId(R.id.compare_with_cur_job_button)).perform(click());
        onView(withId(R.id.editTextTitle)).check(matches(isDisplayed()));
    }

    @Test
    public void ShouldCompareWithCurrentJobIfExists() {
        onView(withId(R.id.cancel_button)).perform(click());
        onView(withId(R.id.update_or_create_current_job)).perform(click());

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

        onView(withId(R.id.button_save)).perform(click());

        onView(withId(R.id.create_job_offer_button)).perform(click());

        onView(withId(R.id.editTextTitle)).perform(replaceText("AA"));
        onView(withId(R.id.editTextCompany)).perform(replaceText("BB"));
        onView(withId(R.id.editTextCity)).perform(replaceText("CC"));
        onView(withId(R.id.editTextState)).perform(replaceText("VVAA"));
        onView(withId(R.id.editTextCostOfLiving)).perform(replaceText("200"));
        onView(withId(R.id.editTextYearlySalary)).perform(replaceText("2000"));
        onView(withId(R.id.editTextYearlyBonus)).perform(replaceText("2000"));
        onView(withId(R.id.editTextTrainingFund)).perform(replaceText("200"));
        onView(withId(R.id.editTextLeaveTime)).perform(replaceText("20"));
        onView(withId(R.id.editTextTeleworkDays)).perform(replaceText("2"));

        onView(withId(R.id.compare_with_cur_job_button)).perform(click());

        onView(withId(R.id.job1Title)).check(matches(isDisplayed()));
        onView(withId(R.id.job1Title)).check(matches(withText("AA")));

        onView(withId(R.id.job2Title)).check(matches(isDisplayed()));
        onView(withId(R.id.job2Title)).check(matches(withText("A")));

        onView(withId(R.id.job1Company)).check(matches(isDisplayed()));
        onView(withId(R.id.job1Company)).check(matches(withText("BB")));

        onView(withId(R.id.job2Company)).check(matches(isDisplayed()));
        onView(withId(R.id.job2Company)).check(matches(withText("B")));

        onView(withId(R.id.job1Location)).check(matches(isDisplayed()));
        onView(withId(R.id.job1Location)).check(matches(withText("CC, VVAA")));

        onView(withId(R.id.job2Location)).check(matches(isDisplayed()));
        onView(withId(R.id.job2Location)).check(matches(withText("C, VA")));

        onView(withId(R.id.job1YearlySalary)).check(matches(isDisplayed()));
        onView(withId(R.id.job1YearlySalary)).check(matches(withText("10.0")));

        onView(withId(R.id.job2YearlySalary)).check(matches(isDisplayed()));
        onView(withId(R.id.job2YearlySalary)).check(matches(withText("10.0")));

        onView(withId(R.id.job1YearlyBonus)).check(matches(isDisplayed()));
        onView(withId(R.id.job1YearlyBonus)).check(matches(withText("10.0")));

        onView(withId(R.id.job2YearlyBonus)).check(matches(isDisplayed()));
        onView(withId(R.id.job2YearlyBonus)).check(matches(withText("10.0")));

        onView(withId(R.id.job1TDF)).check(matches(isDisplayed()));
        onView(withId(R.id.job1TDF)).check(matches(withText("200.0")));

        onView(withId(R.id.job2TDF)).check(matches(isDisplayed()));
        onView(withId(R.id.job2TDF)).check(matches(withText("100.0")));

        onView(withId(R.id.job1LT)).check(matches(isDisplayed()));
        onView(withId(R.id.job1LT)).check(matches(withText("20")));

        onView(withId(R.id.job2LT)).check(matches(isDisplayed()));
        onView(withId(R.id.job2LT)).check(matches(withText("10")));

        onView(withId(R.id.job1RWT)).check(matches(isDisplayed()));
        onView(withId(R.id.job1RWT)).check(matches(withText("2")));

        onView(withId(R.id.job2RWT)).check(matches(isDisplayed()));
        onView(withId(R.id.job2RWT)).check(matches(withText("1")));
    }

    @Test
    public void ShouldConfirmCancel() {
        onView(withId(R.id.cancel_button)).perform(click());
        onView(withId(R.id.update_or_create_current_job)).check(matches(isDisplayed()));
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
