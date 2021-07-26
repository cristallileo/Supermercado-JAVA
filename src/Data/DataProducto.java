package Data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.http.HttpServletResponse;

import Data.*;
import entidades.*;
import logic.*;

@SuppressWarnings("unused")

public class DataProducto {
	 
	public LinkedList<Producto> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from producto");
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
					p.setImagen(rs.getBytes("imagen"));
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productos.add(p);
				}
			}
			
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
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
					p.setImagen(rs.getBytes("imagen"));	
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productos.add(p);
				}
			}
			
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
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
							"insert into producto(desc_producto, stock, stockMinimo, marca, id_categoria, precio, fecha_hora_baja, imagen, id_proveedor) values(?,?,?,?,?,?,?,?,null)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			//stmt.setInt(1, p.getIdProducto());
			stmt.setString(1, p.getDescProducto());
			stmt.setInt(2, p.getStock());
			stmt.setInt(3, p.getStockMinimo());
			stmt.setString(4, p.getMarca());
			stmt.setInt(5, p.getId_categoria());
			stmt.setDouble(6, p.getPrecio());
			stmt.setTimestamp(7, p.getFecha_hora_baja());
			stmt.setBlob(8, p.getImagen_carga());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProducto(keyResultSet.getInt(1)); //por ser autoincremental!
            }
           
			
		}  catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException sqe) {
    			System.out.println("Error Code = " + sqe.getErrorCode());
    			System.out.println("SQL state = " + sqe.getSQLState());
    			System.out.println("Message = " + sqe.getMessage());
    			System.out.println("");
    			sqe.printStackTrace();
            }
		}
		
    }
	
	//Para la edicion del producto desde el admin
	public Producto editProducto (Producto p,Boolean isthereafile) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
		if(isthereafile==true) {
		
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`producto` SET `desc_producto` = ?, `stockMinimo` = ?, `marca` = ?, `id_categoria` = ?, `precio` = ?, `fecha_hora_baja` = ?, `imagen` = ? WHERE (`idProducto` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setString(1, p.getDescProducto());
			stmt.setInt(2, p.getStock());
			stmt.setInt(3, p.getStockMinimo());
			stmt.setString(4, p.getMarca());
			stmt.setInt(5, p.getId_categoria());
			stmt.setDouble(6, p.getPrecio());
			stmt.setTimestamp(7, p.getFecha_hora_baja());
			stmt.setBlob(8, p.getImagen_carga());
			stmt.setInt(9, p.getIdProducto());
			
			stmt.executeUpdate();
		}else {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`producto` SET `desc_producto` = ?, `stock` = ?, `stockMinimo` = ?, `marca` = ?, `id_categoria` = ?, `precio` = ?, `fecha_hora_baja` = ? WHERE (`idProducto` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
				
			stmt.setString(1, p.getDescProducto());
			stmt.setInt(2, p.getStock());
			stmt.setInt(3, p.getStockMinimo());
			stmt.setString(4, p.getMarca());
			stmt.setInt(5, p.getId_categoria());
			stmt.setDouble(6, p.getPrecio());
			stmt.setTimestamp(7, p.getFecha_hora_baja());
			stmt.setInt(8, p.getIdProducto());
			
			stmt.executeUpdate();			
		}
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setIdProducto(keyResultSet.getInt(1));
            }
		}
		catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		} finally {
        try {
        	 if(keyResultSet!=null)keyResultSet.close();
            if(stmt!=null) stmt.close();
            DbConnector.getInstancia().releaseConn();
        } catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
        }
	}
	return p;
	}
	
	//Para los cambios que se van haciendo del producto (habilitación/deshabilitación/etc) que no son hechos por el admin
	public Producto actualizarProducto (Producto p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {		
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `tp_java`.`producto` SET `desc_producto` = ?, `stock` = ?, `stockMinimo` = ?, `marca` = ?, `id_categoria` = ?, `precio` = ?, `fecha_hora_baja` = ? WHERE (`idProducto` = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
				
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
		}
		catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		} finally {
        try {
        	 if(keyResultSet!=null)keyResultSet.close();
            if(stmt!=null) stmt.close();
            DbConnector.getInstancia().releaseConn();
        } catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
        }
	}
	return p;
	}
	
	//ver si se usa
	public LinkedList<Producto> getByPrecio (int max) {
		
		LinkedList<Producto> productos = new LinkedList <> ();
		Producto p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from producto where precio<= ?"
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
				p.setImagen(rs.getBytes("imagen"));	
				p.setId_proveedor(rs.getInt("id_proveedor"));
				productos.add(p);
			}
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
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
					"select * from producto where idProducto=?");
			
			stmt.setInt(1, prod.getIdProducto());
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
				p.setImagen(rs.getBytes("imagen"));	
				p.setId_proveedor(rs.getInt("id_proveedor"));
				
			}
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
			}
		}
		
		return p;
}	
	
	public LinkedList<Producto> getByCategoria(Categoria cat) {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select * from producto where producto.id_categoria="+cat.getIdCategoria());
			
		
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
					p.setImagen(rs.getBytes("imagen"));	
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productos.add(p);

				}
			} }catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
			}finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException sqe) {
					System.out.println("Error Code = " + sqe.getErrorCode());
					System.out.println("SQL state = " + sqe.getSQLState());
					System.out.println("Message = " + sqe.getMessage());
					System.out.println("");
					sqe.printStackTrace();
					}

			}

		
		return productos;
	}

	public LinkedList<Producto> getByCategoriaActivas(Categoria cat) {
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("select * producto where fecha_hora_baja is null and producto.id_categoria="+cat.getIdCategoria());
			
		
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
					p.setImagen(rs.getBytes("imagen"));	
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productos.add(p);

								
					
				}
			} }catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
			}finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException sqe) {
					System.out.println("Error Code = " + sqe.getErrorCode());
					System.out.println("SQL state = " + sqe.getSQLState());
					System.out.println("Message = " + sqe.getMessage());
					System.out.println("");
					sqe.printStackTrace();}

			}

		
		return productos;
	}

	public LinkedList<Producto> getMenosMas(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Producto> productos= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from producto order by precio");
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
					p.setImagen(rs.getBytes("imagen"));	
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productos.add(p);
				}
			}
			
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
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
			rs= stmt.executeQuery("select * from producto order by precio DESC");
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
					p.setImagen(rs.getBytes("imagen"));	
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productos.add(p);
				}
			}
			
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
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
			rs= stmt.executeQuery("select* from producto where fecha_hora_baja is null");
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
					p.setImagen(rs.getBytes("imagen"));	
					p.setId_proveedor(rs.getInt("id_proveedor"));
					productosActivos.add(p);
				}
			}
			
		} catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
			}
		}			
		return productosActivos;
	}
	
	public void actualizarStock(int id_prod, int cant) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE tp_java.producto SET stock = stock - ? WHERE (idProducto = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, cant);
			stmt.setInt(2, id_prod);
			
			stmt.executeUpdate();
		}
		catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			} finally {
	        try {
	        	 if(keyResultSet!=null)keyResultSet.close();
	            if(stmt!=null) stmt.close();
	            DbConnector.getInstancia().releaseConn();
	        } catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
	        }
		}
	}

	public void agregoStock(Producto prod) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE tp_java.producto SET stock =  ?, id_proveedor = ? WHERE (idProducto = ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, prod.getStock());
			stmt.setInt(2, prod.getId_proveedor());
			stmt.setInt(3, prod.getIdProducto());
			
			stmt.executeUpdate();
		}
		catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
			} finally {
	        try {
	        	 if(keyResultSet!=null)keyResultSet.close();
	            if(stmt!=null) stmt.close();
	            DbConnector.getInstancia().releaseConn();
	        } catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
	        }
		}
		
		
	}	
}
