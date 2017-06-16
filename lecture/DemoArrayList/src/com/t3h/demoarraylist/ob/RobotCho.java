package com.t3h.demoarraylist.ob;

/**
 * Created by ducnd on 08/03/2017.
 */
public class RobotCho implements Pet {
    private String chatLieu;

    public RobotCho(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    @Override
    public void choi() {

    }

    public void inTT(){
        System.out.println("chat lieu: " + chatLieu);
        System.out.println("hanh vi: ");
        choi();
    }
}
