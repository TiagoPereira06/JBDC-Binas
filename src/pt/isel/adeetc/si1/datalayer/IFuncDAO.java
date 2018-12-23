package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Funcionário;

import java.util.List;

public interface IFuncDAO {
    List<Funcionário> getFuncs() throws DatabaseException;
    boolean deleteFunc(int num) throws DatabaseException;
}
