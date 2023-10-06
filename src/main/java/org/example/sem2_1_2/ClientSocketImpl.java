package org.example.sem2_1_2;

public class ClientSocketImpl implements SocketThreadListener {
    @Override
    public void pressButton(String buttonName) {
        System.out.println("Client log:  Pressed button " + buttonName);
    }
}
