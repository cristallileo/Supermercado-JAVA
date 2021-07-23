package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

public class DataProveedor {
	
	public LinkedList<Proveedor> getAll(){
			
			Statement stmt=null;
			ResultSet rs=null;
			LinkedList<Proveedor> proveedores= new LinkedList<>();
			
			try {
				stmt= DbConnector.getInstancia().getConn().createStatement();
				rs= stmt.executeQuery("select * from proveedor ");
				if(rs!=null) {
					while(rs.next()) {
						Proveedor p=new Proveedor();
						p.setIdProveedor(rs.getInt("idProveedor"));
						p.setTelefono(rs.getString("telefono"));
						p.setMail(rs.getString("email"));
						p.setRazonSocial(rs.getString("razonSocial"));
						p.setFechaBaja(rs.getDate("fechaBaja"));
											
						proveedores.add(p);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			return proveedores;
		}

	public Proveedor add(Proveedor p) { 
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into proveedor( telefono, email, razonSocial, fechaBaja) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
	
			stmt.setString(1, p.getTelefono());
			stmt.setString(2, p.getMail());
			stmt.setString(3, p.getRazonSocial());
			stmt.setDate(4,p.getFechaBaja());
						
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProveedor(keyResultSet.getInt(1)); //por ser autoincremental!
            }
           
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return p;
    }
	
	public Proveedor editProveedor (Proveedor p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`proveedor` SET `telefono` = ?,`email` = ?,`razonSocial` = ?, `fechaBaja` = ? WHERE (`idProveedor` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			stmt.setString(1, p.getTelefono());
			stmt.setString(2, p.getMail());
			stmt.setString(3, p.getRazonSocial());
			stmt.setDate(4, p.getFechaBaja());
			stmt.setInt(5, p.getIdProveedor());
			
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProveedor(keyResultSet.getInt(1));
            }
		} catch (SQLException e) {
        e.printStackTrace();
		} finally {
        try {
        	 if(keyResultSet!=null)keyResultSet.close();
            if(stmt!=null) stmt.close();
            DbConnector.getInstancia().releaseConn();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	return p;
	}

	

	public Proveedor getById(Proveedor prov) {
		Proveedor p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idProveedor, telefono, email, razonSocial, fechaBaja from proveedor where idProveedor=?"
					);
			stmt.setInt(1, prov.getIdProveedor());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Proveedor();
				p.setIdProveedor(rs.getInt("idProveedor"));
				p.setMail(rs.getString("email"));
				p.setTelefono(rs.getString("telefono"));
				p.setRazonSocial(rs.getString("razonSocial"));
				p.setFechaBaja(rs.getDate("fechaBaja"));

		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
}	

	public LinkedList<Proveedor> getByDesc(String razonS){

		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Proveedor> proveedores= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select * from proveedor where proveedor.razonSocial like  '%" +razonS+"%'");
			
		
			rs=stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Proveedor p=new Proveedor();
					p.setIdProveedor(rs.getInt("idProveedor"));
					p.setTelefono(rs.getString("telefono"));
					p.setMail(rs.getString("email"));
					p.setRazonSocial(rs.getString("razonSocial"));
					p.setFechaBaja(rs.getDate("fechaBaja"));
					proveedores.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return proveedores;
	}


}


