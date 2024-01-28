import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClientReverse {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAdress = InetAddress.getLoopbackAddress();
        byte [] sendData = new byte[1024];
        byte [] receiveData = new byte[1024];
        String str = br.readLine();
        sendData = str.getBytes();
        DatagramPacket dgp = new DatagramPacket(sendData,sendData.length,IPAdress,9999);
        clientSocket.send(dgp);
        dgp = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(dgp);
        str = new String(dgp.getData());
        System.out.println("Output: " + str);
        clientSocket.close();
        br.close();
    }
}
