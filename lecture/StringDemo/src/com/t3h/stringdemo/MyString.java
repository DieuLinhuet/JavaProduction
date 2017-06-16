package com.t3h.stringdemo;

public class MyString {
    private String value;

    public MyString() {
        StringBuilder s = new StringBuilder("hello");
        s.deleteCharAt(0); // s = "ello"
        s.delete(0, 1); // s = "llo"
        s.append("abc");  // s = "lloabc
        s.insert(2, "a"); // s = "llaoabc"
        s.reverse(); // Đảo ngược chuỗi s = "cbaoall"
        s.setCharAt(0, '3'); // s = 3baoall
    }

    public void enterValue(String value) {
        this.value = value;
    }

    public int tinhTongCacSoCoTrongChuoi() {
        String number = "0";
        int tong = 0;

        for (int i = 0; i < value.length(); i++) {
            char k = value.charAt(i);
            if ('0' <= k && k <= '9') {
                number += k;
            } else {
                tong += Integer.parseInt(number);
                number = "0";
            }
            tong += Integer.parseInt(number);
        }
        return tong;
    }


    public int tinhTongMaAscii() {
        int tong = 0;
        for (int i = 0; i < value.length(); i++) {
            tong += value.codePointAt(i);
        }
        return tong;
    }

    public char timkyTuMaAsciiLonNhat() {
        char max = value.charAt(0);
        for (int i = 1; i < value.length(); i++) {
            if (value.charAt(i) > max) {
                max = value.charAt(i);
            }
        }
        return max;
    }

    public boolean kiemTraMatKhauManh() {
        boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (int i = 0; i < value.length(); i++) {
            char k = value.charAt(i);
            if ('0' <= k && k <= '9') {
                hasNumber = true;
            }
            if ('a' <= k && k <= 'z') {
                hasLowerCase = true;
            }
            if ('A' <= k && k <= 'Z') {
                hasUpperCase = true;
            }
        }
        return hasNumber && hasLowerCase && hasUpperCase;
    }

    // 0  48
    // 1  49
    // ...
    // 9  57
    public int tongCacSo() {
        int tong = 0;
        for (int i = 0; i < value.length(); i++) {
            if ('0' <= value.charAt(i) && value.charAt(i) <= '9') {
                tong += value.charAt(i) - 48;
            }
        }
        return tong;
    }

    // http://abc.com/picture/anh-thien-nhien.jpg
    public String layTenAnhTuLink() {
        int viTriDauGachCuoiCung
                = value.lastIndexOf("/");
        String tenAnh = value.substring(viTriDauGachCuoiCung + 1);
        return tenAnh;
    }

}