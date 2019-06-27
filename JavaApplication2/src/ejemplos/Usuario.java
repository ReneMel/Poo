package ejemplos;


import ejemplos.PostgreSqlExample;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Usuario {
	
	  private String name;
	    private String psswd;

	    public Usuario() {
	    
	    }
	    
	    public Usuario(String name, String psswd) {
	        this.name = name;
	        this.psswd = psswd;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPsswd() {
	        return psswd;
	    }

	    public void setPsswd(String psswd) {
	        this.psswd = psswd;
	    }
	   
	    public void SignUp(){
	                PostgreSqlExample n = new PostgreSqlExample();
	        n.connectDatabase();
	        Connection conn= n.getcon();
	        
	        
	         String query = "INSERT INTO usuario(usuario,contrasena) VALUES(?,?)";
	        try{
	            PreparedStatement pstm = conn.prepareStatement(query);
	            pstm.setString(1, this.name.toUpperCase());
	            pstm.setString(2, this.psswd);
	            ResultSet rs = pstm.executeQuery();
	            System.out.println(pstm.toString());
	            System.out.println(rs.getString("usuario"));
	     
	            //conn.close();
	        }catch(SQLException ex){
	    
	        }
	    }

}
