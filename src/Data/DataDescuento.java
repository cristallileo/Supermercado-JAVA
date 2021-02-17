package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

	public class DataDescuento {
	
	public LinkedList<Descuento> getAll(){
			
			Statement stmt=null;
			ResultSet rs=null;
			LinkedList<Descuento> descuentos= new LinkedList<>();
			
			try {
				stmt= DbConnector.getInstancia().getConn().createStatement();
				rs= stmt.executeQuery("select idDcto,porcDcto,fechaDctoInicio, fechaDctoFin from descuento");
				if(rs!=null) {
					while(rs.next()) {
						Descuento d=new Descuento();
						d.setIdDcto(rs.getInt("idDcto"));
						d.setPorcDcto(rs.getDouble("porcDcto"));
						d.setFechaDctoInicio(rs.getDate("fechaDctoInicio"));
						d.setFechaDctoFin(rs.getDate("fechaDctoFin"));
						
						descuentos.add(d);
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
			return descuentos;
		}

	
	public Descuento add(Descuento d) { 
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into descuento( porcDcto, fechaDctoInicio, fechaDctoFin) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			
			stmt.setDouble(1, d.getPorcDcto());
			stmt.setDate(2, d.getFechaDctoInicio());
			stmt.setDate(3, d.getFechaDctoFin());
						
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                d.setIdDcto(keyResultSet.getInt(1)); //por ser autoincremental!
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
		
    return d;
	}

	public Descuento editDescuento (Descuento d) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`descuento` SET `porcDcto` = ?,`fechaDctoInicio` = ?,`fechaDctoFin` = ? WHERE (`idDcto` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			stmt.setDouble(1, d.getPorcDcto());
			stmt.setDate(2, d.getFechaDctoInicio());
			stmt.setDate(3, d.getFechaDctoFin());
			stmt.setInt(4, d.getIdDcto());
						
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                d.setIdDcto(keyResultSet.getInt(1));
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
	return d;
	}

	public Proveedor deleteProveedor(Proveedor p) {
			
			PreparedStatement stmt= null;
			ResultSet keyResultSet=null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"delete from proveedor where proveedor.idProveedor=? ", PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, p.getIdProveedor());
				
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
	
	public void deleteDescuento(Descuento d) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from descuento where descuento.idDcto=? ", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, d.getIdDcto());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                d.setIdDcto(keyResultSet.getInt(1));
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


	public Descuento getById(Descuento des) {
		Descuento d=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idDcto,porcDcto,fechaDctoInicio,fechaDctoFin from descuento where idDcto=? "
					);
			stmt.setInt(1, des.getIdDcto());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				d=new Descuento();
				d.setIdDcto(rs.getInt("idDcto"));
				d.setPorcDcto(rs.getDouble("porcDcto"));
				d.setFechaDctoInicio(rs.getDate("fechaDctoInicio"));
				d.setFechaDctoFin(rs.getDate("fechaDctoFin"));

				
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
		
		return d;
}
	}