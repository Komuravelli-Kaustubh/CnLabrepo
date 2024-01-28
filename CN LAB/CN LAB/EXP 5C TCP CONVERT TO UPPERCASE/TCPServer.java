import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TCPServer {
    private static final int PORT = 5555;
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new java.net.InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;

                Set<SelectionKey>selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey>keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        acceptConnection(selector, serverSocketChannel);
                    }
                    else if (key.isReadable()) {
                        processRequest(key);
                    }
                    keyIterator.remove();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptConnection(Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel clientChannel = serverSocketChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Accepted connection from " + clientChannel.getRemoteAddress());
    }

    private static void processRequest(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientChannel.read(buffer);

        if (bytesRead == -1) {
            key.cancel();
            clientChannel.close();
            return;
        }

        String request = new String(buffer.array(), 0, bytesRead);
        System.out.println("Received request from " + clientChannel.getRemoteAddress() + ": " + request);

        String response = request.toUpperCase();
        clientChannel.write(ByteBuffer.wrap(response.getBytes()));

        key.cancel();
        clientChannel.close();
        System.out.println("Connection closed by client: " + clientChannel.getRemoteAddress());
    }
}
