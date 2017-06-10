package rhm.com.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rhm.rhmandroidapp.R;

import java.util.ArrayList;
import java.util.List;

import rhm.com.adapters.RoomListAdapter;
import rhm.com.entities.Chambre;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link room.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link room#newInstance} factory method to
 * create an instance of this fragment.
 */
public class room extends Fragment {

    private ListView listeDesChambres;
    private List<Chambre> chambres;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.chambres = new ArrayList<Chambre>();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_room, container, false);
        chambres.add(new Chambre(1,"Chambre Simple", 60000,R.drawable.room1));
        chambres.add(new Chambre(2,"Chambre Double", 100000,R.drawable.room3));
        chambres.add(new Chambre(3,"Suite Junior", 150000,R.drawable.room5));
        chambres.add(new Chambre(4,"Suite Exécutive", 200000,R.drawable.room10  ));
        this.listeDesChambres = (ListView) v.findViewById(R.id.listViewRooms);
        this.listeDesChambres.setAdapter(new RoomListAdapter(getContext(), chambres));
        getActivity().setTitle("Nos chambres");
        return v;
    }
}