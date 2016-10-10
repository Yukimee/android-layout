package idk.androidpractice.com.androidlayout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import idk.androidpractice.com.androidlayout.adapters.ImageAdapter;
import idk.androidpractice.com.androidlayout.R;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        setTitle("Grid View");

        GridView gvGallery = (GridView) findViewById(R.id.gvGallery);
        gvGallery.setAdapter(new ImageAdapter(this));
    }
}
