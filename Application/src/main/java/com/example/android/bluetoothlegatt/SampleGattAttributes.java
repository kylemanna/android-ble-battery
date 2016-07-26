/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.bluetoothlegatt;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class includes a small subset of standard GATT attributes for demonstration purposes.
 */
public class SampleGattAttributes {
    private static HashMap<String, String> attributes = new HashMap();
    private static HashMap<Integer, String> presentation = new HashMap();

    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static UUID UUID_CHARACTERISTIC_PRESENTATION_FORMAT = UUID.fromString("00002904-0000-1000-8000-00805f9b34fb");
    public static String BATTERY_LEVEL = "00002a19-0000-1000-8000-00805f9b34fb";
    public static String BATTERY_SERVICE = "0000180f-0000-1000-8000-00805f9b34fb";

    public static Integer GATT_NAMESPACE_INTERNAL = 0x010F;
    public static Integer GATT_NAMESPACE_MAIN = 0x0106;

    /* https://www.bluetooth.com/specifications/assigned-numbers/gatt-namespace-descriptors?_ga=1.226638301.1317430156.1430435893 */
    static {
        presentation.put(GATT_NAMESPACE_MAIN, "main");
        presentation.put(GATT_NAMESPACE_INTERNAL, "internal");
    }

    static {
        // Sample Services.
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate Service");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information Service");
        attributes.put(BATTERY_SERVICE, "Battery Service");
        // Sample Characteristics.
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
        attributes.put(BATTERY_LEVEL, "Battery Level");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }

    public static String lookupPresentationName(int value, String defaultName) {
        String name = presentation.get(value);
        return name == null ? defaultName : name;
    }
}
