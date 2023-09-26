package com.smallscholar.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class serverThread extends Thread{
    Socket socket;
    public serverThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        InputStream is= null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dis=new DataInputStream(is);
        while (true){
            try {
                System.out.println(dis.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
