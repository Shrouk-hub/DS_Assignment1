package ds_assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DS_Sensors {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
    
            Socket s = new Socket("127.0.0.1", 4444);
            
            DataInputStream IS = new DataInputStream(s.getInputStream());
            DataOutputStream OS = new DataOutputStream(s.getOutputStream());
            
             
            while (true)
            {
                String sm = IS.readUTF(); 
                if(sm.equals("Enter your location:"))
                {
                    System.out.println(sm);
                    OS.writeUTF("EL_Shorouk");
                    System.out.println("EL_Shorouk");
                     continue;
                } 
                else if(sm.equals("Enter your destination:"))
                {
                    System.out.println(sm);
                    OS.writeUTF("EL_Abbasia");
                    System.out.println("EL_Abbasia");
                    continue;
                }
               
                else if(sm.equals("the best way is the main"))
                {
                    System.out.println(sm);
                    System.out.println("happy trip");
                    break;
                }
            }
         
            IS.close();
            OS.close();
            s.close();
            
        } 
        catch (IOException error)
        {
            System.out.println("IOException"+error.getMessage());
        }
    }
}
