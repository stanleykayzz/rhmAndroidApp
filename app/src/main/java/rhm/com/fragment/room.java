package rhm.com.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rhm.rhmandroidapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link room.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link room#newInstance} factory method to
 * create an instance of this fragment.
 */
public class room extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_room, container, false);
        getActivity().setTitle("Nos chambres");
        return v;
    }
}