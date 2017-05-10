package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author keven-song.
 * Created on 2017/3/22.
 * @Description
 */
public class SocketClient {

    /**
     * 先启动SocketService，然后在启动此方法，则可完成一次通信
     * @param args
     */
    /*public static void main(String[] args) {
        String message = "client data";
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println(message);
            pw.flush();
            String line = reader.readLine();
            System.out.println("received from server:" + line);
            pw.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
