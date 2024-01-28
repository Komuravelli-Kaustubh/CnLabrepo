import java.io.*;
import java.net.*;

public class TCPChatServer {
    private static final int PORT = 8089;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server listening on port " + PORT + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection accepted from: " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("From client: " + message + "\t To client: ");

                // Simulating server response
                writer.println("Hello, " + message);

                if (message.trim().equalsIgnoreCase("exit")) {
                    System.out.println("Server Exit...");
                    break;
                }
            }

            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
