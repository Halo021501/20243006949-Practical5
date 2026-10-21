package com.example.practicalfive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText municipalityInput;

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

        municipalityInput = findViewById(R.id.municipality_input);
        municipalityInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                        openMunicipality();
                    }
                    return true;
                }
                if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                    openMunicipality();
                    return true;
                }
                return false;
            }
        });
    }

    private void openMunicipality() {
        TextProcessor processor = new TextProcessor();
        String name = processor.processMunicipality(municipalityInput.getText().toString());

        if (name == null) {
            municipalityInput.setError(getString(R.string.invalid_input));
            return;
        }

        municipalityInput.setError(null);
        Intent intent = new Intent(MainActivity.this, Municipality.class);
        intent.putExtra(Municipality.EXTRA_MUNICIPALITY, name);
        startActivity(intent);
    }
}
