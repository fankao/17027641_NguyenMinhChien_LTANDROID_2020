package com.android.a17027641_nguyenminhchien_android_2020.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.a17027641_nguyenminhchien_android_2020.LoginActivity;
import com.android.a17027641_nguyenminhchien_android_2020.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private static final String ARG_USER_IS_SIGNED = "user";

    TextView txtEmail, txtAccountInfo;
    Button btnSignOut;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(FirebaseUser user) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER_IS_SIGNED, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtAccountInfo = view.findViewById(R.id.txtAccountInfo);
        if (getArguments() != null) {
            FirebaseUser user = getArguments().getParcelable(ARG_USER_IS_SIGNED);
            txtEmail.setText(getString(R.string.text_email, user.getEmail()));
            txtAccountInfo.setText(getString(R.string.text_account_info, "Success"));
        }
        btnSignOut = view.findViewById(R.id.btnSignout);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Confirm Log out")
                        .setMessage("Are you sure log out?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(LoginActivity.newIntent(getActivity()));
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();

            }
        });

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        FirebaseAuth.getInstance().signOut();
        Log.d(TAG,"user is log out!");
    }
}