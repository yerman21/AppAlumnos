package presentator;

import java.util.List;

import entidades.Alumno;
import interfaces.AlumnoInterface;
import modelo.AlumnoModel;
import views.FormActivity;
import views.ListarActivity;

/**
 * Created by alum.fial1 on 23/05/2018.
 */

public class AlumnoPresentator implements AlumnoInterface.Presentator {
    private AlumnoInterface.Model model;
    private AlumnoInterface.View view;
    private ListarActivity  view2;

    public AlumnoPresentator(FormActivity view){
        this.view=view;
        model=new AlumnoModel(view,this);
    }

    public AlumnoPresentator(ListarActivity view){
        this.view2=view;
        model=new AlumnoModel(view,this);
    }

    @Override
    public void notificar(long codigo) {
        view.notificar(codigo);
    }

    @Override
    public void insert_update(Alumno alumno) {
        if(alumno.getDni() !=null)
            model.insert_update(alumno);
    }

    @Override
    public List<Alumno> listar() {
        return model.listar();
    }
}
