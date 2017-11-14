package aluno12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class telaInicial extends JFrame implements ActionListener {
	private JPanel painel1 = new JPanel(),
				   botoes = new JPanel();
	private JLabel lblImagem= new JLabel (new ImageIcon ("logo.jpg"));
	private JButton btnFechar = new JButton ("Fechar"),
			        btnCadastro = new JButton ("Cadastro"),
					btnDisciplinas = new JButton ("Disciplinas"),
		            btnNotas= new JButton ("Notas");
	
	
	
	
	public telaInicial(){
	//setLayout(null);
    
    btnNotas.addActionListener(this);
    btnCadastro.addActionListener(this);
    btnDisciplinas.addActionListener(this);
    btnFechar.addActionListener(this);
	this.setTitle("Portal do Aluno");
	this.setVisible(true);
	this.setBounds(100,100,600,500);
	this.add(botoes, BorderLayout.SOUTH);
	botoes.setLayout(new GridLayout(1,2,5,5));	
	botoes.add(btnFechar);
	botoes.add(btnNotas);
	botoes.add(btnDisciplinas);
	botoes.add(btnCadastro);
    btnNotas.addActionListener(this);
	this.add(lblImagem, BorderLayout.CENTER);
	this.setBackground(Color.white);
	
	}

	public void actionPerformed (ActionEvent e){
		if(e.getSource() == btnFechar)
			System.exit(0);
if (e.getSource() == btnNotas){
	nota n = new nota ();
	n.setVisible(true);
	n.setSize(500,600);
}
else
	if (e.getSource() == btnCadastro){
		aluno a = new aluno ();
		a.setVisible(true);
		a.setSize(500,500);
		}
	else
		if (e.getSource() == btnDisciplinas){
			disciplina d = new disciplina ();
			d.setVisible(true);
			d.setSize(400,400);
			
		}
		}
	
	
	public static void main (String [] args){
		telaInicial ti = new telaInicial();
		
	}
}
// teste