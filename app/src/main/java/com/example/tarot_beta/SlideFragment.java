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
    private static final String ARG_DESC = "description";

    public static SlideFragment newInstance(int imageRes, String text, String description) {
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE, imageRes);
        args.putString(ARG_TEXT, text);
        args.putString(ARG_DESC, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide, container, false);
        ImageView imageView = view.findViewById(R.id.slideImageView);
        TextView textView1 = view.findViewById(R.id.slideTextView1);
        TextView textView2 = view.findViewById(R.id.slideTextView2);

        if (getArguments() != null) {
            imageView.setImageResource(getArguments().getInt(ARG_IMAGE));
            textView1.setText(getArguments().getString(ARG_TEXT));
            textView2.setText(getArguments().getString(ARG_DESC));
        }

        return view;
    }
}
