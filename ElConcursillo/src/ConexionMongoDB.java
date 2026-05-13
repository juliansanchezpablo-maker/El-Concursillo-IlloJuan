import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
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
        	String connectionString = "mongodb+srv://jorgejimenezgarcia1419hola_db_user:millonario2026@proyecto.wepnsln.mongodb.net/Concurso?retryWrites=true&w=majority&appName=PROYECTO";
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .serverApi(serverApi)
                    .build();
            client = MongoClients.create(settings);
            database = client.getDatabase("Concurso");
        }
        return database;
    }

    public static MongoCollection<Document> getColeccion(String nombreColeccion) {
        return conectar().getCollection(nombreColeccion);
    }
}