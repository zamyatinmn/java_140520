package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        Scanner sc;
        final String IP_ADDRESS = "localhost";
        final int PORT = 8189;

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);

            Thread t = new Thread(() -> {
                try {

                    while (true){
                        out.writeUTF(sc.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.setDaemon(true);
            t.start();

            while (true){
                String str = in.readUTF();
                if (str.equals("/end")){
                    System.out.println("Сервер отключился");
                    break;
                }
                System.out.println("Сервер: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}