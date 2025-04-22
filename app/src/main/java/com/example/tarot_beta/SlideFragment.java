package com.example.tarot_beta;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class SlideFragment extends Fragment {

    private static final String ARG_IMAGE = "image";
    private static final String ARG_TEXT = "text";

    public static SlideFragment newInstance(int imageRes, String text) {
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, imageRes);
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        ImageView imageView = view.findViewById(R.id.slideImageView);
        TextView textView = view.findViewById(R.id.slideTextView);

        if (getArguments() != null) {
            imageView.setImageResource(getArguments().getInt(ARG_IMAGE));
            textView.setText(getArguments().getString(ARG_TEXT));
        }

        return view;
    }
}
