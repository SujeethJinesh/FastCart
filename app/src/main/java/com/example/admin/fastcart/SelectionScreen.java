package com.example.admin.fastcart;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;


/**
 * Created by aayush on 9/10/16.
 */
public class SelectionScreen extends AppCompatActivity {
    Button noButton;
    Button yesButton;

    Activity activity = null;

    ImageView targetImageView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_screen_layout);

        activity = this;

        targetImageView = (ImageView) findViewById(R.id.target_image);

//        ImageView mChart = (ImageView) findViewById(R.id.targe);
        String URL = getIntent().getExtras().getString("imageUri");
        Log.d("SelectionScreen",URL);

//        new DownloadImageTask.execute(URL);

        /*
        ImageView mChart = (ImageView) findViewById(R.id.imageview);
String URL = "http://www...anything ...";

mChart.setTag(URL);
new DownloadImageTask.execute(mChart);
         */

        noButton = (Button) findViewById(R.id.no_button);
        yesButton = (Button) findViewById(R.id.yes_button);

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Activity caller = this;
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(caller, CarouselMaster.class));
            }
        });
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
////                URI uri = URI.parse(urldisplay);
////                URL url = uri.toURL(); //get URL from your uri object
//                InputStream stream = url.openStream();
                Log.d("SelectionScreen", urldisplay);
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);

            startActivity(new Intent(activity, CarouselMaster.class));
        }
    }
}
