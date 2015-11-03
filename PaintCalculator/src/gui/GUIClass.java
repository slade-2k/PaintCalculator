package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.text.NumberFormatter;

import controller.MainClass;

public class GUIClass extends JFrame {
	public GUIClass(MainClass mainClass){
		this.setSize(300, 400);
		this.setVisible(true);
		this.setTitle("Farb-Kalkulator");
		this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel lblWidth = new JLabel("Breite: ");
		JLabel lblLength = new JLabel("Länge: ");
		JLabel lblInstruc = new JLabel("Geben Sie die Maße des Raumes in Metern an.");
		JLabel lblResult = new JLabel();
		
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();
		symbol.setDecimalSeparator('.');
		DecimalFormat format = new DecimalFormat("#.##", symbol);
		NumberFormatter formatter = new NumberFormatter(format);
		
		JFormattedTextField txtWidth = new JFormattedTextField(formatter);
		JFormattedTextField txtLength = new JFormattedTextField(formatter);
		
		Dimension dTxt = new Dimension(200, 20);
		
		txtWidth.setMaximumSize(dTxt);
		txtLength.setMaximumSize(dTxt);
		lblResult.setPreferredSize(dTxt);
		
		JButton btnCalc = new JButton("Berechne");
		JButton btnReset = new JButton("Zurücksetzen");
		
		JPanel pnlResult = new JPanel();
		JPanel pnlInstruc = new JPanel();
		JPanel pnlWidth = new JPanel();
		JPanel pnlLength = new JPanel();
		JPanel pnlButtons = new JPanel();
		
		pnlResult.setLayout(new BoxLayout(pnlResult, BoxLayout.X_AXIS));
		pnlInstruc.setLayout(new BoxLayout(pnlInstruc, BoxLayout.X_AXIS));
		pnlWidth.setLayout(new BoxLayout(pnlWidth, BoxLayout.X_AXIS));
		pnlLength.setLayout(new BoxLayout(pnlLength, BoxLayout.X_AXIS));
		pnlButtons.setLayout(new BoxLayout(pnlButtons, BoxLayout.X_AXIS));
		
		getContentPane().add(pnlInstruc);
		getContentPane().add(pnlWidth);
		getContentPane().add(pnlLength);
		getContentPane().add(pnlResult);
		getContentPane().add(pnlButtons);

		
		pnlInstruc.add(lblInstruc);
		
		pnlWidth.add(lblWidth);
		pnlWidth.add(txtWidth);
		
		pnlLength.add(lblLength);
		pnlLength.add(txtLength);
		
		pnlButtons.add(btnCalc);
		pnlButtons.add(btnReset);
		
		pnlResult.add(lblResult);
		
		btnCalc.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("Es werden "+mainClass.calcGallons(txtLength, txtWidth)+" Eimer Farbe benötigt.");
			}
		});
		
		btnReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				txtWidth.setText("");
				txtLength.setText("");
				lblResult.setText("");
			}
		});
		validate();
	}
}
