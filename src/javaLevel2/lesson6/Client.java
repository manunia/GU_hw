package javaLevel2.lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            new Client();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Socket client = new Socket("localhost", 9997);

    public Client() throws IOException, InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Socket client = new Socket("localhost", 9997);
                    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    //BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))
                    ) {
                        //send message to server
                        while (true) {
                            Scanner sc = new Scanner(System.in);
                            writer.write("client: " + sc.nextLine());
                            writer.newLine();
                            writer.flush();
                            //get message from server
                            //System.out.println(reader.readLine());
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            //send message to server
            while (true) {
                //get message from server
                System.out.println(reader.readLine());
            }
        }

        //thread.setDaemon(true);

        //thread.join();
    }
}
