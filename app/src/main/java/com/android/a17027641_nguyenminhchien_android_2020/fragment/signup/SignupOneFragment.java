package com.android.a17027641_nguyenminhchien_android_2020.fragment.signup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.a17027641_nguyenminhchien_android_2020.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupOneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupOneFragment extends Fragment {

    public SignupOneFragment() {
        // Required empty public constructor
    }


    public static SignupOneFragment newInstance() {
        SignupOneFragment fragment = new SignupOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_one, container, false);
    }
}