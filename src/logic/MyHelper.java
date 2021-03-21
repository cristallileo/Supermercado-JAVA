package logic;

import java.sql.Date;

public class MyHelper {

	public MyHelper(){
		
	}
	
	public void verificarFechas (Date desde, Date hasta) throws CustomException{
		if (desde.after(hasta)) {
			throw new CustomException("La fecha de comienzo no puede ser posterior a la fecha de fin.");
		}
	}
	
	
}
