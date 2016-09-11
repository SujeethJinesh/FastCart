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
public class Gallery extends Fragment implements ViewSwitcher.ViewFactory {

    Integer pics[] = { R.drawable.greyshirt, R.drawable.khakishorts, R.drawable.pants, R.drawable.shirt };

    ImageSwitcher iSwitcher;

    View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        rootView = inflater.inflate(R.layout.gallery, container, false);
        iSwitcher = (ImageSwitcher) rootView.findViewById(R.id.ImageSwitcher01);
        iSwitcher.setFactory(this);
        iSwitcher.setInAnimation(AnimationUtils.loadAnimation(getActivity(),
                android.R.anim.fade_in));
        iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity(),
                android.R.anim.fade_out));

        android.widget.Gallery gallery = (android.widget.Gallery) rootView.findViewById(R.id.Gallery01);
        gallery.setAdapter(new ImageAdapter(getActivity()));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                iSwitcher.setImageResource(pics[arg2]);
            }
        });

        return rootView;
    }

    public class ImageAdapter extends BaseAdapter {

        private Context ctx;

        public ImageAdapter(Context c) {
            ctx = c;
        }

        @Override
        public int getCount() {

            return pics.length;
        }

        @Override
        public Object getItem(int arg0) {

            return arg0;
        }

        @Override
        public long getItemId(int arg0) {

            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            ImageView iView = new ImageView(ctx);
            iView.setImageResource(pics[arg0]);
            iView.setScaleType(ImageView.ScaleType.FIT_XY);
            iView.setLayoutParams(new android.widget.Gallery.LayoutParams(150, 150));
            return iView;
        }

    }

    @Override
    public View makeView() {
        ImageView iView = new ImageView(getActivity());
        iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iView.setLayoutParams(new
                ImageSwitcher.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        iView.setBackgroundColor(0xFF000000);
        return iView;
    }
}

