package javaLevel2.lesson7_8.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запустился");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(socket, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String nick, String msg){
        for (ClientHandler c: clients ) {
            c.sendMsg(nick + " : " + msg);
        }
    }

    public void broadcastPrivateMsg(String msg, String nick){
        for (ClientHandler c: clients ) {
            if (c.getNick().equals(nick)){
                c.sendMsg(msg);
            } else {
                c.sendMsg("");
            }

        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public boolean isLoginAuthorized(String login) {
        for (ClientHandler c:clients) {
            if (c.getLogin().equals(login)) return true;
        }
        return false;
    }


}
