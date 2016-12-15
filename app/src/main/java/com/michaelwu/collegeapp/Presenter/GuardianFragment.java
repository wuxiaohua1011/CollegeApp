package com.michaelwu.collegeapp.Presenter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.michaelwu.collegeapp.Model.Guardian;
import com.michaelwu.collegeapp.R;

/**
 * Created by csaper6 on 12/13/16.
 */
public class GuardianFragment extends Fragment {
    private EditText firstName,lastName,occupation;
    private DatePicker datePicker;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian,container,false);

        firstName = (EditText) rootView.findViewById(R.id.guardian_first_name);
        lastName=(EditText)rootView.findViewById(R.id.guardian_last_name);
        occupation = (EditText)rootView.findViewById(R.id.guardian_occupation);
        datePicker=(DatePicker)rootView.findViewById(R.id.guardian_datePicker);

        Guardian guardian = new Guardian("Bob","Smith",30,"Professor");

        firstName.setText(guardian.getFName());
        lastName.setText(guardian.getLName());
        occupation.setText(guardian.getOccupation());

        return rootView;

    }
}
