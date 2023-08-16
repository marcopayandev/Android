package com.vp.springclient;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.vp.springclient.model.Employee;
import com.vp.springclient.retrofit.EmployeeApi;
import com.vp.springclient.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeForm extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeComponents();
  }

  private void initializeComponents() {
    TextInputEditText inputEditTextNombre = findViewById(R.id.form_textFieldNombre);
    TextInputEditText inputEditApellidop = findViewById(R.id.form_textFieldApellidop);
    TextInputEditText inputEditApellidom = findViewById(R.id.form_textFieldApellidom);
    TextInputEditText inputEditTextCalle = findViewById(R.id.form_textFieldCalle);
    TextInputEditText inputEditTextNumero = findViewById(R.id.form_textFieldNumero);
    TextInputEditText inputEditTextColonia = findViewById(R.id.form_textFieldColonia);
    TextInputEditText inputEditTextCp = findViewById(R.id.form_textFieldCp);
    TextInputEditText inputEditTextTelefono = findViewById(R.id.form_textFieldTelefono);
    TextInputEditText inputEditTextRfc = findViewById(R.id.form_textFieldRfc);


      MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

    RetrofitService retrofitService = new RetrofitService();
    EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

    buttonSave.setOnClickListener(view -> {
      String nombre = String.valueOf(inputEditTextNombre.getText());
      String apellidop = String.valueOf(inputEditApellidop.getText());
      String apellidom = String.valueOf(inputEditApellidom.getText());
      String calle = String.valueOf(inputEditTextCalle.getText());
      String numero = String.valueOf(inputEditTextNumero.getText());
      String colonia = String.valueOf(inputEditTextColonia.getText());
      String cp = String.valueOf(inputEditTextCp.getText());
      String telefono = String.valueOf(inputEditTextTelefono.getText());
      String rfc = String.valueOf(inputEditTextRfc.getText());


      Employee employee = new Employee();
      employee.setNombre(nombre);
      employee.setApellidop(apellidop);
      employee.setApellidom(apellidom);
      employee.setCalle(calle);
      employee.setNumero(numero);
      employee.setColonia(colonia);
      employee.setCp(cp);
      employee.setTelefono(telefono);
      employee.setRfc(rfc);
      employee.setEstatus(1);


        employeeApi.guardar(employee)
          .enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
              Toast.makeText(EmployeeForm.this, "Guardado con exito!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
              Toast.makeText(EmployeeForm.this, "Fallo al guardar!!!", Toast.LENGTH_SHORT).show();
              Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
            }
          });
    });
  }
}