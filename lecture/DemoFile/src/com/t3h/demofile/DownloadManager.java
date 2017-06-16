package com.t3h.demofile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * Created by ducnd on 13/03/2017.
 */
public class DownloadManager {
    private String link;

    public DownloadManager(String link) {
        this.link = link;
    }

    public void download() {

        try {
            URL url = new URL(link);

            URLConnection conn = url.openConnection();


            int lengthFile = conn.getContentLength();

            System.out.println("lengthFile: " + lengthFile);

            InputStream in = conn.getInputStream();

            byte[] b = new byte[1024];

            //par1: array chua noi dung doc
            //par2 vi tri bat dau ghi vao
            //par3: so luong byte mong nuon doc
            //ket qua tra ve la int ( so luong byte doc duoc <= so luong byte mong nuon doc
//            int leRead = in.read(b, 0, 1024);
//            System.out.println("leRead: " + leRead);
//            System.out.println("content: " + Arrays.toString(b));

            int leRead = in.read(b, 0, 1024);
//            System.out.println("leRead: " + leRead);
//            System.out.println("content: " + Arrays.toString(b));

            int positionPointLast = link.lastIndexOf('.');
            String tailFile = link.substring(positionPointLast, link.length());
            File file = new File("lactroi" + tailFile);
            //tao file:
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);

            int totalLenghtDownloaded = 0;
            while (leRead > -1) {
                totalLenghtDownloaded +=leRead;
                System.out.println("phan tram: " + totalLenghtDownloaded*100/lengthFile);
                //phan tram da down duoc
                out.write(b, 0, leRead);
                leRead = in.read(b, 0, 1024);


            }
            out.close();

            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
