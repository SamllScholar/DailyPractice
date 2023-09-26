package com.smallscholar.demo;

import java.io.*;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/9/5 20:41
 * @describe ...
 */
public class Demo {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        Scanner sc = null;
        int count = 0;
        try {
            sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);
            fileInputStream = new FileInputStream(new File("src\\com\\smallscholar\\demo\\test.txt"));
            int len;
            while ((len = fileInputStream.read()) != -1) {
                count += (char) len == ch ? 1 : 0;
            }
            System.out.println(count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (sc != null) {
                sc.close();
            }
        }

    }

}
