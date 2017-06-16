package com.t3h.demofile;

import java.io.File;

/**
 * Created by ducnd on 13/03/2017.
 */
public class ExternalManager {
    private String rootPath;

    public ExternalManager(String rootPath) {
        this.rootPath = rootPath;
    }

    //get info file

    public void getInfoFile() {
        File file = new File(rootPath);
        //kiem tra duong dan file co ton tai khong
        boolean isExist = file.exists();
        if (isExist) {
            System.out.println("file da ton tai");
        } else {
            System.out.println("file khong ton tai");
        }
        //kiem tra file co phai la file hay folder khong
        boolean isDirectory = file.isDirectory();
        if (isDirectory) {
            System.out.println("la duong dan");
        } else {
            System.out.println("la file");
        }

        //lay duong dan cua file
        String pathFile = file.getPath();
        System.out.println("pathFiel: " + pathFile);
        //lay file cha
        File parentFile = file.getParentFile();
        //neu la file thi lay tat ca cac fil trong folder
//        if ( file.isDirectory() ) {
//            File[] files = file.listFiles();
//            for ( int i = 0; i < files.length; i++ ) {
//                System.out.println("child file: " + files[i].getPath());
//            }
//        }
        printChildFolder(file);

    }

    public void printChildFolder(File file) {
        if (file.isFile()) {
            System.out.println("path: " + file.getPath());
            return;
        }

        File[] files = file.listFiles();
        if (null == files) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            printChildFolder(files[i]);
        }
    }

    public boolean changeFile(String pathRoot, String pathChange) {
        File fileRoot = new File(pathRoot);
        if (!fileRoot.exists()) {
            return false;
        }

        File fileChange = new File(pathChange);
        if (fileChange.exists()) {
            return false;
        }
        fileRoot.renameTo(fileChange);
        return true;

    }
}
