package Sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {

        try{
            ServerSocket server = new ServerSocket(1989);
            Socket socket = server.accept();
            System.out.println("Client connected");

            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            MessageData data = null;
            while((data = (MessageData) inStream.readObject())!=null)
            {
                System.out.println(data);
                MessageData response = null;

                if(data.getMessageText().toLowerCase().equalsIgnoreCase("hello") || data.getMessageText().toLowerCase().equals("hi")){

                    response = new MessageData("Server","Hello!");

                }else if(data.getMessageText().toLowerCase().equalsIgnoreCase("lol")){

                    response = new MessageData("Server","LOOOOL!");
                }
                outputStream.writeObject(response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}