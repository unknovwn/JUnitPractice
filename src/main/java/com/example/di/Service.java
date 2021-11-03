package com.example.di;

import javax.inject.Inject;

public class Service {

    @Inject
    String s;

    public Service() {}

    @Inject
    public Service(String s) {
        this.s = s;
    }
}
