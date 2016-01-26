package pt.ipbeja.estig.pdm.bmxtricklistfinal;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler db = new DatabaseHandler(this);
        List<Trick> trick = db.getAllTricks();
        if (trick.size() == 0){
            db.addTrick(new Trick("lPfNagf1Yl8","EasyTrick","Bunny Hop","Bunny Hop é uma das manobra essenciais para quem quer começar na modalidade."));
            db.addTrick(new Trick("G0REpuCXyos","EasyTrick","180","180 é a manobra seguinte para quem ja aprendeu o Bunny Hop."));
            db.addTrick(new Trick("m1o_vTKCKv4","MediumTrick","Tailwhip","Manual é dos primeiros truques a serem aprendidos pelos praticantes da modalidade bmx!"));
            db.addTrick(new Trick("GCq_AyrNppA","MediumTrick","360","360 é dos primeiros truques a serem aprendidos pelos praticantes da modalidade bmx!"));
            db.addTrick(new Trick("j7u4nyX4qcM","HardTrick","Decade","Decade é dos primeiros truques a serem aprendidos pelos praticantes da modalidade bmx!"));
            db.addTrick(new Trick("BisRxDuF1eA","HardTrick","Backflip","Backflip manobra já com algum risco e de dificuldade média bmx!"));
            db.addTrick(new Trick("BisRxDuF1eA","GrindTrick","Double Peg","Double peg manobra já com algum risco e de dificuldade média bmx!"));

            db.getAllTricks();
        }

        for (Trick tr : trick) {
            String log = tr.getTricks() + " - " + tr.getYoutubeLink()+ "-"+ tr.getTrickDescription();
            Log.d("Name: ", log);
        }
    }
    public void easytricks_Onclick(View view){
        Intent fragmentLocal = new Intent(this, ActivityFragmentScreen.class);
        fragmentLocal.putExtra("bName", "easytricks");
        startActivity(fragmentLocal);
    }


    public void Mediumtricks_Onclick(View view){
        Intent fragmentLocal = new Intent(this, ActivityFragmentScreen.class);
        fragmentLocal.putExtra("bName", "mediumtrick");
        startActivity(fragmentLocal);
    }


    public void Hardtricks_Onclick(View view){
        Intent fragmentLocal = new Intent(this, ActivityFragmentScreen.class);
        fragmentLocal.putExtra("bName", "hardtrick");
        startActivity(fragmentLocal);
    }

    public void Grindtricks_Onclick(View view){
        Intent fragmentLocal = new Intent(this, ActivityFragmentScreen.class);
        fragmentLocal.putExtra("bName", "grindtrick");
        startActivity(fragmentLocal);
    }

    public void Flatlandtricks_Onclick(View view){
        Intent fragmentLocal = new Intent(this, ActivityFragmentScreen.class);
        fragmentLocal.putExtra("bName", "flatlandtrick");
        startActivity(fragmentLocal);
    }

    public void Ramptips_Onclick(View view){
        Intent fragmentLocal = new Intent(this, ActivityFragmentScreen.class);
        fragmentLocal.putExtra("bName", "ramptip");
        startActivity(fragmentLocal);
    }

}
