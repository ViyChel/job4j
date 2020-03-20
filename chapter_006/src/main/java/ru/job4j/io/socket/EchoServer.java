package ru.job4j.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.startsWith("GET") && str.contains("msg=Hello")) {
                            out.write("Hello\r\n".getBytes());
                            break;
                        } else if (str.startsWith("GET") && str.contains("msg=Exit")) {
                            return;
                        }
                        String answer = str.substring(str.lastIndexOf("=") + 1, str.indexOf(" HTTP")) + "\r\n";
                        out.write(answer.getBytes());
                        break;
                    }
                }
            }
        }
    }
}
