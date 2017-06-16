package com.t3h.demofile;

import com.t3h.demofile.chuabaitaparray.ArrayIntManager;
import com.t3h.demofile.chuabaitaparray.ChuaBaiFile;

import java.io.File;

/**
 * Created by ducnd on 13/03/2017.
 */
public class Main {

    public static void main(String[] args) {
//        String linkFileServer = "http://s1mp3.hot1.cache31.vcdn.vn/58408f9374d79d89c4c6/5263915882515440837?key=YNYrtYfB32UUO08HeDX5VQ&expires=1489428140&filename=Lac-Troi-Son-Tung-M-TP.mp3";
//
//        DownloadManager manager = new DownloadManager(linkFileServer);
//        manager.download();


//        ExternalManager manager = new ExternalManager("/home/ducnd/Desktop");
////        manager.getInfoFile();
//        long current = System.currentTimeMillis();
//        manager.changeFile("/home/ducnd/Downloads/lactroi.mp3",
//                "/media/ducnd/Study/lactroi.mp3");
//        System.out.println("detal: " + (System.currentTimeMillis() - current) + "");
//
//        DemoRandomAccessFile accessFile =
//                new DemoRandomAccessFile("/home/ducnd/Downloads/account.txt");
//        accessFile.saveUsername("hello", "23");

//        Account account = accessFile.readAccount();
//        if ( null != account ) {
//            System.out.println("username: " + account.getUsername());
//            System.out.println("password: " + account.getPassword());
//        }


//        ArrayIntManager intManager = new ArrayIntManager();
//        intManager.inDayConLienTiep();

        ChuaBaiFile baiFile = new ChuaBaiFile();
        baiFile.readFile();
    }


}
