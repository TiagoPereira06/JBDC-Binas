package pt.isel.adeetc.si1.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.datalayer.common.BaseDAO;
import pt.isel.adeetc.si1.model.Pessoa;

public class PessoaDAO extends BaseDAO implements IPessoaDAO {

	@Override
	public List<Pessoa> getPessoas() throws DatabaseException {
		Connection conn = null;

		try {
			//String statementQuery = "select BIAluno, NomeAluno, MoradaAluno, DataNascimento, NIFAluno from Aluno";
			String statementQuery = "select Email, Nome, NIF from Pessoa";
			Pessoa item;
			ArrayList<Pessoa> container = new ArrayList<Pessoa>();

			conn = getConnectionFactory().getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(statementQuery);
			while (rs.next()) {
				item = new Pessoa();
				item.setEmail(rs.getString(1));
				item.setName(rs.getString(2));
				item.setNif(rs.getInt(3));
				container.add(item);
			}

			return container;
		} catch (Exception exception) {
			throw new DatabaseException(
					"Unable to list people. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closeConnection(conn);
		}
	}

	@Override
	public String insertPessoa(String email, String nome, int nif) throws DatabaseException {
		String comandoSQL = "INSERT INTO Pessoa VALUES (?, ?, ?)";
		Connection conn = null;
		try {
			conn = getConnectionFactory().getConnection();
			PreparedStatement preparedStat = conn.prepareStatement(comandoSQL);
			preparedStat.setString(1, email);
			preparedStat.setString(2, nome);
			preparedStat.setInt(3, nif);
			preparedStat.executeUpdate();
			conn.commit();
			preparedStat.close();
		} catch (Exception exception) {
			throw new DatabaseException(
					"Unable to insert Pessoa. \nCause: "
							+ exception.getMessage(), exception);
		} finally {
			closeConnection(conn);
		}
		return email;
	}
}