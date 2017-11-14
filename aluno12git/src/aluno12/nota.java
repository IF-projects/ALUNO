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

public class nota extends JFrame implements ActionListener{

	private JPanel painel1 = new JPanel (new GridLayout(14, 10)),
			painel2 = new JPanel ();


	private JButton btnSalvar = new JButton("Salvar"),
			btnFechar = new JButton ("Fechar"),
			btnLimpar = new JButton ("Limpar"),
			btnCalcular = new JButton ("Calcular");
	
	private JLabel lblNota1 = new JLabel (" Nota da Primeira Etapa"),
			lblNota2 = new JLabel (" Nota da Segunda Etapa"),
			lblNota3 = new JLabel (" Nota da Terceira Etapa"),
			lblNota4 = new JLabel (" Nota da Quarta Etapa"),
			lblResultado = new JLabel (" Resultado");
	
	private JTextField txtNota1 = new JTextField (),
			txtNota2 = new JTextField (),
			txtNota3 = new JTextField (),
			txtNota4 = new JTextField (),
			txtResultado= new JTextField ();
	
	public nota (){
		painel1.add(lblNota1);
		painel1.add(txtNota1);
		painel1.add(lblNota2);
		painel1.add(txtNota2);
		painel1.add(lblNota3);
		painel1.add(txtNota3);
		painel1.add(lblNota4);
		painel1.add(txtNota4);
		painel1.add(lblResultado);
		painel1.add (txtResultado);

		painel2.add(btnSalvar);
		painel2.add(btnLimpar);
		painel2.add(btnFechar);
		painel2.add(btnCalcular);
		this.setTitle ("Média Do Aluno");
		txtResultado.setEditable(false);
		this.add(painel1, BorderLayout.CENTER);
		this.add(painel2, BorderLayout.SOUTH);
		this.setBounds(300, 200, 500, 220);

		btnSalvar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnFechar.addActionListener(this);
		btnCalcular.addActionListener(this);
		painel1.setBackground(Color.white);
		painel2.setBackground(Color.white);
		this.setVisible(true);
		
		lblNota1.setFont(new  Font("", Font.BOLD, 17));
		lblNota2.setFont(new  Font("", Font.BOLD, 17));
		lblNota3.setFont(new  Font("", Font.BOLD, 17));
		lblNota4.setFont(new  Font("", Font.BOLD, 17));
		lblResultado.setFont(new  Font("", Font.BOLD, 17));


	}
	public void limpar(){
	
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota4.setText("");
		txtResultado.setText("");

	}
	public void salvar(){
		try{
			////Class.forName("com.mysql.jdbc.Driver");
		//	conexao = DriverManager.getConnection(
				//	url, usuario, senha);
			//stm = conexao.createStatement();
			//stm.executeUpdate("insert into projeto"
					//+"( nota1, nota2, nota3, nota4)"
				//	+ //"values ('" +"" + ", ' " + "', '" +  "', '" 
					//+"', '" + txtNota1.getText() + "', '" + txtNota2.getText() + 
				//	"', " + txtNota3.getText()+", '"	+ txtNota4.getText() + "'')");

			limpar ();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!"	); 
			


		}
		catch (Exception e ) {
			e.printStackTrace();
		}

		this.setVisible (true);
	}


	public void actionPerformed (ActionEvent e){

		if (e.getSource() == btnCalcular ) {
			int nota1= Integer.parseInt(txtNota1.getText()),
					nota2= Integer.parseInt(txtNota2.getText()),
					nota3= Integer.parseInt(txtNota2.getText()),
					nota4= Integer.parseInt(txtNota2.getText()),
					resultado= (nota1+nota2+nota3+ nota4)/4;  

			if (resultado>=60){
				txtResultado.setText(txtResultado.getText()+"  Está aprovado com média = "+ resultado);
			}
			else 
				txtResultado.setText(txtResultado.getText()+"  Está reprovado com média = "+ resultado);

		}  

		if (e.getSource() == btnLimpar){
			
			txtNota1.setText("");
			txtNota2.setText("");
			txtNota3.setText("");
			txtNota4.setText("");
			txtResultado.setText("");
		}
		if (e.getSource()== btnSalvar){
			salvar();
		}
		else{
			JOptionPane.showMessageDialog(null, ""	); 
		}

		if(e.getSource() == btnFechar)
			System.exit(0);


	}


	public static void main(String[] args) {
		nota n = new nota ();
		n.setVisible(true);
		n.setSize(500,600); // tamanho da janela


	}
}


		
	
