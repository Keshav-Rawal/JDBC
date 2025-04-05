import java.sql.*;

public class Main{
    public static void main(String [] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/Talbros";
        String username = "root";
        String password = "keshav@123";
        String q = "Select*from employee;";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded ");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection establish Successfully");
            Statement stmt = con.createStatement();
          /*int rowaffect = stmt.executeUpdate();// Insert the data ,update,delete
          if(rowaffect>0){
              System.out.println("Insert successfully " + rowaffect + " Affected");
          }
          else{
              System.out.println("Insertion failed");
          }*/
            ResultSet res = stmt.executeQuery(q);
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("Name");

                double salary= res.getDouble("salary");
                System.out.println();
                System.out.println("=================================");
                System.out.println("id " + id);
                System.out.println("Name " + name);

                System.out.println("Salary " + salary);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());

        }


    }



}
