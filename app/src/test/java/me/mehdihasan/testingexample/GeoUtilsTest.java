package me.mehdihasan.testingexample;

import android.location.Address;
import android.location.Geocoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

/**
 * Example of a Mockito Unit test
 */
@RunWith(MockitoJUnitRunner.class)
public class GeoUtilsTest {

    @Mock private Geocoder geocoder;

    @Mock private Address addressForHomeLund;

    private GeoUtils geoUtils;

    @Before
    public void setUp() {
        geoUtils = new GeoUtils(geocoder);
    }

    @Test
    public void coordinateWithNoZipCodeReturnNull() throws Exception {
        String zipCode = geoUtils.getCurrentCode(0, 0);
        Assert.assertNull(zipCode);
    }

    @Test
    public void validGeolocationPasses() throws Exception {

        String homeLundZip = "22223";

        // whenever we ask for Lund home address for the postal code,
        // the mock object is going to return 22223
        when(addressForHomeLund.getPostalCode())
                .thenReturn(homeLundZip);

        // whenever we mocked GeoCoder for the addresses
        // associated with the Home(Lund) latitude and longitude
        // we want to return the Home(Lund) mock address
        when(geocoder.getFromLocation(
                    anyDouble(),
                    anyDouble(),
                    anyInt()
                ))
                .thenReturn(Collections.singletonList(addressForHomeLund));

        String zipCodeOne = geoUtils.getCurrentCode(45.4534534, -34.2334234);
        String zipCodeTwo = geoUtils.getCurrentCode(67.4534534, 78.2334234);
        Assert.assertEquals(homeLundZip, zipCodeOne);
        Assert.assertEquals(homeLundZip, zipCodeTwo);
    }
}
