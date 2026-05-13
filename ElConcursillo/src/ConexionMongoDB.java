import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConexionMongoDB {

    private static MongoClient client;
    private static MongoDatabase database;

    public static MongoDatabase conectar() {
        if (client == null) {
            String connectionString = "mongodb+srv://daniclosy:millonario2026@proyecto.wepnsln.mongodb.net/";
            client = MongoClients.create(connectionString);
            database = client.getDatabase("Concurso");
        }
        return database;
    }

    public static MongoCollection<Document> getColeccion(String nombreColeccion) {
        return conectar().getCollection(nombreColeccion);
    }
}