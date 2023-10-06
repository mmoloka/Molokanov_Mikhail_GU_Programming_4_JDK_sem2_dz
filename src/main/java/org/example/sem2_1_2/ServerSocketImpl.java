package org.example.sem2_1_2;

public class ServerSocketImpl implements ServerSocketThreadListener {
    @Override
    public void onStop() {
        System.out.println("Log:  Server stopped");
    }

    @Override
    public void onStart() {
        System.out.println("Log:  Server started");
    }
}
