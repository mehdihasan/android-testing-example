package me.mehdihasan.testingexample;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * RoboElectric test
 *
 * The target class has some dependency with the Android API.
 * So, the target class can only be tested on the Instrumentation / integration
 * test environment. RoboElectric framework can save us here.
 */
@RunWith(RobolectricTestRunner.class)
public class GeoUtilRoboElectricTest {

    private GeoUtils geoUtils;

    @Before
    public void setUp() {
        geoUtils = new GeoUtils(ApplicationProvider.getApplicationContext());
    }

    @Test
    public void testNashvilleInZipCodeFromLatLng() throws Exception {
        String zipCode = geoUtils.getCurrentCode(36.139017, -86.796924);
        assertEquals("37212", zipCode);
    }

    @Test
    public void aTestThatShouldFail() throws Exception {
        String zipCode = geoUtils.getCurrentCode(0, 0);
        assertNull(zipCode);
    }
}
