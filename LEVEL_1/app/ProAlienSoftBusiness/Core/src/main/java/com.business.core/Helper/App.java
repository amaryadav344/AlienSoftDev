package com.business.core.Helper;

import com.business.businessobjects.BusBase;

import java.util.HashMap;

public class App {
    private static App mApp;
    private HashMap<String, BusBase> forms;

    public static App getInstance() {
        if (mApp == null) {
            mApp = new App();
        }
        return mApp;
    }

    private App() {
        forms = new HashMap<>();
    }

    public void AddFormObject(String form, BusBase busBase) {
        forms.put(form, busBase);
    }

    public BusBase GetFormObject(String form) {
        return forms.get(form);
    }

}
