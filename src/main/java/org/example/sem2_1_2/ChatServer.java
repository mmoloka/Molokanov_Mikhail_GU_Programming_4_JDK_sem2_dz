package org.example.sem2_1_2;

public class ChatServer {
    private boolean isServerWorking;
    private final ServerListener listener;
    private final ServerSocketThreadListener serverSocketThreadListener;
    private final SocketThreadListener socketThreadListener;

    public ChatServer(boolean isServerWorking, ServerListener listener, ServerSocketThreadListener serverSocketThreadListener, SocketThreadListener socketThreadListener) {
        this.isServerWorking = isServerWorking;
        this.listener = listener;
        this.serverSocketThreadListener = serverSocketThreadListener;
        this.socketThreadListener = socketThreadListener;
    }

    public String stop() {
        socketThreadListener.pressButton("Stop");
        if (!isServerWorking) {
            return listener.getMessage("Server not started" + "\n");
        } else {
            isServerWorking = false;
            serverSocketThreadListener.onStop();
            return listener.getMessage("Server stopped " + false + "\n");
        }
    }

    public String start() {
        socketThreadListener.pressButton("Start");
        if (isServerWorking) {
            return listener.getMessage("Server is already working" + "\n");
        } else {
            isServerWorking = true;
            serverSocketThreadListener.onStart();
            return listener.getMessage("Server started " + true + "\n");
        }
    }
}
