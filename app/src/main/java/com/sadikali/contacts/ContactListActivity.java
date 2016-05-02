package com.sadikali.contacts;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sadikali.data.model.ContactNetworkService;
import com.sadikali.data.model.Results;
import com.sadikali.data.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sadikali1up on 2016-04-27.
 */
public class ContactListActivity extends ListActivity implements Callback<Results> {

    private List<User> data;
    private ContactsArrayAdapter adapter;

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        setContentView(R.layout.activity_main);

        ContactNetworkService service = retrofit.create(ContactNetworkService.class);
        Call<Results> call = service.userData("1", "10");
        call.enqueue(this);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        t.setTitle("Contacts");

        adapter = new ContactsArrayAdapter(this, new ArrayList<User>());
        setListAdapter(adapter);

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, DisplayDetailsActivity.class);
        //i.putExtra("index", i);
        i.putExtra("User", data.get(position));
        startActivity(i);
    }


    @Override
    public void onResponse(Call<Results> call, Response<Results> response) {
        data = response.body().results;
        adapter.updateData(data);


    }

    @Override
    public void onFailure(Call<Results> call, Throwable t) {
        Log.d("USER", "Got an error " + t.getMessage());

    }

    public User getUser(int position){
        return data.get(position);
    }

}
