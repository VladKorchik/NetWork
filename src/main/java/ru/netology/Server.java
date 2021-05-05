package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int port = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        boolean autoFlush = true;
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), autoFlush);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connetcion accepted");
        final String name = in.readLine();
        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

    }
}
