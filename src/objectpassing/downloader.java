package objectpassing;

import java.io.IOException;

public class downloader extends Thread {
    
    static String url;
    int uno;
    int s;
    int e;
    
    downloader(String u,int s,int e,int uno)      //  for server
    {
        this.url = u;
        this.s = s;
        this.e = e;
        this.uno = uno;
        System.out.println(" :: " + url + " :: ");
    }
    
    downloader(int s,int e,int uno)         //  for client
    {
        this.s = s;
        this.e = e;
        this.uno = uno;
    }
    downloader()
    {
        
    }
    
    public static void seturl(String u)
    {
        url = u;
    }

    public void run()
    {
  // url = "http://7-zip.org/a/7z1604-x64.exe";
        mainserver ms = new mainserver();
        url = ms.geturl();
    
        System.out.println("URL : " + this.url + " :: from Downloader Class");
        String saveDir = "D:/AI/" + uno;
        uno++;
        int len = 0;
        try {
         //   HttpDownloadUtility.seturl(url);
           len = HttpDownloadUtility.filelength(this.url,s,e);
         
        } catch (IOException ex) {
            System.out.println("Getting Size Error");
        }
        System.out.println("File Size GOT");
        int i,max=4;                                    // + 1 connections will be made, max means no. of threads
        int parts = len/max;
        int  start = s,end = 0;
        for( i=1;i<=max;i++)
        {
            start = s + parts*(i-1);
            end = start + parts - 1;
		try {
             //       HttpDownloadUtility d1;
		//	HttpDownloadUtility.downloadFile(fileURL, saveDir);
             
         HttpDownloadUtility r = new HttpDownloadUtility(start,end,url,saveDir,i);
     
       r.start();
        System.out.println("Thread " + i + " Started");
                
		} catch (Exception ex) {
			System.out.println("Inter Error");
		}
                
        }
        
        if(end < e)
        {
        start = end + 1;
        end = e;
      HttpDownloadUtility rr = new HttpDownloadUtility(start,end,url,saveDir,i);
      rr.start();
        }
        
    }
    
    int getfilesize(String u) throws IOException
    {
        HttpDownloadUtility http = new HttpDownloadUtility();
       int size = http.filelengthfull(u);
       return size;
    }
    
}
