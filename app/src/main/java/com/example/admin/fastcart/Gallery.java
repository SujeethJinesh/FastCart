package com.example.admin.fastcart;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by aayush on 9/10/16.
 */

    import android.app.Activity;
    import android.content.Context;
    import android.content.Intent;
    import android.database.Cursor;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.net.Uri;
    import android.os.Bundle;
    import android.provider.MediaStore;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.ImageView;


    /**
     * Example of loading an image into an image view using the image picker.
     *
     * Created by Rex St. John (on behalf of AirPair.com) on 3/4/14.
     */
    public class Gallery extends Fragment implements ViewSwitcher.ViewFactory, Button.OnClickListener {

        // Code for our image picker select action.
        private static final int IMAGE_PICKER_SELECT = 999;

        // Reference to our image view we will use
        private ImageView mSelectedImage;

        // Reference to picker button.
        private Button mPickPhotoButton;


        public Gallery(){
            super();
        }


        public static Gallery newInstance(int sectionNumber) {
            Gallery fragment = new Gallery();
            Bundle args = new Bundle();
            args.putInt(sectionNumber + "", sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view =  null;
            view = inflater.inflate(R.layout.fragment_photo_picker, container, false);

            // Set the image view
            mSelectedImage = (ImageView)view.findViewById(R.id.imageViewFullSized);
            mPickPhotoButton = (Button)view.findViewById(R.id.button);

            // Set OnItemClickListener so we can be notified on button clicks
            mPickPhotoButton.setOnClickListener(this);

            return view;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, IMAGE_PICKER_SELECT);
        }


        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == IMAGE_PICKER_SELECT  && resultCode == Activity.RESULT_OK) {
//                MainActivity activity = (MainActivity)getActivity();
                Bitmap bitmap = getBitmapFromCameraData(data, getActivity());
                mSelectedImage.setImageBitmap(bitmap);
            }
        }

        private void setFullImageFromFilePath(String imagePath) {
            // Get the dimensions of the View
            int targetW = mSelectedImage.getWidth();
            int targetH = mSelectedImage.getHeight();

            // Get the dimensions of the bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imagePath, bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, bmOptions);
            mSelectedImage.setImageBitmap(bitmap);
        }
        public static Bitmap getBitmapFromCameraData(Intent data, Context context){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = context.getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            return BitmapFactory.decodeFile(picturePath);
        }

        @Override
        public View makeView() {
            return null;
        }
    }

