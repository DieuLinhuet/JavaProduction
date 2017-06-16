package com.t3h.demofile.chuabaitaparray;

/**
 * Created by ducnd on 15/03/2017.
 */
public class ItemRss {
    private String tieuDe;
    private String mieuTa;
    private String date;
    private String link;
    private String linkImage;

    public ItemRss(String tieuDe, String mieuTa, String date, String link, String linkImage) {
        this.tieuDe = tieuDe;
        this.mieuTa = mieuTa;
        this.date = date;
        this.link = link;
        this.linkImage = linkImage;
    }

    public void inTT(){
        System.out.println("tieuDe: " + tieuDe);
        System.out.println("mieuTa: " + mieuTa);
        System.out.println("date: " + date);
        System.out.println("link: " + link);
        System.out.println("linkImage: " + linkImage);
    }
}
