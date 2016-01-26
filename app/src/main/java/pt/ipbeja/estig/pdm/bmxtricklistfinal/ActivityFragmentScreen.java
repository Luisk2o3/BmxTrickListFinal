package pt.ipbeja.estig.pdm.bmxtricklistfinal;


import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;


/**
 * Created by LLuis on 15/12/2015.
 */
public class ActivityFragmentScreen extends FragmentActivity {

    private String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_screen);

        Intent intent = getIntent();
        buttonName = intent.getStringExtra("bName");

        if(buttonName.equals("easytricks")){

            List_Fragment listFragment = new List_Fragment();
            listFragment.SetTrickLevel("EasyTrick");
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, listFragment).commit();

        }

        if(buttonName.equals("mediumtrick")){
            List_Fragment listFragment = new List_Fragment();
            listFragment.SetTrickLevel("MediumTrick");
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, listFragment).commit();
        }


        if(buttonName.equals("hardtrick")){
            List_Fragment listFragment = new List_Fragment();
            listFragment.SetTrickLevel("HardTrick");
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, listFragment).commit();
        }

        if(buttonName.equals("grindtrick")){
            List_Fragment listFragment = new List_Fragment();
            listFragment.SetTrickLevel("GrindTrick");
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, listFragment).commit();
        }

        if(buttonName.equals("flatlandtrick")){
            List_Fragment listFragment = new List_Fragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, listFragment).commit();
        }

        if(buttonName.equals("ramptip")){
            List_Fragment listFragment = new List_Fragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, listFragment).commit();
        }
    }

}
