package pt.ipbeja.estig.pdm.bmxtricklistfinal;


import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Description_Fragment extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    //static private final String DEVELOPER_KEY = "AIzaSyAA-xNi0upOapXnGARs0l1TXtwHeZvVM4c";
    //static private final String VIDEO = "lPfNagf1Yl8";

    final static String ARG_POSITION = "position";

    String description;
    String youtube;
    int v;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_description);

        Intent intent = getIntent();
        if (intent !=null){
            int value = intent.getIntExtra(Description_Fragment.ARG_POSITION, 0);
            v = (value +1);
        }

        YouTubePlayerView youTubeView = (YouTubePlayerView)
                findViewById(R.id.view);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);

        DatabaseHandler db = new DatabaseHandler(this);
        List<Trick> tricks = db.getAllTricks(v);

        for (Trick trick : tricks) {
            youtube = trick.getYoutubeLink();
            description = trick.getTrickDescription();
        }

        TextView txt = (TextView)findViewById(R.id.textView);
        txt.setText(description);






    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult error) {
        Toast.makeText(this, "Erro,tente de novo! " + error.toString(),
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        player.loadVideo(youtube);

    }


}
