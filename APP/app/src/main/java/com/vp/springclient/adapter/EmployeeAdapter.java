package com.vp.springclient.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vp.springclient.EmployeeDetailsActivity;
import com.vp.springclient.R;
import com.vp.springclient.model.Employee;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeHolder> {

  private List<Employee> employeeList;

  public EmployeeAdapter(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }


  @NonNull
  @Override
  public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_employee_item, parent, false);

    EmployeeHolder viewHolder = new EmployeeHolder(itemView);

    itemView.setOnClickListener(v -> {
      int position = viewHolder.getAdapterPosition();
      if (position != RecyclerView.NO_POSITION) {
        Employee employee = employeeList.get(position);
        Intent intent = new Intent(itemView.getContext(), EmployeeDetailsActivity.class);
        intent.putExtra("id", employee.getId());
        intent.putExtra("nombre", employee.getNombre());
        intent.putExtra("apellidop", employee.getApellidop());
        intent.putExtra("apellidom", employee.getApellidom());
        intent.putExtra("calle", employee.getCalle());
        intent.putExtra("numero", employee.getNumero());
        intent.putExtra("colonia", employee.getColonia());
        intent.putExtra("cp", employee.getCp());
        intent.putExtra("telefono", employee.getTelefono());
        intent.putExtra("rfc", employee.getRfc());
        intent.putExtra("estatus", employee.getEstatus());
        intent.putExtra("desc", employee.getDescripcion());



        itemView.getContext().startActivity(intent);
      }
    });

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
    Employee employee = employeeList.get(position);
    int estatus = employee.getEstatus();

    String status = "";

    if (estatus == 1){
      status = "Enviado";
    } else if (estatus == 2) {
      status = "Autorizado";
    }else{
      status = "Rechazado";
    }
    holder.nombre.setText(employee.getNombre());
    holder.apellidop.setText(employee.getApellidop());
    holder.apellidom.setText(employee.getApellidom());
    holder.estatus.setText(status);



  }



  @Override
  public int getItemCount() {
    return employeeList.size();
  }
}
