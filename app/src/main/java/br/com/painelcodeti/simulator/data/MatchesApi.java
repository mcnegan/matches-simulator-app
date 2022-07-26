package br.com.painelcodeti.simulator.data;

import java.util.List;

import br.com.painelcodeti.simulator.domain.Match;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {

    //TODO: EndPoint Mapeado com sucesso.
    @GET("matches.json")
    Call<List<Match>> getMatches();

}
