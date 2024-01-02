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


public class DialogGestionCompras extends JDialog {
    private JTextField txtCodigoCompras;
	private JTextField txtNombreArticulo;
	private JTextField txtDescricion;
        private JTextField txtPecio;
	private JTable tbListaCompras;
        public static void main(String[] args) {
		try {
			DialogGestionCompras dialog = new DialogGestionCompras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   public DialogGestionCompras() {
            setTitle("GESTION DE COMPRAS");
		setBounds(100, 100, 633, 313);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 55, 239, 214);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigoCompras = new JTextField();
		txtCodigoCompras.setBounds(132, 24, 86, 20);
		panel.add(txtCodigoCompras);
		txtCodigoCompras.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 24, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Articulo");
		lblNewLabel_4.setBounds(10, 50, 112, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion");
		lblNewLabel_5.setBounds(10, 75, 112, 14);
		panel.add(lblNewLabel_5);
                JLabel lblNewLabel_6 = new JLabel("Precio");
		lblNewLabel_6.setBounds(10,100 , 112, 14);
		panel.add(lblNewLabel_6);
		
		txtNombreArticulo = new JTextField();
		txtNombreArticulo.setBounds(132, 50, 86, 20);
		panel.add(txtNombreArticulo);
		txtNombreArticulo.setColumns(10);
		
		txtDescricion = new JTextField();
		txtDescricion.setBounds(132, 75, 86, 20);
		panel.add(txtDescricion);
		txtDescricion.setColumns(10);
                txtPecio = new JTextField();
		txtPecio.setBounds(132, 100, 86, 20);
		panel.add(txtPecio);
		txtPecio.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.setCodigoCompras(txtCodigoCompras.getText());
				objetoCompras.setNombreArticulo(txtNombreArticulo.getText());
				objetoCompras.setDescripcion(txtDescricion.getText());
                                objetoCompras.setPrecio(txtPecio.getText());
				objetoCompras.agregarRegistrosCompras();
			}
		});
                    btnGuardar.setBounds(10, 140, 99, 23);
		panel.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras= new clases.Compras();
				objetoCompras.EditarCompras(tbListaCompras);
			}
		});
		btnEditar.setBounds(109, 140, 112, 23);
		panel.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.EliminarCompras(tbListaCompras, txtCodigoCompras);
			}
		});
		btnEliminar.setBounds(10, 168, 208, 29);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Lista de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(275, 54, 338, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 318, 136);
		panel_1.add(scrollPane);
		
		tbListaCompras = new JTable();
		scrollPane.setViewportView(tbListaCompras);
		
		JButton btnCrearArchivoCompras = new JButton("Crear Archivo de Conpras");
		btnCrearArchivoCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras= new clases.Compras();
				objetoCompras.crearArchivoCompras();
			}
		});
		btnCrearArchivoCompras.setBounds(10, 21, 239, 23);
		getContentPane().add(btnCrearArchivoCompras);
		
		JButton btnMostrarCompras = new JButton("Mostrar Compras");
		btnMostrarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				objetoCompras.MostrarTotalCompras(tbListaCompras);
			}
		});
		btnMostrarCompras.setBounds(275, 21, 158, 23);
		getContentPane().add(btnMostrarCompras);
		
		JButton btnSeleccionar = new JButton("Seleccionar ");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clases.Compras objetoCompras = new clases.Compras();
				
				objetoCompras.seleccionarCompras(tbListaCompras);
				txtCodigoCompras.setText(objetoCompras.getCodigoCompras());
				txtNombreArticulo.setText(objetoCompras.getNombreArticulo());
				txtDescricion.setText(objetoCompras.getDescripcion());
                                txtPecio.setText(objetoCompras.getPrecio());
			}
		});
		btnSeleccionar.setBounds(443, 20, 164, 23);
		getContentPane().add(btnSeleccionar);
	}
}
