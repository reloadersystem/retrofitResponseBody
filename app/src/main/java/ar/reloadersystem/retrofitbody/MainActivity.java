package ar.reloadersystem.retrofitbody;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MethodWs methodWs = HelperWs.getConfiguration().create(MethodWs.class);
        String provincia = "cordoba";
        Call<ResponseBody> responseBodyCall = methodWs.getVerificarProvincia(provincia);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    ResponseBody informacion = response.body();
                    try {
                        String cadena_respuesta = informacion.string();
                        Log.i("logRespuesta", informacion.toString());

                        JSONObject resObject = new JSONObject(cadena_respuesta);

                        String cantidad = resObject.getString("cantidad");
                        JSONArray departamentos = resObject.getJSONArray("departamentos");
                        String inicio = resObject.getString("inicio");
                        String parametros = resObject.getJSONObject("parametros").getString("provincia");
                        String total = resObject.getString("total");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
