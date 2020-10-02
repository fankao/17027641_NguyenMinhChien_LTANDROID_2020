package com.android.a17027641_nguyenminhchien_android_2020;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.a17027641_nguyenminhchien_android_2020.fragment.HomeFragment;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends MainActivity {
    public static String EXTRA_USER_IS_SIGNED = "user";

    public static Intent newIntent(Context packageContext, FirebaseUser user) {
        Intent intent = new Intent(packageContext, HomeActivity.class);
        intent.putExtra(EXTRA_USER_IS_SIGNED, user);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return HomeFragment.newInstance((FirebaseUser) getIntent().getParcelableExtra(EXTRA_USER_IS_SIGNED));
    }
}
