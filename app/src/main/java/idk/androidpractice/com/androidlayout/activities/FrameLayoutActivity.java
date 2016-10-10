package idk.androidpractice.com.androidlayout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import idk.androidpractice.com.androidlayout.R;

public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute_layout);
        setTitle("Frame Layout");
    }
}
