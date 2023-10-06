package org.example.sem2_1_2;

public class ServerButtonListenerImpl implements SocketThreadListener {
    @Override
    public void pressButton(String buttonName) {
        System.out.println("Server log:  command received " + buttonName);
    }
}
