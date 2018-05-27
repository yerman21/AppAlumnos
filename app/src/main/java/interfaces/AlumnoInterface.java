package interfaces;

import android.database.Cursor;

import java.util.List;

import entidades.Alumno;

/**
 * Created by alum.fial1 on 23/05/2018.
 */

public interface AlumnoInterface {
    public interface View{
        void notificar(long codigo);
    }
    public interface Presentator{
        void notificar(long codigo);
        void insert_update(Alumno alumno);
        List<Alumno> listar();
    }
    public interface Model{
        void insert_update(Alumno alumno);
        List<Alumno> listar();
    }
}
