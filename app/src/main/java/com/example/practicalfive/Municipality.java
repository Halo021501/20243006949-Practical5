package com.example.practicalfive;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Municipality extends Activity {
    public static final String EXTRA_MUNICIPALITY = "municipality";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        TextProcessor processor = new TextProcessor();
        String name = processor.processMunicipality(getIntent().getStringExtra(EXTRA_MUNICIPALITY));
        if (name == null) {
            Toast.makeText(this, R.string.invalid_municipality, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        TextView nameText = findViewById(R.id.municipality_name);
        nameText.setText(name);
    }
}
