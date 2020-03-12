

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class oracleTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ip：");
		String Ip = scanner.nextLine();
		System.out.print("port：");
        String port = scanner.nextLine();
        System.out.print("user ID：");
        String userid = scanner.nextLine();
        System.out.print("password：");
        String password = scanner.nextLine();
		
        Connection conn = null;
		//Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//String dburl = "jdbc:oracle:thin:@//"+Ip+":"+port+"/ORCL";
		String dburl = "jdbc:jtds:sybase://192.168.11.240:5000;";
        try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(dburl,"ecom","ecom@168");
			}	
		}catch(Exception e) {
			System.out.println("連線失敗!");
		}
		
        System.out.println("連線成功!");
        
	}
}
