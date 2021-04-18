package ir.ecommerce.inklix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoarding extends AppCompatActivity {

    private LinearLayout dotLayout;
    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;

    private Button back;
    private Button next;

    private int currentPage;

    private TextView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        dotLayout = (LinearLayout) findViewById(R.id.dots_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        back = (Button) findViewById(R.id.back);
        next = (Button) findViewById(R.id.next);
        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(currentPage+1);

                if(currentPage+1 == dots.length)
                {
                    Intent intent = new Intent(viewPager.getContext(),FullScreen.class);
                    startActivity(intent);
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage-1);
            }
        });
    }


    public void addDotsIndicator(int position){
        dots = new TextView[3];
        dotLayout.removeAllViews();

        for(int i=0; i<dots.length ;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.black));

            dotLayout.addView(dots[i]);

        }

        if (dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.light_gray));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            currentPage = position;


            if (currentPage == 0){
                back.setEnabled(false);
                next.setEnabled(true);
                back.setVisibility(View.INVISIBLE);

                back.setText("");
                next.setText("Next");
            }else if(currentPage == (dots.length)-1){
                back.setEnabled(true);
                next.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                back.setText("Back");
                next.setText("Finish");
            }else {
                back.setEnabled(true);
                next.setEnabled(true);
                back.setVisibility(View.VISIBLE);

                back.setText("Back");
                next.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
