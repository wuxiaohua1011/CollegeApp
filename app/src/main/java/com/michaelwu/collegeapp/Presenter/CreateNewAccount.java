package com.michaelwu.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.michaelwu.collegeapp.R;

public class CreateNewAccount extends AppCompatActivity implements View.OnClickListener{
private EditText firstName,lastName,email,password,confirmPassword;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        wireWidget();
        addListner();
    }

    private void addListner() {
        submitButton.setOnClickListener(this);
    }
    private void wireWidget(){
    firstName = (EditText)findViewById(R.id.activity_creat_new_account_edit_text_first_name);
        lastName=(EditText)findViewById(R.id.activity_creat_new_account_edit_text_last_name);
        email=(EditText)findViewById(R.id.activity_creat_new_account_edit_text_email);
        password=(EditText)findViewById(R.id.activity_creat_new_account_edit_text_password);
        confirmPassword=(EditText)findViewById(R.id.activity_creat_new_account_edit_text_confirm_password);
        submitButton=(Button)findViewById(R.id.activity_creat_new_account_button_submit);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.activity_creat_new_account_button_submit:

                    if (confirmPassword.getText().toString().equals(password.getText().toString())) {
                        Toast.makeText(CreateNewAccount.this, "password Match", Toast.LENGTH_SHORT).show();
                        new CountDownTimer(3000,1000) {
                            @Override
                            public void onTick(long l) {

                            }

                            @Override
                            public void onFinish() {
                                launchActivity();
                            }
                        }.start();

                    }
                    else{
                        Toast.makeText(CreateNewAccount.this, "two password does not match", Toast.LENGTH_SHORT).show();
                        break;
                    }

                break;
            default:
                Toast.makeText(CreateNewAccount.this, "something went wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private void launchActivity() {
        startActivity(new Intent(this,LoginActivity.class));
    }
}
