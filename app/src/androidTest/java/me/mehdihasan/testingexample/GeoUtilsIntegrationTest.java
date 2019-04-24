package me.mehdihasan.testingexample;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

@RunWith(AndroidJUnit4.class)
public class GeoUtilsIntegrationTest {

    private GeoUtils geoUtils;

    @Before
    public void setUp() {
        Context ctx = InstrumentationRegistry.getInstrumentation().getContext();
        geoUtils = new GeoUtils(ctx);
    }

    @Test
    public void testNashvilleInZipCodeFromLatLng() throws Exception {
        String zipCode = geoUtils.getCurrentCode(36.139017, -86.796924);
        assertEquals("37212", zipCode);
    }

    @Test
    public void aTestThatShouldFail() throws Exception {
        String zipCode = geoUtils.getCurrentCode(0, 0);
        assertNotEquals("5555", zipCode);
    }
}
