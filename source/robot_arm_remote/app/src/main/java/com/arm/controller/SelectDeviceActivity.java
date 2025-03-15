package com.arm.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Set;

public class SelectDeviceActivity extends AppCompatActivity {

    private ListView mListView;
    private Button mScanButton;

    private ArrayAdapter<BluetoothDeviceWrapper> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device);

        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> remoteDevices = ba.getBondedDevices();

        mListView = findViewById(R.id.listview);
        mScanButton = findViewById(R.id.button_scan);

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        for (BluetoothDevice remoteDevice : remoteDevices) {
            arrayAdapter.add(new BluetoothDeviceWrapper(remoteDevice));
        }
        mListView.setAdapter(arrayAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BluetoothDeviceWrapper item = (BluetoothDeviceWrapper) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("EXTRA_DEVICE_ADDRESS", item.remoteDevice.getAddress());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    public void onScanButtonPress(View view) {
//        if (!mBlueAdapter.isDiscovering()) {
//            mBlueAdapter.startDiscovery();
//        }
    }
}