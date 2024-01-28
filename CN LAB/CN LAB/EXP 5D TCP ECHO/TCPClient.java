import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class TCPClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 5555;

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Hello, Server!",
                "How are you?",
                "Echo this sentence.",
                "TCP is awesome!"
        );

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            for (String sentence : sentences) {
writer.println(sentence);
                String response = reader.readLine();
System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
e.printStackTrace();
        }
    }
}