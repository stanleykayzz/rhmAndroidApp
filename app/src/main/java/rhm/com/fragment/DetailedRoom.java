package rhm.com.fragment;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rhm.rhmandroidapp.R;
import java.io.Serializable;
import rhm.com.entities.Chambre;

/**
 * Created by alvin.ondzounga on 15/06/2017.
 */

public class DetailedRoom extends Fragment {

    private TextView price;
    private TextView roomType;

    public DetailedRoom(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Détail des chambres");
        Bundle bundle = this.getArguments();
        /*if(bundle != null){
            String p = bundle.getString("LePrix");
            String priceValue = p;
        }*/

        View view = inflater.inflate(R.layout.room_details_layout, container, false);
        this.price = (TextView) view.findViewById(R.id.priceValue);
        this.roomType = (TextView) view.findViewById(R.id.roomType);
        this.price.setText(bundle.getString("LePrix"));
        this.roomType.setText(bundle.getString("LeType"));
        return view;
    }

}
