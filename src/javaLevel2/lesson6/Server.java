package javaLevel2.lesson6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            new Server();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Server() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(9997);
                    Socket client = serverSocket.accept();
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
                    ){
                        while (true){
                            Scanner sc = new Scanner(System.in);
                            //System.out.print("server: ");
                            writer.write("server: " + sc.nextLine());
                            writer.newLine();
                            writer.flush();
                            //get message from client
                            System.out.println(reader.readLine());
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        thread.join();
    }

}
