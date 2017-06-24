package com.t3h.demofile;

import com.t3h.demofile.chuabaitaparray.ArrayIntManager;
import com.t3h.demofile.chuabaitaparray.ChuaBaiFile;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ducnd on 13/03/2017.
 */
public class Main {

    public static void testFile(){
        ArrayList<Account> accounts = new ArrayList<>();

        accounts.add(new Account("NVA", "111"));
        accounts.add(new Account("NVB", "222"));
        accounts.add(new Account("NVC", "123"));
        accounts.add(new Account("NVD", "331"));
        accounts.add(new Account("NVE", "132"));
        accounts.add(new Account("NVF", "444"));

        boolean check = SerializeDemoFile.saveFile(accounts,"/home/dieulinh/testFile.txt");

        if (check){
            System.out.println("Save successed!");
        }else {
            System.out.println("File is not saved!");
        }
    }

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

//        ChuaBaiFile baiFile = new ChuaBaiFile();
//        baiFile.readFile();
        //////////////////////////////////////////////////////////

        //Test SerializeDemoFile
        //testFile();

        ArrayList<Account> accounts = SerializeDemoFile.readFile("/home/dieulinh/testFile.txt");

        System.out.println("A list accounts:");
        System.out.println("Username\tPassword");
        for (Account account: accounts){
            System.out.println(account);
        }

    }


}
