package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import entidades.Alumno;
import interfaces.AlumnoInterface;

/**
 * Created by alum.fial1 on 23/05/2018.
 */

public class AlumnoModel implements AlumnoInterface.Model{
    private ConSqlite conn;
    private SQLiteDatabase database;
    private AlumnoInterface.Presentator presentator;

    public AlumnoModel(Context context,AlumnoInterface.Presentator presentator){
        conn=new ConSqlite(context);
        this.presentator=presentator;
    }

    private SQLiteDatabase getDatabase(){
        if(database==null){
            database=conn.getWritableDatabase();
        }
        return database;
    }

    @Override
    public void insert_update(Alumno alumno) {
        ContentValues values=new ContentValues();
        values.put(ConSqlite.Alumno._ID,alumno.getDni());
        values.put(ConSqlite.Alumno.NOMBRE,alumno.getNombre());
        values.put(ConSqlite.Alumno.APELLIDO,alumno.getApellido());

        //validar si recibe el DNI
        if(!ValidarAlumno(Integer.toString(alumno.getDni()))){
            presentator.notificar(database.insert(ConSqlite.Alumno.TABLE,null,values));
        }else{
            presentator.notificar(getDatabase().update(ConSqlite.Alumno.TABLE,values,"DNI=?",new String[]{alumno.getDni().toString()}));
        }
    }

    public boolean ValidarAlumno(String dni){
        Cursor cursor = getDatabase().query(ConSqlite.Alumno.TABLE,null,
                "DNI = ?", new String[]{dni}, null, null,null);
        if(cursor.moveToNext()){
            return true;
        }
        return false;
    }

    @Override
    public List<Alumno> listar() {
        Cursor cursor=getDatabase().query(ConSqlite.Alumno.TABLE,ConSqlite.Alumno.COLUMNAS,null,null,null,null,null);
        List<Alumno> listaAlumno=new ArrayList<Alumno>();
        while(cursor.moveToNext()){
            Alumno alumno=cursor_to_alumno(cursor);
            listaAlumno.add(alumno);
        }
        return listaAlumno;
    }
    private Alumno cursor_to_alumno(Cursor cursor){
        Alumno alum=new Alumno(
                cursor.getInt(cursor.getColumnIndex(ConSqlite.Alumno._ID)),
                cursor.getString(cursor.getColumnIndex(ConSqlite.Alumno.NOMBRE)),
                cursor.getString(cursor.getColumnIndex(ConSqlite.Alumno.APELLIDO))
        );
        return alum;
    }


}
