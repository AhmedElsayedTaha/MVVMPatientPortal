package com.dms.apps.mvvmpatientporta.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dms.apps.mvvmpatientporta.Model.SpecialityModel;
import com.dms.apps.mvvmpatientporta.R;
import com.dms.apps.mvvmpatientporta.ViewModels.SpecialityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    SpecialityAdapter specialityAdapter;
    LinearLayoutManager linearLayoutManager;
    SpecialityViewModel specialityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rec);
        progressBar = findViewById(R.id.pp);

        specialityViewModel = ViewModelProviders.of(this).get(SpecialityViewModel.class);
        specialityViewModel.getListMutableLiveData().observe(this, new Observer<List<SpecialityModel>>() {
            @Override
            public void onChanged(List<SpecialityModel> specialityModels) {
            specialityAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"size is "+specialityModels.size(),Toast.LENGTH_LONG).show();
            }
        });

        specialityViewModel.init("Bearer JHw6I-Le2bImTemwQGyqgMAQfiaPojL1XAoBjtXMglQN6nCwq86qNlE_S-CqeivsWNmla6A-_z_D40T_8WtHFjUqRM1QohmQqbpxlBkLsLoK8HMxLET_cnG7-6SO9I2Q6cIU7ehcgAJPBIYIZn2cJh5ffbjEbB4Qp3M4XbWGJ3Ja4-o9xREeBlT8FUMqKumTep2IgqofuJ1uzGwN3eY7LEiXG5vvvq2wUgZOg3ViKH6iL_1zZOjp22Lgi2N4hRoeg6gMA6s6imIiLar7t-2mPwPr4eAmdwWD5Zy19USYPAu1JLfZVqhKxRwjrEgnbGCyEK7wfNB32hUoJtZ1-OFHsg",
                "01","DB2A75C31D3B1CEC5B7836D2C9D3D8910A179E12B712179856E863971372123840EB43BA61835516");


        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        specialityAdapter = new SpecialityAdapter(this,specialityViewModel.getListMutableLiveData().getValue());
    }


}