package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.OutputStream;

public class PostHandler implements HttpHandler {
    final int port;

    public PostHandler(int p_port) {port = p_port;}

    public boolean CorrectSchema(String p_schema){
        String True_schema = "{\n\"$schema\": \"http://json-schema.org/schema#\",\n\"type\": \"object\",\n\"properties\": {\n\"id\": {\n\"type\": \"string\"\n},\n\"url\": {\n\"type\": \"string\"\n},\n\"message\": {\n\"type\": \"string\"\n}\n},\n\"required\": [\n\"id\",\n\"url\",\n \"message\"\n]\n}";
        JSONTokener Tschema = new JSONTokener(True_schema);
        JSONObject Oschema = new JSONObject(Tschema);
        JSONTokener TTest = new JSONTokener(p_schema);
        JSONObject OTest = new JSONObject(TTest);
        Schema Validator = SchemaLoader.load(Oschema);
        try {
            Validator.validate(OTest);
            return true;
        }catch (ValidationException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if(exchange.getRequestMethod().equals("POST")) {
            String reponse = "{ \"id\":\"0\", \"url\":\"http://localhost:" + port + "\", \"message\":\"May the best code win\"}";
            if (CorrectSchema(reponse)) {
                exchange.sendResponseHeaders(202, reponse.length());
            } else {
                exchange.sendResponseHeaders(400, reponse.length());
            }
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(reponse.getBytes());
            }
            System.out.println("QUE LE JEU COMMENCE !!!");
        }
    }
}
