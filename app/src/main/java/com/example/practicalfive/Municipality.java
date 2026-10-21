package com.example.practicalfive;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
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

        ImageView cityImage = findViewById(R.id.municipality_image);
        TextView informationText = findViewById(R.id.municipality_information);
        String[] information = getResources().getStringArray(R.array.municipalities_array);
        int index;
        int image;

        if (name.equals("Beijing")) {
            index = 0;
            image = R.drawable.beijing;
        } else if (name.equals("Shanghai")) {
            index = 1;
            image = R.drawable.shanghai;
        } else if (name.equals("Chongqing")) {
            index = 2;
            image = R.drawable.chongqing;
        } else {
            index = 3;
            image = R.drawable.tianjin;
        }

        cityImage.setImageResource(image);
        cityImage.setContentDescription(name);
        informationText.setText(information[index]);
    }
}
