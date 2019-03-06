package com.example.mvvmexample.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvmexample.R;
import com.example.mvvmexample.model.Employee;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private Activity activity;
    private List<Employee> employeeList;

    public RecyclerAdapter(Activity activity, List<Employee> employeeList) {
        this.activity = activity;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.child_employee,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int i) {
        Employee employee = employeeList.get(i);
        holder.setDataToViews(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mEmployeeName;
        private TextView mEmployeeDepartment;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mEmployeeName = itemView.findViewById(R.id.employeeName);
            mEmployeeDepartment = itemView.findViewById(R.id.employeeDepartment);
        }
        void setDataToViews(Employee employee){
            String employeeName = employee.getEmployee();
            String employeeDepartment = employee.getDepartment();
            mEmployeeName.setText(employeeName);
            mEmployeeDepartment.setText(employeeDepartment);
        }
    }
}
