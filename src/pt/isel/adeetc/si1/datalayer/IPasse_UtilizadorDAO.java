package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Passe_Utilizador;

import java.sql.Date;
import java.util.List;

public interface IPasse_UtilizadorDAO {
    List<Passe_Utilizador> getUtilizadores() throws DatabaseException;

    boolean insertUtilizador(int id, String email, Date dt_reg, String ref, int saldo, Date dt_aqui) throws DatabaseException;

    void deleteUtilizador(int id) throws DatabaseException;
}
