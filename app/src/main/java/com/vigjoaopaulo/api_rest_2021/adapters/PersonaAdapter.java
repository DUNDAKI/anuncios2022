package com.vigjoaopaulo.api_rest_2021.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vigjoaopaulo.api_rest_2021.R;
import com.vigjoaopaulo.api_rest_2021.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter  extends ArrayAdapter<Persona> {

    private Context context;
    private List<Persona> personas;



    public PersonaAdapter(Context context, int resource, List<Persona> objects) {
        super(context, R.layout.persona_model, objects);
        this.context = context;
        this.personas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.persona_model, parent, false);

        TextView id = (TextView) rowView.findViewById(R.id.ID);
        TextView nombre = (TextView) rowView.findViewById(R.id.txtNombre);
        TextView apellidos = (TextView) rowView.findViewById(R.id.txtApellido);

        id.setText(String.format("ID:%s ", personas.get(position).getId()));
        nombre.setText(String.format("Nombre:%s ", personas.get(position).getNombres()));
        apellidos.setText(String.format("Apellido:%s ", personas.get(position).getApellidos()));


        if(position % 2 == 0){
            rowView.setBackgroundColor(Color.CYAN);
        }else{
            rowView.setBackgroundColor(Color.RED);
        }
        return rowView;
    }
}
