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

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AdjustComparisonSettingsActivityTest {

    @Rule
    public ActivityScenarioRule<AdjustComparisonSettingsActivity> adjustComparisonSettingsActivityRule =
            new ActivityScenarioRule<>(AdjustComparisonSettingsActivity.class);

    @Test
    public void ShouldConfirmWidgetsAreAlignedCorrectly() {
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(isCompletelyAbove(withId(R.id.textViewYearlySalary)));
        onView(withId(R.id.textView)).check(isCompletelyAbove(withId(R.id.editTextYearlySalaryWgt)));

        onView(withId(R.id.textViewYearlySalary)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewYearlySalary)).check(isCompletelyLeftOf(withId(R.id.editTextYearlySalaryWgt)));
        onView(withId(R.id.textViewYearlySalary)).check(isCompletelyAbove(withId(R.id.textViewYearlyBonus)));

        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlySalaryWgt)).check(isCompletelyRightOf(withId(R.id.textViewYearlySalary)));
        onView(withId(R.id.editTextYearlySalaryWgt)).check(isCompletelyAbove(withId(R.id.editTextYearlyBonusWgt)));

        onView(withId(R.id.textViewYearlyBonus)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewYearlyBonus)).check(isCompletelyAbove(withId(R.id.textViewTrainingFund)));
        onView(withId(R.id.textViewYearlyBonus)).check(isCompletelyLeftOf(withId(R.id.editTextYearlyBonusWgt)));

        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(isCompletelyAbove(withId(R.id.editTextTrainingFundWgt)));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(isCompletelyRightOf(withId(R.id.textViewYearlyBonus)));

        onView(withId(R.id.textViewTrainingFund)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTrainingFund)).check(isCompletelyAbove(withId(R.id.textViewLeaveTime)));
        onView(withId(R.id.textViewTrainingFund)).check(isCompletelyLeftOf(withId(R.id.editTextTrainingFundWgt)));

        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTrainingFundWgt)).check(isCompletelyAbove(withId(R.id.editTextLeaveTimeWgt)));
        onView(withId(R.id.editTextTrainingFundWgt)).check(isCompletelyRightOf(withId(R.id.textViewTrainingFund)));

        onView(withId(R.id.textViewLeaveTime)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewLeaveTime)).check(isCompletelyAbove(withId(R.id.textViewTeleworkDays)));
        onView(withId(R.id.textViewLeaveTime)).check(isCompletelyLeftOf(withId(R.id.editTextLeaveTimeWgt)));

        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(isCompletelyAbove(withId(R.id.editTextTeleworkDaysWgt)));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(isCompletelyRightOf(withId(R.id.textViewLeaveTime)));

        onView(withId(R.id.textViewTeleworkDays)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewTeleworkDays)).check(isCompletelyAbove(withId(R.id.save_return_button)));
        onView(withId(R.id.textViewTeleworkDays)).check(isCompletelyLeftOf(withId(R.id.editTextTeleworkDaysWgt)));

        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(isCompletelyAbove(withId(R.id.save_return_button)));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(isCompletelyRightOf(withId(R.id.textViewTeleworkDays)));

        onView(withId(R.id.save_return_button)).check(matches(isDisplayed()));
        onView(withId(R.id.save_return_button)).check(isCompletelyAbove(withId(R.id.cancel_button)));

        onView(withId(R.id.cancel_button)).check(matches(isDisplayed()));
        onView(withId(R.id.cancel_button)).check(isCompletelyBelow(withId(R.id.save_return_button)));
    }

    @Test
        public void ShouldBeAbleToSaveAndReturnInfoAndConfirmSettingsPersist() {
        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.save_return_button)).check(matches(isDisplayed()));
        onView(withId(R.id.cancel_button)).check(matches(isDisplayed()));

        onView(withId(R.id.editTextYearlySalaryWgt)).perform(replaceText("5"));
        onView(withId(R.id.editTextYearlyBonusWgt)).perform(replaceText("4"));
        onView(withId(R.id.editTextTrainingFundWgt)).perform(replaceText("3"));
        onView(withId(R.id.editTextLeaveTimeWgt)).perform(replaceText("2"));
        onView(withId(R.id.editTextTeleworkDaysWgt)).perform(replaceText("1"));

        onView(withId(R.id.save_return_button)).perform(click());

        onView(withId(R.id.adjust_comparison_settings_button)).check(matches(isDisplayed()));
        onView(withId(R.id.adjust_comparison_settings_button)).perform(click());

        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(withText("5")));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(withText("4")));
        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(withText("3")));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(withText("2")));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(withText("1")));
    }

    @Test
    public void ShouldConfirmOnCancelSettingsAreNotSaved() {
        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.save_return_button)).check(matches(isDisplayed()));
        onView(withId(R.id.cancel_button)).check(matches(isDisplayed()));

        ViewInteraction tvSalary = onView(withId(R.id.editTextYearlySalaryWgt));
        String textSalary = getTextFromViewInteraction(tvSalary);
        ViewInteraction tvBonus = onView(withId(R.id.editTextYearlyBonusWgt));
        String textBonus = getTextFromViewInteraction(tvBonus);
        ViewInteraction tvTraining = onView(withId(R.id.editTextTrainingFundWgt));
        String textTraining = getTextFromViewInteraction(tvTraining);
        ViewInteraction tvLeaveTime = onView(withId(R.id.editTextLeaveTimeWgt));
        String textLeaveTime = getTextFromViewInteraction(tvLeaveTime);
        ViewInteraction tvTelework = onView(withId(R.id.editTextTeleworkDaysWgt));
        String textTelework = getTextFromViewInteraction(tvTelework);

        onView(withId(R.id.editTextYearlySalaryWgt)).perform(replaceText("9"));
        onView(withId(R.id.editTextYearlyBonusWgt)).perform(replaceText("9"));
        onView(withId(R.id.editTextTrainingFundWgt)).perform(replaceText("9"));
        onView(withId(R.id.editTextLeaveTimeWgt)).perform(replaceText("9"));
        onView(withId(R.id.editTextTeleworkDaysWgt)).perform(replaceText("9"));

        onView(withId(R.id.cancel_button)).perform(click());

        onView(withId(R.id.adjust_comparison_settings_button)).check(matches(isDisplayed()));
        onView(withId(R.id.adjust_comparison_settings_button)).perform(click());

        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlySalaryWgt)).check(matches(withText(textSalary)));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextYearlyBonusWgt)).check(matches(withText(textBonus)));
        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTrainingFundWgt)).check(matches(withText(textTraining)));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextLeaveTimeWgt)).check(matches(withText(textLeaveTime)));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTeleworkDaysWgt)).check(matches(withText(textTelework)));
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
