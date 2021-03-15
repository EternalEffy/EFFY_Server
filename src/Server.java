import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
            try {
                server = new ServerSocket(3310,1);
                System.out.println("Сервер запущен");
                while (true) {
                    clientSocket = server.accept();
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    if(clientSocket.isConnected()){
                        System.out.println("Клиент " + new String(in.readLine().getBytes(StandardCharsets.UTF_8)) + " с ip адреса: " + clientSocket.getInetAddress() + " подключен");
                        out.write("Подключение установлено" + "\n");
                        out.flush();
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
}
