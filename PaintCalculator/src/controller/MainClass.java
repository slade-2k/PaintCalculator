package controller;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import gui.GUIClass;

public class MainClass {
	
	public GUIClass gui;
	final private double gallon = 32.5; 
	
	public static void main(String args[]){
		MainClass mainClass = new MainClass();
		GUIClass gui = new GUIClass(mainClass);
	}
	
	public int calcGallons(JFormattedTextField length, JFormattedTextField width){
		if(checkFields(length, width)){
			double squareMeter = Double.parseDouble(length.getText()) * Double.parseDouble(width.getText());
			double gallonsNeeded = squareMeter/gallon;
			int result = (int) gallonsNeeded;
			double rest = squareMeter % gallon;
			if(rest > 0){
				result += 1;
			}
			return result;
			
		} else {
			JOptionPane.showMessageDialog(gui, "Beide Felder müssen mit Werten größer 0 gefüllt sein.");
			length.setText("");
			width.setText("");
			return 0;
		}
	}
	
	private Boolean checkFields(JFormattedTextField length, JFormattedTextField width){
		if(length.getText().isEmpty() || width.getText().isEmpty()){
			return false;
		}
		else if(Double.parseDouble(length.getText()) <= 0 || Double.parseDouble(width.getText()) <= 0){
			return false;
		}
		else{
			return true;
		}
	}
}
