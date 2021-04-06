package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import Data.*;
import entidades.*;
import logic.*;

@SuppressWarnings("unused")

public class DataProducto {
	
	//not used
	public LinkedList<Producto> getByDescCat(Categoria cat){
		
		LinkedList<Producto> productos = new LinkedList <> ();
		Producto p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select p.idProducto, p.desc_producto, p.stock, p.stockMinimo, p.marca, p.id_categoria, p.precio, p.fecha_hora_baja from producto p inner join categoria c on c.idCategoria=p.id_categoria where c.desc_categoria=?"
					);
			stmt.setString(1, cat.getDescCategoria());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Producto();
				p.setIdProducto(rs.getInt("idProducto"));
				p.setDescProducto(rs.getString("desc_producto"));
				p.setStock(rs.getInt("stock"));
				p.setStockMinimo(rs.getInt("stockMinimo"));
				p.setMarca(rs.getString("marca"));
				p.setId_categoria(rs.getInt("id_categoria"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
				productos.add(p);
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
		
		return productos;
		
	}

	public LinkedList<Producto> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idProducto, desc_producto, stock, stockMinimo, marca, id_categoria, precio, fecha_hora_baja from producto");
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescProducto(rs.getString("desc_producto"));
					p.setStock(rs.getInt("stock"));
					p.setStockMinimo(rs.getInt("stockMinimo"));
					p.setMarca(rs.getString("marca"));
					p.setId_categoria(rs.getInt("id_categoria"));
					p.setPrecio(rs.getDouble("precio"));
					p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					productos.add(p);
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
		
		
		return productos;
	}
	
	public LinkedList<Producto> getByDesc(String desc){

		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select * from producto where producto.desc_producto like  '%" +desc+"%'");
			
		
			rs=stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescProducto(rs.getString("desc_producto"));
					p.setStock(rs.getInt("stock"));
					p.setStockMinimo(rs.getInt("stockMinimo"));
					p.setMarca(rs.getString("marca"));
					p.setId_categoria(rs.getInt("id_categoria"));
					p.setPrecio(rs.getDouble("precio"));
					p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					productos.add(p);
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
		
		return productos;
	}

	public void add(Producto p) { 
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into producto(idProducto, desc_producto, stock, stockMinimo, marca, id_categoria, precio, fecha_hora_baja) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, p.getIdProducto());
			stmt.setString(2, p.getDescProducto());
			stmt.setInt(3, p.getStock());
			stmt.setInt(4, p.getStockMinimo());
			stmt.setString(5, p.getMarca());
			stmt.setInt(6, p.getId_categoria());
			stmt.setDouble(7, p.getPrecio());
			stmt.setTimestamp(8, p.getFecha_hora_baja());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProducto(keyResultSet.getInt(1)); //por ser autoincremental!
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

	public Producto editProducto (Producto p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`producto` SET  `desc_producto` = ?, `stock` = ?, `stockMinimo` = ?, `marca` = ?, `id_categoria` = ?, `precio` = ?, `fecha_hora_baja` = ? WHERE (`idProducto` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setString(1, p.getDescProducto());
			stmt.setInt(2, p.getStock());
			stmt.setInt(3, p.getStockMinimo());
			stmt.setString(4, p.getMarca());
			stmt.setInt(5, p.getId_categoria());
			stmt.setDouble(6, p.getPrecio());
			stmt.setTimestamp(7, p.getFecha_hora_baja());
			stmt.setInt(8, p.getIdProducto());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProducto(keyResultSet.getInt(1));
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
	
	public Producto deleteProducto(Producto p) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from producto where producto.idProducto=? ", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdProducto());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProducto(keyResultSet.getInt(1));
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

	//not used
	public LinkedList<Producto> getByPrecio (int max) {
		
		LinkedList<Producto> productos = new LinkedList <> ();
		Producto p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idProducto, desc_producto, stock, stockMinimo, marca, id_categoria, precio, fecha_hora_baja from producto where precio<= ?"
					);
			stmt.setDouble(1, max);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Producto();
				p.setIdProducto(rs.getInt("idProducto"));
				p.setDescProducto(rs.getString("desc_producto"));
				p.setStock(rs.getInt("stock"));
				p.setStockMinimo(rs.getInt("stockMinimo"));
				p.setMarca(rs.getString("marca")); 
				p.setId_categoria(rs.getInt("id_categoria"));
				p.setPrecio(rs.getDouble("precio"));
				p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja "));
				productos.add(p);
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
		return productos;
	}

	public Producto getById(Producto prod) {
		Producto p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idProducto,desc_producto,stock,stockMinimo,marca,id_categoria,precio,fecha_hora_baja  from producto where idProducto=?"
					);
			stmt.setInt(1, prod.getIdProducto());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Producto();
				p.setIdProducto(rs.getInt("idProducto"));
				p.setDescProducto(rs.getString("desc_Producto"));
				p.setStock(rs.getInt("stock"));
				p.setStockMinimo(rs.getInt("stockMinimo"));
				p.setMarca(rs.getString("marca"));
				p.setId_categoria(rs.getInt("id_categoria"));
				p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja "));
				p.setPrecio(rs.getDouble("precio"));
		
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

	
	public LinkedList<Producto> getByCategoria(Categoria cat) {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select idProducto,desc_producto,stock,stockMinimo,marca,id_categoria,precio, fecha_hora_baja from producto where producto.id_categoria="+cat.getIdCategoria());
			
		
			rs=stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescProducto(rs.getString("desc_producto"));
					p.setStock(rs.getInt("stock"));
					p.setStockMinimo(rs.getInt("stockMinimo"));
					p.setMarca(rs.getString("marca"));
					p.setId_categoria(rs.getInt("id_categoria"));
					p.setPrecio(rs.getDouble("precio"));
					p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					productos.add(p);

								
					
				}
			} }catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();}

			}

		
		return productos;
	}


	public LinkedList<Producto> getMenosMas(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idProducto,desc_producto,stock,stockMinimo,marca,id_categoria, precio,fecha_hora_baja from producto order by precio");
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescProducto(rs.getString("desc_producto"));
					p.setStock(rs.getInt("stock"));
					p.setStockMinimo(rs.getInt("stockMinimo"));
					p.setMarca(rs.getString("marca"));
					p.setId_categoria(rs.getInt("id_categoria"));
					p.setPrecio(rs.getDouble("precio"));
					p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					productos.add(p);
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
		
		
		return productos;
	}

	public LinkedList<Producto> getMasMenos(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idProducto,desc_producto,stock,stockMinimo,marca,id_categoria, precio, fecha_hora_baja from producto order by precio DESC");
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescProducto(rs.getString("desc_producto"));
					p.setStock(rs.getInt("stock"));
					p.setStockMinimo(rs.getInt("stockMinimo"));
					p.setMarca(rs.getString("marca"));
					p.setId_categoria(rs.getInt("id_categoria"));
					p.setPrecio(rs.getDouble("precio"));
					p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja"));
					productos.add(p);
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
		
		
		return productos;
	}

	//not used
	public LinkedList<Producto> getAllActivos(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productosActivos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idProducto, desc_producto, stock, stockMinimo, marca, id_categoria, precio, fecha_hora_baja  from producto where fecha_hora_baja is null");
			if(rs!=null) {
				while(rs.next()) {
					Producto p=new Producto();
					p.setIdProducto(rs.getInt("idProducto"));
					p.setDescProducto(rs.getString("desc_producto"));
					p.setStock(rs.getInt("stock"));
					p.setStockMinimo(rs.getInt("stockMinimo"));
					p.setMarca(rs.getString("marca"));
					p.setId_categoria(rs.getInt("id_categoria"));
					p.setPrecio(rs.getDouble("precio"));
					p.setFecha_hora_baja(rs.getTimestamp("fecha_hora_baja "));
					productosActivos.add(p);
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
		return productosActivos;
	}
}
