package ir.ecommerce.inklix;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends Fragment {

    private RecyclerView trendList;

    private int[] images = {
            R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image
    };


    private String[] titles = {
            "title1","title2","title3","title4","title5",

    };

    private String[] captions = {
            "caption1","caption2","caption3","caption4","caption5",

    };

    private String[] dates = {
            "date1","date2","date3","date4","date5",

    };

    private String[] publishers = {
            "publisher1","publisher2","publisher3","publisher4","publisher5",

    };


    public TrendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trend, container, false);
        trendList = (RecyclerView) view.findViewById(R.id.trends_recycle_view);
        //listPostList.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        trendList.setLayoutManager(linearLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(getContext(),titles,captions,dates,publishers,images);
        trendList.setAdapter(newsAdapter);
        return view;
    }

}
