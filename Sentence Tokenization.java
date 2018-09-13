import java.awt.EventQueue;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.BasicDependenciesAnnotation;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.trees.Dependency;
import edu.stanford.nlp.trees.HeadFinder;
import edu.stanford.nlp.trees.ModCollinsHeadFinder;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.trees.Trees;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.trees.tregex.*;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.util.*;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import java.lang.NullPointerException;
import java.nio.file.Files;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.Canvas;

import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class JavaDesign {

	protected static final String String = null;
	private JFrame frmSentenceTokenization;
	private JTextField textField;
	private JTextArea textArea;
	private File s2;
	private String sa;
	private ArrayList ali;
/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaDesign window = new JavaDesign();
					window.frmSentenceTokenization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaDesign() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frmSentenceTokenization = new JFrame();
		frmSentenceTokenization.setTitle("Sentence Tokenization");
		frmSentenceTokenization.setBounds(-7, -1, 1382, 736);
		frmSentenceTokenization.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSentenceTokenization.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(155, 61, 614, 603);
				frmSentenceTokenization.getContentPane().add(textArea);
				textArea.setEditable(false);

				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setDialogTitle("Select an text file");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT and DOC Files", "txt", "doc");
				fileChooser.addChoosableFileFilter(filter);
				
				
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
				textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
				File fi=fileChooser.getSelectedFile();
				s2=fi;
				try{
                    BufferedReader br = new BufferedReader(new FileReader(fi));
                    String s1="";
                    while((s1=br.readLine())!=null){
                        textArea.append("\n"+s1);
                   }
                   br.close();

				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}				
				}
				
				
				JScrollPane scroll = new JScrollPane(textArea);
				scroll.setBounds(155, 61, 614, 603);
				frmSentenceTokenization.getContentPane().add(scroll);
				
			}
		});
		frmSentenceTokenization.getContentPane().add(btnNewButton);
		btnNewButton.setBounds(10, 29, 89, 23);
		frmSentenceTokenization.getContentPane().add(btnNewButton);
		
		
		textField = new JTextField();
		textField.setBounds(109, 30, 205, 20);
		frmSentenceTokenization.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File("/home/me/Documents"));
			    chooser.setDialogTitle("Specify a file to save");
				chooser.setAcceptAllFileFilterUsed(false);
			    chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Documents", "txt"));
				chooser.setAcceptAllFileFilterUsed(true);
			    int retrival = chooser.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION) {
                         FileInputStream fis=null;
                         String str="";
                         try{
                        	 FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");	
             				ArrayList al =ali;
             				for(int i=0;i<al.size();i++)
             				{            					
             					fw.write("Line"+i+": ");
        			            fw.write(al.get(i).toString());
        			            fw.write("\n");
             				}             				
             				fw.close();			     
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
                         
			    }
			   
				
			}
		});
		btnSave.setBounds(1048, 668, 89, 23);
		frmSentenceTokenization.getContentPane().add(btnSave);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1362, 23);
		frmSentenceTokenization.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(Color.LIGHT_GRAY);
		mnFile.setForeground(Color.BLACK);
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mntmOpenFile.setBackground(Color.WHITE);
		mntmOpenFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmOpenFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.setBackground(Color.WHITE);
		mntmClose.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmClose);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setBackground(Color.WHITE);
		mntmSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As..");
		mntmSaveAs.setBackground(Color.WHITE);
		mntmSaveAs.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmSaveAll = new JMenuItem("Save All");
		mntmSaveAll.setBackground(Color.WHITE);
		mntmSaveAll.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmSaveAll);
		
		JMenuItem mntmResfresh = new JMenuItem("Resfresh");
		mntmResfresh.setBackground(Color.WHITE);
		mntmResfresh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmResfresh);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mntmRestart.setBackground(Color.WHITE);
		mntmRestart.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmRestart);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setBackground(Color.WHITE);
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setBackground(Color.LIGHT_GRAY);
		mnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.setForeground(Color.BLACK);
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setBackground(Color.WHITE);
		mntmUndo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.setBackground(Color.WHITE);
		mntmRedo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmRedo);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setBackground(Color.WHITE);
		mntmCut.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setBackground(Color.WHITE);
		mntmCopy.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setBackground(Color.WHITE);
		mntmPaste.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setBackground(Color.WHITE);
		mntmDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmDelete);
		
		JMenuItem mntmFindreplace = new JMenuItem("Find/Replace");
		mntmFindreplace.setBackground(Color.WHITE);
		mntmFindreplace.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEdit.add(mntmFindreplace);
		
		JMenu mnFormat = new JMenu("Format");
		mnFormat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFormat.setBackground(Color.LIGHT_GRAY);
		mnFormat.setForeground(Color.BLACK);
		menuBar.add(mnFormat);
		
		JMenuItem mntmWordWrap = new JMenuItem("Word Wrap");
		mntmWordWrap.setBackground(Color.WHITE);
		mntmWordWrap.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFormat.add(mntmWordWrap);
		
		JMenuItem mntmFont = new JMenuItem("Font...");
		mntmFont.setBackground(Color.WHITE);
		mntmFont.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFormat.add(mntmFont);
		
		JMenu mnVeiw = new JMenu("Veiw");
		mnVeiw.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnVeiw.setBackground(Color.LIGHT_GRAY);
		mnVeiw.setForeground(Color.BLACK);
		menuBar.add(mnVeiw);
		
		JMenuItem mntmStatusBar = new JMenuItem("Status Bar");
		mntmStatusBar.setBackground(Color.WHITE);
		mntmStatusBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnVeiw.add(mntmStatusBar);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHelp.setBackground(Color.LIGHT_GRAY);
		mnHelp.setForeground(Color.BLACK);
		menuBar.add(mnHelp);
		
		JMenuItem mntmVeiwHelp = new JMenuItem("Veiw Help");
		mntmVeiwHelp.setBackground(Color.WHITE);
		mntmVeiwHelp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHelp.add(mntmVeiwHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setBackground(Color.WHITE);
		mntmAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHelp.add(mntmAbout);
						
				
				JButton btnPhraseTokenization = new JButton("Phrase Tokenization");
				btnPhraseTokenization.setHorizontalAlignment(SwingConstants.LEFT);
				btnPhraseTokenization.setBounds(4, 142, 147, 21);
				frmSentenceTokenization.getContentPane().add(btnPhraseTokenization);
				btnPhraseTokenization.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Phrase wi = new Phrase();
						wi.setVisible(true);
					}
				});
								
				
				JButton btnPartOfSpeech = new JButton("Part of Speech");
				btnPartOfSpeech.setBounds(4, 120, 147, 21);
				frmSentenceTokenization.getContentPane().add(btnPartOfSpeech);
				btnPartOfSpeech.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					//	frame.dispose();
						P_f_s word=new P_f_s();
						word.setVisible(true);	
					}
				});
				
				
				JButton btnNewButton_1 = new JButton("Word Tokenization");
				btnNewButton_1.setBounds(4, 99, 147, 21);
				frmSentenceTokenization.getContentPane().add(btnNewButton_1);		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WordToken windo = new WordToken();
				windo.setVisible(true);
			}
		});
		
		
		
		
		
		JButton btnNewButton_6 = new JButton("Sentence Tokenization");
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setBounds(4, 78, 147, 21);
		frmSentenceTokenization.getContentPane().add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea_1.setBounds(779, 61, 573, 603);
				frmSentenceTokenization.getContentPane().add(textArea_1);
				textArea_1.setEditable(false);
				
				
				try{
				ArrayList al =SentenceToken();
				ali=al;
				for(int i=0;i<al.size();i++)
				{
					String text=al.get(i).toString();
					textArea_1.append("Line"+i+": ");
					textArea_1.append(text);
					textArea_1.append("\n");
				}
				}catch(Exception e){
					System.out.println(e);
				}
				
				JScrollPane scroll = new JScrollPane(textArea_1);
				scroll.setBounds(779, 61, 573, 603);
				frmSentenceTokenization.getContentPane().add(scroll);
			}
		});
		
	}

public  ArrayList<String> SentenceToken() throws Exception{	

	File s3=s2;
	Properties props = new Properties();
	props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	
	Scanner sc=new Scanner(s3);
ArrayList<String> list = new ArrayList<String>();
	
	while(sc.hasNextLine()){
		String s1=sc.nextLine(); 
		Annotation document = new Annotation(s1);
        pipeline.annotate(document);
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            	System.out.println(sentence.toString());
            	list.add(sentence.toString());
            	}

	}
	return list;
}

}
