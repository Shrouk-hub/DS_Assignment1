package ds_assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Clienthandler implements Runnable
{

    Socket v;
    Socket s;
    public Clienthandler(Socket v,Socket s)
    {
        this.v = v;
        this.s=s;
    }

    @Override
    public void run()
    {
        try
        {
            DataInputStream IS = new DataInputStream(v.getInputStream());
            DataOutputStream OS = new DataOutputStream(v.getOutputStream());
            
            DataInputStream ISS = new DataInputStream(s.getInputStream());
            DataOutputStream OSS = new DataOutputStream(s.getOutputStream());
            
            while (true)
            {
                
                   
                  String sm = ISS.readUTF(); 
                  System.out.println(sm);
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
        catch(Exception error)
        {
            System.out.println("Exception:"+error.getMessage());
        }
    }

}

public class DS_client {
 
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
                Clienthandler l = new Clienthandler(v,s);
                Thread r = new Thread(l);
                r.start();
            }

        } catch (IOException IO)
        {
            System.out.println("IOException"+IO.getMessage());
        }
    }
}
