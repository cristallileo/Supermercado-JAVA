package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

public class DataPedido {
	
	public LinkedList<Pedido> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Pedido> pedidos= new LinkedList<Pedido>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idPedido,fechaPedido,precioTotal,fechaEntrega,direccionEnvio,estado,id_persona,id_dcto from pedido");
			if(rs!=null) {
				while(rs.next()) {
					Pedido p=new Pedido();
					p.setIdPedido(rs.getInt("idPedido"));
					p.setFechaPedido(rs.getDate("fechaPedido"));
					p.setPrecioTotal(rs.getDouble("precioTotal"));
					p.setFechaEntrega(rs.getDate("fechaEntrega"));
					p.setDireccionEnvio(rs.getString("direccionEnvio"));
					p.setEstado(rs.getString("estado"));
					p.setId_persona(rs.getInt("id_persona"));
					p.setId_dcto(rs.getInt("id_dcto"));
					
				
					pedidos.add(p);
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
		return pedidos;
	}

	public void add(Pedido p) { 
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		Pedido ped = new Pedido();
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into pedido(fechaPedido, precioTotal, fechaEntrega, direccionEnvio, estado, id_persona, id_dcto) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setDate(1, p.getFechaPedido());
			stmt.setDouble(2, p.getPrecioTotal());
			stmt.setDate(3, p.getFechaEntrega());
			stmt.setString(4, p.getDireccionEnvio());
			stmt.setString(5, p.getEstado());
			stmt.setInt(6, p.getId_persona());
			stmt.setInt(7, p.getId_dcto());
				
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPedido(keyResultSet.getInt(1)); //por ser autoincremental!
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
    }

	
	public Pedido editTotal (Pedido p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`pedido` SET  `precioTotal` = ? WHERE (`idPedido` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setDouble(1, p.getPrecioTotal());
			stmt.setInt(2, p.getIdPedido());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPedido(keyResultSet.getInt(1));
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

	public Pedido deletePedido(Pedido p) {
			
			PreparedStatement stmt= null;
			ResultSet keyResultSet=null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"delete from pedido where pedido.idPedido=? ", PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, p.getIdPedido());
				
				stmt.executeUpdate();
				
				keyResultSet=stmt.getGeneratedKeys();
	            if(keyResultSet!=null && keyResultSet.next()){
	                p.setIdPedido(keyResultSet.getInt(1));
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

	public Pedido getById(Pedido ped) {
		Pedido p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from pedido where idPedido = ? "
					);
			stmt.setInt(1, ped.getIdPedido());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Pedido();
				p.setIdPedido(rs.getInt("idPedido"));
				p.setFechaPedido(rs.getDate("fechaPedido"));	
				p.setPrecioTotal(rs.getDouble("precioTotal"));
				p.setFechaEntrega(rs.getDate("fechaEntrega"));
				p.setDireccionEnvio(rs.getString("direccionEnvio"));
				p.setEstado(rs.getString("estado"));
				p.setId_persona(rs.getInt("id_persona"));
				p.setId_dcto(rs.getInt("id_dcto"));
				
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
	
	public void confirmarPedido (Pedido p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`pedido` SET  `direccionEnvio` = ?, `estado` = ? WHERE (`idPedido` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
						
			stmt.setString(1, p.getDireccionEnvio());
			stmt.setString(2, "Confirmado");
			stmt.setInt(3, p.getIdPedido());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPedido(keyResultSet.getInt(1));
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
	}

	public LinkedList<Pedido> getByCliente(Persona per) {
		LinkedList<Pedido> pedidos= new LinkedList<Pedido>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from pedido where id_persona = ?");
			stmt.setInt(1, per.getIdPersona());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Pedido p = new Pedido();
				p.setId_dcto(rs.getInt("idPedido"));
				p.setFechaPedido(rs.getDate("fechaPedido"));
				p.setPrecioTotal(rs.getDouble("precioTotal"));
				p.setFechaEntrega(rs.getDate("fechaEntrega"));
				p.setDireccionEnvio(rs.getString("direccionEnvio"));
				p.setEstado(rs.getString("estado"));
				p.setId_persona(rs.getInt("id_persona"));
				p.setId_dcto(rs.getInt("id_dcto"));
				
				pedidos.add(p);
				
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
		
		return pedidos;
	}


	public Pedido editEstado (Pedido p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`pedido` SET  `estado` = ? WHERE (`idPedido` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, p.getEstado());
			stmt.setInt(2, p.getIdPedido());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdPedido(keyResultSet.getInt(1));
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
}
