package aluno12;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class disciplina extends JFrame implements ActionListener{

	private JPanel painel1 = new JPanel (new GridLayout(14, 20)),
			painel2 = new JPanel ();
	
	
	private JButton btnSalvar = new JButton("Salvar"),
			btnFechar = new JButton ("Fechar");
			
	
	private JLabel lblDisciplina = new JLabel (" Disciplina"),
			lblCargaH = new JLabel (" Carga Horária da disciplina");
	
	private JComboBox cbDisciplina= new JComboBox (),
			cbCargaH= new JComboBox ();
//	int largura = 100;
	//int altura = 21;
	//cbDisciplina.setPreferredSize( new Dimension(100,200) );
	
	public disciplina(){
		
		painel1.add(lblDisciplina);
		cbDisciplina.addItem("Português");
		cbDisciplina.addItem("Matemática");
		cbDisciplina.addItem("História");
		cbDisciplina.addItem("Ciências");
		cbDisciplina.addItem("Geografia");	
		painel1.add(cbDisciplina);

		painel1.add(lblCargaH);
		cbCargaH.addItem("180 Horas");
		cbCargaH.addItem("90 horas");
		painel1.add(cbCargaH);
		
		painel2.add(btnSalvar);
        painel2.add(btnFechar);
		
		cbDisciplina.setSelectedItem(null);
		cbCargaH.setSelectedItem(null);
		this.setTitle ("Disciplina");
		
		this.add(painel1, BorderLayout.CENTER);
		this.add(painel2, BorderLayout.SOUTH);
		this.setBounds(300, 200, 500, 220);
		
		btnSalvar.addActionListener(this);
	    btnFechar.addActionListener(this);
		
		
		painel1.setBackground(Color.white);
		painel2.setBackground(Color.white);
		this.setVisible(true);
		
		lblDisciplina.setFont(new  Font("", Font.BOLD, 17));
		lblCargaH.setFont(new  Font("", Font.BOLD, 17));
		
	}



	public void salvar(){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			//conexao = DriverManager.getConnection(
					//url, usuario, senha);
			//stm = conexao.createStatement();
			//stm.executeUpdate("insert into projeto"
			//		+"( disciplina, cargah)"
				//	+ "values ('" +""  + ", ' " +  "', '" +  "', '" 
				//	+"', '" + "', '" +  
	//				"', " + ", '"	+ "'')");

			

		}
		catch (Exception e ) {
			e.printStackTrace();
		}

		this.setVisible (true);
		
	}
		public void actionPerformed (ActionEvent e){

	if(e.getSource() == btnFechar)
		System.exit(0);
	}

		
		

public static void main(String[] args) {
	disciplina d = new disciplina ();
	d.setVisible(true);
	d.setSize(400,400); // tamanho da janela
	
}
}
	
	
	
	