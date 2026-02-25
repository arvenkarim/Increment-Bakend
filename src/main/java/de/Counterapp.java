package de;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.HashMap;
import java.util.Map;

public class Counterapp {

    // Zähler – bleibt nur im Speicher (neu starten = wieder 0)
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("🚀 Starte Javalin Counter... (passt perfekt zu deiner HTML!)");

        Javalin app = Javalin.create(config -> {
            //index.html wird automatisch unter http://localhost:8080 geladen
            config.staticFiles.add("public", Location.CLASSPATH);
        });


        // GET /api/counter → gibt aktuelle Zahl zurück
        app.get("/api/counter", ctx -> {
            System.out.println("📡 GET /api/counter → aktuell: " + count);

            Map<String, Integer> response = new HashMap<>();
            response.put("count", count);

            ctx.json(response);
        });

        // POST /api/counter → zählt um 1 hoch (wird von einem Button aufgerufen!)
        app.post("/api/counter", ctx -> {
            count = count + 1;

            System.out.println("🎉 POST /api/counter → neuer Stand: " + count);

            Map<String, Integer> response = new HashMap<>();
            response.put("count", count);

            ctx.json(response);
        });

        // Server starten
        app.start(8080);

        System.out.println("✅ Server läuft!");
        System.out.println("   Öffne jetzt: http://localhost:8080");
        System.out.println("   Dein Button sollte jetzt perfekt zählen!");
    }
}