package com.smallscholar.demo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
   //2. 编写一个测试应用程序，将服务器作为聊天服务器（ip：192.168.1.1，端口：8888），等待来自多个客户端的连接请求，通信应该通过TCP协议来处理连接。
   public static void main(String[] args) throws Exception {
       Socket socket=new Socket("127.0.0.1",8888);
       OutputStream os=socket.getOutputStream();
       DataOutputStream dos=new DataOutputStream(os);
       Scanner sc=new Scanner(System.in);
       while (true){
           System.out.println("请说：");
           String word=sc.nextLine();
           System.out.println(word);
           if("exit".equals(word)){
               System.out.println("欢迎下次光临，退出成功！");
               dos.close();
               socket.close();
               break;
           }
           dos.writeUTF(word);
           dos.close();
       }

       try {
           // 有异常的代码
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
}
