/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diseasediagnosis;

import Ontology.Parser;
import bayesianNetwork.Inference;
import chatBot.AnswerProcessor;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.lucene.queryparser.classic.ParseException;
import chatBot.*;
import datastructures.Disease;
import datastructures.DiseaseProbabilityBean;
import datastructures.DiseaseSymptom;

/**
 *
 * @author Karol Abramczyk
 */
public class DiagnosisApp extends JFrame {
	public static final String NEWLINE = "\n";
	public static final String SAMPLE_ANSWER = "I am coughing and sneezing, i have fever, my muscles are paining, i feel weak,"
			+ " i am loosing hair and vomit, my head is itching, i have skin lesions and i have diarrhea";
	public static final String SHORT_ANSWER = "I am sneezing";
	private DataModel data;
	private ChatBot chatbot;

	public DiagnosisApp(DataModel data, Map <String, Disease> diseases, Map <String, DiseaseSymptom> symptoms) {
		super();
		this.data = data;
		Inference engine = new Inference(diseases, symptoms);
		chatbot = new ChatBot(this, data, engine);
		
		initComponents();
		chatbot.invitation();
		//textField.setText(SHORT_ANSWER);
		textField.requestFocus();
	}

	public void log(String text) {
		//        logger.setForeground(Color.BLUE);
		logger.append(text);
	}

	public void log(String text, Color color) {
		logger.setForeground(color);
		logger.append(text);
	}

	public void logln(String text) {
		//        logger.setForeground(Color.BLUE);
		logger.append(text + NEWLINE);
	}

	public void logln(String text, Color color) {
		logger.setForeground(color);
		logger.append(text + NEWLINE);
	}

	/**
	 * Main method of the application.
	 * @param args application call parameters.
	 */
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Parser parser = new Parser();
				try {
					//	parser.parseOntology("resources/ontology/HumanDO_no_xrefs.obo"); //D: 362, S: 715
					//	parser.parseOntology("resources/ontology/DO_logical_def.obo");//D: 287, S: 582
					//	parser.parseOntology("resources/ontology/HumanDO_xp.obo");//D: 388, S:768
					parser.parseOntology("resources/ontology/HumanDO.obo"); //D: 388, S:777
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DataModel data = new DataModel();
				data.setSymptoms(parser.getSymptoms());
				data.setSymptomNames( parser.getSymptoms().keySet().toArray(new String[parser.getSymptoms().size()]));
				//                    data.setSymptomNames(parser.getSymptoms());
				new DiagnosisApp(data, parser.getDiseases(), parser.getSymptoms()).setVisible(true);
			}
		});
	}

	/**
	 * Creates new form DiagnosisApp
	 */
	public DiagnosisApp() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		logger = new javax.swing.JTextArea();
		textField = new javax.swing.JTextField();
		textField.addActionListener(chatbot);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		logger.setEditable(false);
		logger.setBackground(new java.awt.Color(153, 153, 153));
		logger.setColumns(20);
		logger.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		logger.setForeground(new java.awt.Color(0, 0, 0));
		logger.setRows(5);
		logger.setToolTipText("");
		jScrollPane1.setViewportView(logger);

		textField.setBackground(new java.awt.Color(153, 153, 153));
		textField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		textField.setForeground(new java.awt.Color(0, 0, 0));
		textField.setToolTipText("Enter text here");
		textField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
								.addComponent(textField))
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea logger;
	private javax.swing.JTextField textField;
	// End of variables declaration//GEN-END:variables

	public javax.swing.JTextArea getLogger() {
		return logger;
	}

	public javax.swing.JTextField getTextField() {
		return textField;
	}


}
