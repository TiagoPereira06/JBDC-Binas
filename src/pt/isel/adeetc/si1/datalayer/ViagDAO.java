package pt.isel.adeetc.si1.datalayer;

import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Viagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViagDAO extends BaseDAO implements IViagDAO {

    @Override
    public List<Viagem> getViagsUtil(String email, Timestamp dt_init, Timestamp dt_fim) throws DatabaseException {
        Connection conn = null;
        try {
            String statementQuery = "select Viagem.Data_Inicial,Viagem.Email, Bicicleta.* " +
                    "from Viagem " +
                    "inner join Bicicleta on (Bicicleta.ID = Viagem.IDBicicleta) " +
                    "where Viagem.Data_Final is null and Email = ? AND Data_Inicial >= ? AND Data_Inicial <= ?";
            Viagem item;
            ArrayList<Viagem> container = new ArrayList<Viagem>();

            conn = getConnectionFactory().getConnection();

            PreparedStatement stmt = conn.prepareStatement(statementQuery);
            stmt.setString(1, email);
            stmt.setTimestamp(2, dt_init);
            stmt.setTimestamp(3, dt_fim);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                item = new Viagem();
                item.setDt_init(rs.getTimestamp(1));
                item.setEmail(rs.getString(2));
                item.setIdBic(rs.getInt(3));
                container.add(item);
            }
            stmt.close();
            rs.close();
            return container;
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to list Viagens. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public boolean checkBic(int idBic) throws DatabaseException { //retorna true se a bicicleta não estiver a ser utilizada
        Connection conn = null;
        try {
            String statementQuery = "select Email from Viagem " +
                    "where Viagem.Data_Final is null and IDBicicleta = ?";

            conn = getConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(statementQuery);
            stmt.setInt(1, idBic);
            return !stmt.executeQuery().next();
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to check if Bicicleta is in a trip. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public boolean insertViagem(String email, Timestamp dt_init, Timestamp dt_fim, int idEstI, int idEstD, int idBic) throws DatabaseException {
        String comandoSQL = "INSERT INTO Viagem VALUES (?, ?, ?, ?, ?, ?, null, null)";
        Connection conn = null;
        int count;
        try {
            conn = getConnectionFactory().getConnection();
            PreparedStatement preparedStat = conn.prepareStatement(comandoSQL);
            preparedStat.setString(1, email);
            preparedStat.setTimestamp(2, dt_init);
            preparedStat.setTimestamp(3, dt_fim);
            preparedStat.setInt(4, idEstI);
            preparedStat.setInt(5, idEstD);
            preparedStat.setInt(6, idBic);
            count = preparedStat.executeUpdate();
            conn.commit();
            preparedStat.close();
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to insert Viagem. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
        return count > 0;
    }

    @Override
    public boolean updateViagem(String email, Timestamp dt_init, int avl, String messg) throws DatabaseException {
        String comandoSQL = "UPDATE Viagem SET Avaliação = ?, Mensagem = ? WHERE Email = ? AND Data_Inicial = ?";
        Connection conn = null;
        int count;
        try {
            conn = getConnectionFactory().getConnection();
            PreparedStatement preparedStat = conn.prepareStatement(comandoSQL);
            preparedStat.setInt(1, avl);
            preparedStat.setString(2, messg);
            preparedStat.setString(3, email);
            preparedStat.setTimestamp(4, dt_init);
            count = preparedStat.executeUpdate();
            conn.commit();
            preparedStat.close();
        } catch (Exception exception) {
            throw new DatabaseException(
                    "Unable to update Viagem. \nCause: "
                            + exception.getMessage(), exception);
        } finally {
            closeConnection(conn);
        }
        return count > 0;
    }

}
