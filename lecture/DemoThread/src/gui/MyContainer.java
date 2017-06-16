package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ducnd on 29/03/2017.
 */
public class MyContainer extends JPanel implements ActionListener, Runnable {
    private JTextField tfLink;
    volatile private JProgressBar progressBar;
    private JButton btnStart;

    public MyContainer() {
        setSize(700, 400);
        setLayout(null);
        init();
        addCops();
    }

    private void init() {
        tfLink = new JTextField();
        tfLink.setLocation(100, 30);
        tfLink.setSize(500, 50);
        tfLink.setText("http://s1mp3.hot1.cache31.vcdn.vn/e996a93a417ea820f16f/1673606354144801777?key=7Hh0e12_W7ekUT5GP7BIZg&expires=1490811459&filename=Anh-Da-Quen-Voi-Co-Don-Soobin-Hoang-Son.mp3");

        progressBar = new JProgressBar();
        progressBar.setLocation(100, 100);
        progressBar.setSize(500, 50);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        btnStart = new JButton();
        btnStart.setLocation(200, 200);
        btnStart.setSize(200, 50);
        btnStart.setText("Start");

        btnStart.addActionListener(this);
    }

    private void addCops() {
        add(tfLink);
        add(progressBar);
        add(btnStart);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //.......
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                download();
//            }
//        };

        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public synchronized void run() {
        download();
    }

    private void download() {
        String link = tfLink.getText();
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            int length = conn.getContentLength();
            InputStream in = conn.getInputStream();
            File file = new File("/home/ducnd/Downloads/nhac.mp3");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            byte b[] = new byte[1024];
            int le = in.read(b);
            int totalDownload = le;
            while (le >= 0) {
                int percent = totalDownload * 100 / length;
                System.out.println("persent: " + percent);
                out.write(b, 0, le);
                progressBar.setValue(percent);
                le = in.read(b);
                totalDownload += le;
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
