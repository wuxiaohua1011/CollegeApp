package com.michaelwu.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.michaelwu.collegeapp.R;

public class CreateNewAccount extends AppCompatActivity implements View.OnClickListener{
private EditText firstName,lastName,email,password,confirmPassword;
    private Button submitButton;
    public static boolean newAccountCreated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);
        newAccountCreated=false;
        wireWidget();
        addListner();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
               String cp= confirmPassword.getText().toString();
               String p = password.getText().toString();
                String un = email.getText().toString();
                String fname = firstName.getText().toString();
                String lname = lastName.getText().toString();

                    if (cp.equals("")&&p.equals("")&&un.equals("")&&fname.equals("")&&lname.equals("")){
                        Toast.makeText(CreateNewAccount.this, "Please fill in all information", Toast.LENGTH_SHORT).show();
                    }
                    else if (cp.equals(p)) {
                        Toast.makeText(CreateNewAccount.this, "password Match", Toast.LENGTH_SHORT).show();
                        new CountDownTimer(3000,1000) {
                            @Override
                            public void onTick(long l) {

                            }

                            @Override
                            public void onFinish() {
                                Backendless.initApp(getApplicationContext(),"5D8AA47B-02C1-D7C2-FF41-3A2B7FAC6600","F55D219C-44FC-C7CD-FFFD-D83453B97A00","v1");
                                BackendlessUser user = new BackendlessUser();
                                user.setEmail(email.getText().toString());
                                user.setPassword(password.getText().toString());
                                user.setProperty("first_name",firstName.getText().toString());
                                user.setProperty("last_name",lastName.getText().toString());

                                Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>()
                                {
                                    public void handleResponse( BackendlessUser registeredUser )
                                    {
                                        Toast.makeText(CreateNewAccount.this, "registration success", Toast.LENGTH_SHORT).show();
                                    }

                                    public void handleFault( BackendlessFault fault )
                                    {
                                        Toast.makeText(CreateNewAccount.this, "" + fault.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                } );


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
        newAccountCreated=true;
        Intent intent = new Intent(this,LoginActivity.class);
        intent.putExtra("userName",email.getText().toString());
        intent.putExtra("password",password.getText().toString());
        startActivity(intent);
        finish();
    }
}
