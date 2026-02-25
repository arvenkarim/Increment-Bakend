# Counter App

Einfache Zähl-App mit Javalin (Java)

Was macht das Ding?
- Startet eine Webseite
- Zeigt eine Zahl (fängt bei 0 an)
- Button "Increment" macht +1

Wie starten?
1. `mvn clean package`  (oder einfach in IntelliJ starten)
2. `java -jar target/counter-backend-v1-1.0-SNAPSHOT.jar`  
   oder direkt CounterApp.java ausführen
3. Browser aufmachen: http://localhost:8080

Dateien:
- src/main/resources/public/index.html  → die Seite
- src/main/java/de/counter/CounterApp.java  → das Backend

Fertig. Viel Spaß beim Rumklicken 😄