package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) {
        try {
            HttpServer new_server = HttpServer.create(new InetSocketAddress(Integer.parseInt(args[0])), 0);
            new_server.setExecutor(Executors.newFixedThreadPool(1));
            new_server.createContext("/ping", new CallHandler());
            new_server.createContext("/api/game/start", new PostHandler(Integer.parseInt(args[0])));
            new_server.createContext("/api/game/fire", new FireHandler());
            new_server.start();
            if (args.length > 1){
                Online online = new Online(Integer.parseInt(args[0]));
                online.POSTRequest(args[1]);
                online.GETrequestfire(args[1],"C1" );
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
}
