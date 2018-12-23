package pt.isel.adeetc.si1.businesslayer;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import pt.isel.adeetc.si1.datalayer.*;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Funcionário;
import pt.isel.adeetc.si1.model.Passe_Utilizador;
import pt.isel.adeetc.si1.model.Pessoa;
import pt.isel.adeetc.si1.model.Viagem;

/// Uncomment to work with MySQLDataAccessLayer.Database 
/// and comment the TrabalhoSI1.SQLServerDataAccessLayer.Database import above.

//import TrabalhoSI1.MySQLDataAccessLayer.Database;


public class Business implements IBusiness {

    private IPessoaDAO pessoaDAO;
    private IPasse_UtilizadorDAO passe_uDAO;
    private IFuncDAO func_DAO;
    private IViagDAO viag_DAO;


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

    public IFuncDAO getFunc_DAO() {
        return func_DAO;
    }

    public void setFunc_DAO(IFuncDAO func_DAO) {
        this.func_DAO = func_DAO;
    }

    public IViagDAO getViag_DAO() {
        return viag_DAO;
    }

    public void setViag_DAO(IViagDAO viag_DAO) {
        this.viag_DAO = viag_DAO;
    }

    public Business() {
        /* Creates a new DAO but allows for future refactoring to support Dependency Injection */
        pessoaDAO = new PessoaDAO();
        passe_uDAO = new Passe_UtilizadorDAO();
        func_DAO = new FuncDAO();
        viag_DAO = new ViagDAO();
    }

    @Override
    public List<Pessoa> GetPessoas() throws ServiceException {
        try {
            return pessoaDAO.getPessoas();
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public List<Funcionário> getFuncs() throws ServiceException {
        try {
            return func_DAO.getFuncs();
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public List<Passe_Utilizador> GetPasses() throws ServiceException {
        try {
            return passe_uDAO.getUtilizadores();
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public List<Viagem> getViagsUtil(String email, Timestamp dt_init, Timestamp dt_fim) throws ServiceException {
        try {
            return viag_DAO.getViagsUtil(email, dt_init, dt_fim);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public boolean insertUtilizador(int id, String email, Date dt_reg, String ref, int saldo, Date dt_aqui) throws ServiceException {
        try {
            return passe_uDAO.insertUtilizador(id, email, dt_reg, ref, saldo, dt_aqui);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public String insertPessoa(String email, String nome, int nif) throws ServiceException {
        try {
            return pessoaDAO.insertPessoa(email, nome, nif);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public void deleteUtilizador(int id) throws ServiceException {
        try {
            passe_uDAO.deleteUtilizador(id);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }


    @Override
    public boolean deleteFunc(int num) throws ServiceException {
        try {
            return func_DAO.deleteFunc(num);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public boolean checkBic(int idBic) throws ServiceException {
        try {
            return viag_DAO.checkBic(idBic);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public boolean insertViagem(String email, Timestamp dt_init, Timestamp dt_fim, int idEstI, int idEstD, int idBic) throws ServiceException {
        try {
            return viag_DAO.insertViagem(email, dt_init, dt_fim, idEstI, idEstD, idBic);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    @Override
    public boolean updateViagem(String email, Timestamp dt_init, int avl, String messg) throws ServiceException {
        try {
            return viag_DAO.updateViagem(email, dt_init, avl, messg);
        } catch (DatabaseException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
