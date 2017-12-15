package com.example.user.lab41;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

/**
 * Created by User on 15/12/2017.
 */

public class PrefsFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.addPreferencesFromResource(R.xml.preferences);
    }
}
