package com.t3h.demofile.chuabaitaparray;

import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 15/03/2017.
 */
public class ChuaBaiFile {
    private List<ItemRss> itemRsses;
    private String pathFile;

    public ChuaBaiFile() {
        pathFile = getClass().getResource("/file/rss.txt").getPath();
        pathFile = pathFile.replaceAll("%20", " ");
        itemRsses = new ArrayList<>();
    }

    public void readFile() {
        try {
            File file = new File(pathFile);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
            BufferedReader rd = new BufferedReader(inputStreamReader);
            while (rd.readLine() != null) {
//            rd.readLine();
                String noiDungTienDe = rd.readLine();
                String tieuDe;
                if (noiDungTienDe.equals("<title>")) {
                    tieuDe = rd.readLine();
                    rd.readLine();
                } else {
                    int vitriCuoiTieuDe = noiDungTienDe.lastIndexOf("</");
                    tieuDe = noiDungTienDe.substring(7, vitriCuoiTieuDe);
                }

                rd.readLine();
                rd.readLine();
                String mieuTa = rd.readLine();
                mieuTa = mieuTa.substring(0, mieuTa.indexOf("<br"));
                rd.readLine();
                rd.readLine();
                rd.readLine();
                String link = rd.readLine();
                rd.readLine();
                String date = rd.readLine();
                date = date.substring(9, date.lastIndexOf("</pubDate>"));
                rd.readLine();
                String linkImage = rd.readLine();
                rd.readLine();
                rd.readLine();

                ItemRss itemRss = new ItemRss(tieuDe, mieuTa, date, link, linkImage);
                itemRss.inTT();
                System.out.println("===================================");

            }

            rd.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
