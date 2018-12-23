package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Passe_Utilizador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Passe_UtilizadorDAO extends BaseDAO implements IPasse_UtilizadorDAO {

    @Override
    public List<Passe_Utilizador> getUtilizadores() throws DatabaseException {
        Connection conn = null;

        try {
            String statementQuery = "select ID, Email, Data_Registo, Referência, Saldo, Data_Aquisição from Passe_Utilizador";
            Passe_Utilizador item;
            ArrayList<Passe_Utilizador> container = new ArrayList<Passe_Utilizador>();

            conn = getConnectionFactory().getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statementQuery);

            while (rs.next()) {
                item = new Passe_Utilizador();
                item.setId(rs.getInt(1));
                item.setEmail(rs.getString(2));
                item.setDt_reg(rs.getDate(3));
                item.setRef(rs.getString(4));
                item.setSaldo(rs.getInt(5));
                item.setDt_aqui(rs.getDate(6));
                container.add(item);
            }

            return container;
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to list Users. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public void insertUtilizador(int id, String email, Date dt_reg, String ref, int saldo, Date dt_aqui) throws DatabaseException {
        String comandoSQL = "INSERT INTO Passe_Utilizador VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = getConnectionFactory().getConnection();
            PreparedStatement preparedStat = conn.prepareStatement(comandoSQL);
            preparedStat.setInt(1, id);
            preparedStat.setString(2, email);
            preparedStat.setDate(3, dt_reg);
            preparedStat.setString(4, ref);
            preparedStat.setInt(5, saldo);
            preparedStat.setDate(6, dt_aqui);
            preparedStat.executeUpdate();
            conn.commit();
            preparedStat.close();
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to insert Utilizador. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }


    }

    @Override
    public void deleteUtilizador(int id) throws DatabaseException {
        String comandSql = "DELETE FROM PASSE_UTILIZADOR WHERE ID = ?";
        Connection conn = null;

        try {
            conn = getConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(comandSql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            throw new DatabaseException(
                    "Unable to delete Utilizador. \nCause: "
                            + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    }