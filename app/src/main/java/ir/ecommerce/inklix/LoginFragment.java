package ir.ecommerce.inklix;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ir.ecommerce.inklix.server.classserver;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Button btn_login;
    private EditText edt_username , edt_password;
    private TextView lbl_forgot_password , lbl_sign_up;
    private android.support.v4.app.FragmentManager fragmentManager;



    public LoginFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btn_login =(Button) view.findViewById(R.id.btn_sign_in);
        edt_username = (EditText) view.findViewById(R.id.edt_username);
        edt_password = (EditText) view.findViewById(R.id.edt_password);
        lbl_forgot_password = (TextView) view.findViewById(R.id.lbl_forgot_password);
        lbl_sign_up = (TextView) view.findViewById(R.id.lbl_no_account);



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String user = edt_username.getText().toString().trim();
//                String pass = edt_password.getText().toString().trim();
//                classserver regserver = new classserver(getActivity(), user, pass,"1");
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });

        lbl_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpFragment signUpFragment = new SignUpFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.user_fragment_container,signUpFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        lbl_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgetPasswordFragment forgetPasswordFragment = new ForgetPasswordFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.user_fragment_container,forgetPasswordFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

}
