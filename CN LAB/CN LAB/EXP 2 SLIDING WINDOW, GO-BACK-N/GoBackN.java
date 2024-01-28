import java.util.*;

class GoBackN{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Please enter the Window Size: ");
    int window=sc.nextInt();
    boolean loop=true;
    int sent=0;
    while(loop){
      for (int i=0;i<window;i++){
          System.out.println("Frame "+sent+" has been transmitted.");
          sent++;
          if(sent==window)
              break;
      }
      System.out.println("Please enter the last Acknowledgement received.");
      int ack=sc.nextInt();
      if(ack==window)
        loop=false;
      else
        sent=ack;
    }
    sc.close();
  }
}
