package projava;

import javax.net.SocketFactory;         // }　1や2のクラスを使うために
import javax.net.ssl.SSLSocketFactory;  // }　このimport文が必要となる

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WebClient {
    public static void main(String[] args) throws IOException {
        var domain = "www.google.com";

        SocketFactory factory = SSLSocketFactory.getDefault();  // -- 1
        try (
             Socket soc = factory.createSocket(domain, 443); // -- 2（HTTPSではポート443が標準的に使われる）
             var pw = new PrintWriter(soc.getOutputStream());
             var isr = new InputStreamReader(soc.getInputStream());
             var bur = new BufferedReader(isr)
        )
        {
            pw.println("GET /index.html HTTP/1.1");
            pw.println("Host: " + domain);
            pw.println();
            pw.flush();
            bur.lines()
                    .limit(18)
                    .forEach(System.out::println);
        }
    }
}
