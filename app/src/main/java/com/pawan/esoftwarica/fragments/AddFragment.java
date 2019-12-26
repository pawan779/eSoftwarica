package com.pawan.esoftwarica.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pawan.esoftwarica.MainActivity;
import com.pawan.esoftwarica.Model.AddModel;
import com.pawan.esoftwarica.R;
import com.pawan.esoftwarica.RecycleView.Softwarica;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private EditText etName, etAge, etAddress;
    private RadioGroup rgGender;
    private Button btnSave;
    private AddModel addModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addModel = ViewModelProviders.of(this).get(AddModel.class);

        View view = inflater.inflate(R.layout.fragment_add, container, false);

        etName = view.findViewById(R.id.etName);
        etAddress = view.findViewById(R.id.etAddress);
        etAge = view.findViewById(R.id.etAge);
        btnSave = view.findViewById(R.id.btnSave);
        rgGender=view.findViewById(R.id.rgGender);
        rgGender.setOnCheckedChangeListener(this);
        btnSave.setOnClickListener(this);
        final TextView textView = view.findViewById(R.id.tvAdd);
        addModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return view;
    }

    int age;
    String name, address, gender;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            //Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();


            if (TextUtils.isEmpty(etName.getText())) {
                etName.setError("Enter full name");
                etName.requestFocus();
                return;
            } else if (TextUtils.isEmpty(etAge.getText())) {
                etAge.setError("Enter age");
                etAge.requestFocus();
                return;
            }
                else if (TextUtils.isEmpty(gender)) {
                    Toast.makeText(getContext(), "Select gender", Toast.LENGTH_SHORT).show();
                    return;
                }

            else if (TextUtils.isEmpty(etAddress.getText())) {
                etAddress.setError("Enter Address");
                etAddress.requestFocus();
                return;

            }

            name = etName.getText().toString();
            age = Integer.parseInt(etAge.getText().toString());
            address = etAddress.getText().toString();





                MainActivity.softwaricas.add(new Softwarica(name, age, address, gender));
                Toast.makeText(getContext(), "Student Added", Toast.LENGTH_SHORT).show();


        }


    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbMale) {
            gender = "male";
        }
        if (checkedId == R.id.rbFemale) {
            gender = "female";
        }
        if (checkedId == R.id.rbOthers) {
            gender = "Others";
        }

    }
}
