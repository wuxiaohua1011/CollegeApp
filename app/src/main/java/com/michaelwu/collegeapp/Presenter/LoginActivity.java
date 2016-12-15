package com.michaelwu.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.michaelwu.collegeapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
private EditText userName,password;
    private Button submitButton,createNewAccountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        wireWidget();
        addListener();
    }

    private void addListener() {
        submitButton.setOnClickListener(this);
        createNewAccountButton.setOnClickListener(this);
    }

    private void wireWidget() {
        userName=(EditText)findViewById(R.id.activity_login_edit_text_username);
        password=(EditText)findViewById(R.id.activity_login_edit_text_password);
        submitButton =(Button)findViewById(R.id.activity_login_button_submit);
        createNewAccountButton=(Button)findViewById(R.id.activity_login_button_creat_new_account);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_login_button_submit:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.activity_login_button_creat_new_account:
                startActivity(new Intent(this,CreateNewAccount.class));
                break;
            default:
                Toast.makeText(LoginActivity.this, "something is wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
