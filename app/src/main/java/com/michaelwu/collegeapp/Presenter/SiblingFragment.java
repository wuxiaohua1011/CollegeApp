package com.michaelwu.collegeapp.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.michaelwu.collegeapp.R;

/**
 * Created by csaper6 on 12/13/16.
 */
public class SiblingFragment extends Fragment {
    private EditText firstName,lastName;
    private DatePicker datePicker;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment_sibling,container,false);

        firstName = (EditText) rootView.findViewById(R.id.sibling_first_name);
        lastName=(EditText)rootView.findViewById(R.id.sibling_last_name);
        datePicker=(DatePicker)rootView.findViewById(R.id.sibling_datePicker);

        return rootView;

    }
}
