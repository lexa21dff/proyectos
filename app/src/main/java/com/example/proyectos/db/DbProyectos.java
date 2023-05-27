package com.example.proyectos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbProyectos extends  DbHelper {

    Context context;

    public DbProyectos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public  long insertarProyecto(String nombre, String descripcion, String estado){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("descripcion", descripcion);
            values.put("estado", estado);

            id = db.insert(TABLE_PROYECTOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
}
