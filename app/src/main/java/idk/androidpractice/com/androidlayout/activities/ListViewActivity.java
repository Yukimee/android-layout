package idk.androidpractice.com.androidlayout.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import idk.androidpractice.com.androidlayout.R;

public class ListViewActivity extends AppCompatActivity {

    private String[] BestFriendList = {"Lina", "Siew Chee", "Tze Hui", "Yoyo", "Ling Ling", "Tiffany", "Khai Ling",
            "Maygi", "Yama", "Shan Shan", "Phoebe", "Ze Wen", "Hui Qi", "Khim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.item_best_friends, BestFriendList);

        ListView lvBestFriends = (ListView) findViewById(R.id.lvBestFriends);
        lvBestFriends.setAdapter(adapter);
    }
}
