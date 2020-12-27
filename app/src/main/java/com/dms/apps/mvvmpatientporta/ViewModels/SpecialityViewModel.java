package com.dms.apps.mvvmpatientporta.ViewModels;

import com.dms.apps.mvvmpatientporta.Model.SpecialityModel;
import com.dms.apps.mvvmpatientporta.Repository.SpecialityRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpecialityViewModel extends ViewModel {

    //MutableLiveData is a subclass of LiveData
    //LiveData can actually be observed
    //we return LiveData because if screen closed , the data will not change , it will be the same

    private MutableLiveData<List<SpecialityModel>> listMutableLiveData;
    SpecialityRepository repository;

    public void init(String token,String branchCode,String hospUrl){
        if(listMutableLiveData!=null)
            return;
         repository = SpecialityRepository.getInstance();
         listMutableLiveData = repository.getSpecialityMutableList(token,branchCode,hospUrl);
    }

    public LiveData<List<SpecialityModel>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}
