package idk.androidpractice.com.androidlayout.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import idk.androidpractice.com.androidlayout.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnUILayouts, btnRelativeLayout, btnTableLayout, btnFrameLayout, btnListView, btnCursorListView,
            btnGridView, btnUIControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUILayouts = (Button) findViewById(R.id.btnLinearLayout);
        btnUILayouts.setOnClickListener(this);

        btnRelativeLayout = (Button) findViewById(R.id.btnRelativeLayout);
        btnRelativeLayout.setOnClickListener(this);

        btnTableLayout = (Button) findViewById(R.id.btnTableLayout);
        btnTableLayout.setOnClickListener(this);

        btnFrameLayout = (Button) findViewById(R.id.btnFrameLayout);
        btnFrameLayout.setOnClickListener(this);

        btnListView = (Button) findViewById(R.id.btnListView);
        btnListView.setOnClickListener(this);

        btnCursorListView = (Button) findViewById(R.id.btnCursorListView);
        btnCursorListView.setOnClickListener(this);

        btnGridView = (Button) findViewById(R.id.btnGridView);
        btnGridView.setOnClickListener(this);

        btnUIControls = (Button) findViewById(R.id.btnUIControls);
        btnUIControls.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnLinearLayout:
                intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRelativeLayout:
                intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTableLayout:
                intent = new Intent(MainActivity.this, TableLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btnFrameLayout:
                intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btnListView:
                intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCursorListView:
                intent = new Intent(MainActivity.this, CursorListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btnGridView:
                intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUIControls:
                intent = new Intent(MainActivity.this, UIControlsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
