package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;

public class FireHandler implements HttpHandler {

    public String RefreshBody(HttpExchange exchange){
        JSONObject body = new JSONObject();
        //Mock car manque de temps
        body.put("consequence", "miss");
        body.put("shipLeft", "true");
        return body.toString();
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String body = "";
        if (exchange.getRequestMethod().equals("GET")){
            String position = exchange.getRequestURI().getQuery();
            String cell = position.split("=")[1];
            String x = cell.substring(0,1);
            String y = cell.substring(1);
            body = RefreshBody(exchange);
            exchange.sendResponseHeaders(202, body.length());
        }
        else{
            exchange.sendResponseHeaders(400,1);
        }
        try (OutputStream os = exchange.getResponseBody()){
            os.write(body.getBytes());
        }
    }
}
