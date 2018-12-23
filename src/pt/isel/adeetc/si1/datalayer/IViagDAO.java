package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Viagem;

import java.sql.Timestamp;
import java.util.List;

public interface IViagDAO {
    List<Viagem> getViagsUtil(String email, Timestamp dt_init, Timestamp dt_fim) throws DatabaseException;

    boolean checkBic(int idBic) throws DatabaseException;

    boolean insertViagem(String email, Timestamp dt_init, Timestamp dt_fim, int idEstI, int idEstD, int idBic) throws DatabaseException;

    boolean updateViagem(String email, Timestamp dt_init, int avl, String messg) throws DatabaseException;
}
