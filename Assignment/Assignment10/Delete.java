import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PrepareSQL sql = new PrepareSQL();
		sql.prepare();
		String query = "DELETE FROM students WHERE NAME = 'John Eoe'";
		int result = sql.statement.executeUpdate(query);
		System.out.println("Deleted "+result+" no of rows");
	}
}
