package com.android.curorloader;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomContactAdapter extends BaseAdapter{

    Cursor cursor;
    Context context;
    LayoutInflater inflater;

    public CustomContactAdapter(Context context,Cursor cursor){
        this.context = context;
        this.cursor = cursor;
        inflater =(LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder;
        cursor.moveToPosition(position);
        if(view == null) {
            view = inflater.inflate(R.layout.row, viewGroup,false);
            holder = new Holder();
            holder.tvCOntactName = view.findViewById(R.id.rowtext1);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }

        holder.tvCOntactName.setText(cursor.getString(cursor
                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
        return view ;
    }
    class Holder {
        TextView tvCOntactName;
    }
}
