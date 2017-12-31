package com.example.mujtaba.basicai.Computer_Vision;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mujtaba.basicai.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Upload_image extends AppCompatActivity {
    private Button upload;
    private Button greyscale;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        upload=(Button) findViewById(R.id.uploadbutton);
        greyscale=(Button)findViewById(R.id.greyscaleconversion);
        image = (ImageView) findViewById(R.id.imageViewGallery);
    }

    // This function is called after clicking the Browse From Gallery button
    public boolean image_select(View view) {

        // access the images gallery
        Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);

        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        image.setColorFilter(0);    //convert the image back to coloured

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // Show the Selected Image on ImageView
            image.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            upload.setText("Change picture");    //when this button pressed atleast one time
            greyscale.setVisibility(View.VISIBLE);

        }
    }

    public void greyscale(View V){
        greyscale.setVisibility(View.INVISIBLE);
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        image.setColorFilter(filter);
    }

}
