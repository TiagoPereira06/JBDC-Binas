package pt.isel.adeetc.si1.businesslayer;

import java.sql.Date;
import java.util.List;

import pt.isel.adeetc.si1.datalayer.IPasse_UtilizadorDAO;
import pt.isel.adeetc.si1.datalayer.IPessoaDAO;
import pt.isel.adeetc.si1.datalayer.Passe_UtilizadorDAO;
import pt.isel.adeetc.si1.datalayer.PessoaDAO;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Passe_Utilizador;
import pt.isel.adeetc.si1.model.Pessoa;

/// Uncomment to work with MySQLDataAccessLayer.Database 
/// and comment the TrabalhoSI1.SQLServerDataAccessLayer.Database import above.

//import TrabalhoSI1.MySQLDataAccessLayer.Database;
        

public class StudentService implements IStudentService {

	private IPessoaDAO pessoaDAO;
	private IPasse_UtilizadorDAO passe_uDAO;
	
	
	public IPessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public IPasse_UtilizadorDAO getPasse_uDAO() {
		return passe_uDAO;
	}

	public void setPasse_uDAO(IPasse_UtilizadorDAO passe_uDAO) {
		this.passe_uDAO = passe_uDAO;
	}

	public void setPessoaDAO(IPessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public StudentService()
	{
		/* Creates a new DAO but allows for future refactoring to support Dependency Injection */
		pessoaDAO = new PessoaDAO();
		passe_uDAO = new Passe_UtilizadorDAO();

	}
	
	@Override
	public List<Pessoa> GetPessoas() throws ServiceException {
		try 
		{
			return pessoaDAO.getPessoas();
		} 
		catch (DatabaseException exception) 
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}

	@Override
	public List<Passe_Utilizador> GetPasses() throws ServiceException {
		try
		{
			return passe_uDAO.getUtilizadores();
		}
		catch (DatabaseException exception)
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}

	@Override
	public void insertUtilizador(int id, String email, Date dt_reg, String ref, int saldo, Date dt_aqui) throws ServiceException {
		try
		{
			passe_uDAO.insertUtilizador(id,email,dt_reg,ref,saldo,dt_aqui);
		}
		catch (DatabaseException exception)
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}

	@Override
	public void deleteUtilizador(int id) throws ServiceException {
		try
		{
			passe_uDAO.deleteUtilizador(id);
		}
		catch (DatabaseException exception)
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}

	@Override
	public String insertPessoa(String email, String nome, int nif) throws ServiceException {
		try
		{
			return pessoaDAO.insertPessoa(email,nome,nif);
		}
		catch (DatabaseException exception)
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
}
