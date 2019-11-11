package ar.reloadersystem.retrofitbody;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Reloader on 10/7/19.
 */

public interface MethodWs {

    @GET("departamentos")
    Call<ResponseBody> getVerificarProvincia(@Query("provincia") String provincia);


    //https://apis.datos.gob.ar/georef/api/departamentos?provincia=cordoba&max=16
    //https://apis.datos.gob.ar/georef/api/provincias?nombre=cordoba

    //base https://apis.datos.gob.ar/georef/api/
}

