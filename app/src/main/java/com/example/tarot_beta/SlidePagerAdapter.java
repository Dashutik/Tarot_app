package com.example.tarot_beta;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

public class SlidePagerAdapter extends FragmentStateAdapter {

    private final List<Slide> slides;

    public SlidePagerAdapter(FragmentActivity fa, List<Slide> slides) {
        super(fa);
        this.slides = slides;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Slide slide = slides.get(position);
        return SlideFragment.newInstance(slide.getImageRes(), slide.getText());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }
}

class Slide {
    private final int imageRes;
    private final String text;

    public Slide(int imageRes, String text) {
        this.imageRes = imageRes;
        this.text = text;
    }

    public int getImageRes() { return imageRes; }
    public String getText() { return text; }
}
