package com.dms.apps.mvvmpatientporta.Network;

import com.dms.apps.mvvmpatientporta.Model.SpecialityModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIService {
    @GET("api/SearchCriteria/getSpeciality")
    Call<List<SpecialityModel>> getSpeciality(@Header("Authorization") String Bearer_Token,
                                              @Query("branchCode") String hospCode,
                                              @Query("HospServiceURL") String hospUrl);
}
