package com.michaelwu.collegeapp.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
private EditText userName,password;
    private Button submitButton,createNewAccountButton;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        wireWidget();
        addListener();
        autoFill();
        Backendless.initApp(getApplicationContext(),"5D8AA47B-02C1-D7C2-FF41-3A2B7FAC6600","F55D219C-44FC-C7CD-FFFD-D83453B97A00","v1");
    }

    private void autoFill() {
        if (CreateNewAccount.newAccountCreated==true){
            CreateNewAccount.newAccountCreated=false;
            Intent intent=getIntent();
            userName.setText(intent.getStringExtra("userName"));
            password.setText(intent.getStringExtra("password"));

        }
        else{
            userName.setText("");
            password.setText("");
        }

        userName.setText("try2@gmail.com");
        password.setText("try2");
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
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Loading");
                progressDialog.show();
                BackendlessUser user = new BackendlessUser();
                Backendless.UserService.login(userName.getText().toString(),password.getText().toString(), new AsyncCallback<BackendlessUser>() {

                    @Override
                    public void handleResponse(BackendlessUser response) {
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));finish();
                    }
                    @Override
                    public void handleFault(BackendlessFault fault) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, ""+fault.toString(), Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case R.id.activity_login_button_creat_new_account:
                startActivity(new Intent(this,CreateNewAccount.class));
                break;
            default:
                Toast.makeText(LoginActivity.this, "something is wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
