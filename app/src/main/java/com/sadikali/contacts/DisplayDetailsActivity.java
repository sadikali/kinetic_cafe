package com.sadikali.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadikali.data.model.User;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by sadikali1up on 2016-04-28.
 */
public class DisplayDetailsActivity extends Activity{



    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);




        User u = (User) getIntent().getParcelableExtra("User");

        setContentView(R.layout.contact_details);
        TextView street = (TextView) findViewById(R.id.street);
        street.setText(u.location.street);

        TextView city = (TextView) findViewById(R.id.city);
        city.setText(u.location.city);

        TextView state = (TextView) findViewById(R.id.state);
        state.setText(u.location.state);

        ImageView imageView = (ImageView) findViewById(R.id.avatar);
        Picasso.with(this).load(u.picture.large).into(imageView);

        TextView phone = (TextView) findViewById(R.id.phone);
        phone.setText(u.phone);

        TextView email = (TextView) findViewById(R.id.email);
        email.setText(u.email);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar_details);
        t.setTitle(u.toString());

    }

}
