package pt.isel.adeetc.si1.businesslayer;

import java.util.List;

import pt.isel.adeetc.si1.datalayer.IStudentDAO;
import pt.isel.adeetc.si1.datalayer.StudentDAO;
import pt.isel.adeetc.si1.datalayer.common.DatabaseException;
import pt.isel.adeetc.si1.model.Student;

/// Uncomment to work with MySQLDataAccessLayer.Database 
/// and comment the TrabalhoSI1.SQLServerDataAccessLayer.Database import above.

//import TrabalhoSI1.MySQLDataAccessLayer.Database;
        

public class StudentService implements IStudentService {

	IStudentDAO studentDAO;
	
	
	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public StudentService()
	{
		/* Creates a new DAO but allows for future refactoring to support Dependency Injection */
		studentDAO = new StudentDAO();
	}
	
	@Override
	public List<Student> GetStudents() throws ServiceException {
		try 
		{
			return studentDAO.GetStudents();
		} 
		catch (DatabaseException exception) 
		{
			throw new ServiceException(exception.getMessage(), exception);
		}
	}
}
