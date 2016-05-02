package com.sadikali.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadikali.data.model.User;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sadikali1up on 2016-04-27.
 */
public class ContactsArrayAdapter extends ArrayAdapter<User> {

    private final List<User> data;
    private final Context context;

    public ContactsArrayAdapter(Context context, List<User> input){
        super(context, R.layout.item_contact, input);

        if (input == null)
            data = new ArrayList<>();
        else
            data = input;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View rowView = convertView;
        User u = data.get(position);

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_contact, parent, false);
        }
        ImageView iv = (ImageView) rowView.findViewById(R.id.user_thumb);
        Picasso.with(context).load(u.picture.thumbnail).into(iv);

        TextView tv = (TextView) rowView.findViewById(R.id.user_name);
        tv.setText(u.toString());

        return rowView;
    }

    public void updateData(List<User> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

}
