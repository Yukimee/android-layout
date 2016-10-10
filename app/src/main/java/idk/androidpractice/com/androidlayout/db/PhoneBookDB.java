package idk.androidpractice.com.androidlayout.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PhoneBookDB {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";

    private static final String TAG = "PhoneBookDBAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "PhoneBook";
    private static final String SQLITE_TABLE = "PhoneNumberTable";
    private static final int DATABASE_VERSION = 1;

    private Context context;

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " + SQLITE_TABLE +
            "(" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PHONE  + " TEXT," +
            KEY_NAME + "TEXT)";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.w(TAG, DATABASE_CREATE);
            sqLiteDatabase.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + "to "
                    + newVersion + ", which will destroy all data");
            sqLiteDatabase.execSQL("DROP TABLE IS EXISTS " + SQLITE_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

    public PhoneBookDB(Context context) {
        this.context = context;
    }

    public PhoneBookDB open() throws SQLException {
        mDbHelper = new DatabaseHelper(context);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public long createPhoneBook(String phone, String name) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_PHONE, phone);
        initialValues.put(KEY_NAME, name);

        return mDb.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAllPhones() {
        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_TABLE, null, null);
        Log.w(TAG, Integer.toString(doneDelete));

        return doneDelete > 0;
    }

    public Cursor fetchAllPhones() {
        Cursor mCursor = mDb.query(SQLITE_TABLE, new String[]{KEY_ROWID, KEY_PHONE, KEY_NAME}, KEY_ROWID , null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertSomePhones() {
        createPhoneBook("0192348769", "Lina");
        createPhoneBook("0138570495", "Swee Chee");
        createPhoneBook("0126468796", "Shan Shan");
        createPhoneBook("0107758979", "Ze Wen");
    }
}
