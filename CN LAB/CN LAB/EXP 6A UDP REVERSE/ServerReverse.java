import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ServerReverse {
    public static String reverseInt(int num) {
        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + (num % 10);
            num = num / 10;
        }
        return Integer.toString(ans);
    }
    public static void main(String[] args) throws Exception {
        DatagramSocket dgs = new DatagramSocket(9999);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramPacket dgp = new DatagramPacket(receiveData, receiveData.length);
        dgs.receive(dgp);
        String str = new String(dgp.getData()).trim();
        System.out.println("Data Received: " + str);
        InetAddress IPAddress = dgp.getAddress();
        String ans = ServerReverse.reverseInt(Integer.parseInt(str));
        sendData = ans.getBytes();
        dgp = new DatagramPacket(sendData, sendData.length, IPAddress, dgp.getPort());
        dgs.send(dgp);
    }
}
