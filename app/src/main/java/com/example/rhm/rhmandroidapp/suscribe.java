package com.example.rhm.rhmandroidapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link suscribe.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link suscribe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class suscribe extends Fragment {

    public suscribe() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("S'inscription");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suscribe, container, false);
    }
}
