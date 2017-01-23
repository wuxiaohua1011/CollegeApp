package com.michaelwu.collegeapp.Presenter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.michaelwu.collegeapp.Model.Guardian;
import com.michaelwu.collegeapp.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csaper6 on 12/13/16.
 */
public class GuardianFragment extends Fragment {
    private EditText firstName,lastName,occupation;
    private DatePicker datePicker;
    private Button buttonSubmit;

    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian,container,false);

        firstName = (EditText) rootView.findViewById(R.id.guardian_first_name);
        lastName=(EditText)rootView.findViewById(R.id.guardian_last_name);
        occupation = (EditText)rootView.findViewById(R.id.guardian_occupation);
        datePicker=(DatePicker)rootView.findViewById(R.id.guardian_datePicker);
        buttonSubmit = (Button)rootView.findViewById(R.id.fragment_guardian_button_submit);
        Backendless.initApp(getContext(),"5D8AA47B-02C1-D7C2-FF41-3A2B7FAC6600","F55D219C-44FC-C7CD-FFFD-D83453B97A00","v1");

        Guardian guardian = new Guardian("Bob","Smith",30,"Professor");

        firstName.setText(guardian.getFName());
        lastName.setText(guardian.getLName());
        occupation.setText(guardian.getOccupation());

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("FName",firstName.getText().toString());
                hashMap.put("LName",lastName.getText().toString());
                hashMap.put("age",4);
                hashMap.put("occupation",occupation.getText().toString());
                BackendlessUser user = new BackendlessUser();
                Backendless.Persistence.of( "Guardian" ).save( hashMap, new AsyncCallback<Map>() {
                    public void handleResponse( Map response )
                    {
                        Toast.makeText(getContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                    }

                    public void handleFault( BackendlessFault fault )
                    {
                        Toast.makeText(getContext(), ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return rootView;
    }
}
