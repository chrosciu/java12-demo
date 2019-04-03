package com.chrosciu.java12demo;

import java.util.ArrayList;
import java.util.List;

public class Traps {
    public void implicitIntInference() {
        // ORIGINAL
        byte flags = 0;
        short mask = 0x7fff;

        byteConsumer(flags);
        shortConsumer(mask);

        // DANGEROUS: all are inferred as int
        var inferredFlags = 0;
        var inferredMask = 0x7fff;

        //byteConsumer(inferredFlags);
        //shortConsumer(inferredMask);
    }

    private void byteConsumer(byte b) {}

    private void shortConsumer(short s) {}

    public void collectionInitialization() {
        // ORIGINAL
        List<String> list = new ArrayList<String>();
        stringListConsumer(list);
        //stringArrayListConsumer(list);

        // OK: still inferred as List<String>
        List<String> listWithDiamond = new ArrayList<>();
        stringListConsumer(listWithDiamond);
        //stringArrayListConsumer(listWithDiamond);

        // OK: still inferred as ArrayList<String>
        var inferredList = new ArrayList<String>();
        stringListConsumer(inferredList);
        stringArrayListConsumer(inferredList);

        // DANGEROUS: inferred as ArrayList<Object>
        var inferredAsObjectList = new ArrayList<>();
        //stringListConsumer(inferredAsObjectList);
        //stringArrayListConsumer(inferredAsObjectList);

    }

    private void stringListConsumer(List<String> list) {}

    private void stringArrayListConsumer(ArrayList<String> arrayList) {}
}
