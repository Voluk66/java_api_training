package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Online {
    final int port;

    public Online(int port) {
        this.port = port;
    }
    public String POSTRequest(String p_enemyurl) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(p_enemyurl + "/api/game/start")).setHeader("Accept","application/json").setHeader("Content-Type","application/json").POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + port + "\", \"message\":\"I will crush you\"}")).build();
        HttpResponse<String> respond = client.send(request, HttpResponse.BodyHandlers.ofString());
        return respond.body();
    }
    public void GETrequestfire(String p_enemyurl, String target_cell) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(p_enemyurl + "/api/game/fire?cell=" + target_cell)).setHeader("Content-Type","application/json").GET().build();
        HttpResponse<String> respond = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(respond.statusCode());
        System.out.println(respond.body());

    }
}
