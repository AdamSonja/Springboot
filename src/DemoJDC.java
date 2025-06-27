import java.sql.*;

import static java.lang.Class.forName;

public class DemoJDC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        import package
        load and register
        create connection
        execute statement
        process the result
        close
        */
        int sid =102;
        String sname= "Kylie";
        int marks= 69;
        String url ="jdbc:postgresql://localhost:5432/demodb";
        String uname="postgres";
        String pass="0000";

        String sql="insert into student values(?,?,?)";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection established");

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);
        st.execute();
//        ResultSet rs =  st.executeQuery(sql);
////        rs.next();
////        String Name = rs.getString("sname"); ------->This is to get the query of a single data of a table
////        System.out.println("Name of the Student is: "+Name);
//        while(rs.next()){
//            System.out.print(rs.getInt(1)+" - ");//-------->This is to get data of whole table
//            System.out.print(rs.getString(2)+" - ");//-------->This is to get data of whole table
//            System.out.print(rs.getInt(3));
//            System.out.println(" ");//-------->This is to get data of whole table
//
//        }
        //boolean status = st.execute(sql);
        //System.out.println(status);

        System.out.println("Connection closed");
        con.close();
    }
}
