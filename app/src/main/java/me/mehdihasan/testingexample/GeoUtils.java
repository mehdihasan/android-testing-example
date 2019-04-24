package me.mehdihasan.testingexample;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoUtils {

    private Geocoder geocoder;

    public GeoUtils(Context context) {
        this.geocoder = new Geocoder(context, Locale.getDefault());
    }

    public String getCurrentCode(double lat, double lon) throws IOException {
        List<Address> addressesAtLocation = geocoder.getFromLocation(lat, lon, 1);
        if (addressesAtLocation.size() <= 0) {
            return "";
        }
        return addressesAtLocation.get(0).getPostalCode();
    }
}
