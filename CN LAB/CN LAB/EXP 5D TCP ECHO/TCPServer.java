import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    private static final int PORT = 5555;

    public static void main(String[] args) {
        try {
ServerSocket serverSocket = new ServerSocket(PORT);
System.out.println("Server is listening on port " + PORT);

ExecutorService executorService = Executors.newFixedThreadPool(10);

            while (true) {
                Socket clientSocket = serverSocket.accept();
System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
System.out.println("Received from " + clientSocket.getRemoteSocketAddress() + ": " + line);
writer.println("Server Echo: " + line);
            }

System.out.println("Connection closed by client: " + clientSocket.getRemoteSocketAddress());
        } catch (IOException e) {
e.printStackTrace();
        } finally {
            try {
clientSocket.close();
            } catch (IOException e) {
e.printStackTrace();
            }
        }
    }
}
