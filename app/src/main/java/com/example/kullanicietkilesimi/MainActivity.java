package com.example.kullanicietkilesimi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kullanicietkilesimi.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonToast.setOnClickListener(view -> {
            // eski bir yapı fazla kullanılmıyor artık
            Toast.makeText(MainActivity.this, "merhaba", Toast.LENGTH_SHORT).show();

        });
        binding.buttonSnackbar.setOnClickListener(view -> {
            Snackbar.make(view, "Silme istiyor musunuz ?", Snackbar.LENGTH_SHORT)
                    .setAction("Evet", view1 -> {
                        Snackbar.make(view, "Silindi", Snackbar.LENGTH_SHORT)
                                .setBackgroundTint(Color.WHITE)
                                .setTextColor(Color.RED)

                                .show();


                    })
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.RED)//"Silme istiyor musunuz ? kırmızı
                    .setActionTextColor(Color.BLUE)// evet yazısı mavi
                    .show();

        });
        binding.buttonDialog.setOnClickListener(view -> {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Başlık")
                    .setMessage("Mesaj")
                    .setPositiveButton("tamam", (d, i) -> {
                        Toast.makeText(this, "Tamam seçildi", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("İptal", (d, i) -> {
                        Toast.makeText(this, "İptal Seçildi", Toast.LENGTH_SHORT).show();
                    })
                    .show();
        });
    }
}