package com.example.proyectos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectos.db.DbProyectos;

public class CrearProyecto extends AppCompatActivity {
    EditText et_nombre, et_descripcion;
    Button btn_guarda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_proyecto);

        et_nombre = findViewById(R.id.txt_nombre);
        et_descripcion = findViewById(R.id.txt_descripcion);
        btn_guarda = findViewById(R.id.btn_guarda);

        btn_guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProyectos dbProyectos  = new DbProyectos(CrearProyecto.this);
                String nombre = et_nombre.getText().toString();
                String descripcion = et_descripcion.getText().toString();
                String estado = "Pendiente";
                long id = dbProyectos.insertarProyecto(nombre, descripcion,estado);
                et_nombre.setText("");
                et_descripcion.setText("");
                if (id > 0) {
                    Toast.makeText(CrearProyecto.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(CrearProyecto.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}