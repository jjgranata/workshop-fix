package edu.gatech.seclass.jobcompare6300.utility;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class JobForComparisonTest {

    @Test
    public void ShouldComputeDynamicBonusAdjustedForCostOfLiving() {
        JobForComparison jobForComparisonWithCol = new JobForComparison("id", "title", "company", "city", "state", 100, 10000, 10000, 10000, 10, 1, false);
        double bonusColAdjusted = jobForComparisonWithCol.getYearlyBonusColAdjusted();

        JobForComparison jobForComparisonWithoutCol = new JobForComparison("id", "title", "company", "city", "state", 0, 10000, 10000, 10000, 10, 1, false);
        double bonusNoCol = jobForComparisonWithoutCol.getYearlyBonusColAdjusted();

        assertNotEquals(bonusNoCol, bonusColAdjusted);
    }
}
