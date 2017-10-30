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

    String hexColorPrimary;
    String hexColorSecondary;
    String hexColorTertiary;

    ImageView wallpaperView;
    ImageView pcCircleIcon;
    TextView pcTextView;
    TextView scTextView;
    ImageView scCircleIcon;
    TextView tcTextView;
    ImageView tcCircleIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pcCircleIcon = findViewById(R.id.circlePrimary);
        pcTextView = findViewById(R.id.primaryColourText);
        scTextView = findViewById(R.id.secondaryColourText);
        scCircleIcon = findViewById(R.id.circleSecondary);
        tcTextView = findViewById(R.id.teritaryColourText);
        tcCircleIcon = findViewById(R.id.circleTeritary);

        //declare the IDs
        wallpaperView = findViewById(R.id.wallpaperView);

        //get an instance of the wallpaper manager first
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();

        //display the wallpaper
        wallpaperView.setImageDrawable(wallpaperDrawable);

        //create a wallpaper colors object
        WallpaperColors wallpaperColors = WallpaperColors.fromDrawable(wallpaperDrawable);

        /** PRIMARY COLOUR*/
        //retrieve the colors
        Color primaryColor = wallpaperColors.getPrimaryColor();
        hexColorPrimary = String.format("#%06X", (0xFFFFFF & primaryColor.toArgb()));
        //set the text with the primary colours
        pcTextView.setText(hexColorPrimary);
        pcCircleIcon.setColorFilter(Color.parseColor(hexColorPrimary));

        /** SECONDARY COLOUR */
        Color secondaryColor = wallpaperColors.getSecondaryColor();
        hexColorSecondary = String.format("#%06X", (0xFFFFFF & secondaryColor.toArgb()));
        scTextView.setText(hexColorSecondary);
        scCircleIcon.setColorFilter(Color.parseColor(hexColorSecondary));

        /** TERTIARY COLOUR*/
        Color tertiaryColor = wallpaperColors.getTertiaryColor();
        hexColorTertiary = String.format("#%06X", (0xFFFFFF & tertiaryColor.toArgb()));
        tcTextView.setText(hexColorTertiary);
        tcCircleIcon.setColorFilter(Color.parseColor(hexColorTertiary));

    }

    public void copyPrimaryColor(View view){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(hexColorPrimary, hexColorPrimary);
        clipboard.setPrimaryClip(clip);
    }

    public void copySecondaryColor(View view){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(hexColorSecondary, hexColorSecondary);
        clipboard.setPrimaryClip(clip);
    }

    public void copyTertiaryColor(View view){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(hexColorTertiary, hexColorTertiary);
        clipboard.setPrimaryClip(clip);
    }

}


