package com.arm.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    int REQ_CODE_EN_BT = 1;
    int REQ_CODE_SELECT_REMOTE_DEVICE = 2;
    final int CONNECTION_IS_ENABLED = 3;
    final int CONNECTION_IS_DISABLED = 4;

    BluetoothAdapter mBlueAdapter;
    BluetoothSocket mSocket;

    ImageView mButton_up;
    ImageView mButton_down;
    ImageView mButton_left;
    ImageView mButton_right;

    ImageView mButton_triangle;
    ImageView mButton_cross;
    ImageView mButton_square;
    ImageView mButton_circle;

    ImageView mButton_l;
    ImageView mButton_r;

    ImageView mButton_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBlueAdapter == null) {
        } else if(!mBlueAdapter.isEnabled()){
            // enable the bluetooth
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, REQ_CODE_EN_BT);
        }

        mButton_up = findViewById(R.id.button_up);
        mButton_down = findViewById(R.id.button_down);
        mButton_left = findViewById(R.id.button_left);
        mButton_right = findViewById(R.id.button_right);

        mButton_triangle = findViewById(R.id.triangle_button);
        mButton_cross = findViewById(R.id.cross_button);
        mButton_square = findViewById(R.id.square_button);
        mButton_circle = findViewById(R.id.circle_button);

        mButton_l = findViewById(R.id.l_button);
        mButton_r = findViewById(R.id.r_button);

        mButton_connect = findViewById(R.id.connect_button);

        /* buttons click event */
        mButton_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("w".getBytes());
                    return true;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("w".getBytes());
                    return true;
                }

                return false;
            }

        });
        mButton_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("s".getBytes());
                    return true;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("s".getBytes());
                    return true;
                }
                return false;
            }
        });
        mButton_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("a".getBytes());
                    return true;

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("a".getBytes());
                    return true;

                }
                return false;
            }
        });
        mButton_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.i("UP", "down");
                    write("d".getBytes());
                    return true;

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.i("UP", "up");
                    write("d".getBytes());
                    return true;

                }
                return false;
            }
        });
        mButton_triangle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("i".getBytes());
                    return true;

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("i".getBytes());
                    return true;

                }
                return false;
            }
        });
        mButton_cross.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("k".getBytes());
                    return true;

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("k".getBytes());
                    return true;

                }
                return false;
            }
        });
        mButton_square.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("j".getBytes());
                    return true;

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("j".getBytes());
                    return true;

                }
                return false;
            }
        });
        mButton_circle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("l".getBytes());
                    return true;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("l".getBytes());
                    return true;
                }
                return false;
            }
        });
        mButton_l.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("q".getBytes());
                    return true;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("q".getBytes());
                    return true;
                }
                return false;
            }
        });
        mButton_r.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    write("e".getBytes());
                    return true;
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    write("e".getBytes());
                    return true;
                }
                return false;
            }
        });

        mButton_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSelectActivity();
            }
        });


        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                handler.obtainMessage(CONNECTION_IS_DISABLED).sendToTarget();
            }
        }, new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECTED));
    }


    public void startSelectActivity() {
        Intent intent = new Intent(this, SelectDeviceActivity.class);
        startActivityForResult(intent, REQ_CODE_SELECT_REMOTE_DEVICE );
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_EN_BT && resultCode == RESULT_OK) {
            Toast.makeText(getApplicationContext(), "bluetooth is enabled", Toast.LENGTH_SHORT).show();
        }

        if (requestCode == REQ_CODE_SELECT_REMOTE_DEVICE && resultCode == RESULT_OK) {
            String address = data.getStringExtra("EXTRA_DEVICE_ADDRESS");
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            requestRfConnection(address);
                        }
                    }
            ).start();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mSocket != null && mSocket.isConnected()) {
            try {
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestRfConnection(String remoteDeviceAddress) {
        BluetoothDevice remoteDevice = mBlueAdapter.getRemoteDevice(remoteDeviceAddress);
        UUID uuid = remoteDevice.getUuids()[0].getUuid();
        BluetoothSocket temp = null;
        try {
            temp = remoteDevice.createInsecureRfcommSocketToServiceRecord(uuid);
            temp.connect();
            mSocket = temp;
            handler.obtainMessage(CONNECTION_IS_ENABLED).sendToTarget();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void write(byte... b){
        try {
            if (mSocket != null && mSocket.isConnected()) {
                OutputStream out = mSocket.getOutputStream();
                out.write(b);
            }
        } catch (IOException e) {

        }
    }



    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch(msg.what) {
                case CONNECTION_IS_ENABLED:
                    mButton_connect.setImageDrawable(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.plug_in)); break;
                case CONNECTION_IS_DISABLED:
                    mButton_connect.setImageDrawable(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.plug_out)); break;
            }
        }
    };

}