package com.vp.springclient.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vp.springclient.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {

  TextView nombre, apellidop, apellidom, estatus;

  public EmployeeHolder(@NonNull View itemView) {
    super(itemView);
    nombre = itemView.findViewById(R.id.employeeListItem_nombre);
    apellidop = itemView.findViewById(R.id.employeeListItem_apellidop);
    apellidom = itemView.findViewById(R.id.employeeListItem_apellidom);
    estatus = itemView.findViewById(R.id.employeeListItem_estatus);
  }
}
