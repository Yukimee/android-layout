package idk.androidpractice.com.androidlayout.activities;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import idk.androidpractice.com.androidlayout.R;

public class UIControlsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private String[] Countries = {"America", "Australia", "Afghanistan", "Brunei", "Bangladesh", "Brazil", "Bulgaria", "China", "Columbia",
            "Denmark", "Egypt", "French", "Germany", "Hong Kong", "Ireland", "Japan", " Korea", "Libya", "Laos", "Malaysia", "Macau", "Maldives", "Myanmar",
            "Nepal", "Nigeria", "Oman", "Pakistan", "Philippines", "Qatar", "Romania", "Singapore", "Somalia", "Spain", "Turkey",
            "Taiwan", "Thailand", "US", "UK", "Vietnam", "Western Sahara", "Yemen", "Zambia"};

    private Button btnDone;
    private CheckBox cb1, cb2;
    private ToggleButton tbMode;
    private RadioButton rbMango, rbMatcha, rbDurian;
    private ProgressDialog progress;
    private Spinner spAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicontrols);

        AutoCompleteTextView actvOne = (AutoCompleteTextView) findViewById(R.id.actvOne);

        progress = new ProgressDialog(this);

        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);

        tbMode = (ToggleButton) findViewById(R.id.tbMode);
        tbMode.setOnClickListener(this);

        rbMango = (RadioButton) findViewById(R.id.rbMango);
        rbMango.setOnClickListener(this);

        rbMatcha = (RadioButton) findViewById(R.id.rbMatcha);
        rbMatcha.setOnClickListener(this);

        rbDurian = (RadioButton) findViewById(R.id.rbDurian);
        rbDurian.setOnClickListener(this);

        spAnimals = (Spinner) findViewById(R.id.spAnimals);
        spAnimals.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_best_friends, Countries);
        actvOne.setThreshold(1);
        actvOne.setAdapter(adapter);

        List<String> animals = new ArrayList<String>();
        animals.add("Please Select");
        animals.add("Leo");
        animals.add("Husky");
        animals.add("Tiger");

        ArrayAdapter<String> spAdapter = new ArrayAdapter<String>(this, R.layout.item_best_friends, animals);
        spAnimals.setAdapter(spAdapter);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnDone) {
            StringBuffer result = new StringBuffer();

            if (cb1.isChecked()) {
                result.append("Here you go: " + cb1.getText() + " is ").append(cb1.isChecked());
            } else {
                result.append("Here you are: " + cb2.getText() + " is ").append(cb2.isChecked());
            }
            Toast.makeText(UIControlsActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

        } else if (view.getId() == R.id.tbMode) {
            if (tbMode.isChecked()) {
                Toast.makeText(UIControlsActivity.this, "Toggle Button is Checked!", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.rbMango) {
            Toast.makeText(UIControlsActivity.this, "You love Mango!", Toast.LENGTH_SHORT).show();

            progress.setMessage("Going to buy Mango for you...");
            progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progress.setIndeterminate(true);
            progress.setProgress(0);
            progress.show();

            final int totalProgressTime = 100;
            final Thread t = new Thread() {

                @Override
                public void run() {
                    int jumpTime = 0;

                    while (jumpTime < totalProgressTime) {
                        try {
                            sleep(200);
                            jumpTime += 5;
                            progress.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();

        } else if (view.getId() == R.id.rbMatcha) {
            Toast.makeText(UIControlsActivity.this, "You love Matcha!", Toast.LENGTH_SHORT).show();

        } else if (view.getId() == R.id.rbDurian) {
            Toast.makeText(UIControlsActivity.this, "You love Durian!", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
