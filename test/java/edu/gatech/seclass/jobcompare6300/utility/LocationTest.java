package edu.gatech.seclass.jobcompare6300.utility;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LocationTest {

    @Test
    public void ShouldCreateNewLocationWithValidInput() {
        Location location = new Location("Mountain View", "CA", 1);
        assertNotNull(location);
    }
}
