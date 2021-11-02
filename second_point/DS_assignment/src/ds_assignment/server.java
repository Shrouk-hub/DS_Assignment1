package ds_assignment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args)
    {
        try
        {
           
            ServerSocket sev = new ServerSocket(5000);
            System.out.println("Server is ready");
            
            while (true)
            {
               
                Socket v = sev.accept();
                System.out.println("Client is ready");
                DataInputStream IS = new DataInputStream(v.getInputStream());
                DataOutputStream OS = new DataOutputStream(v.getOutputStream());
            
            
                OS.writeUTF("Enter your location:");
                OS.flush();
                String s1 = IS.readUTF();
                OS.writeUTF("Enter your destination:");
                OS.flush();
                String s2 = IS.readUTF();
                OS.writeUTF("the best way is the main");
                OS.flush();
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
