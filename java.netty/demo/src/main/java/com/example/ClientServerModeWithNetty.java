package com.example;

public class ClientServerModeWithNetty {
    public static void main(String[] args) {
        Runnable server = () -> {

        };

        new Thread(server).start();

        Runnable client = () -> {

        };

        new Thread(client).start();
    }
}
