package ventanas;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogGestionRecursosHumanos extends JDialog {
     private JTextField txtCodigoRecursos;
	private JTextField txtNombreApellidos;
	private JTextField txtCargo;
        private JTextField txtEspecialidad;
	private JTable tbListaRecursosHumanos;
        public static void main(String[] args) {
		try {
			DialogGestionRecursosHumanos dialog = new DialogGestionRecursosHumanos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   public DialogGestionRecursosHumanos () {
            setTitle("GESTION DE RecursosHumanos");
		setBounds(100, 100, 633, 313);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de RecursosHumanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 239, 214);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoRecursos = new JTextField();
		txtCodigoRecursos.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoRecursos);
		txtCodigoRecursos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 24, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre y Apellidos");
		lblNewLabel_4.setBounds(10, 50, 112, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cargo");
		lblNewLabel_5.setBounds(10, 75, 112, 14);
		panel.add(lblNewLabel_5);
                JLabel lblNewLabel_6 = new JLabel("Especialidad");
		lblNewLabel_6.setBounds(10,100 , 112, 14);
		panel.add(lblNewLabel_6);
		
		txtNombreApellidos = new JTextField();
		txtNombreApellidos.setBounds(132, 50, 86, 20);
		panel.add(txtNombreApellidos);
		txtNombreApellidos.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(132, 75, 86, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
                txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(132, 100, 86, 20);
		panel.add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.setCodigoRecursos(txtCodigoRecursos.getText());
				objetoRecursosHumanos.setNombreApellidos(txtNombreApellidos.getText());
				objetoRecursosHumanos.setCargo(txtCargo.getText());
                                objetoRecursosHumanos.setEspecialidad(txtEspecialidad.getText());
				objetoRecursosHumanos.agregarRegistrosRecursosHumanos();
			}
		});
                    btnGuardar.setBounds(10, 140, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.EditarRecursosHumanos(tbListaRecursosHumanos);
			}
		});
		btnEditar.setBounds(109, 140, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.EliminarRecursosHumanos(tbListaRecursosHumanos, txtCodigoRecursos);
			}
		});
		btnEliminar.setBounds(10, 168, 208, 29);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de RecursosHumanos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 136);
		panel_1.add(scrollPane);
		
		tbListaRecursosHumanos = new JTable();
		scrollPane.setViewportView(tbListaRecursosHumanos);
		
		JButton btnCrearArchivoMedicamentos = new JButton("Crear Archivo RRHH");
		btnCrearArchivoMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Medicamentos objetoMedicamentos= new clases.Medicamentos();
				objetoMedicamentos.crearArchivoMedicamentos();
			}
		});
		btnCrearArchivoMedicamentos.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoMedicamentos);
		
		JButton btnMostrarCompras = new JButton("Mostrar Lista RecursosHumanos");
		btnMostrarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				objetoRecursosHumanos.MostrarTotalRecursosHumanos(tbListaRecursosHumanos);
			}
		});
		btnMostrarCompras.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarCompras);
		
		JButton btnSeleccionar = new JButton("Seleccionar ");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.RecursosHumanos objetoRecursosHumanos = new clases.RecursosHumanos();
				
				objetoRecursosHumanos.seleccionarRecursosHumanos(tbListaRecursosHumanos);
				txtCodigoRecursos.setText(objetoRecursosHumanos.getCodigoRecursos());
				txtNombreApellidos.setText(objetoRecursosHumanos.getNombreApellidos());
				txtCargo.setText(objetoRecursosHumanos.getCargo());
                                txtEspecialidad.setText(objetoRecursosHumanos.getEspecialidad());
			}
		});
		btnSeleccionar.setBounds(443, 20, 164, 23);
		getContentPane().add(btnSeleccionar);
	}
}
