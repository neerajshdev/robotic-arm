package com.arm.controller;

import android.bluetooth.BluetoothDevice;


public class BluetoothDeviceWrapper {
    public BluetoothDevice remoteDevice;

    public BluetoothDeviceWrapper(BluetoothDevice remoteDevice) {
        this.remoteDevice = remoteDevice;
    }

    @Override
    public String toString() {
        return remoteDevice.getName() +  " " + remoteDevice.getAddress();
    }
}
