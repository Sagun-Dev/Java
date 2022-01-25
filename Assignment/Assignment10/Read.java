import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		PrepareSQL sql = new PrepareSQL();
		sql.prepare();
		String query = "SELECT * FROM students";
		ResultSet results = sql.statement.executeQuery(query);
		while(results.next()) {
			System.out.print(results.getInt("Roll_No")+", ");
			System.out.print(results.getString("Name")+", ");
			System.out.print(results.getString("Address")+", ");
			System.out.print(results.getInt("Semester"));
			System.out.println();
		}
	}
}
