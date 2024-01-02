package clases;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class RecursosHumanos {
String codigoRecursos;
String nombreApellidos;
String Cargo;
String Especialidad;
public String getCodigoRecursos () {
	return codigoRecursos;
}
public void setCodigoRecursos(String codigoRecursos) {
	this.codigoRecursos = codigoRecursos;
}
public String getNombreApellidos() {
	return nombreApellidos;
}
public void setNombreApellidos(String nombreApellidos) {
	this.nombreApellidos = nombreApellidos;
}
public String getCargo() {
	return Cargo;
}
public void setCargo(String tipoCargo) {
	this.Cargo = tipoCargo;
}
public String getEspecialidad(){
    return Especialidad;
}
public void setEspecialidad(String Especialidad) {
	this.Especialidad = Especialidad;
}
public void crearArchivoRecursosHumanos() {
	try {
		File objetoArchivo = new File("RecursosHumanos.txt");
		if(objetoArchivo.createNewFile()) {
			JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
		}
		else {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		}
		
	} catch (Exception e) {
		System.out.println("Ocurrió un error al crear el archivo");
		
	}
}
public void agregarRegistrosRecursosHumanos() {
	try {
		FileWriter fw = new FileWriter(" RecursosHumanos.txt",true);
		
		
		fw.write(getCodigoRecursos());
		fw.write(",");
		fw.write(getNombreApellidos());
		fw.write(",");
                fw.write(getCargo());
		fw.write(",");
		fw.write(getEspecialidad());
		fw.write("\n");
		fw.close();
		
		JOptionPane.showMessageDialog(null,"Se registro correctamente");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error al registrar" + e.toString());
	}
}
public void MostrarTotalRecursosHumanos(JTable tablaTotalRecursosHumanos) {
	
	String nombreArchivo = "Compras.txt";
	
	File file = new File(nombreArchivo);
	
	try {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String primeraLinea = br.readLine().trim();
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Codigo");
		model.addColumn("Nombre y Apellidos");
                model.addColumn("Cargo");
                model.addColumn("Especialidad");
		
		tablaTotalRecursosHumanos.setModel(model);
		
		Object[] tableLines = br.lines().toArray();
		
		for (int i = 0; i < tableLines.length; i++) {
			
			String line = tableLines[i].toString().trim();
			String[] datarow= line.split(",");
			model.addRow(datarow);
			tablaTotalRecursosHumanos.setModel(model);
		}
		
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
		
	}
}
public void seleccionarRecursosHumanos(JTable tablaRecursosHumanos) {
	
	try {
		
		int  fila = tablaRecursosHumanos.getSelectedRow();
		
		if (fila>=0) {
			
			setCodigoRecursos(tablaRecursosHumanos.getValueAt(fila, 0).toString());
			setNombreApellidos(tablaRecursosHumanos.getValueAt(fila, 1).toString());
			setCargo(tablaRecursosHumanos.getValueAt(fila, 2).toString());
                        setEspecialidad(tablaRecursosHumanos.getValueAt(fila, 3).toString());
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
	}
	
}
public void EliminarRecursosHumanos (JTable tablaCompras, JTextField codigoRecuros) {
	
	//Eliminaci�n visual de la tabla
	DefaultTableModel model = (DefaultTableModel)tablaCompras.getModel();
	
	for (int i = 0; i < model.getRowCount(); i++) {
		
		if(((String)model.getValueAt(i, 0)).equals(codigoRecuros.getText())) {	
			model.removeRow(i);
			break;
			
		}
	}
	//Limpieza del archivo .txt
	
	try {
		PrintWriter writer = new PrintWriter("RecursosHumanos.txt");
		writer.print("");
		writer.close();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
	}
	
	//Creaci�n de los nuevos registros luego de la eliminaci�n
	
	try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RecursosHumanos.txt")))) {
		StringJoiner joiner = new StringJoiner(",");
		
		for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
			joiner.add(tablaCompras.getColumnName(col));
		}
		
		System.out.println(joiner.toString());
		bw.write(joiner.toString());
		bw.newLine();
		
		for (int row = 0; row < tablaCompras.getRowCount(); row++) {
			 joiner = new StringJoiner(",");		
			for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
				
				Object obj = tablaCompras.getValueAt(row, col);
				String value = obj == null ? "null" :obj.toString();
				joiner.add(value);
				
			}
			
			
			bw.write(joiner.toString());
			bw.newLine();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente");
		}

		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error");
	}
	
	
	
}
public void EditarRecursosHumanos(JTable tablaCompras) {
	
	//Limpieza del archivo .txt
	
		try {
			PrintWriter writer = new PrintWriter("RecursosHumanos.txt");
			writer.print("");
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Ocurrió un problema"+ e.toString());
		}
		
		//Creaci�n de los nuevos registros luego de la eliminaci�n
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RecursosHumanos.txt")))) {
			StringJoiner joiner = new StringJoiner(",");
			for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
				joiner.add(tablaCompras.getColumnName(col));
			}
			
			System.out.println(joiner.toString());
			bw.write(joiner.toString());
			bw.newLine();
			
			for (int row = 0; row < tablaCompras.getRowCount(); row++) {
				joiner = new StringJoiner(",");
				for (int col = 0; col < tablaCompras.getColumnCount(); col++) {
					
					Object obj = tablaCompras.getValueAt(row, col);
					String value = obj == null ? "null" :obj.toString();
					joiner.add(value);
					
				}
				
				System.out.println(joiner.toString());
				bw.write(joiner.toString());
				bw.newLine();
				//JOptionPane.showMessageDialog(null, "Se modific� correctamente");
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error");
		}
		
}
}
