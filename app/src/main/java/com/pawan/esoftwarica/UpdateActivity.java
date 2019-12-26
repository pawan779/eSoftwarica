package com.pawan.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    EditText etReName, etReAge, etReAddress;
    RadioGroup rgReGender;
    RadioButton rbReMale, rbReFemale, rbReOther;
    Button btnReSave,btnReCancel;
    String name, address, gender;
    int age;
    public static int index;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));

        etReName = findViewById(R.id.etUName);
        etReAge = findViewById(R.id.etUAge);
        etReAddress = findViewById(R.id.etUAddress);
        btnReSave = findViewById(R.id.btnUSave);
        rgReGender = findViewById(R.id.rgUGender);
        rbReMale = findViewById(R.id.rbUMale);
        rbReOther = findViewById(R.id.rbUOther);
        rbReFemale = findViewById(R.id.rbUFemale);
        btnReCancel=findViewById(R.id.btnUCancel);
        etReName.setText(MainActivity.softwaricas.get(index).getName());
        etReAge.setText(MainActivity.softwaricas.get(index).getAge() + "");
        etReAddress.setText(MainActivity.softwaricas.get(index).getAddress());
        gender = MainActivity.softwaricas.get(index).getGender();
        if (gender == "male") {
            rbReMale.setChecked(true);
            rbReFemale.setChecked(false);
            rbReOther.setChecked(false);
        } else if (gender == "female") {
            rbReMale.setChecked(false);
            rbReFemale.setChecked(true);
            rbReOther.setChecked(false);
        }
        if (gender == "other") {
            rbReMale.setChecked(false);
            rbReFemale.setChecked(false);
            rbReOther.setChecked(true);
        }
        rgReGender.setOnCheckedChangeListener(this);
        btnReSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    name = etReName.getText().toString();
                    address = etReAddress.getText().toString();
                    age = Integer.parseInt(etReAge.getText().toString());
                    try {
                        MainActivity.softwaricas.get(index).setName(name);
                        MainActivity.softwaricas.get(index).setAddress(address);
                        MainActivity.softwaricas.get(index).setAge(age);
                        MainActivity.softwaricas.get(index).setGender(gender);
                        Toast.makeText(UpdateActivity.this, "Student updated", Toast.LENGTH_SHORT).show();
                        finish();



                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(UpdateActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        btnReCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private boolean validate() {
        if (TextUtils.isEmpty(etReName.getText())) {
            etReName.setError("Enter full name");
            etReName.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etReAge.getText())) {
            etReAge.setError("Enter the age");
            etReAge.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etReAddress.getText())) {
            etReAddress.setError("Enter the address");
            etReAddress.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(gender)) {
            Toast.makeText(UpdateActivity.this, "Select gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rbUMale) {
            gender = "male";
        }
        if (checkedId == R.id.rbUFemale) {
            gender = "female";
        }
        if (checkedId == R.id.rbUOther) {
            gender = "other";
        }

    }
}
