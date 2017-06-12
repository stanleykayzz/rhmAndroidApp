package rhm.com.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rhm.rhmandroidapp.R;
import com.example.rhm.rhmandroidapp.suscribe;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link login.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class login extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        TextView forgotPassword = (TextView)v.findViewById(R.id.forgotPassword);
        getActivity().setTitle("Connexion");

        forgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //new Toast(getActivity()).makeText(getActivity(), "Button1 clicked.", Toast.LENGTH_SHORT).show();
                FragmentManager fragMan = getFragmentManager();
                fragMan.beginTransaction().replace(R.id.content_frame, new suscribe()).commit();
            }
        });

        return v;

    }
}