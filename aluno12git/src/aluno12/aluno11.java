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

public class aluno11 extends JFrame implements ActionListener{

	private JPanel painel1 = new JPanel (new GridLayout(14, 10)),
			painel2 = new JPanel ();


	private JButton btnSalvar = new JButton("Salvar"),
			btnFechar = new JButton ("Fechar"),
			btnLimpar = new JButton ("Limpar"),
			btnCalcular = new JButton ("Calcular");

	private JLabel lblNome = new JLabel (" Nome do Aluno"),
			lblRg = new JLabel(" RG"),
			lblCpf= new JLabel (" CPF"),
			lblEndereco = new JLabel (" Endereço"),
			lblDisciplina = new JLabel (" Disciplina"),
			lblCargaH = new JLabel (" Carga Horária da disciplina"),
			lblNota1 = new JLabel (" Nota da Primeira Etapa"),
			lblNota2 = new JLabel (" Nota da Segunda Etapa"),
			lblNota3 = new JLabel (" Nota da Terceira Etapa"),
			lblNota4 = new JLabel (" Nota da Quarta Etapa"),
			lblResultado = new JLabel (" Resultado");

	private JTextField txtNome = new JTextField(),
			txtRg = new JTextField (),
			txtCpf = new JTextField (),
			txtEndereco = new JTextField (),
			txtNota1 = new JTextField (),
			txtNota2 = new JTextField (),
			txtNota3 = new JTextField (),
			txtNota4 = new JTextField (),
			txtResultado= new JTextField ();

	private JComboBox cbDisciplina= new JComboBox (),
			cbCargaH= new JComboBox ();

	private String nomeServidor = "//localhost",
			porta = ":3306/",
			bd = "projeto?useSSL=false",
			url = "jdbc:mysql:",
			usuario = "root",
			senha = "root";

	private Connection conexao;
	private Statement stm;



	public aluno11 (){
		painel1.add(lblNome);
		painel1.add(txtNome);
		painel1.add(lblRg);
		painel1.add(txtRg);
		painel1.add(lblCpf);
		painel1.add(txtCpf);
		painel1.add(lblEndereco);
		painel1.add(txtEndereco);

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
		cbDisciplina.setSelectedItem(null);
		cbCargaH.setSelectedItem(null);
		this.setTitle ("Média Dos Alunos");
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

		lblNome.setFont(new  Font("", Font.BOLD, 17));
		lblRg.setFont(new  Font("", Font.BOLD, 17));
		lblCpf.setFont(new  Font("", Font.BOLD, 17));
		lblEndereco.setFont(new  Font("", Font.BOLD, 17));
		lblDisciplina.setFont(new  Font("", Font.BOLD, 17));
		lblCargaH.setFont(new  Font("", Font.BOLD, 17));
		lblNota1.setFont(new  Font("", Font.BOLD, 17));
		lblNota2.setFont(new  Font("", Font.BOLD, 17));
		lblNota3.setFont(new  Font("", Font.BOLD, 17));
		lblNota4.setFont(new  Font("", Font.BOLD, 17));
		lblResultado.setFont(new  Font("", Font.BOLD, 17));


	}
	public void limpar(){
		txtNome.setText("");
		txtRg.setText("");
		txtCpf.setText("");
		txtEndereco.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota4.setText("");
		txtResultado.setText("");

	}



	public void salvar(){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(
					url, usuario, senha);
			stm = conexao.createStatement();
			stm.executeUpdate("insert into projeto"
					+"(nome, rg, cpf, endereco, disciplina, cargah, nota1, nota2, nota3, nota4)"
					+ "values ('" +"" + txtNome.getText() + ", ' " + txtRg.getText() + "', '" + txtCpf.getText() + "', '" + txtEndereco.getText()
					+"', '" + txtNota1.getText() + "', '" + txtNota2.getText() + 
					"', " + txtNota3.getText()+", '"	+ txtNota4.getText() + "'')");

			limpar ();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!"	); 
			stm.close();


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
			txtNome.setText("");
			txtRg.setText("");
			txtCpf.setText("");
			txtEndereco.setText("");
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
		aluno11 f = new aluno11 ();
		f.setVisible(true);
		f.setSize(500,600); // tamanho da janela


	}
}