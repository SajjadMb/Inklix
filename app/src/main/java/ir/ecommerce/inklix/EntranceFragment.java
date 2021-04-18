package ir.ecommerce.inklix;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EntranceFragment extends Fragment {

    private Button btn_sign_up , btn_sign_in;
    private android.support.v4.app.FragmentManager fragmentManager;

    public EntranceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entrance, container, false);
        btn_sign_in = (Button) view.findViewById(R.id.btn_sign_in);
        btn_sign_up = (Button) view.findViewById(R.id.btn_sign_up);
        fragmentManager = getActivity().getSupportFragmentManager();

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignUpFragment signUpFragment = new SignUpFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.user_fragment_container, signUpFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment = new LoginFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.user_fragment_container, loginFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }

}
