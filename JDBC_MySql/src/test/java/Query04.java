import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "1234");

       // Statement st = con.createStatement();
        PreparedStatement ps =con.prepareStatement("select * from ogrenciler");
        ResultSet rs= ps.executeQuery();
        ResultSetMetaData rsmd= rs.getMetaData();

        System.out.println("1.Sütütün İsmi: "+rsmd.getColumnName(1));
        System.out.println("2.Sütütün İsmi: "+rsmd.getColumnName(2));
        System.out.println("3.Sütütün İsmi: "+rsmd.getColumnName(3));
        System.out.println("4.Sütütün İsmi: "+rsmd.getColumnName(4));

        System.out.println("=====================================================");

        System.out.println("Toplam Sütün Sayısı: "+rsmd.getColumnCount());

        System.out.println("=====================================================");

        System.out.println("1. Sütünün Data Tipi: "+rsmd.getColumnTypeName(1));
        System.out.println("2. Sütünün Data Tipi: "+rsmd.getColumnTypeName(2));
        System.out.println("3. Sütünün Data Tipi: "+rsmd.getColumnTypeName(3));
        System.out.println("4. Sütünün Data Tipi: "+rsmd.getColumnTypeName(4));

        System.out.println("=====================================================");

        System.out.println("Tablonun İsmi: "+ rsmd.getTableName(1)); // 4 sütün olduğundan 4 kadar no yazılabilir.

        System.out.println("=====================================================");

    }
}