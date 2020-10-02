package com.android.a17027641_nguyenminhchien_android_2020;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.a17027641_nguyenminhchien_android_2020.fragment.SignUpFragment;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends MainActivity {
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, SignUpActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return SignUpFragment.newInstance();
    }
}
