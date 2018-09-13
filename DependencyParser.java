import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.BasicDependenciesAnnotation;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.util.CoreMap;
import javax.swing.JTextArea;
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

public class DependencyParser {

private JFrame frmWordTokenization;
private File s2;
private JTextField textField_1;
private ArrayList<String> ali;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DependencyParser window = new DependencyParser();
					window.frmWordTokenization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DependencyParser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWordTokenization = new JFrame();
		frmWordTokenization.setVisible(true);
		frmWordTokenization.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWordTokenization.setTitle("Dependency Parser");
		frmWordTokenization.setBounds(-7, -1, 1382, 736);
		frmWordTokenization.getContentPane().setLayout(null);
		JButton btnBrowse = new JButton("Browse");
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(10, 60, 636, 604);
				frmWordTokenization.getContentPane().add(textArea);
				textArea.setEditable(false);
				

				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setDialogTitle("Select an text file");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT and DOC Files", "txt", "doc");
				fileChooser.addChoosableFileFilter(filter);
				
				
				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
				textField_1.setText(fileChooser.getSelectedFile().getAbsolutePath());
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
				scroll.setBounds(10, 60, 636, 604);
				frmWordTokenization.getContentPane().add(scroll);
				
			}
		});
		btnBrowse.setBounds(10, 30, 89, 23);
		frmWordTokenization.getContentPane().add(btnBrowse);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
                        		 ArrayList<String> al =ali; 
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
		btnSave.setBounds(1017, 663, 89, 23);
		frmWordTokenization.getContentPane().add(btnSave);
		
		JButton btnWordTokenization = new JButton("Dependency Parser");
		btnWordTokenization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i=0;
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea_1.setBounds(726, 58, 626, 599);
				frmWordTokenization.getContentPane().add(textArea_1);
				textArea_1.setEditable(false);
				try{
					ArrayList<String> all=depen();
					ali=all;
					Iterator<String> mylist=all.iterator();
					while(mylist.hasNext())
					{
						textArea_1.append("Line"+i+": ");
						textArea_1.append(mylist.next());
						textArea_1.append("\n");
						i++;
}
					}catch(Exception e){
						System.out.println(e);
					}
				JScrollPane scroll = new JScrollPane(textArea_1);
				scroll.setBounds(726, 58, 626, 599);
				frmWordTokenization.getContentPane().add(scroll);
				
			}
		});
		btnWordTokenization.setBounds(342, 30, 153, 23);
		frmWordTokenization.getContentPane().add(btnWordTokenization);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 31, 194, 20);
		frmWordTokenization.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
	
	
	
	public ArrayList<String> depen() throws Exception
	{
		File s4=s2;
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		Scanner sc=new Scanner(s4);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();
			while(sc.hasNextLine()){
				String s1=sc.nextLine(); 
				Annotation document = new Annotation(s1);
		        pipeline.annotate(document);
		        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
		        for (CoreMap sentence : sentences) {
		        	SemanticGraph graph = sentence.get(BasicDependenciesAnnotation.class);
	        	     //System.out.println(graph.toString()); 
	        	     //pw1.write(text+"\n");
	        	     for(SemanticGraphEdge e:graph.edgeListSorted())
	        	 	{
	        	    	 
	                 	list.add(e.getRelation().toString()+"--->"+e.getGovernor().value()+"--->"+e.getGovernor().tag()+"--->"+e.getDependent().value()+"--->"
	        	    	 +e.getDependent().tag()+"\n");
	        	 	}
		                	}
		        	list1.add(list.toString());
		        	list.clear();
		        }
			return list1  ;
	}


	
	
}
