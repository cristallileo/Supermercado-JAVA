package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.*;

public class DataLineaDePedido {

	public LinkedList<LineaDePedido> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<LineaDePedido> lineas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from lineapedido");
			//select id_pedido,id_producto,desc_producto,cantidad from lineapedido lp inner join producto p on p.idProducto=lp.id_producto
			if(rs!=null) {
				while(rs.next()) {
					LineaDePedido lp=new LineaDePedido();
					lp.setId_pedido(rs.getInt("id_pedido"));
					lp.setId_producto(rs.getInt("id_producto"));
					lp.setCantidad(rs.getInt("cantidad"));
					
					lineas.add(lp);
				}
			}
			
		} catch (SQLException sqe) {
			lineas.clear();
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
				lineas.clear();
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
			}
		}
		return lineas;
	}

	
	public void add(LineaDePedido lp) { 
		PreparedStatement stmt= null;
		//ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into lineapedido( id_pedido,id_producto,cantidad) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			stmt.setInt(1, lp.getId_pedido());
			stmt.setDouble(2, lp.getId_producto());
			stmt.setInt(3, lp.getCantidad());
			
						
			stmt.executeUpdate();
			
		}  catch (SQLException sqe) {
			System.out.println("Error Code = " + sqe.getErrorCode());
			System.out.println("SQL state = " + sqe.getSQLState());
			System.out.println("Message = " + sqe.getMessage());
			System.out.println("");
			sqe.printStackTrace();
		} finally {
            try {
                //if(keyResultSet!=null)keyResultSet.close();
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

	public LineaDePedido deleteLineaDePedido (LineaDePedido lp) {
			
			PreparedStatement stmt= null;
			//ResultSet keyResultSet=null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"delete from lineapedido where lineapedido.id_producto=? and lineapedido.id_pedido=?", PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, lp.getId_producto());
				stmt.setInt(2, lp.getId_pedido());
				
				stmt.executeUpdate();
			} catch (SQLException sqe) {
				System.out.println("Error Code = " + sqe.getErrorCode());
				System.out.println("SQL state = " + sqe.getSQLState());
				System.out.println("Message = " + sqe.getMessage());
				System.out.println("");
				sqe.printStackTrace();
			} finally {
	        try {
	        	//if(keyResultSet!=null)keyResultSet.close();
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
		return lp;
		}
	
	public LinkedList<LineaDePedido> getByPedido(Pedido ped){
		
		LinkedList<LineaDePedido> lineas1= new LinkedList<LineaDePedido>();
		LinkedList<LineaDePedido> lineas2= new LinkedList<LineaDePedido>();
		lineas1= this.getAll();
		for (LineaDePedido lp: lineas1) {
			if(lp.getId_pedido()==ped.getIdPedido()) {
				lineas2.add(lp);
			}
		}
		
		return lineas2;
	}
}