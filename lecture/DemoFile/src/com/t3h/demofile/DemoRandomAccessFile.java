package com.t3h.demofile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by ducnd on 13/03/2017.
 */
public class DemoRandomAccessFile {
    private String pathFile;

    public DemoRandomAccessFile(String pathFile) {
        this.pathFile = pathFile;
        char a = 'a';
        int b = a;
    }

    public void saveUsername(String usernamen, String password) {
        try {
            RandomAccessFile rd = new RandomAccessFile(pathFile, "rw");
            //ghi tung dong
            rd.seek(rd.length());
            String contentUsernamen = "username:" + usernamen + "\r\n";
            rd.writeBytes(contentUsernamen);
            String contentPassword = "password:" + password + "\r\n";
            rd.writeBytes(contentPassword);
            rd.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Account readAccount(){
        try {
            RandomAccessFile rd = new RandomAccessFile(pathFile, "r");
            String lineUser = rd.readLine();
            String sub[] = lineUser.split("\\:");
            String username = sub[1];
            String linePassword = rd.readLine();
            String password = linePassword.split("\\:")[1];

            Account account = new Account(username, password);

            return account;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
