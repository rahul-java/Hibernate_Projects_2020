package max;

import java.sql.Connection;
import java.sql.*;

public class ConnectionUtility {
	private ConnectionUtility() {

	}

	static Connection con = null;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/abc", "postgres", "postgres");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}

	public static int getID(Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select max(eid) as eid from usermaster");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("eid");
				return ++i;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
