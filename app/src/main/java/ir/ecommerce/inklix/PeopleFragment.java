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
public class PeopleFragment extends Fragment {
    private RecyclerView publisherList;

    private int[] images = {
            R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image,
            R.drawable.card_view_image,
            R.drawable.publisher_image
    };


    private String[] publisherName = {
            "publisherName1","publisherName2","publisherName3","publisherName4","publisherName5",

    };

    private String[] publisherBio = {
            "bio1","bio2","bio3","bio4","bio5",

    };

    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        publisherList = (RecyclerView) view.findViewById(R.id.people_recycle_view);
        //listPostList.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        publisherList.setLayoutManager(linearLayoutManager);
        PeopleAdapter peopleAdapter = new PeopleAdapter(getContext(),publisherName,publisherBio,images);
        publisherList.setAdapter(peopleAdapter);
        return view;
    }

}
