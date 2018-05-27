package views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.alumfial1.appalumnos.R;

import entidades.Alumno;
import interfaces.AlumnoInterface;
import presentator.AlumnoPresentator;

public class ListarActivity extends AppCompatActivity {

    private AlumnoInterface.Presentator presentator;
    private FloatingActionButton fab;
    private TextView tv_alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        tv_alumno=(TextView)findViewById(R.id.tv_lista);
        fab = (FloatingActionButton) findViewById(R.id.new_alumno);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarVista();
            }
        });

        presentator=new AlumnoPresentator(this);
        String texto="";
        for(Alumno al: presentator.listar()){
            texto=texto+"---"+al.getDni()+"----------"+al.getNombre()+"----------"+al.getApellido()+"---------"+Html.fromHtml("<br />");
        }
        tv_alumno.setText("---Dni----------Nombre----------Apellido---------"+Html.fromHtml("<br />")+texto);
    }

    public void cambiarVista(){
        startActivity(new Intent(this,FormActivity.class));
    }

}
