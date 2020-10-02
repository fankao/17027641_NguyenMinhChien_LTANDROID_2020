package com.android.a17027641_nguyenminhchien_android_2020;

import androidx.fragment.app.Fragment;

public class PasswordGeneratorActivity extends MainActivity {
    @Override
    protected Fragment createFragment() {
        return PassWordGeneratorFragment.newInstance();
    }
}
