package com.t3h.demofile;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by dieulinh on 6/24/17.
 */
public class SerializeDemoFile {

    public static boolean saveFile(ArrayList<Account> accounts, String path){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);
            oos.close();
            fos.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static ArrayList<Account> readFile(String path){
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            accounts = (ArrayList<Account>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return accounts;
    }
}
