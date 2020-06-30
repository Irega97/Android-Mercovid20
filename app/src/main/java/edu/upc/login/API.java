package edu.upc.login;



import java.util.List;

import edu.upc.login.Entidades.Comentario;
import edu.upc.login.Entidades.Foro;
import edu.upc.login.Entidades.Inventario;
import edu.upc.login.Entidades.Item;
import edu.upc.login.Entidades.LoginCredentials;
import edu.upc.login.Entidades.Mapa;
import edu.upc.login.Entidades.Nivel;
import edu.upc.login.Entidades.Partida;
import edu.upc.login.Entidades.PartidaAdd;
import edu.upc.login.Entidades.Ranking;
import edu.upc.login.Entidades.RegisterCredentials;
import edu.upc.login.Entidades.Token;
import edu.upc.login.Entidades.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

@GET("game/ranking")
    Call <List<Ranking>> getRanking();

@GET("game/toppartidas ")
    Call<List<Partida>> getRankingPersonal(@Query("token") String token);

@GET("game/mapitas")
    Call<List<Mapa>> getMapas();

@GET("game/enemigos")
    Call<Nivel> getEnemigos(@Query("idNivel") int idNivel);

@POST("game/useobject")
    Call<Void> useObjeto(@Body Inventario i);

@POST("game/addpartida")
    Call<Void> addPartida(@Body PartidaAdd p);

@POST("game/puntos")
    Call<Void> addPuntos(@Query("token") String token, @Query("puntos") int puntos);

//Servicio que pasa un JSON con las credenciales del login y devuelve un token
//que se guardara en sharedPreferences
//Para ver sharedPreferences: device file explorer->data->data->edu.upc.login->shared_prefs
@POST("auth/login")
    Call<Token> login(@Body LoginCredentials loginCredentials);

@POST("auth/register")
    Call<Token> register(@Body RegisterCredentials registerCredentials);

@POST("game/compra")
    Call<Void> comprar (@Body Inventario inventario);

@GET("game/objetos")
    Call<List<Inventario>> inventario (@Query("token") String token);

@GET("user/comments")
    Call<List<Foro>> getComments();

@POST("user/newcomment")
    Call<Void> addComment(@Query("token") String token, @Body Comentario comentario);

@DELETE("user/signout")
    Call<Void> signOut(@Query("token") String token);

@GET("user/user")
    Call<User> getUser(@Query("token") String token);

@POST("user/update")
    Call<Void> updateUser(@Body User user);

}