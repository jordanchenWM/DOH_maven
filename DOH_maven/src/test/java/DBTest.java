

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.IntStream;

import org.apache.commons.io.IOUtils;

import internal.db.util.DBUtil;



public class DBTest {
	
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		DBTest t = new DBTest();
		t.select();	
	}

	public void insert() throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		
		String sql = "insert into output_images values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
				
		String testString = "安安 我是中文";
		InputStream stream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));

		
		pstmt.setBinaryStream(1, stream);
		pstmt.setString(2, testString + "123");
		
		pstmt.executeUpdate();
		
		//System.out.println(rs.getMetaData().getColumnName(1));
		
		
		conn.close();
		System.out.println(conn.isClosed());
	}
	
	public void select() throws SQLException, IOException, ClassNotFoundException {
		
		Connection conn = DBUtil.getConnection();
		
		String sql = "select * from output_images";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
		    InputStream imageData = rs.getBinaryStream("imageData");
		    InputStream imageContent = rs.getBinaryStream("imageContent");
		    
		    StringWriter writer = new StringWriter();
		    IOUtils.copy(imageData, writer, StandardCharsets.UTF_8);
		    String theString = writer.toString();
		    
		    StringWriter writer2 = new StringWriter();
		    IOUtils.copy(imageContent, writer2, StandardCharsets.UTF_8);
		    String theString2 = writer2.toString();
		    
		    System.out.println(theString);
		    System.out.println(theString2);
		}
	}
}
