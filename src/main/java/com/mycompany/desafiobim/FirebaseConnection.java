/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafiobim;

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
                        new FileInputStream("firebase-key.json");

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