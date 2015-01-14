package com.androidbegin.parselogintutorial;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;
 
public class ParseApplication extends Application {
 
    @Override
    public void onCreate() {
        super.onCreate();
 

        Parse.initialize(this, "Jxvbfd1RqnLHVMect7fK9nIPH1vQIpMqvwiIEv8l", "rrrFZ8dw6FQvLrKXDTPmhosQ6H1uZKgynXwprbmK");
 
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
 

        defaultACL.setPublicReadAccess(true);
 
        ParseACL.setDefaultACL(defaultACL, true);
    }
 
}