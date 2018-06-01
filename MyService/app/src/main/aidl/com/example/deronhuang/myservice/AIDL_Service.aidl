// AIDL_Service.aidl
package com.example.deronhuang.myservice;

// Declare any non-default types here with import statements

interface AIDL_Service {

    void AIDL_Service_Base();
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
