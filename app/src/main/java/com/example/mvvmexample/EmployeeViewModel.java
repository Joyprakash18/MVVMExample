package com.example.mvvmexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mvvmexample.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeViewModel extends ViewModel {
    MutableLiveData<List<Employee>> employeeList;
    public LiveData<List<Employee>> getEmployee(){
        if (employeeList == null){
            employeeList = new MutableLiveData<>();
            loadEmployeeList();
        }
        return employeeList;
    }

    private void loadEmployeeList() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.myjson.com")
                .build();
        Service service = retrofit.create(Service.class);
        Call<List<Employee>> call = service.getEmployeeList();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                employeeList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });
    }
}
