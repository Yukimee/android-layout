package idk.androidpractice.com.androidlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUILayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUILayouts = (Button) findViewById(R.id.btnUILayouts);
        btnUILayouts.setOnClickListener(this);

        //momoiioi
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnUILayouts:
                intent = new Intent(MainActivity.this, UILayoutsActivity.class);
                startActivity(intent);
                break;
        }

    }
}
