import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(3310);
                System.out.println("Сервер запущен");
                while (true) {
                    clientSocket = server.accept();
                    System.out.println(clientSocket.isConnected());
                }
            } finally {
                System.out.println("Сервер закрыт");
                server.close();
            }
        }    catch (IOException e) {
                e.printStackTrace();
            }
    }
}
