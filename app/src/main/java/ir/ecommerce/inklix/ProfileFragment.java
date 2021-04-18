package ir.ecommerce.inklix;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private ImageButton btn_setting;
    private ImageView profile_photo;
    private TextView profile_title , honesty_percentage, profile_bio;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProfilePager profilePager;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_photo = (ImageView) view.findViewById(R.id.profile_img);
        profile_title = (TextView) view.findViewById(R.id.profile_title);
        honesty_percentage = (TextView) view.findViewById(R.id.honesty_percentage);
        profile_bio = (TextView) view.findViewById(R.id.profile_bio);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager =(ViewPager) view.findViewById(R.id.pager_profile);
        profilePager = new ProfilePager(getActivity().getSupportFragmentManager());
        profilePager.addFragment(new GridPostFragment(),"Grid");
        profilePager.addFragment((new ListPostFragment()),"List");
        viewPager.setAdapter(profilePager);
        tabLayout.setupWithViewPager(viewPager);

        view.findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SettingActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

}
