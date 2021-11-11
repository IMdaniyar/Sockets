package Sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert your name");
        String userName = in.next();
        try
        {
            Socket socket = new Socket("127.0.0.1",1989);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while (true)
            {
                System.out.println("PRESS [1] TO SEND MESSAGE");
                System.out.println("PRESS [2] TO EXIT");
                int choose = in.nextInt();
                switch (choose)
                {
                    case 1:
                        System.out.println("Insert message text:");
                        String textMessage = in.next();
                        MessageData md = new MessageData(userName, textMessage);
                        outputStream.writeObject(md);
                        if((md = (MessageData) inputStream.readObject())!=null){
                            System.out.println(md.getMessageText());
                        }
                    case 2:
                        System.exit(0);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
