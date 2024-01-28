import java.io.*;
import java.net.*;

public class TCPChatClient {
    private static final int PORT = 8089;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", PORT);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String userInput;
            while ((userInput = reader.readLine()) != null) {
                writer.println(userInput);

                // Simulating client response
                String serverResponse = serverReader.readLine();
                System.out.println("From Server: " + serverResponse);

                if (userInput.trim().equalsIgnoreCase("exit")) {
                    System.out.println("Client Exit...");
                    break;
                }
            }

            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
