package de;

import java.io.*;
import java.net.*;

public class Counterapp {

    static int count = 0;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8080);

            while (true) {

                Socket socket = server.accept();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                OutputStream out = socket.getOutputStream();

                String firstLine = in.readLine();

                if (firstLine != null) {
                    System.out.println("REQ: " + firstLine);
                }


                String line;
                while ((line = in.readLine()) != null && !line.isEmpty()) {
                }


                if (firstLine != null && firstLine.startsWith("POST") && firstLine.contains("/api/counter")) {
                    count++;
                }
                if (line != null && line.contains("OPTIONS")) {
                    String res =
                            "HTTP/1.1 200 OK\r\n" +
                                    "Access-Control-Allow-Origin: *\r\n" +
                                    "Access-Control-Allow-Methods: GET, POST, OPTIONS\r\n" +
                                    "Access-Control-Allow-Headers: *\r\n\r\n";
                    out.write(res.getBytes());
                    out.flush();
                    socket.close();
                    continue;
                }

                String body = "{\"count\":" + count + "}";

                String response =
                        "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: application/json\r\n" +
                                "Access-Control-Allow-Origin: *\r\n" +
                                "Content-Length: " + body.length() + "\r\n\r\n" +
                                body;

                out.write(response.getBytes());
                out.flush();

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}