package fes.aragon.inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fes.aragon.pila.Pila;

public class Inicio extends JFrame {
	
	private JPanel contentPane;
	JLabel lblPostfija = new JLabel("Postfija:");
	private JTextField textField;
	private JTextField Resultado;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPostfija, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPostfija, 28, SpringLayout.WEST, contentPane);
		contentPane.add(lblPostfija);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 9, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 11, SpringLayout.EAST, lblPostfija);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 516, SpringLayout.EAST, lblPostfija);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Resultado = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, Resultado, 149, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Resultado, -148, SpringLayout.EAST, contentPane);
		Resultado.setEditable(false);
		Resultado.setBackground(Color.PINK);
		contentPane.add(Resultado);
		Resultado.setColumns(10);
		
		JButton btnAwebo = new JButton("Awebo");
		btnAwebo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = textField.getText();
				String[] arg = cadena.split(" ");
				operacionPosfija(arg);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, Resultado, 33, SpringLayout.SOUTH, btnAwebo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAwebo, 27, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAwebo, 275, SpringLayout.WEST, contentPane);
		contentPane.add(btnAwebo);
	}
	private void operacionPosfija(String[] cadena) {
		Pila<Float> pila = new Pila<>();
		float valor = 0.0f;
		for (int i = 0; i<cadena.length; i++){
			String simbolo =  cadena[i];
			if (!simbolo.equals("+") && !simbolo.equals("-") && !simbolo.equals("*") && !simbolo.equals("/")) {
				pila.insertar(Float.parseFloat(simbolo));
			} else {
				float oper1 = pila.sacar();
				float oper2 = pila.sacar();
				if( simbolo.equals("+")) {
					valor = oper1+oper2;
				}
				else if( simbolo.equals("-")) {
					valor = oper1-oper2;
				}
				else if( simbolo.equals("*")) {
					valor = oper1*oper2;
				}
				else if(simbolo.equals("/")) {
					valor = oper1/oper2;
				}else{
					valor= (float)Math.pow(oper1, oper2);
				}
				pila.insertar(valor);
			}
		}
		Resultado.setText(String.valueOf(pila.sacar()));
	}
}
