import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;

public class FirebaseConnection {

    private static Firestore db;

    public static Firestore conecta() {

        try {

            if (FirebaseApp.getApps().isEmpty()) {

                FileInputStream serviceAccount =
                        new FileInputStream("");

                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
            }

            db = FirestoreClient.getFirestore();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return db;
    }
}