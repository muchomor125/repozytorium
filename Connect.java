import java.sql.*;
import java.util.Scanner;
 
public class Connect {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://Full202086309:3306/stack";
 
   static final String USER = "admin";
   static final String PASS = "admin";
 
   static Scanner in = new Scanner( System.in);
  
     public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
 
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
 
 
      stmt = conn.createStatement();
      String sql;
      String optNr;
      int id;
      String idr;
      String first;
      String last;
      String address;
      String city;
      do
      {
         System.out.println("1. Select *\n2. Insert\n3. Edit\n4. Delete\nS. Press S to Exit");
         optNr = in.nextLine();
         switch( optNr )
         {
              case "1" : sql = "SELECT PersonID, FirstName, LastName, Address, City FROM Persons";
                       ResultSet rs = stmt.executeQuery(sql);
                                           System.out.println("ID    First    Last    Address    City");
 
                       while(rs.next()){
                          id  = rs.getInt("PersonID");
                          first = rs.getString("FirstName");
                          last = rs.getString("LastName");
                          address = rs.getString("Address");
                          city = rs.getString("City");
 
                          System.out.println(id+"    "+first+"    "+last+"    "+address+"    "+city);
 
                      
                       } rs.close();
                       break;
 
              case "2" :  
                        System.out.println("ID");
                          idr = in.nextLine();
 
                        System.out.println("First:");
                          first = in.nextLine();
 
                        System.out.println("Last");
                          last = in.nextLine();
 
                        System.out.println("Last:");
                          address = in.nextLine();
 
                        System.out.println("Address");
                          city = in.nextLine();
                        sql = " INSERT INTO Persons (PersonID, LastName, FirstName, Address,City) VALUES ('"+idr+"', '"+last+"', '"+first+"', '"+address+"','"+city+"')";
                        System.out.println("sql:"+sql);
                        int ri = stmt.executeUpdate(sql);
                     break; 
              case "3" : 
                       sql = "SELECT PersonID, FirstName, LastName, Address, City FROM Persons";
                       ResultSet rss = stmt.executeQuery(sql);
                                           System.out.println("ID    First    Last    Address    City");
 
                       while(rss.next()){
                          id  = rss.getInt("PersonID");
                          first = rss.getString("FirstName");
                          last = rss.getString("LastName");
                          address = rss.getString("Address");
                          city = rss.getString("City");
 
                          System.out.println(id+"    "+first+"    "+last+"    "+address+"    "+city);
 
                       
                       }
rss.close();
                        System.out.println("Enter ID to edit");
                          idr = in.nextLine();
 
                        System.out.println("First");
                          first = in.nextLine();
 
                        System.out.println("Last");
                          last = in.nextLine();
 
                        System.out.println("Last:");
                          address = in.nextLine();
 
                        System.out.println("Address");
                          city = in.nextLine();
                        sql = " UPDATE Persons SET LastName = '"+last+"' , FirstName = '"+first+"', Address = '"+address+"',City ='"+city+"' WHERE PersonID= '"+idr+"';";
                        System.out.println("sql:"+sql);
                        int rii = stmt.executeUpdate(sql);
                     break;
case "4" : 
                       sql = "SELECT PersonID, FirstName, LastName, Address, City FROM Persons";
                       ResultSet rsss = stmt.executeQuery(sql);
                                           System.out.println("ID    First    Last    Address    City");
 
                       while(rsss.next()){
                          id  = rsss.getInt("PersonID");
                          first = rsss.getString("FirstName");
                          last = rsss.getString("LastName");
                          address = rsss.getString("Address");
                          city = rsss.getString("City");
 
                          System.out.println(id+"    "+first+"    "+last+"    "+address+"    "+city);
 
                       }
                       rsss.close();
                        System.out.println("Enter ID to delete");
                          idr = in.nextLine();
                        sql = " DELETE FROM Persons WHERE PersonID= '"+idr+"';";
                        System.out.println("sql:"+sql);
                        int riii = stmt.executeUpdate(sql);
                     break;                                       
         }
       }while (!optNr.equals("S"));       
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
}
