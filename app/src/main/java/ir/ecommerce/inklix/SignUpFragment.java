package ir.ecommerce.inklix;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ir.ecommerce.inklix.server.classserver;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    private EditText edt_username, edt_password, edt_confirm_password;
    private Button btn_sign_up;
    private TextView lbl_have_account;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        edt_username = (EditText) view.findViewById(R.id.edt_username);
        edt_password = (EditText) view.findViewById(R.id.edt_password);
        edt_confirm_password = (EditText) view.findViewById(R.id.edt_password_confirm);
        btn_sign_up = (Button) view.findViewById(R.id.btn_sign_up);
        lbl_have_account = (TextView) view.findViewById(R.id.lbl_have_account);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_username.getText().toString().trim();
                String pass = edt_password.getText().toString().trim();
                String conpass = edt_confirm_password.getText().toString().trim();
                if (!pass.equals(conpass)) {
                    Toast.makeText(getActivity(), "Passwords Not Equal \n" + edt_confirm_password + "-----", Toast.LENGTH_SHORT).show();
                }
                else {
                    classserver regserver = new classserver(getActivity(), user, pass,"1");
                }
            }
        });

        lbl_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment = new LoginFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.user_fragment_container,loginFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
