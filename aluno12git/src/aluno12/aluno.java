package aluno12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class aluno extends JFrame implements ActionListener {
	
	private JPanel painel1 = new JPanel (new GridLayout(14, 10)),
			painel2 = new JPanel ();


	private JButton btnSalvar = new JButton("Salvar"),
			btnFechar = new JButton ("Fechar"),
			btnLimpar = new JButton ("Limpar");
	private JLabel lblNome = new JLabel (" Nome do Aluno"),
			lblRg = new JLabel(" RG"),
			lblCpf= new JLabel (" CPF"),
			lblEndereco = new JLabel (" Endereço");
	

	
	private JTextField txtNome = new JTextField(),
			txtRg = new JTextField (),
			txtCpf = new JTextField (),
			txtEndereco = new JTextField ();
	
	public aluno (){
		painel1.add(lblNome);
		painel1.add(txtNome);
		painel1.add(lblRg);
		painel1.add(txtRg);
		painel1.add(lblCpf);
		painel1.add(txtCpf);
		painel1.add(lblEndereco);
		painel1.add(txtEndereco);
		
		painel2.add(btnSalvar);
		painel2.add(btnLimpar);
		painel2.add(btnFechar);
		
		
		this.setTitle ("Cadastro do Aluno");
		
		this.add(painel1, BorderLayout.CENTER);
		this.add(painel2, BorderLayout.SOUTH);
		this.setBounds(300, 200, 500, 220);


		btnSalvar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnFechar.addActionListener(this);
		
		
		
		painel1.setBackground(Color.white);
		painel2.setBackground(Color.white);
		this.setVisible(true);

		
		lblNome.setFont(new  Font("", Font.BOLD, 17));
		lblRg.setFont(new  Font("", Font.BOLD, 17));
		lblCpf.setFont(new  Font("", Font.BOLD, 17));
		lblEndereco.setFont(new  Font("", Font.BOLD, 17));
		
		

}
	public void limpar(){
		txtNome.setText("");
		txtRg.setText("");
		txtCpf.setText("");
		txtEndereco.setText("");
		
	}
	public void salvar(){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			//conexao = DriverManager.getConnection(
				//	url, usuario, senha);
		//	stm = conexao.createStatement();
			//stm.executeUpdate("insert into projeto"
				//	+"(nome, rg, cpf, endereco)"
					//+ "values ('" +"" + txtNome.getText() + ", ' " + txtRg.getText() + "', '" + txtCpf.getText() + "', '" + txtEndereco.getText()
				//	+"', '"  + "', '"  + 
				//	"', " +", '"	 + "'')");

			//limpar ();
		//	JOptionPane.showMessageDialog(null, "Salvo com sucesso!"	); 
		//	//stm.close();


		}
		catch (Exception e ) {
			e.printStackTrace();
		}

		this.setVisible (true);
		
	}
	
		public void actionPerformed (ActionEvent e){
			
		
	if (e.getSource() == btnLimpar){
			txtNome.setText("");
			txtRg.setText("");
			txtCpf.setText("");
			txtEndereco.setText("");
			
			if(e.getSource() == btnFechar)
				System.exit(0);
	}
		}
	
	public static void main(String[] args) {
				aluno a = new aluno ();
				a.setVisible(true);
				a.setSize(500,500); // tamanho da janela


			
	}
		}

