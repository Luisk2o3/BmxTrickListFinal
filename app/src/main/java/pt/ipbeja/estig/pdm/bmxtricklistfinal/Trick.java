package pt.ipbeja.estig.pdm.bmxtricklistfinal;

/**
 * Created by LLuis on 04/01/2016.
 */
public class Trick {

    //variaveis privadas
    int _id;
    String _youtubelink;
    String _getTricks;
    String _getTricksName;
    String _getTrickDescription;
    // constructor vazio
    public Trick(){
    }
    // constructor
    public Trick(int id, String youtubelink, String getTricks, String getTricksName,String getTrickDescription){
        this._id = id;
        this._youtubelink = youtubelink;
        this._getTricks = getTricks;
        this._getTricksName = getTricksName;
        this._getTrickDescription = getTrickDescription;
    }
    // constructor
    public Trick(String youtubelink, String getTricks, String getTricksName,String getTrickDescription){
        this._youtubelink = youtubelink;
        this._getTricks = getTricks;
        this._getTricksName = getTricksName;
        this._getTrickDescription = getTrickDescription;
    }
    // getting ID
    public int getID(){
        return this._id;
    }
    // setting id
    public void setID(int id){
        this._id = id;
    }
    // getting name
    public String getYoutubeLink(){
        return this._youtubelink;
    }
    // setting name
    public void setyoutubelink(String youtubelink){
        this._youtubelink = youtubelink;
    }
    // getting phone number
    public String getTricks(){
        return this._getTricks;
    }
    // setting phone number
    public void setTricks(String getTricks){
        this._getTricks = getTricks;
    }


    public String getTricksName(){
        return this._getTricksName;
    }

    public void setTricksName(String getTricksName){
        this._getTricksName = getTricksName;
    }

    public String getTrickDescription(){
        return this._getTrickDescription;
    }

    public void setTrickDescription(String getTrickDescription){
        this._getTrickDescription = getTrickDescription;
    }

}
