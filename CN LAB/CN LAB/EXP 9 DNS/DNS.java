import java.net.*;
import java.io.*;

public class DNS {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice=0;

        do {
            System.out.println("\nMenu:\n1. DNS Lookup\n2. Reverse DNS Lookup\n3. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(in.readLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Host Name: ");
                        String hostName = in.readLine();
                        InetAddress address = InetAddress.getByName(hostName);
                        System.out.println("Host Name: " + address.getHostName());
                        System.out.println("IP: " + address.getHostAddress());
                        break;

                    case 2:
                        System.out.print("Enter IP address: ");
                        String ipStr = in.readLine();
                        InetAddress ia = InetAddress.getByName(ipStr);
                        System.out.println("IP: " + ipStr);
                        System.out.println("Host Name: " + ia.getHostName());
                        break;

                    case 3:
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        } while (choice != 3);
    }
}
