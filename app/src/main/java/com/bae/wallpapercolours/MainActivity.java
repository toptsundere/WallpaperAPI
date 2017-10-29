package com.bae.wallpapercolours;

import android.app.AlertDialog;
import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get an instance of the wallpaper manager first
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();

        //display the wallpaper
        ImageView wallpaperView = findViewById(R.id.wallpaperView);
        wallpaperView.setImageDrawable(wallpaperDrawable);

        //create a wallpaper colors object
        WallpaperColors wallpaperColors = WallpaperColors.fromDrawable(wallpaperDrawable);


        /** PRIMARY COLOUR*/
        //retrieve the colors
        Color primaryColor = wallpaperColors.getPrimaryColor();
        final String hexColorPrimary = String.format("#%06X", (0xFFFFFF & primaryColor.toArgb()));

        //set the text with the primary colours
        TextView pcTextView = findViewById(R.id.primaryColourText);
        pcTextView.setText(hexColorPrimary);

        ImageView pcCircleIcon = findViewById(R.id.circlePrimary);
        pcCircleIcon.setColorFilter(Color.parseColor(hexColorPrimary));

        /** SECONDARY COLOUR */
        Color secondaryColor = wallpaperColors.getSecondaryColor();
        final String hexColorSecondary = String.format("#%06X", (0xFFFFFF & secondaryColor.toArgb()));

        TextView scTextView = findViewById(R.id.secondaryColourText);
        scTextView.setText(hexColorSecondary);

        ImageView scCircleIcon = findViewById(R.id.circleSecondary);
        scCircleIcon.setColorFilter(Color.parseColor(hexColorSecondary));

        /** TERTIARY COLOUR*/
        Color tertiaryColor = wallpaperColors.getTertiaryColor();
        final String hexColorTertiary = String.format("#%06X", (0xFFFFFF & tertiaryColor.toArgb()));

        TextView tcTextView = findViewById(R.id.teritaryColourText);
        tcTextView.setText(hexColorTertiary);

        ImageView tcCircleIcon = findViewById(R.id.circleTeritary);
        tcCircleIcon.setColorFilter(Color.parseColor(hexColorTertiary));


        /** COPY BUTTONS **/
        ImageView copyPrimary = findViewById(R.id.copyPrimary);
        ImageView copySecondary = findViewById(R.id.copySecondary);
        ImageView copyTertiary = findViewById(R.id.copyTertiary);

        copyPrimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(hexColorPrimary, hexColorPrimary);
                clipboard.setPrimaryClip(clip);
            }
        });

        copySecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(hexColorSecondary, hexColorSecondary);
                clipboard.setPrimaryClip(clip);
            }
        });

        copyTertiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText(hexColorTertiary, hexColorTertiary);
                clipboard.setPrimaryClip(clip);
            }
        });
    }

}


