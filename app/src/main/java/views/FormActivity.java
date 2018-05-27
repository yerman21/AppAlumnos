package views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumfial1.appalumnos.R;

import entidades.Alumno;
import interfaces.AlumnoInterface;
import presentator.AlumnoPresentator;

public class FormActivity extends AppCompatActivity implements AlumnoInterface.View{
    private FloatingActionButton fab;
    private EditText et_dni,et_nombre,et_apellido;
    private AlumnoInterface.Presentator presentator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et_dni=(EditText)findViewById(R.id.dni);
        et_nombre=(EditText)findViewById(R.id.nombre);
        et_apellido=(EditText)findViewById(R.id.apellido);

        fab = (FloatingActionButton) findViewById(R.id.add_alumno);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer dni=new Integer(et_dni.getText().toString());
                String nombre=et_nombre.getText().toString();
                String apellido=et_apellido.getText().toString();
                presentator.insert_update(new Alumno(dni,nombre,apellido));
            }
        });

        presentator=new AlumnoPresentator(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void notificar(long codigo) {
        if(codigo>0) {
            startActivity(new Intent(this, ListarActivity.class));
            Toast.makeText(this, "registro Satisfactorio", Toast.LENGTH_LONG).show();
        }

    }
}
