package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Сервер запущен");
            try (Socket socket = server.accept()){
                System.out.println("Клиент подключен");
                try (DataInputStream in = new DataInputStream(socket.getInputStream());
                     Scanner sc = new Scanner(System.in);
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                    Thread t = new Thread(()->{
                        while (true){
                            try {
                                out.writeUTF(sc.nextLine());
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
                                System.out.println("Клиент отключился");
                                break;
                            }
                            System.out.println("Клиент: " + str);
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
