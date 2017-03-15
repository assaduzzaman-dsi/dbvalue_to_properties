package test.app;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;
public class ReadProperty {
	
	public final static String ERROR$NOT_VALID = "error.not_valid";
	
	public static void main(String [] args) {
		readProperty();
	}
	
	public static void readProperty() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			prop.load(readerFromString());
			MessageFormat formatter = new MessageFormat("");
            formatter.applyPattern(prop.getProperty(ERROR$NOT_VALID)); 
			String message = formatter.format(new String []{"1223"}); 
			System.out.println(message);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	  }
	
	public static Reader readerFromString() {
		String property = getPropertyString();
		InputStream stream = new ByteArrayInputStream(property.getBytes(StandardCharsets.UTF_8));
		InputStreamReader isr = new InputStreamReader(stream);
		return isr;
	}
	
	public static String getPropertyString() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		StringBuilder sb = new StringBuilder();

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","user", "db_password");
			ResultSet rs = connection.createStatement().executeQuery("select * from property");
			while(rs.next()) {
				sb.append(rs.getString("key"));
				sb.append("=");
				sb.append(rs.getString("value"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		return sb.toString();
	}
}
