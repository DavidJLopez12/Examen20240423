package principal.controllers;

import java.util.List;

import principal.entities.Contrato;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripcion", "Saldo", "Limite", "FechaFirma", "IdTipoContrato", "Usuario"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Contrato> contratos = (List<Contrato>) ControladorContrato.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < contratos.size(); i++) {
			Contrato contratos1 = contratos.get(i);
			datos[i][0] = contratos1.getId();
			datos[i][1] = contratos1.getDescripcion();
			datos[i][2] = contratos1.getSaldo();
			datos[i][3] = contratos1.getLimite();
			datos[i][4] = contratos1.getFechaFirma();
			datos[i][5] = contratos1.getIdTipoContrato();
			datos[i][6] = contratos1.getIdUsuario();

		}
		
		return datos;
	}
	
	
}
