package rhm.com.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.rhm.rhmandroidapp.MainActivity;
import com.example.rhm.rhmandroidapp.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rhm.com.adapters.RoomListAdapter;
import rhm.com.entities.Chambre;

public class room extends Fragment {

    private ListView listeDesChambres;
    private List<Chambre> chambres;

    public room(){
    }

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
        //on ajoute le code pour afficher la page de détails lorsqu'on clique sur un objet
        this.listeDesChambres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chambre detailRoom = chambres.get(position);

                DetailedRoom dr = new DetailedRoom();
                Bundle bundle = new Bundle();

                bundle.putString("LePrix",detailRoom.getPriceIntoString());
                bundle.putString("LeType",detailRoom.getTypeRoom());

                dr.setArguments(bundle);

                FragmentManager fragMan = getFragmentManager();
                fragMan.beginTransaction().replace(R.id.content_frame, dr).commit();
            }
        });
        getActivity().setTitle("Nos chambres");
        return v;
    }
}