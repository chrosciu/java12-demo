package com.chrosciu.java12demo;

public class UnsupportedFeatures {

    public void test() {
//        var notInitialized;
//        var nullInitialized = null;
//        var nullInitializedWithCast = (String) null;
//        var array = {"a", "b", "c"};
//        String[] arrayWithExplicitType = {"a", "b", "c"};
//        var lambda = () -> test;
//        Supplier<String> lambdaWithExplicitType = () -> "test";
//        var methodReference = this::stringSupplier;
//        Supplier<String> methodReferenceWithExplicitType = this::stringSupplier;
    }

    private String stringSupplier() {
        return "test";
    }

}
