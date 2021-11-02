package ds_assignment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class computer {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            //for server connection
            Socket s = new Socket("127.0.0.1", 5000);
            
            
            
            //for sensor connection
            ServerSocket sev = new ServerSocket(4444);
            System.out.println("Client is ready");
            
            while (true)
            {
               
                Socket v = sev.accept();
                System.out.println("Sensor is ready");
                DataInputStream IS = new DataInputStream(v.getInputStream());
                DataOutputStream OS = new DataOutputStream(v.getOutputStream());
            
                DataInputStream ISS = new DataInputStream(s.getInputStream());
                DataOutputStream OSS = new DataOutputStream(s.getOutputStream());
            
                while (true)
                {
                   
                  String sm = ISS.readUTF(); 
                  OS.writeUTF(sm);
                  OS.flush();
                  String ss = IS.readUTF();
                  OSS.writeUTF(ss);
                  OSS.flush();
                  
                  if(sm.equals("the best way is the main")){
                      break;
                  }
                  continue;               
                  
               }
         
            ISS.close();
            OSS.close();
            s.close();
            IS.close();
            OS.close();
            v.close();
            }

        } catch (IOException IO)
        {
            System.out.println("IOException"+IO.getMessage());
        }
    }
}
