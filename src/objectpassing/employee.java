package objectpassing;


import java.io.Serializable;
import java.util.Scanner;


public class employee implements Serializable {
    
    private int emplno;
    private String emplname;
   
    employee()
    {
        emplno = 0;
        emplname = "NULL";
    }
    
    employee(int empno,String empn)
    {
        emplno = empno;
        emplname = empn;
    }
    
    public int getemplno()
    {
        return emplno;
    }
    
    public String getemplname()
    {
        return emplname;
    }
    
    public void setemplno(int no)
    {
        emplno = no;
    }
    
    public void setemplname(String name)
    {
        emplname = name;
    }
}
