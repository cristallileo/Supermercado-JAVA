package Data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
 
import Data.*;
import entidades.*;

@SuppressWarnings("unused")

public class DataCategoria {

	public LinkedList<Categoria> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Categoria> categorias= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idCategoria,desc_categoria from categoria");
			if(rs!=null) {
				while(rs.next()) {
					Categoria c=new Categoria();
					c.setIdCategoria(rs.getInt("idCategoria"));
					c.setDescCategoria(rs.getString("desc_categoria"));
					
					categorias.add(c);
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
		return categorias;
	}

	public Categoria addCategoria(Categoria c) { 
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into categoria(desc_categoria) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			
			stmt.setString(1, c.getDescCategoria());					
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                c.setIdCategoria(keyResultSet.getInt(1)); //por ser autoincremental!
            }
           
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                
                if(stmt!=null)stmt.close();
             //   conn.commit();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
    return c;
	}
	
	public Categoria editCategoria (Categoria c) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`categoria` SET `desc_categoria` = ? WHERE (`idCategoria` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			//NO PERMITIMOS EDITAR FECHAS DE INGRESO DE EMPLEADOS NI FEHCA DE REGISTRO DE CLIENTES PORQ ES DE INGRESO AUTOMATICO, NO INGRESO HUMANO.
			stmt.setString(1, c.getDescCategoria());
			stmt.setInt(2, c.getIdCategoria());			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                c.setIdCategoria(keyResultSet.getInt(1));
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
	return c;
	}
	
	public Categoria deleteCategoria(Categoria c) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from categoria c where c.idCategoria=? ", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, c.getIdCategoria());			
			stmt.executeUpdate();			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                c.setIdCategoria(keyResultSet.getInt(1));
            }
		} catch (SQLException e) {
        e.printStackTrace();
		}

			
		finally {
        try {
        	 if(keyResultSet!=null)keyResultSet.close();
            if(stmt!=null) stmt.close();
            DbConnector.getInstancia().releaseConn();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	return c;
	}

	
	public Categoria getOne(Categoria cat) {
		Categoria c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idCategoria,desc_categoria from categoria where idCategoria=?"
					);
			stmt.setInt(1, cat.getIdCategoria());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				c=new Categoria();
				c.setIdCategoria(rs.getInt("idCategoria"));
				c.setDescCategoria(rs.getString("desc_categoria"));			
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
		
		return c;
}
	

	public LinkedList<Categoria> getAllCategorias(){
		

	Statement stmt=null;
	ResultSet rs=null;
	LinkedList<Categoria> categorias= new LinkedList<>();
	
	try {
		stmt= DbConnector.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select idCategoria,desc_categoria from categoria");
		if(rs!=null) {
			while(rs.next()) {
				Categoria c=new Categoria();
				c.setIdCategoria(rs.getInt("idCategoria"));
				c.setDescCategoria(rs.getString("desc_categoria"));				
				categorias.add(c);
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
	return categorias;
}
	
	public LinkedList<Categoria> getAllActivas(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Categoria> categoriasActivas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idCategoria, desc_categoria from categoria where fecha_hora_baja is null");
			if(rs!=null) {
				while(rs.next()) {
					
					Categoria c = new Categoria();
					
					c.setIdCategoria(rs.getInt("idCategoria"));
					c.setDescCategoria(rs.getString("desc_categoria"));
					
					categoriasActivas.add(c);
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
		return categoriasActivas;
	}
}
}