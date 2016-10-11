package idk.androidpractice.com.androidlayout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import idk.androidpractice.com.androidlayout.R;

public class UIControlsActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] Countries = {"America", "Australia", "Afghanistan", "Brunei", "Bangladesh", "Brazil", "Bulgaria", "China", "Columbia",
            "Denmark", "Egypt", "French", "Germany", "Hong Kong", "Ireland", "Japan", " Korea", "Libya", "Laos", "Malaysia", "Macau", "Maldives", "Myanmar",
            "Nepal", "Nigeria", "Oman", "Pakistan", "Philippines", "Qatar", "Romania", "Singapore", "Somalia", "Spain", "Turkey",
            "Taiwan", "Thailand", "US", "UK", "Vietnam", "Western Sahara", "Yemen", "Zambia"};

    private Button btnDone;
    private CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicontrols);

        AutoCompleteTextView actvOne = (AutoCompleteTextView) findViewById(R.id.actvOne);

        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_best_friends, Countries);
        actvOne.setThreshold(1);
        actvOne.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnDone){
            StringBuffer result = new StringBuffer();

            if(cb1.isChecked()){
                result.append("Here you go: " + cb1.getText() + " is ").append(cb1.isChecked());
            }else{
                result.append("Here you are: " + cb2.getText() + " is ").append(cb2.isChecked());
            }
            Toast.makeText(UIControlsActivity.this, result.toString(), Toast.LENGTH_LONG).show();

        }

    }
}
