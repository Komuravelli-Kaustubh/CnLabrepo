import java.util.Scanner;
public class SlidingWindowProtocol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, f, i;
        System.out.print("Enter window size: ");
        n = scanner.nextInt();
        System.out.print("Enter number of frames to transmit: ");
        f = scanner.nextInt();
        int[] frames = new int[f + 1]; // Adding 1 to the array size for 1-based indexing
        System.out.println("Enter " + f + " frames:");
        for (i = 1; i <= f; i++) {
            frames[i] = scanner.nextInt();
        }
        System.out.println("\nWith sliding window protocol the frames will be sent in the following manner (assuming no corruption of frames)\n");
        System.out.println("After sending " + n + " frames at each stage sender waits for acknowledgement sent by the receiver\n");
        for (i = 1; i <= f; i++) {
            if (i % n == 0) {
                System.out.print(frames[i] + " ");
                System.out.println("\n Acknowledgment of above frames sent is received by sender\n");
            } else {
                System.out.print(frames[i] + " ");
            }
        }
        if (f % n != 0) {
            System.out.println("\n Acknowledgment of above frames sent is received by sender");
        }
    }
}