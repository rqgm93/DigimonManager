package com.raquel.garvi.digimonmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DigimonAdapter adapter;
    private ArrayList<Digimon> digimonList;
    private ImageButton imageNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewDigimon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        digimonList = new ArrayList<>();
        // Agregar algunos Digimon de ejemplo
        digimonList.add(new Digimon("Agumon", "Reptil", "Infantil"));
        digimonList.add(new Digimon("Gatomon", "Bestia Sagrada", "Adulto"));

        adapter = new DigimonAdapter(digimonList);
        recyclerView.setAdapter(adapter);

        // Al hacer clic en un botón, abre la actividad para agregar Digimon
        findViewById(R.id.add_digimon).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddDigimonActivity.class);
            startActivity(intent);
        });

        imageNotification = findViewById(R.id.buttonNotification);

        imageNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });

    }

    private void notification() {
        Intent intent_notification = new Intent(this, NotificationActivity.class);
        startActivity(intent_notification);
    }
}