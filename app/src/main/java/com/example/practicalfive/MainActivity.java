package com.example.practicalfive;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= 30) {
            android.view.View content = findViewById(android.R.id.content);
            content.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() {
                @Override
                public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets insets) {
                    android.graphics.Insets padding = insets.getInsets(android.view.WindowInsets.Type.systemBars() | android.view.WindowInsets.Type.ime());
                    view.setPadding(padding.left, padding.top, padding.right, padding.bottom);
                    return android.view.WindowInsets.CONSUMED;
                }
            });
        }
    }
}
