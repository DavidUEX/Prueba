package es.unex.propuesta_proyecto.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import es.unex.propuesta_proyecto.model.Clases;


@Dao
public interface DaoClases {

    @Query("SELECT * FROM Clases")
    abstract List<Clases> obtenerTodasClases();

    @Query("SELECT * FROM Clases WHERE usuario = :usuario")
    abstract List<Clases> obtenerClasesUsuario(String usuario);

    @Query("SELECT * FROM Clases WHERE nombre = :nombreClase AND usuario = :usuario")
    Clases obtenerClase(String nombreClase, String usuario);

    @Insert
    void insertarClase(Clases clase);

    @Query("DELETE FROM Clases WHERE nombre = :nombre")
    void borrarClase(String nombre);

    @Query("UPDATE Clases SET idArmaPrincipal = :idArmaPrincipal, idArmaSecundaria = :idArmaSecundaria WHERE nombre = :nombreClase AND usuario = :usuario")
    void actualizarArma(String nombreClase,String usuario,int idArmaPrincipal, int idArmaSecundaria);
}