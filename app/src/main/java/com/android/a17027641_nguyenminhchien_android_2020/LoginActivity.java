package com.android.a17027641_nguyenminhchien_android_2020;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.a17027641_nguyenminhchien_android_2020.fragment.LoginFragment;

public class LoginActivity extends MainActivity{
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, LoginActivity.class);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        return LoginFragment.newInstance();
    }
}
