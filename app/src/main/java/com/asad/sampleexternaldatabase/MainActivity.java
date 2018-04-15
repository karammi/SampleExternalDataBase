package com.asad.sampleexternaldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = (TextView) findViewById(R.id.tvText);
        tvText.setText("This is a test of the application");

        List<Contact> contactList = SampleDataBaseHelper.getsInstance(this).getContactList();
        for (Contact contact : contactList) {
            Log.e("VALUE", "id: " + contact.getId());
            Log.e("VALUE", "Name: " + contact.getName());
            Log.e("VALUE", "Family: " + contact.getFamily());
            Log.e("VALUE", "Phone: " + contact.getPhone());
            Log.e("VALUE", "--------------------------------------- " );

        }
    }
}
