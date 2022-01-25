import java.sql.SQLException;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		PrepareSQL sql = new PrepareSQL();
		sql.prepare();
		String query = "UPDATE students SET Roll_NO = '15' where Name='John Doe'";
		int result = sql.statement.executeUpdate(query);
		System.out.println("Changed "+result+" num of rows.");
	}
}
