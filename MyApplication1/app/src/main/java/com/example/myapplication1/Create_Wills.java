package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Create_Wills extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner1;
    private EditText etOne;
    private EditText etTwo;
    private EditText etThree;
    private EditText etFour;
    private EditText etFive;
    private EditText ac;
    private EditText bal;
    private EditText br;
    private EditText date;
    private Button addbank;
    private Button addpass;
    private ArrayAdapter<String> arrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__wills);

        etOne = (EditText) findViewById(R.id.et1);
        etTwo = (EditText) findViewById(R.id.et2);
        etThree = (EditText) findViewById(R.id.et3);
        etFour = (EditText) findViewById(R.id.et4);
        etFive = (EditText) findViewById(R.id.et5);
        ac = (EditText) findViewById(R.id.etAC);
        bal = (EditText) findViewById(R.id.etBAL);
        br = (EditText) findViewById(R.id.etBR);
        date = (EditText) findViewById(R.id.etDate);
        addpass = (Button) findViewById(R.id.btnaddpass);
        addbank = (Button) findViewById(R.id.btnaddbank);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        switch (i) {
            case 1:
                etOne.setVisibility(view.VISIBLE);
                etTwo.setVisibility(View.VISIBLE);
                etThree.setVisibility(View.INVISIBLE);
                etFour.setVisibility(View.INVISIBLE);
                etFive.setVisibility(View.INVISIBLE);
                ac.setVisibility(View.VISIBLE);
                bal.setVisibility(view.VISIBLE);
                br.setVisibility(view.VISIBLE);
                addpass.setVisibility(View.INVISIBLE);
                addbank.setVisibility(View.VISIBLE);
                date.setVisibility(view.INVISIBLE);
                etOne.setHint("Enter Account Name");
                ac.setHint("Enter Account Number");
                bal.setHint("Enter Balance");
                br.setHint("Enter Branch Number");
                etTwo.setHint("Enter IFSC Code");
                addbank.setText("Add Bank Details");

                break;
            case 2:
                ac.setVisibility(View.INVISIBLE);
                bal.setVisibility(View.INVISIBLE);
                br.setVisibility(View.INVISIBLE);
                date.setVisibility(view.INVISIBLE);
                addpass.setVisibility(view.VISIBLE);
                etOne.setHint("Enter Account");
                etOne.setVisibility(view.VISIBLE);
                addbank.setVisibility(view.INVISIBLE);
                etThree.setVisibility(view.VISIBLE);
                etThree.setHint("Enter Password");
                etTwo.setVisibility(view.INVISIBLE);
                etFour.setVisibility(View.INVISIBLE);
                etFive.setVisibility(View.INVISIBLE);
                break;
            case 3:
                etOne.setVisibility(view.VISIBLE);
                ac.setVisibility(View.VISIBLE);
                etThree.setVisibility(view.VISIBLE);
                date.setVisibility(view.VISIBLE);
                etTwo.setVisibility(view.INVISIBLE);
                addbank.setVisibility(view.VISIBLE);
                bal.setVisibility(View.INVISIBLE);
                br.setVisibility(View.INVISIBLE);
                addpass.setVisibility(view.INVISIBLE);
                etOne.setVisibility(view.VISIBLE);
                ac.setHint("Enter Insurance Number");
                etThree.setVisibility(view.INVISIBLE);
                addbank.setText("Add Insurance Details");
                date.setVisibility(view.VISIBLE);
                etFour.setVisibility(View.VISIBLE);
                etFive.setVisibility(View.VISIBLE);
                etFour.setHint("Enter Nominee Names");
                etFive.setHint("Enter Insurance Type");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}