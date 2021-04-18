package ir.ecommerce.inklix;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridPostFragment extends Fragment {

    private RecyclerView gridPostList;

    private int[] images = {R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image,
            R.drawable.card_view_image};

    public GridPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_post, container, false);
        gridPostList = (RecyclerView) view.findViewById(R.id.list_post);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        gridPostList.setLayoutManager(gridLayoutManager);
        GridAdapter gridAdapter = new GridAdapter(getContext(),images);
        gridPostList.setAdapter(gridAdapter);
        return view;
    }

}
