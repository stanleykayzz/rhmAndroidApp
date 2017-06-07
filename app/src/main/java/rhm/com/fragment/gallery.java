package rhm.com.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.rhm.rhmandroidapp.MyGridAdapter;
import com.example.rhm.rhmandroidapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link booking.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link booking#newInstance} factory method to
 * create an instance of this fragment.
 */

public class gallery extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myGalleryView =  inflater.inflate(R.layout.fragment_gallery, container, false);
        GridView myGrid = (GridView)this.getActivity().findViewById(R.id.myGalleryGrid);
        myGrid.setAdapter(new MyGridAdapter(myGalleryView.getContext()));
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }
}