package pt.ipbeja.estig.pdm.bmxtricklistfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LLuis on 04/01/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    //Todas as Variaveis estaticas
    // Versão da Base de Dados
    private static final int DATABASE_VERSION = 1;
    // Nome da Base de Dados
    private static final String DATABASE_NAME = "mytable";
    // Nome da Tabela Contactos
    private static final String TABLE_MYTABLE = "mytable";
    // Nome das colunas da tabela contactos
    private static final String ID = "id";
    private static final String YOUTUBE_LINK = "Youtube_link";
    private static final String TRICKS = "Tipo_de_Truques";
    private static final String TRICKS_NAME = "Nome_dos_truques";
    private static final String TRICK_DESCRIPTION = "Descricao_dos_Truques";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MYTABLE_TABLE = "CREATE TABLE " + TABLE_MYTABLE + "("
                + ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + YOUTUBE_LINK + " TEXT,"
                + TRICKS + " TEXT," + TRICKS_NAME + " TEXT," +  TRICK_DESCRIPTION + " TEXT" + ")";
        db.execSQL(CREATE_MYTABLE_TABLE);



    }
    // Actualizando a base de dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MYTABLE);

        onCreate(db);
    }

    public void addTrick(Trick trick) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(YOUTUBE_LINK, trick.getYoutubeLink()); // Youtube Link
        values.put(TRICKS, trick.getTricks()); // Tipo de truque
        values.put(TRICKS_NAME, trick.getTricksName());
        values.put(TRICK_DESCRIPTION, trick.getTrickDescription());
        db.insert(TABLE_MYTABLE, null, values);
        db.close();
    }

    public List<Trick> getAllTricks(int position) {
        List<Trick> trickList = new ArrayList<Trick>();
        // query
        String selectQuery = "SELECT  * FROM " + TABLE_MYTABLE +
                " WHERE id='" + String.valueOf(position) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Percorendo o resultado da query
        if (cursor.moveToFirst()) {
            do {
                Trick trick = new Trick();
                trick.setID(Integer.parseInt(cursor.getString(0)));
                trick.setyoutubelink(cursor.getString(1));
                trick.setTricks(cursor.getString(2));
                trick.setTricksName(cursor.getString(3));
                trick.setTrickDescription(cursor.getString(4));

                trickList.add(trick);
            } while (cursor.moveToNext());
        }
        return trickList;
    }

    public List<Trick> getAllTricks() {
        List<Trick> trickList = new ArrayList<Trick>();
        // query
        String selectQuery = "SELECT  * FROM " + TABLE_MYTABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Percorendo o resultado da query
        if (cursor.moveToFirst()) {
            do {
                Trick trick = new Trick();
                trick.setID(Integer.parseInt(cursor.getString(0)));
                trick.setyoutubelink(cursor.getString(1));
                trick.setTricks(cursor.getString(2));
                trick.setTricksName(cursor.getString(3));
                trick.setTrickDescription(cursor.getString(4));

                trickList.add(trick);
            } while (cursor.moveToNext());
        }
        return trickList;
    }

    /** O SELECTED RECEBE A STRING COM O TIPO DE TRUQUE **/
    public List<Trick> getTrickBySelect(String selected) {
        List<Trick> trickList = new ArrayList<Trick>();
        // query
        String selectQuery = "SELECT " + TRICKS_NAME + " FROM " + TABLE_MYTABLE +
                " WHERE Tipo_de_Truques='" + selected + "';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Percorendo o resultado da query.
        if (cursor.moveToFirst()) {
            do {
                Trick trick = new Trick();
                trick.setTricks(cursor.getString(0));
                // Adicionado
                trickList.add(trick);
            } while (cursor.moveToNext());
        }
        return trickList;
    }

}
