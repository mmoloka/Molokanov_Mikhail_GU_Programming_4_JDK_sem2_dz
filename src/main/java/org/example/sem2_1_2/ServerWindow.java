package org.example.sem2_1_2;

/*
1) Было описано окно сервера приложения, содержащее две кнопки (старт и стоп) и текстовое поле журнала.
Необходимо вынести логику работы сервера в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки
и журналирования сообщений от сервера. Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
«получить сообщение», вызывать его с одной стороны, и реализовать с другой.

2) Создать интерфейсы ServerSocketThreadListener и SocketThreadListener, содержащие методы, соответствующие событиям
сервера и клиента чата. Реализовать созданные интерфейсы простым логированием.
Со стороны клиента – только SocketThreadListener,со стороны сервера – оба интерфейса.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 250;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final ChatServer chatServer;
    private final SocketThreadListener socketThreadListener;

    private final JButton buttonStart = new JButton("Start");
    private final JButton buttonStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();

    public static void main(String[] args) {
        ServerSocketThreadListener serverSocketThreadListener = new ServerSocketImpl();
        SocketThreadListener socketThreadListener = new ClientSocketImpl();
        SocketThreadListener serverButtonListener = new ServerButtonListenerImpl();
        ServerListener listener = new ServerListenerImpl();
        ChatServer chatServer = new ChatServer(false, listener, serverSocketThreadListener, serverButtonListener);
        new ServerWindow(chatServer, socketThreadListener);
    }

    private ServerWindow(ChatServer chatServer, SocketThreadListener socketThreadListener) {
        this.chatServer = chatServer;
        this.socketThreadListener = socketThreadListener;
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                log.setText("");
                log.append(chatServer.stop());
                socketThreadListener.pressButton("Start");
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.setText("");
                log.append(chatServer.start());
                socketThreadListener.pressButton("Stop");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        add(log, BorderLayout.SOUTH);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        add(buttonPanel);
        setVisible(true);
    }
}
