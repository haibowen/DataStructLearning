package com.example.myapplication;

public class Test {

    public static void main(String[] args) {

        int result = (((0xF0FF & 0x000F) | 0x00F0) << 1) / (4 >> 1);
        System.out.println(result + "这是输出");
        String a = intersect("abcde", "dbcdqrrt");
        System.out.println(a);
        System.out.println("测试");

    }

    public static String intersect(String s1, String s2) {
        String max = "", min = "";
        //区分哪个长哪个短
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;
        for (int x = 0; x < min.length(); x++) {
//            for (int y = 0,z =min.length()-x;z!=min.length()+1 ;y++, z++) {
//                String temp=
//            }
            for (int y = 1; y < min.length(); y++) {
                String temp = min.substring(x, y);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return "";
    }
}
