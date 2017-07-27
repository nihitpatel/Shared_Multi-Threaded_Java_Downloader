package objectpassing;
import java.io.*;
import java.net.*;
import java.util.*;


public class client{

    static employee e1 = new employee(101,"Nihit");
    static employee e2 = new employee();
   
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        System.out.println("Employee No. : " + e1.getemplno());
        System.out.println("Employee Name : " + e1.getemplname());
        
        Socket clientsocket = new Socket("127.0.0.1",1234);
        
        ObjectOutputStream oos = new ObjectOutputStream(clientsocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(clientsocket.getInputStream());
 
        oos.writeObject(e1);
        
        e2 = (employee) ois.readObject();
 
        System.out.println("Employee No. : " + e2.getemplno());
        System.out.println("Employee Name : " + e2.getemplname());
        
        oos.close();
        ois.close();
    }
    
    
    
}
