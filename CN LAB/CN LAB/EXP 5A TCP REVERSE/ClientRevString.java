import java.net.*;
import java.io.*;
import java.util.Scanner;
public class ClientRevString{
public static void main(String arg[]) throws Exception{
InetAddress ia = InetAddress.getLocalHost();
Socket cSock = new Socket(ia,1234);
DataInputStream in = new DataInputStream(cSock.getInputStream());
DataOutputStream out = new DataOutputStream(cSock.getOutputStream());
System.out.println("Please Enter String");
Scanner sc = new Scanner(System.in);
String inp = sc.nextLine();
out.writeUTF(inp);
// System.out.println("response from server");
// System.out.println(in.readUTF().toString());
cSock.close();
}
}
