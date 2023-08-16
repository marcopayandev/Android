package com.vp.springclient;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.vp.springclient.model.Employee;
import com.vp.springclient.retrofit.EmployeeApi;
import com.vp.springclient.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeDetailsActivity extends AppCompatActivity {
    private TextView nombreTextView;
    private TextView apellidopTextView;
    private TextView apellidomTextView;
    private TextView calleTextView;
    private TextView numeroTextView;
    private TextView coloniaTextView;
    private TextView cpTextView;
    private TextView telefonoTextView;
    private TextView rfcTextView;
    private TextView estatusTextView;
    private TextView descTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        nombreTextView = findViewById(R.id.form_textFieldNombre);
        apellidopTextView = findViewById(R.id.form_textFieldApellidop);
        apellidomTextView = findViewById(R.id.form_textFieldApellidom);
        calleTextView = findViewById(R.id.form_textFieldCalle);
        numeroTextView = findViewById(R.id.form_textFieldNumero);
        coloniaTextView = findViewById(R.id.form_textFieldColonia);
        cpTextView = findViewById(R.id.form_textFieldCp);
        telefonoTextView = findViewById(R.id.form_textFieldTelefono);
        rfcTextView = findViewById(R.id.form_textFieldRfc);
        estatusTextView = findViewById(R.id.form_textFieldEstatus);
        descTextView = findViewById(R.id.form_textFieldDesc);



        // Obtener los datos pasados a través del Intent
        Intent intent = getIntent();
        int id = ((Intent) intent).getIntExtra("id",0);
        String nombre = ((Intent) intent).getStringExtra("nombre");
        String apellidop = ((Intent) intent).getStringExtra("apellidop");
        String apellidom = ((Intent) intent).getStringExtra("apellidom");
        String calle = ((Intent) intent).getStringExtra("calle");
        String numero = ((Intent) intent).getStringExtra("numero");
        String colonia = ((Intent) intent).getStringExtra("colonia");
        String cp = ((Intent) intent).getStringExtra("cp");
        String telefono = ((Intent) intent).getStringExtra("telefono");
        String rfc = ((Intent) intent).getStringExtra("rfc");
        int estatus = ((Intent) intent).getIntExtra("estatus",0);
        String desc = ((Intent) intent).getStringExtra("desc");

        String numeroString = String.valueOf(numero);
        String cpString = String.valueOf(cp);
        String telefonoString = String.valueOf(telefono);
        String status = "";

        if (estatus == 1){
            status = "Enviado";
        } else if (estatus == 2) {
            status = "Autorizado";
        }else{
            status = "Rechazado";
        }

        // Mostrar los datos en los TextViews
        nombreTextView.setText(nombre);
        apellidopTextView.setText(apellidop);
        apellidomTextView.setText(apellidom);
        calleTextView.setText(calle);
        numeroTextView.setText(numeroString);
        coloniaTextView.setText(colonia);
        cpTextView.setText(cpString);
        telefonoTextView.setText(telefonoString);
        rfcTextView.setText(rfc);
        estatusTextView.setText(status);
        descTextView.setText(desc);


        //Actualizar estatus
        MaterialButton buttonSave = findViewById(R.id.btnGuardarEstatus);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        buttonSave.setOnClickListener(view -> {

            TextInputEditText inputEditTextDesc = findViewById(R.id.form_textFieldDesc);
            Spinner spinner = findViewById(R.id.spinner);
            String descv = String.valueOf(inputEditTextDesc.getText());
            String valorEstatus =spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();

            int EstatusValor = 0;
            if (valorEstatus.equals("Rechazado")){
                EstatusValor = 3;
            } else if (valorEstatus.equals("Autorizado") ) {
                EstatusValor = 2;
            }else{
                EstatusValor = 1;
            }

            Employee employee = new Employee();
            employee.setId(id);
            employee.setEstatus(EstatusValor);
            employee.setDescripcion(descv);



            employeeApi.actualizarEstatus(employee)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(EmployeeDetailsActivity.this, "Estatus actualizado con exito!" , Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(EmployeeDetailsActivity.this, "Fallo al actualizar estatus!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
        });

    }



}
