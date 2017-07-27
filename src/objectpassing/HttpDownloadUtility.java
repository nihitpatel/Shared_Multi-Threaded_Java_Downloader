package objectpassing;
            

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A utility that downloads a file from a URL.
 * @author www.codejava.net
 *
 */
public class HttpDownloadUtility extends Thread{
	private static final int BUFFER_SIZE = 4096;
        int start;
         int end;
        static String url;
         String dir;
         int fname;
         
            public  HttpDownloadUtility(){
//        start = 0;
//        end = 0;
//        url = "";
//        dir = "";
 }
            
        public HttpDownloadUtility(int start2,int end2,String url2,String dir2,int fname){
        start = start2;
        end = end2;
        url = url2;
        dir = dir2;
        this.fname = fname;
        
 }
        
        public static void seturl(String u)
    {
        url = u;
    }

        
        public void run(){
     
         //       filelength(url);
     //    url = "http://7-zip.org/a/7z1604-x64.exe";
        mainserver ms = new mainserver();
        url = ms.geturl();
     
            try {
//                System.out.println("Start : " + this.start + " for " + fname);
//                System.out.println("End : " + this.end + " for " + fname);
      //          System.out.println("URL : " + this.url + " for " + fname);
//                System.out.println("Dir : " + this.dir + " for " + fname);
//                System.out.println("Fname" + this.fname + " for " + fname);
                this.downloadFile(this.url,dir,start,end,fname);
            } catch (IOException ex) {
               System.out.println("Runnable Error");
            }
                         
        }
	/**
	 * Downloads a file from a URL
	 * @param fileURL HTTP URL of the file to be downloaded
	 * @param saveDir path of the directory to save the file
	 * @throws IOException
	 */
	public static void downloadFile(String fileURL, String saveDir,int start,int end,int fname)
			throws IOException {
            int length=0;int down = start ,fd=0; int fn = fname;
            System.out.println("Thread " + fname + " ::: Start = " + start + " end = " + end);
            do{
                fd=0;
            {
		URL url = new URL(fileURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                 httpConn.setRequestProperty("Range", "bytes=" + start + "-" + end );
                 System.out.println("Thread " + fname + " again ::: Start = " + start + " end = " + end);
 //                System.out.println("Start : " + start);
                
	//	int responseCode = httpConn.getResponseCode();
                    


		// always check HTTP response code first
	//	if (responseCode == HttpURLConnection.HTTP_OK) 
        {
			String fileName = "";
			String disposition = httpConn.getHeaderField("Content-Disposition");
			String contentType = httpConn.getContentType();
			
                        int contentLength = httpConn.getContentLength();
                        if(length==0)
                        {
                            length = contentLength;
                        }
			if (disposition != null) {
				// extracts file name from header field
				int index = disposition.indexOf("filename=");
				if (index > 0) {
					fileName = disposition.substring(index + 10,
							disposition.length() - 1);
				}
			} else {
				// extracts file name from URL
				fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,fileURL.length());
                        }
                        String exten = fileURL.substring(fileURL.lastIndexOf(".") );
                   ///////     String fileSaveName = fname + exten ;
                        
                   
                        String fileSaveName = fname + "" ;
                        ////////////////////////////////////
                   
                   
                       // System.out.println("File will be Saved with :: " + fileSaveName + " for " + fname);

              //          String extension = fileName.substring(fileName.lastIndexOf("."));
                //        System.out.println(extension);
/*			System.out.println("Content-Type = " + contentType);
			System.out.println("Content-Disposition = " + disposition);
			System.out.println("Content-Length = " + contentLength);
			System.out.println("fileName = " + fileName);
*/
			// opens input stream from the HTTP connection
			InputStream inputStream = httpConn.getInputStream();
                       
			//////////String saveFilePath = saveDir + File.separator + fileSaveName ;
                        
                        String saveFilePath = fileSaveName ;
                        
                        //////////////////////////////////
		//	i++;
			// opens an output stream to save into file
			FileOutputStream outputStream = new FileOutputStream(saveFilePath,true);

			int bytesRead = 0;
			byte[] buffer = new byte[BUFFER_SIZE];
                      //  bytesRead = inputStream.read(buffer);
                   //   for(int i=0;i<10;i++)
                      {
                    	while ((bytesRead = inputStream.read(buffer)) > -1 ) {
                     //   while(down<=40959){
                    //        bytesRead = inputStream.read(buffer);
				outputStream.write(buffer, 0,bytesRead );
                                down += bytesRead;
                                fd+=bytesRead;
                    //            System.out.println(bytesRead);
                             //   break;
			}
           //            System.out.println(bytesRead);
                       start = down;
                        System.out.println(fd + " by thread " + fname);
                      }
			outputStream.close();
			inputStream.close();

			
		}
        //else 
        {
	//		System.out.println("No file to download. Server replied HTTP code: " + responseCode);
		}
		httpConn.disconnect();
	}
            }while(start<length);
            System.out.println(" Thread " + fname + " Completed Finally.");
}
        
        
        public static int filelength(String url2,int s,int e) throws IOException{
           
            
            URL url = new URL(url2);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                  httpConn.setRequestProperty("Range", "bytes=" + s + "-" +  e);
                 int size = httpConn.getContentLength();
                 httpConn.disconnect();
                 return size;
        }
        
        
      public static int filelengthfull(String url2) throws IOException{
           
            
            URL url = new URL(url2);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        //          httpConn.setRequestProperty("Range", "bytes=" + s + "-" +  e);
                 int size = httpConn.getContentLength();
                 httpConn.disconnect();
                 return size;
        }
        
        
        public static void join2() throws IOException{
   try {
    Process p = Runtime
                    .getRuntime()
                    .exec("cmd /c \"cd / && D: && cd AI && copy /b *.exe new2.exe");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
                
        System.out.println("File Successfully Download");
            
        }
        
}