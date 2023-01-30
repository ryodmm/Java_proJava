package projava;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer_twr {
    public static void main(String[] args) throws IOException {
        var server = new ServerSocket(1700);
        System.out.println("Waiting...");
        try(Socket soc = server.accept();
            InputStream input = soc.getInputStream())
        {
            System.out.println("connect from" + soc.getInetAddress());
            System.out.println(input.read());
        }
    }
}
