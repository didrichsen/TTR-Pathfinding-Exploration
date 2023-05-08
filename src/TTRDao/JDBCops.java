package TTRDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCops {

        public JDBCops(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");

            }catch (ClassNotFoundException classNotFoundException){
                classNotFoundException.printStackTrace();
            }
        }

        public Connection getConnection(){
            try{
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ttr?useSSL=false",
                        "root",
                        ""
                );
                return con;
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
            return null;
        }
        public void closeConnection(Connection con){

            try{
                con.close();


            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
}
