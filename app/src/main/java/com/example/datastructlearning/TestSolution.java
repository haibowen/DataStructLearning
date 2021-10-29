package com.example.datastructlearning;

public class TestSolution {

    public static void main(String[] args) {
        int result = (((0xF0FF & 0x000F) | 0x00F0) << 1) / (4 >> 1);
        System.out.println(result + "");
    }


    /**
     * 2、写一个函数，输入两个字符串，输出这两个字符串的字符的交集。例如，当s1 = "magazine", s2 = "validate"时，函数返回"aie"
     * String intersect(String s1, String s2)
     * （请在 IDE中完成）
     */

    public String intersect(String s1, String s2) {
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

    /**
     * 写出两种单例
     */
    //第一种
    private static TestSolution testSolution = new TestSolution();

    private TestSolution() {

    }

    public static TestSolution getInstance() {
        return testSolution;
    }

    //第二种
    private static volatile TestSolution testSolutionInstance;

    public static TestSolution getTestSolutionInstance() {
        if (testSolution == null) {
            synchronized (TestSolution.class) {
                testSolution = new TestSolution();
            }
        }
        return testSolutionInstance;
    }

    /**
     * 一个二分查找
     */
    public int BinarySearch(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (array[mid] < key) {
                first = mid + 1;
            } else if (array[mid] == key) {
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            return -1;
        }
        return mid;
    }
    /**
     * 5、给定 a、b 两个文件，各存放 50 亿个互不相同的URL，每个 URL 各占 64B，内存限制是 4G。请找出 a、b 两个文件共同的 URL。
     * （给出思路即可）
     */


    /**
     * singleNumber
     */


}
