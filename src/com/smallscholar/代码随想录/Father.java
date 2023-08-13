package com.smallscholar.代码随想录;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/27 19:31
 * @describe ...
 */
public class Father {

    public static void main(String[] args) {

//        String s1 = new String("ab");
//        System.out.println(s1 == s1.intern());
//        System.out.println("s1: " + System.identityHashCode(s1));
//        System.out.println("s1.intern: " + System.identityHashCode(s1.intern()));
//        System.out.println("=============================================");
        String s3 = new String("a") + new String("b");
        System.out.println(s3 == s3.intern());
        System.out.println("s3: " + System.identityHashCode(s3));
        System.out.println("s3.intern: " + System.identityHashCode(s3.intern()));
        String s2 = "ab";
        System.out.println(s2 == s2.intern());
        System.out.println("s2:" + System.identityHashCode(s2));
        System.out.println("s2.intern:" + System.identityHashCode(s2.intern()));
        System.out.println("=============================================");
//        //
//        String s3 = new String("a") + new String("b");
//        System.out.println(s3 == s3.intern());
//        System.out.println("s3: " + System.identityHashCode(s3));
//        System.out.println("s3.intern: " + System.identityHashCode(s3.intern()));




//        String s2 = new String("a") + new String("b");
//        System.out.println(s2 == s2.intern());
//
//        String s = new String("a") + new String("b");
//        System.out.println(s == s.intern());
//
//        System.out.println(" =========================");
//        test01();

//        String s2 = new String("a") + new String("b");
//        System.out.println(s2 == s2.intern());
//
//        String s1 = new String("ab") + new String("cd");
//        System.out.println(s1 == s1.intern());
//        System.out.println(test01());
//        System.out.println(test02());
//        test03();

//        System.out.println(test01());
//        System.out.println(test02());

//        test04();
    }

    public static void test01() {
        String s = new String("ab");
        System.out.println(s.intern() == s);
        System.out.println("s:" + System.identityHashCode(s));
        System.out.println("s.intern" + System.identityHashCode(s.intern()));
    }

    public static boolean test04() {
        String str = "ab";
        String s1 = "ab";

        System.out.println(s1 == str);
        return false;
    }

    public static boolean test02() {
        String s = "ab";
        return s.intern() == s;
    }

    public static void test03() {
        String s = new String("a") + new String("b");
        System.out.println(s == s.intern());
    }


}
