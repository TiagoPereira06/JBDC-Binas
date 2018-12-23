package pt.isel.adeetc.si1.datalayer;

import java.util.List;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Pessoa;

public interface IPessoaDAO {
	List<Pessoa> getPessoas() throws DatabaseException;
}
