package com.android.a17027641_nguyenminhchien_android_2020;

import androidx.fragment.app.Fragment;

import com.android.a17027641_nguyenminhchien_android_2020.fragment.signup.SignupOneFragment;

public class ListUIActivity extends MainActivity {
    @Override
    protected Fragment createFragment() {
        return SignupOneFragment.newInstance();
    }
}
