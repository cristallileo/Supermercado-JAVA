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
				rs= stmt.executeQuery("select * from descuento");
				if(rs!=null) {
					while(rs.next()) {
						Descuento d=new Descuento();
						d.setIdDcto(rs.getInt("idDcto"));
						d.setPorcDcto(rs.getDouble("porcDcto"));
						d.setFechaDctoInicio(rs.getDate("fechaDctoInicio"));
						d.setFechaDctoFin(rs.getDate("fechaDctoFin"));
						d.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
						
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
							"insert into descuento( porcDcto, fechaDctoInicio, fechaDctoFin,fecha_hora_baja) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			
			stmt.setDouble(1, d.getPorcDcto());
			stmt.setDate(2, d.getFechaDctoInicio());
			stmt.setDate(3, d.getFechaDctoFin());
			stmt.setTimestamp(4, d.getFecha_hora_baja());
						
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

	public Descuento deshabilitarDescuento (Descuento d) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`descuento` SET `fecha_hora_baja` = ? WHERE (`idDcto` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			
			stmt.setTimestamp(1, d.getFecha_hora_baja());
			stmt.setInt(2, d.getIdDcto());
						
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

	
	public Descuento getById(Descuento des) {
		Descuento d=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from descuento where idDcto=? "
					);
			stmt.setInt(1, des.getIdDcto());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				d=new Descuento();
				d.setIdDcto(rs.getInt("idDcto"));
				d.setPorcDcto(rs.getDouble("porcDcto"));
				d.setFechaDctoInicio(rs.getDate("fechaDctoInicio"));
				d.setFechaDctoFin(rs.getDate("fechaDctoFin"));
				d.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));

				
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


	public LinkedList<Descuento> getAllActivos() {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Descuento> descuentos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from descuento where fechaDctoInicio<=curdate() and fechaDctoFin>=curdate()");
			if(rs!=null) {
				while(rs.next()) {
					Descuento d=new Descuento();
					d.setIdDcto(rs.getInt("idDcto"));
					d.setPorcDcto(rs.getDouble("porcDcto"));
					d.setFechaDctoInicio(rs.getDate("fechaDctoInicio"));
					d.setFechaDctoFin(rs.getDate("fechaDctoFin"));
					d.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					
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
	
	public LinkedList<Descuento> getAllHabilitados() {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Descuento> descuentos= new LinkedList<Descuento>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from descuento  where fecha_hora_baja is null");
			if(rs!=null) {
				while(rs.next()) {
					Descuento d=new Descuento();
					d.setIdDcto(rs.getInt("idDcto"));
					d.setPorcDcto(rs.getDouble("porcDcto"));
					d.setFechaDctoInicio(rs.getDate("fechaDctoInicio"));
					d.setFechaDctoFin(rs.getDate("fechaDctoFin"));
					d.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					
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
	
	

			}
	
			
		