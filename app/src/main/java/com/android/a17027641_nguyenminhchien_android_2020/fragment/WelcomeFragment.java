package com.android.a17027641_nguyenminhchien_android_2020.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.a17027641_nguyenminhchien_android_2020.LoginActivity;
import com.android.a17027641_nguyenminhchien_android_2020.R;
import com.android.a17027641_nguyenminhchien_android_2020.SignUpActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    Button btnNextLogin;
    Button btnNextSignUp;

    public WelcomeFragment() {
        // Required empty public constructor
    }


    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        btnNextLogin = (Button) view.findViewById(R.id.btnNextLogin);
        btnNextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =  LoginActivity.newIntent(getActivity());
               startActivity(intent);
            }
        });
        btnNextSignUp = (Button)view.findViewById(R.id.btnNextSignUp);
        btnNextSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SignUpActivity.newIntent(getActivity());
                startActivity(intent);
            }

        });
        return view;
    }
}