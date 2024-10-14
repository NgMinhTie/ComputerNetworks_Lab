
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class lab1cEx2_client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            InetAddress addr_host = InetAddress.getByName("127.0.0.1");
            String hostname = addr_host.getHostName();

            int port = 1003;
            Socket client_socket = null;
            ObjectOutputStream write = null;
            ObjectInputStream read = null;
            for (int i = 0; i < 5; i++) {
                client_socket = new Socket(hostname, port);

                String inputString = scanner.nextLine();
                write = new ObjectOutputStream(client_socket.getOutputStream());
                write.writeObject(inputString);

                read = new ObjectInputStream(client_socket.getInputStream());
                String message = (String) read.readObject();
                System.out.println(message);
                write.close();
                read.close();
                client_socket.close();
                Thread.sleep(100); //! LUU Y: HOC THEM CACH DUNG THREAD.SLEEP();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/* 
//package com.journaldev.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        for(int i=0; i<5;i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i==4)oos.writeObject("exit");
            else oos.writeObject(""+i);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            //close resources
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
    }
}
*/