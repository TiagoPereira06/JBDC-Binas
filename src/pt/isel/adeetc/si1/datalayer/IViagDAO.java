package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Viagem;

import java.sql.Timestamp;
import java.util.List;

public interface IViagDAO {
    List<Viagem> getViagsUtil(String email, Timestamp dt_init, Timestamp dt_fim) throws DatabaseException;
}
