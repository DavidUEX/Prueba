package es.unex.propuesta_proyecto.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;

import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import es.unex.propuesta_proyecto.R;
import es.unex.propuesta_proyecto.model.Armas;
import es.unex.propuesta_proyecto.api.AppExecutors;
import es.unex.propuesta_proyecto.api.ReposNetworkLoaderRunnable;
//Esta clase es igual que ArmasPrincipalesActivity, hace lo mismo pero con las armas secundarias
public class ArmasSecundariasActivity extends AppCompatActivity  implements MyAdapter.OnListInteractionListener {

    ArrayList<Armas> alPistolas = new ArrayList<Armas>();
    ArrayList<Armas> alCuerpoACuerpo = new ArrayList<Armas>();

    RecyclerView rvPistolas;
    RecyclerView rvCuerpoACuerpo;

    private MyAdapter pistolas, cuerpo;
    private MyAdapter cogerUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armas_secundarias);
        /** INICIALIZACION DE LOS ADAPTERS **/
        pistolas = new MyAdapter(new ArrayList<>(), this);
        cuerpo = new MyAdapter(new ArrayList<>(), this);

        cargarPreferencias();

        // Carga del RecyclerView de las pistolas
        rvPistolas = findViewById(R.id.rvPistolas);
        rvPistolas.setLayoutManager(new LinearLayoutManager(this));
        //Inserción de las pistolas de la API en pistolas
        for (int i = 76 ; i < 77; i++){
            //int j=i;
            AppExecutors.getInstance().networkIO().execute(new ReposNetworkLoaderRunnable(i,(repos) ->  pistolas.swap((repos))));
            //AppExecutors.getInstance().networkIO().execute(new ReposNetworkLoaderRunnable(i,(repos) ->  cogerUsuario.pasarIdArma((repos.get(0).getPrincipal()))));
        }
        rvPistolas.setAdapter(pistolas);//se carga el ArrayList de pistolas recuperado de la API en el RecyclerView

        // Carga del RecyclerView de las armas cuerpo a cuerpo
        rvCuerpoACuerpo = findViewById(R.id.rvCuerpoACuerpo);
        rvCuerpoACuerpo.setLayoutManager(new LinearLayoutManager(this));
        //Inserción de las armas cuerpo a cuerpo de la API en cuerpo
        for (int i = 0 ; i < 3; i++){
            // AppExecutors.getInstance().networkIO().execute(new ReposNetworkLoaderRunnable(i,(repos) ->  cuerpo.swap((repos))));
        }
        rvCuerpoACuerpo.setAdapter(cuerpo);//se carga el ArrayList de armas cuerpo a cuerpo recuperado de la API en el RecyclerView

    }

    private void cargarPreferencias() {

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String usuario = preferences.getString("user","usuario vacio");
        String clase = preferences.getString("clase","clases vacia");

        cogerUsuario = new MyAdapter(new ArrayList<>(),this);

        cogerUsuario.usuarioActivo(usuario);
        cogerUsuario.claseActiva(clase);
    }

    @Override
    public void onListInteraction(String url) {
        Uri webpage = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }
}