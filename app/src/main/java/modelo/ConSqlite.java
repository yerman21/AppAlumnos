package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alum.fial1 on 23/05/2018.
 */

public class ConSqlite extends SQLiteOpenHelper{
    private static final String DB_NAME  = "db_alumno";
    private static final int DB_VERSION = 1;

    private final String CREATE_ALUMNO="CREATE TABLE ALUMNO( DNI INTEGER NOT NULL PRIMARY KEY UNIQUE" +
                                        ",NOMBRE TEXT NOT NULL, APELLIDO TEXT NOT NULL)";

    public ConSqlite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ALUMNO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static class Alumno{
        public static final String TABLE="ALUMNO";
        public static final String _ID="DNI";
        public static final String NOMBRE="NOMBRE";
        public static final String APELLIDO="APELLIDO";
        public static final String[] COLUMNAS=new String[]{_ID,NOMBRE,APELLIDO};
    }
}
