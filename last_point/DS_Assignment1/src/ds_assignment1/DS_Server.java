
package ds_assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class ClientHandler implements Runnable
{

    Socket v;
    public ClientHandler(Socket v)
    {
        this.v = v;
    }

    @Override
    public void run()
    {
        try
        {
            DataInputStream IS = new DataInputStream(v.getInputStream());
            DataOutputStream OS = new DataOutputStream(v.getOutputStream());
            OS.writeUTF("Enter your location:");
            OS.flush();
            OS.writeUTF("Enter your destination:");
            OS.flush();
            OS.writeUTF("the best way is the main");
            OS.flush();
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

public class DS_Server {
    
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
                ClientHandler l = new ClientHandler(v);
                Thread r = new Thread(l);
                r.start();
            }

        } catch (IOException IO)
        {
            System.out.println("IOException"+IO.getMessage());
        }
    }
}
