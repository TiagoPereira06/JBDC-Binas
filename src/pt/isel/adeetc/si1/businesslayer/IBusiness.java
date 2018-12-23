package pt.isel.adeetc.si1.businesslayer;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import pt.isel.adeetc.si1.model.Funcionário;
import pt.isel.adeetc.si1.model.Passe_Utilizador;
import pt.isel.adeetc.si1.model.Pessoa;
import pt.isel.adeetc.si1.model.Viagem;

public interface IBusiness extends IService {

    List<Pessoa> getPessoas() throws ServiceException;

    List<Funcionário> getFuncs() throws ServiceException;

    List<Passe_Utilizador> getPasses() throws ServiceException;

    List<Viagem> getViagsUtil(String email, Timestamp dt_init, Timestamp dt_fim) throws ServiceException;

    boolean insertUtilizador(int id, String email, Date dt_reg, String ref, int saldo, Date dt_aqui) throws ServiceException;

    void deleteUtilizador(int id) throws ServiceException;

    String insertPessoa(String email, String nome, int nif) throws ServiceException;

    boolean deleteFunc(int num) throws ServiceException;

    boolean checkBic(int idBic) throws ServiceException;

    boolean insertViagem(String email, Timestamp dt_init, Timestamp dt_fim, int idEstI, int idEstD, int idBic) throws ServiceException;

    boolean updateViagem(String email, Timestamp dt_init, int avl, String messg) throws ServiceException;
}
