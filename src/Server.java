import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static DataInputStream inStream;
    private static DataOutputStream outStream;
    private static String message ="Подключение установлено";

    public static void main(String[] args) {
            try {
                server = new ServerSocket(3320);
                System.out.println("Сервер запущен");

                while (true) {
                    clientSocket = server.accept();
                    inStream= new DataInputStream(clientSocket.getInputStream());
                    outStream=new DataOutputStream((clientSocket.getOutputStream()));
                    if(clientSocket.isConnected()){
                        System.out.println("Клиент "+ inStream.readUTF()+ " с ip-адресом: " + clientSocket.getInetAddress()+ " подключился.");
                        outStream.writeUTF(message);
                        outStream.flush();
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }
}
