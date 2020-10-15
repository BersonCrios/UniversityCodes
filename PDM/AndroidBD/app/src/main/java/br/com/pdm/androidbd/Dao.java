package br.com.pdm.androidbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dao extends SQLiteOpenHelper {

    String [] scriptCriaBanco = {
            "CREATE TABLE Carro (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "placa TEXT NOT NULL, " +
                    "ano TEXT NOT NULL);"
        };

    public  final String scriptApagaDB = "DROP TABLE IF EXISTS Carro";

    Context vrContexto = null;

    public Dao(Context contexto,String nome, int versao) {
        super(contexto, nome, null,versao);
        vrContexto = contexto;
    }

    @Override
    //CRIAÇAO
    public void onCreate(SQLiteDatabase db) {
        for (int iIndex = 0;iIndex < scriptCriaBanco.length ; iIndex++){
            db.execSQL(scriptCriaBanco[iIndex]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(scriptApagaDB);
    }

    //INSERÇĀO
    public void insereCarro(ContentValues dados){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Carro", null, dados);
        Toast.makeText(vrContexto, "Inserçāo realizada com sucesso", Toast.LENGTH_SHORT).show();
    }

    //REMOÇĀO
    public void removeCarro(String placa){
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {placa};
        db.delete("Carro","placa = ?",params);
    }
    //CONSULTA
    public ArrayList<Carro> listaCarros(){
        ArrayList<Carro> lista = new ArrayList<Carro>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Carro", new String[]{"nome", "placa", "ano"}, null, null,null, null, null);

        while (cursor.moveToNext()) {
            Carro c = new Carro();
            c.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            c.setPlaca(cursor.getString(cursor.getColumnIndex("placa")));
            c.setAno(cursor.getString(cursor.getColumnIndex("ano")));

            lista.add(c);
        }
        return lista;
    }

}
