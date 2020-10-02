package com.android.a17027641_nguyenminhchien_android_2020;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PassWordGeneratorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassWordGeneratorFragment extends Fragment {

    TextView txtPassword;
    EditText edtPasswordLength;
    CheckBox chkLowerCase, chkUpperCase, chkNumber, chkSpecialSymbol;
    Button btnGeneratePassWord;

    public PassWordGeneratorFragment() {
        // Required empty public constructor
    }

    public static PassWordGeneratorFragment newInstance() {
        PassWordGeneratorFragment fragment = new PassWordGeneratorFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pass_word_generator, container, false);
        txtPassword = (TextView) view.findViewById(R.id.txtPassword);
        txtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPassword.getText().toString().trim().equals("")){
                    Toast.makeText(getActivity(), "Mật khẩu chưa được tạo. Mời tạo mật khẩu!", Toast.LENGTH_SHORT).show();
                    return;
                }
                setClipboard(getActivity(),txtPassword.getText().toString());
            }
        });
        edtPasswordLength = (EditText) view.findViewById(R.id.edtPassWordLength);
        chkLowerCase= (CheckBox)view.findViewById(R.id.chkLowerCase);
        chkUpperCase= (CheckBox)view.findViewById(R.id.chkUpperCase);
        chkNumber= (CheckBox)view.findViewById(R.id.chkNumber);
        chkSpecialSymbol= (CheckBox)view.findViewById(R.id.chkSpecialSymbol);

        final boolean hasLowerCase = chkLowerCase.isChecked();
        final boolean hasUpperCase = chkUpperCase.isChecked();
        final boolean hasNumber = chkLowerCase.isChecked();
        final boolean hasSpecialSymbol = chkSpecialSymbol.isChecked();
        btnGeneratePassWord = (Button)view.findViewById(R.id.btnGeneratePassWord);
        btnGeneratePassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int passwordLength = 0;
                try {
                    passwordLength = Integer.parseInt(edtPasswordLength.getText().toString());

                }catch (NumberFormatException e){
                    Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                generatePassword(passwordLength,hasLowerCase,hasUpperCase,hasNumber,hasSpecialSymbol);
            }
        });

        return view;
    }

    /**
     * Tạo password
     * @param finalPasswordLength: độ dài password
     * @param hasLowerCase: có kí tự thường
     * @param hasUpperCase: có ký tự hoa
     * @param hasNumber: có ký số
     * @param hasSpecialSymbol: có ký tự đặc biệt
     */
    private void generatePassword(int finalPasswordLength,
                                  boolean hasLowerCase,
                                  boolean hasUpperCase,
                                  boolean hasNumber,
                                  boolean hasSpecialSymbol) {
            if(finalPasswordLength == 0){
                Toast.makeText(getActivity(), "Chưa nhập độ dài password", Toast.LENGTH_SHORT).show();
                edtPasswordLength.setFocusable(true);
                return;
            }

            txtPassword.setText("Password");
    }

    /**
     * Copy chuỗi ký tự vào bộ nhớ tạm
     * @param context: ngữ cảnh hiện tại sử dụng
     * @param text: chuỗi muốn copy
     */
    private void setClipboard(Context context, String text) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
            Toast.makeText(context, "Đã lưu vào bộ nhớ tạm", Toast.LENGTH_SHORT).show();
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            Toast.makeText(context, "Đã lưu vào bộ nhớ tạm", Toast.LENGTH_SHORT).show();
            clipboard.setPrimaryClip(clip);
        }
    }
}