package activities;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import db.PhoneBookDB;
import idk.androidpractice.com.androidlayout.R;

public class CursorListViewActivity extends AppCompatActivity {

    private PhoneBookDB phoneBookDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_list_view);

        phoneBookDB = new PhoneBookDB(this);
        phoneBookDB.open();

        //Clean all data
        phoneBookDB.deleteAllPhones();

        //Add some data
        phoneBookDB.insertSomePhones();

        //Generate ListView from SQLITE database
        displayListView();

    }

    private void displayListView() {
        Cursor cursor = phoneBookDB.fetchAllPhones();

        //The desired columns to be bound
        String[] columns = new String[]{PhoneBookDB.KEY_PHONE, PhoneBookDB.KEY_NAME};

        //The xml defined views which the data will be bound to
        int[] to = new int[]{R.id.tvPhoneNumber, R.id.tvName};

        //create the adapter using the cursor pointing to the desired data as well as the layout information
        MyCursorAdapter adapter = new MyCursorAdapter(this, R.layout.activity_cursor_list_view, cursor, columns, to, 0);

        ListView listview = (ListView) findViewById(R.id.lvPhoneBook);
        listview.setAdapter(adapter);

    }

    //Extend

    private class MyCursorAdapter extends SimpleCursorAdapter {


        public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flag) {
            super(context, layout, c, from, to, flag);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);

            if (position % 2 == 0) {
                view.setBackgroundColor(Color.rgb(238, 233, 233));
            } else {
                view.setBackgroundColor(Color.rgb(255, 255, 255));
            }
            return view;
        }
    }


}
