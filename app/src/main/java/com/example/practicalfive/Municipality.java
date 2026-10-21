package com.example.practicalfive;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.ColorStateList;
import android.widget.Button;
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
        int color;
        int textColor = getColor(R.color.color_text_light);

        if (name.equals("Beijing")) {
            index = 0;
            image = R.drawable.beijing;
            color = getColor(R.color.municipality_beijing);
        } else if (name.equals("Shanghai")) {
            index = 1;
            image = R.drawable.shanghai;
            color = getColor(R.color.municipality_shanghai);
        } else if (name.equals("Chongqing")) {
            index = 2;
            image = R.drawable.chongqing;
            color = getColor(R.color.municipality_chongqing);
            textColor = getColor(R.color.color_text_dark);
        } else {
            index = 3;
            image = R.drawable.tianjin;
            color = getColor(R.color.municipality_tianjin);
        }

        cityImage.setImageResource(image);
        cityImage.setContentDescription(name);
        informationText.setText(information[index]);

        Button visitSite = findViewById(R.id.visit_site_button);
        nameText.setBackgroundColor(color);
        nameText.setTextColor(textColor);
        informationText.setTextColor(color);
        visitSite.setBackgroundTintList(ColorStateList.valueOf(color));
        visitSite.setTextColor(textColor);
    }
}
