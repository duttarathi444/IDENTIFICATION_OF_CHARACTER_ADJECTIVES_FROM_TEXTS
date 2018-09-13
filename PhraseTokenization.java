import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Phrase {

	private JFrame frmPhraseTokenization;
	private File s2;
private boolean adjpbo;
private JTextField textField;
private ArrayList ali;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phrase window = new Phrase();
					window.frmPhraseTokenization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Phrase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhraseTokenization = new JFrame();
		frmPhraseTokenization.setTitle("Phrase Tokenization");
		frmPhraseTokenization.setVisible(true);
		frmPhraseTokenization.setBounds(-7, -1, 1382, 736);
		frmPhraseTokenization.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPhraseTokenization.getContentPane().setLayout(null);
		
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(10, 74, 636, 578);
				frmPhraseTokenization.getContentPane().add(textArea);
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
				scroll.setBounds(10, 74, 636, 578);
				frmPhraseTokenization.getContentPane().add(scroll);
			}
		});
		btnBrowse.setBounds(10, 40, 89, 23);
		frmPhraseTokenization.getContentPane().add(btnBrowse);
		
		JCheckBox chckbxAdjpAdjectivePhrase = new JCheckBox("ADJP");		
		chckbxAdjpAdjectivePhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				boolean adjpb=true;
				adjpbo=adjpb;
			}
		});
		chckbxAdjpAdjectivePhrase.setBounds(10, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxAdjpAdjectivePhrase);
		
		JCheckBox chckbxAdvpAdverbPhrase = new JCheckBox("ADVP");
		chckbxAdvpAdverbPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxAdvpAdverbPhrase.setBounds(73, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxAdvpAdverbPhrase);
		
		JCheckBox chckbxConjpConjunctionPhrase = new JCheckBox("CONJP");
		chckbxConjpConjunctionPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxConjpConjunctionPhrase.setBounds(137, 7, 71, 23);
		frmPhraseTokenization.getContentPane().add(chckbxConjpConjunctionPhrase);
		
		JCheckBox chckbxFragFragment = new JCheckBox("FRAG");
		chckbxFragFragment.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxFragFragment.setBounds(210, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxFragFragment);
		
		JCheckBox chckbxIntjInterjection = new JCheckBox("INTJ");
		chckbxIntjInterjection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
			}
		});
		chckbxIntjInterjection.setBounds(274, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxIntjInterjection);
		
		JCheckBox chckbxLstListMarker = new JCheckBox("LST");
		chckbxLstListMarker.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxLstListMarker.setBounds(338, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxLstListMarker);
		
		JCheckBox chckbxNacNotA = new JCheckBox("NAC");
		chckbxNacNotA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxNacNotA.setBounds(402, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxNacNotA);
		
		JCheckBox chckbxNpNounPhrase = new JCheckBox("NP");
		chckbxNpNounPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxNpNounPhrase.setBounds(466, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxNpNounPhrase);
		
		JCheckBox chckbxNxComplexNps = new JCheckBox("NX");
		chckbxNxComplexNps.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxNxComplexNps.setBounds(524, 7, 63, 23);
		frmPhraseTokenization.getContentPane().add(chckbxNxComplexNps);
		
		JCheckBox chckbxPpPrepositionalPhrase = new JCheckBox("PP");
		chckbxPpPrepositionalPhrase.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPpPrepositionalPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxPpPrepositionalPhrase.setBounds(575, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxPpPrepositionalPhrase);
		
		JCheckBox chckbxPrnParenthetical = new JCheckBox("PRN");
		chckbxPrnParenthetical.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxPrnParenthetical.setBounds(638, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxPrnParenthetical);
		
		JCheckBox chckbxPrtParticle = new JCheckBox("PRT");
		chckbxPrtParticle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxPrtParticle.setBounds(701, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxPrtParticle);
		
		JCheckBox chckbxQpQuantifierPhrase = new JCheckBox("QP");
		chckbxQpQuantifierPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxQpQuantifierPhrase.setBounds(764, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxQpQuantifierPhrase);
		
		JCheckBox chckbxRrcReducedRelative = new JCheckBox("RRC");
		chckbxRrcReducedRelative.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxRrcReducedRelative.setBounds(828, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxRrcReducedRelative);
		
		JCheckBox chckbxUcpUnlikeCoordinated = new JCheckBox("UCP");
		chckbxUcpUnlikeCoordinated.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxUcpUnlikeCoordinated.setBounds(891, 7, 62, 23);
		frmPhraseTokenization.getContentPane().add(chckbxUcpUnlikeCoordinated);
		
		JCheckBox chckbxVpVerebPhrase = new JCheckBox("VP");
		chckbxVpVerebPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxVpVerebPhrase.setBounds(955, 7, 53, 23);
		frmPhraseTokenization.getContentPane().add(chckbxVpVerebPhrase);
		
		JCheckBox chckbxWhadjpWhadjectivePhrase = new JCheckBox("WHADJP");
		chckbxWhadjpWhadjectivePhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxWhadjpWhadjectivePhrase.setBounds(1010, 7, 78, 23);
		frmPhraseTokenization.getContentPane().add(chckbxWhadjpWhadjectivePhrase);
		
		JCheckBox chckbxWhavpWhadverbPhrase = new JCheckBox("WHAVP");
		chckbxWhavpWhadverbPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxWhavpWhadverbPhrase.setBounds(1090, 7, 78, 23);
		frmPhraseTokenization.getContentPane().add(chckbxWhavpWhadverbPhrase);
		
		JCheckBox chckbxWhnpWhnounPhrase = new JCheckBox("WHNP");
		chckbxWhnpWhnounPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxWhnpWhnounPhrase.setBounds(1170, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxWhnpWhnounPhrase);
		
		JCheckBox chckbxWhppWhprepositionalPhrase = new JCheckBox("WHPP");
		chckbxWhppWhprepositionalPhrase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxWhppWhprepositionalPhrase.setBounds(1233, 7, 61, 23);
		frmPhraseTokenization.getContentPane().add(chckbxWhppWhprepositionalPhrase);
		
		JCheckBox chckbxXUnknown = new JCheckBox("X");
		chckbxXUnknown.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		chckbxXUnknown.setBounds(1296, 7, 38, 23);
		frmPhraseTokenization.getContentPane().add(chckbxXUnknown);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=0;
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(676, 74, 676, 578);
				frmPhraseTokenization.getContentPane().add(textArea);
				textArea.setEditable(false);
			/*	try{
					ArrayList all= ();
					Iterator<String> mylist=all.iterator();
					
					while(mylist.hasNext())
					{
						textArea.append("Line"+i+": ");
						textArea.append(mylist.next());
						textArea.append("\n");
						i++;
						
					}
					
					}
				
				catch(Exception ex){
						System.out.println(ex);
					}
					JScrollPane scroll = new JScrollPane(textArea);
					scroll.setBounds(726, 58, 626, 599);
					frame.getContentPane().add(scroll);	*/
			}
		});
		btnExecute.setBounds(284, 663, 89, 23);
		frmPhraseTokenization.getContentPane().add(btnExecute);
		
		
		JButton btnPhraseTag = new JButton("Phrase Tag");
		btnPhraseTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=0;
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(676, 74, 676, 578);
				frmPhraseTokenization.getContentPane().add(textArea);
				textArea.setEditable(false);
				try{
					ArrayList all= PhraseToken();
					ali=all;
					Iterator<String> mylist=all.iterator();
					
					while(mylist.hasNext())
					{
						textArea.append("Line"+i+": ");
						textArea.append(mylist.next());
						textArea.append("\n");
						i++;
						
					}
					
					}
				
				catch(Exception ex){
						System.out.println(ex);
					}
					JScrollPane scroll = new JScrollPane(textArea);
					scroll.setBounds(676, 74, 676, 578);
					frmPhraseTokenization.getContentPane().add(scroll);	
				
			}
		});
		btnPhraseTag.setBounds(348, 40, 111, 23);
		frmPhraseTokenization.getContentPane().add(btnPhraseTag);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File("/home/me/Documents"));
			    chooser.setDialogTitle("Specify a file to save");
				chooser.setAcceptAllFileFilterUsed(false);
			    chooser.addChoosableFileFilter(new FileNameExtensionFilter("text Documents", "txt"));
				chooser.setAcceptAllFileFilterUsed(true);
			    int retrival = chooser.showSaveDialog(null);
			    if (retrival == JFileChooser.APPROVE_OPTION) {
			    	
                         FileInputStream fis=null;
                         String str="";
                         try{
                        	 FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");	 
                        	 ArrayList al=ali;
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
		btnSave.setBounds(973, 663, 89, 23);
		frmPhraseTokenization.getContentPane().add(btnSave);
		
		
		
		textField = new JTextField();
		textField.setBounds(109, 41, 215, 20);
		frmPhraseTokenization.getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<String> PhraseToken() throws Exception
	{
		File s4=s2;
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		Scanner sc=new Scanner(s4);
		ArrayList<String> list = new ArrayList<String>();
			
			while(sc.hasNextLine()){
				String s1=sc.nextLine(); 
				Annotation document = new Annotation(s1);
		        pipeline.annotate(document);
		        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
		        for (CoreMap sentence : sentences) {
		        	ArrayList<String> list1=new ArrayList();
		        	
		             // String word = token.get(CoreAnnotations.TextAnnotation.class);
		        		Tree tree = sentence.get(TreeAnnotation.class);
			        	System.out.println(tree);
		              list.add(tree.toString());  
		         
		        
		        	//list.add(list1.toString());
		        }
	}
			return list  ;
	}
}
