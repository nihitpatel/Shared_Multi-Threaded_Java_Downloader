/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectpassing;

import java.io.Serializable;

public class data implements Serializable{
    
    int start;
    int end;
    int uno;
    
    data()
    {
        start = end = uno = 0;
    }

    data(int s, int e,int u) {
      start = s;
      end = e;
      uno = u;
    }
    
    int getstart()
    {
        return start;
    }
    
    int getend()
    {
        return end;
    }
    
    int getuno()
    {
        return uno;
    }
    
    void setstart(int s)
    {
        start = s;
    }
    
    void setend(int e)
    {
        end = e;
    }
    
    void setuno(int n)
    {
        uno = n;
    }
}
