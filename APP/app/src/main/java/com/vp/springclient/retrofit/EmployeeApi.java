package com.vp.springclient.retrofit;

import com.vp.springclient.model.Employee;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {

  @GET("/prospecto/todos")
  Call<List<Employee>> getAllEmployees();

  @POST("/prospecto/guardar")
  Call<Employee> guardar(@Body Employee employee);

  @POST("/prospecto/actualizarEstatus")
  Call<Employee> actualizarEstatus(@Body Employee employee);
}
