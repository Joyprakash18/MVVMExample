package com.example.mvvmexample;

import com.example.mvvmexample.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/bins/e75la")
    Call<List<Employee>> getEmployeeList();
}
