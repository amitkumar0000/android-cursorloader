package com.android.curorloader;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    String TAG = "CursorLoader";
    Loader loader;
    ListView listView;
    CustomContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listcontact);
        loader = getLoaderManager().initLoader(1,null,this);
    }

    @Override
    public Loader onCreateLoader(int i, Bundle bundle) {
        Uri CONTACT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        CursorLoader cursorLoader = new CursorLoader(this, CONTACT_URI, null,
                null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        cursor.moveToFirst();
        adapter = new CustomContactAdapter(this,cursor);
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
