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

    public GeoUtils(Geocoder geocoder) {
        this.geocoder = geocoder;
    }

    /**
     * IOException: grpc failed
     * @param lat
     * @param lon
     * @return
     * @throws IOException
     */
    public String getCurrentCode(double lat, double lon) throws IOException {
        List<Address> addressesAtLocation = geocoder.getFromLocation(lat, lon, 1);
        return (addressesAtLocation.size() > 0) ?
                addressesAtLocation.get(0).getPostalCode() :
                null;
    }
}
