package com.dms.apps.mvvmpatientporta.Repository;

import com.dms.apps.mvvmpatientporta.Model.SpecialityModel;
import com.dms.apps.mvvmpatientporta.Network.APIClient;
import com.dms.apps.mvvmpatientporta.Network.APIService;
import com.dms.apps.mvvmpatientporta.ViewModels.SpecialityViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialityRepository {
    //Singleton
    private static SpecialityRepository instance ;


    public static SpecialityRepository getInstance(){
        if(instance!=null)
            instance = new SpecialityRepository();
        return instance;
    }

    public MutableLiveData<List<SpecialityModel>> getSpecialityMutableList(String token,String branchCode,String hospUrl) {
        MutableLiveData<List<SpecialityModel>> specialityMutableList = new MutableLiveData<>() ;

        APIClient apiClient = new APIClient();
        APIService apiService = apiClient.getRetrofitInstance().create(APIService.class);
        Call<List<SpecialityModel>> call = apiService.getSpeciality(token,branchCode,hospUrl);
        call.enqueue(new Callback<List<SpecialityModel>>() {
            @Override
            public void onResponse(Call<List<SpecialityModel>> call, Response<List<SpecialityModel>> response) {
                specialityMutableList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SpecialityModel>> call, Throwable t) {
                specialityMutableList.postValue(null);
            }
        });

        return specialityMutableList;
    }
}
