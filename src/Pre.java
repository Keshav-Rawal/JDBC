import java.sql.*;


public class Pre {

    public static void main(String [] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/Talbros";
        String username = "root";
        String password = "keshav@123";


        int i = 9;
        String N = "Aditya";
        double s  = 2344.00;
        String q = "Select*from employee;";// retrieve

        String Q = "Insert into employee values (?,?,?);";// whatever you insert put a question marks make dynamic



        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded ");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection establish Successfully");
            PreparedStatement stmt = con.prepareStatement(Q);
            // And here replace the question marks
            stmt.setInt(1,i);
            stmt.setString(2,N);//
            stmt.setDouble(3,s);
            stmt.execute();



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
