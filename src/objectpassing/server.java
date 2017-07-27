
package objectpassing;

import java.io.*;
import java.net.*;

public class server {

    static employee e = null;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ServerSocket serversocket = new ServerSocket(1234);
        Socket conn = serversocket.accept();
        
        ObjectOutputStream oos = new ObjectOutputStream(conn.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
        
        e = (employee) ois.readObject();
        
        e.setemplno(102);
        e.setemplname("Yash");
        
        oos.writeObject(e);
        
        ois.close();
        oos.close();
    }
    
}
