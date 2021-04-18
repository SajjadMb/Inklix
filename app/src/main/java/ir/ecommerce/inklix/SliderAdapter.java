package ir.ecommerce.inklix;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slideImages = {
        R.drawable.onboarding1,
        R.drawable.onboarding2,
        R.drawable.onboarding3
    };

    public String[] Headline = {
            "Publish Fast",
            "Publish Secure",
            "Believe in Wisdom of crowd"
    };

    public String[] Description = {
            "This is boarding one description",
            "This is boarding two description",
            "This is boarding three description"
    };

    @Override
    public int getCount() {
        return Headline.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slideImages[position]);
        slideHeading.setText(Headline[position]);
        slideDescription.setText(Description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
