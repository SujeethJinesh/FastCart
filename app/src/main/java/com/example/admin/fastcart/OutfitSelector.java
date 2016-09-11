package com.example.admin.fastcart;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

/**
 * Created by aayush on 9/10/16.
 */
public class OutfitSelector extends Fragment {

    View rootView;

    ViewFlipper viewFlipperTop;
    ViewFlipper viewFlipperMiddle;
    ViewFlipper viewFlipperBottom;

    Button galleryButton;
    Button purchaseButton;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.outfit_selector, container, false);

        galleryButton = (Button) rootView.findViewById(R.id.gallery_button);
        purchaseButton = (Button) rootView.findViewById(R.id.purchase_button);

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewFlipperTop = (ViewFlipper) rootView.findViewById(R.id.view_flipper_top);
        viewFlipperTop.setOnClickListener(new View.OnClickListener() {
            boolean bool = true;
            @Override
            public void onClick(View v) {
                if (bool) {
                    viewFlipperMiddle.setFlipInterval(3000);
                    viewFlipperTop.startFlipping();
                    bool = !bool;
                } else {
                    viewFlipperTop.stopFlipping();
                    bool = !bool;
                }

            }
        });

        viewFlipperMiddle = (ViewFlipper) rootView.findViewById(R.id.view_flipper_middle);
        viewFlipperMiddle.setOnClickListener(new View.OnClickListener() {
            boolean bool = true;
            @Override
            public void onClick(View v) {
                if (bool) {
                    viewFlipperMiddle.setFlipInterval(3000);
                    viewFlipperMiddle.startFlipping();
                    bool = !bool;
                } else {
                    viewFlipperMiddle.stopFlipping();
                    bool = !bool;
                }
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarouselMaster.moveToGallery();
            }
        });

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarouselMaster.moveToPurchase();
            }
        });

        return rootView;
    }


}
