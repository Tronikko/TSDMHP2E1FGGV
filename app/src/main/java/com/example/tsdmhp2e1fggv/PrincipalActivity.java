package com.example.tsdmhp2e1fggv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab 1");
        tab1.setIndicator("Azul");
        tab1.setContent(R.id.tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab 2");
        Intent intent = new Intent(this, DatosActivity.class);
        tab2.setIndicator("Rojo");
        tab2.setContent(intent);
        tab2.setContent(R.id.tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Tab 3");
        tab3.setIndicator("Amarillo");
        tab3.setContent(R.id.tab3);

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
}