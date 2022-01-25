import java.sql.SQLException;

public class Create {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PrepareSQL sql = new PrepareSQL();
		sql.prepare();
		String query = "INSERT INTO students (`Roll_No`,`Name`,`Address`,`Semester`) VALUES"
				+ "('5','John Doe','XYZ','6'),('6','John Eoe','ABC','7')";
		int change = sql.statement.executeUpdate(query);
		System.out.println("Inserted "+change+" rows of data.");
	}
}
