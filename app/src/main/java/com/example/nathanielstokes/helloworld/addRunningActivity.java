package com.example.nathanielstokes.helloworld;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;

import android.hardware.Camera;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import java.io.Console;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Nathaniel Stokes on 8/11/2016.
 */
public class addRunningActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    Location mCurrentLocation;
    Location previousLocation;
    double distanceTraveled = 0;
    String mLastUpdateTime;

    GoogleApiClient mGoogleApiClient;
    boolean mRequestingLocationUpdates=true;
    boolean mResolvingError;
    static int REQUEST_RESOLVE_ERROR;
    static String DIALOG_ERROR;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    int REQUEST_CHECK_SETTINGS;

    String REQUESTING_LOCATION_UPDATES_KEY;
    String LOCATION_KEY;
    String LAST_UPDATED_TIME_STRING_KEY;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateValuesFromBundle(savedInstanceState);
        setContentView(R.layout.start_running);
        Intent intent = getIntent();

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    private void updateValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Update the value of mRequestingLocationUpdates from the Bundle, and
            // make sure that the Start Updates and Stop Updates buttons are
            // correctly enabled or disabled.
            if (savedInstanceState.keySet().contains(REQUESTING_LOCATION_UPDATES_KEY)) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean(
                        REQUESTING_LOCATION_UPDATES_KEY);
                setButtonsEnabledState();
            }

            // Update the value of mCurrentLocation from the Bundle and update the
            // UI to show the correct latitude and longitude.
            if (savedInstanceState.keySet().contains(LOCATION_KEY)) {
                // Since LOCATION_KEY was found in the Bundle, we can be sure that
                // mCurrentLocationis not null.
                mCurrentLocation = savedInstanceState.getParcelable(LOCATION_KEY);
            }

            // Update the value of mLastUpdateTime from the Bundle and update the UI.
            if (savedInstanceState.keySet().contains(LAST_UPDATED_TIME_STRING_KEY)) {
                mLastUpdateTime = savedInstanceState.getString(
                        LAST_UPDATED_TIME_STRING_KEY);
            }
            updateUI();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);

            if (mLastLocation != null) {
                System.out.println(String.valueOf(mLastLocation.getLatitude()));
                System.out.println(String.valueOf(mLastLocation.getLongitude()));
            }
            createLocationRequest();

            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                    .addLocationRequest(mLocationRequest);

            PendingResult<LocationSettingsResult> result =
                    LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient,
                            builder.build());

            result.setResultCallback(new ResultCallback<LocationSettingsResult>() {

                @Override
                public void onResult(@NonNull LocationSettingsResult result2) {
                    final Status status = result2.getStatus();
                    final LocationSettingsStates lcs = result2.getLocationSettingsStates();
                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.SUCCESS:
                            // All location settings are satisfied. The client can
                            // initialize location requests here.



                            break;
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied, but this can be fixed
                            // by showing the user a dialog.
                            try {
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                status.startResolutionForResult(
                                        addRunningActivity.this,
                                        REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way
                            // to fix the settings so we won't show the dialog.

                            break;
                    }
                }
            });
        } catch (SecurityException secExcept) {
        }

        if (mRequestingLocationUpdates) {
            startLocationUpdates();
           // updateUI();
        }

    }

    @Override
    public void onLocationChanged(Location location) {


        previousLocation = mCurrentLocation;
        mCurrentLocation = location;

        if(previousLocation!=null) {
            double lat1 = Math.toRadians(previousLocation.getLatitude());
            double long1 = Math.toRadians(previousLocation.getLongitude());
            double lat2 = Math.toRadians(mCurrentLocation.getLatitude());
            double long2 = Math.toRadians(mCurrentLocation.getLongitude());
            double deltaLong = long2 - long1;
            double deltaLat = lat2 - lat1;

            double a = Math.pow(Math.sin((deltaLat / 2)), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(deltaLong / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            //3961 miles or 6373km
            double d = 3961 * c;
            distanceTraveled += d;
            mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
        }
        updateUI();
    }

    private void setButtonsEnabledState() {
    }

    private void updateUI() {

        TextView lat = (TextView) findViewById(R.id.latitudeId);
        lat.setText(String.valueOf(mCurrentLocation.getLatitude()));
        TextView lon = (TextView) findViewById(R.id.longitudeId);
        lon.setText(String.valueOf(mCurrentLocation.getLongitude()));

        TextView dist = (TextView) findViewById(R.id.distanceId);
        dist.setText(String.valueOf(distanceTraveled));
        // mLastUpdateTimeTextView.setText(mLastUpdateTime);
    }

    protected void startLocationUpdates() {
    try{
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }
        catch (SecurityException secExcep){}
    }
    protected void createLocationRequest() {
         mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onConnectionSuspended(int arg0) {

        // what should i do here ? should i call mGoogleApiClient.connect() again ? ?

    }
@Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleApiClient.isConnected() && !mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (mResolvingError) {
            // Already attempting to resolve an error.
            return;
        } else if (result.hasResolution()) {
            try {
                mResolvingError = true;
                result.startResolutionForResult(this, REQUEST_RESOLVE_ERROR);
            } catch (IntentSender.SendIntentException e) {
                // There was an error with the resolution intent. Try again.
                mGoogleApiClient.connect();
            }
        } else {
            // Show dialog using GoogleApiAvailability.getErrorDialog()
            showErrorDialog(result.getErrorCode());
            mResolvingError = true;
        }
    }

    // The rest of this code is all about building the error dialog

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }
    /* Creates a dialog for an error message */
    private void showErrorDialog(int errorCode) {
        // Create a fragment for the error dialog
        ErrorDialogFragment dialogFragment = new ErrorDialogFragment();
        // Pass the error that should be displayed
        Bundle args = new Bundle();
        args.putInt(DIALOG_ERROR, errorCode);
        dialogFragment.setArguments(args);
        dialogFragment.show(getFragmentManager(), "errordialog");
    }

    /* Called from ErrorDialogFragment when the dialog is dismissed. */
    public void onDialogDismissed() {
        mResolvingError = false;
    }
    /* A fragment to display an error dialog */
    public static class ErrorDialogFragment extends DialogFragment {
        public ErrorDialogFragment() { }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Get the error code and retrieve the appropriate dialog
            int errorCode = this.getArguments().getInt(DIALOG_ERROR);
            return GoogleApiAvailability.getInstance().getErrorDialog(
                    this.getActivity(), errorCode, REQUEST_RESOLVE_ERROR);
        }

        @Override
        public void onDismiss(DialogInterface dialog) {
            ((addRunningActivity) getActivity()).onDialogDismissed();
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(REQUESTING_LOCATION_UPDATES_KEY,
                mRequestingLocationUpdates);
        savedInstanceState.putParcelable(LOCATION_KEY, mCurrentLocation);
        savedInstanceState.putString(LAST_UPDATED_TIME_STRING_KEY, mLastUpdateTime);
        super.onSaveInstanceState(savedInstanceState);
    }




    }
