package br.com.painelcodeti.simulator.ui;

import android.icu.text.UnicodeSetIterator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import br.com.painelcodeti.simulator.data.MatchesApi;
import br.com.painelcodeti.simulator.databinding.ActivityMainBinding;
import br.com.painelcodeti.simulator.domain.Match;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static UnicodeSetIterator R;
    private ActivityMainBinding binding;
    private MatchesApi matchesApi;

    public static void setR(UnicodeSetIterator r) {
        R = r;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();

    }

    private void setupHttpClient() {
        //TODO:
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mcnegan.github.io/matches-simulator-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        matchesApi = retrofit.create(MatchesApi.class);

    }

    private void setupMatchesList() {
        //TODO: Listar as partidas, consumindo a nossa API.
        matchesApi.getMatches().enqueue(new Callback<List<Match>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(@NonNull Call<List<Match>> call, @NonNull Response<List<Match>> response) {
                if (response.isSuccessful()){
                    List<Match> matches = response.body();
                    assert matches != null;
                    Log.i("SIMULATOR", "Deu tudo Certo!!! Partidas ="
                    + matches.size());
                }else{
                    showErrorMessage();
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onFailure(@NonNull Call<List<Match>> call, @NonNull Throwable t) {
                showErrorMessage();

            }
        });

    }


    private void setupMatchesRefresh() {
        //TODO: atualizar as partidas, na ação de swipe.

    }

    private void setupFloatingActionButton() {
        //TODO: Criar evento de click e simulação de partidas.

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showErrorMessage() {
        Snackbar.make(binding.fabSimulate, R.string, Snackbar.LENGTH_LONG).show();
    }

}
