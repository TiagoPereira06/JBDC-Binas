package pt.isel.adeetc.si1.businesslayer;

import java.sql.Date;
import java.util.List;

import pt.isel.adeetc.si1.model.Passe_Utilizador;
import pt.isel.adeetc.si1.model.Pessoa;

public interface IBusiness extends IService {

	List<Pessoa> GetPessoas() throws ServiceException;
	List<Passe_Utilizador> GetPasses() throws ServiceException;
	void insertUtilizador(int id, String email, Date dt_reg, String ref, int saldo, Date dt_aqui) throws ServiceException;
	void deleteUtilizador(int id) throws ServiceException;
	String insertPessoa(String email, String nome, int nif) throws ServiceException;
}
