package com.example.admin.fastcart;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

/**
 * Created by aayush on 9/10/16.
 */
public class OutfitSelector extends Fragment {

    View rootView;

    ViewFlipper viewFlipperTop;
    ViewFlipper viewFlipperMiddle;
    ViewFlipper viewFlipperBottom;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.outfit_selector, container, false);

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
                }
            }
        });

        viewFlipperBottom = (ViewFlipper) rootView.findViewById(R.id.view_flipper_bottom);
        viewFlipperBottom.setOnClickListener(new View.OnClickListener() {
            boolean bool = true;
            @Override
            public void onClick(View v) {
                if (bool) {
                    viewFlipperBottom.startFlipping();
                    viewFlipperMiddle.setFlipInterval(3000);
                    bool = !bool;
                } else {
                    viewFlipperBottom.stopFlipping();
                }
            }
        });



        return rootView;
    }


}
