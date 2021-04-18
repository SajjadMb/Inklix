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
public class ListPostFragment extends Fragment {

    private RecyclerView listPostList;

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

    public ListPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_post, container, false);
        listPostList = (RecyclerView) view.findViewById(R.id.list_post);
//        listPostList.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation( LinearLayoutManager.VERTICAL );
        listPostList.setLayoutManager(linearLayoutManager);
        ListAdapter listAdapter = new ListAdapter(getContext(),titles,captions,dates,publishers,images);
        listPostList.setAdapter(listAdapter);
        return view;
    }

}
