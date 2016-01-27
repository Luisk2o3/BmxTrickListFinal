package pt.ipbeja.estig.pdm.bmxtricklistfinal;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class List_Fragment extends ListFragment {



    public List_Fragment() {

    }

    public void SetTrickLevel(String trickLevel) {
        mTrickLevel=trickLevel;
    }

    public String mTrickLevel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Trick> tricks = db.getTrickBySelect(mTrickLevel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1);
        for (Trick trick : tricks) {
            adapter.add(trick.getTricks());
        }
        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(getContext(), Description_Fragment.class);
        intent.putExtra(Description_Fragment.ARG_POSITION, position);
        startActivity(intent);
    }


}

