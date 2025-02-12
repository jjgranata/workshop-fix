package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class SettingsSaverTest {
    @Test
    public void ShouldSaveSettings() {
        SettingsSaver settingsSaver = new SettingsSaver(InstrumentationRegistry.getInstrumentation().getTargetContext());
        boolean success = true;
        try {
            settingsSaver.saveSetting("Telework", "9");
        } catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void ShouldGetSettings() {
        SettingsSaver settingsSaver = new SettingsSaver(InstrumentationRegistry.getInstrumentation().getTargetContext());
        settingsSaver.saveSetting("ThisIsATest", "YesItIs");
        String savedSetting = settingsSaver.getSetting("ThisIsATest", "NoItIsNot");
        assertEquals("YesItIs", savedSetting);
    }
}
