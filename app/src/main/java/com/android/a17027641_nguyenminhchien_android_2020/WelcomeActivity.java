package com.android.a17027641_nguyenminhchien_android_2020;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.android.a17027641_nguyenminhchien_android_2020.fragment.WelcomeFragment;

import java.util.UUID;

public class WelcomeActivity extends MainActivity {

    @Override
    protected Fragment createFragment() {
        return WelcomeFragment.newInstance();
    }
}
