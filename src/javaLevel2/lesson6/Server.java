package javaLevel2.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            new Server();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public Server() throws InterruptedException, IOException {
        ServerSocket serverSocket = new ServerSocket(9997);
        Socket client = serverSocket.accept();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){
                        while (true){
                            Scanner sc = new Scanner(System.in);
                            writer.write("server: " + sc.nextLine());
                            writer.newLine();
                            writer.flush();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            //send message to server
            while (true) {
                //get message from client
                System.out.println(reader.readLine());
            }
        }
    }

}
