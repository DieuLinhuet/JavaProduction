package com.t3h.demofile;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by dieulinh on 6/24/17.
 */
public class DemoTextFile {

    public static boolean saveFile(ArrayList<Account> accounts, String path){

        try {
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            for (Account acount : accounts) {
                String line = acount.getUsername() + ";" + acount.getPassword();
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            osw.close();
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
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null){
                String[] arr = line.split(";");
                if (arr.length == 2){
                    Account account = new Account(arr[0], arr[1]);
                    accounts.add(account);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accounts;
    }
}
