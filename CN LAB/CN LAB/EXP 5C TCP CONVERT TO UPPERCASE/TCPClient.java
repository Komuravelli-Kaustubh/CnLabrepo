import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class TCPClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 5555;

    public static void main(String[] args) {
        try {
            InetSocketAddress serverAddress = new InetSocketAddress(SERVER_IP, SERVER_PORT);
            SocketChannel socketChannel = SocketChannel.open(serverAddress);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text to convert to uppercase: ");
            String userInput = scanner.nextLine();

            socketChannel.write(ByteBuffer.wrap(userInput.getBytes()));

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            String response = new String(buffer.array()).trim();
            System.out.println("Server response: " + response);

            socketChannel.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
