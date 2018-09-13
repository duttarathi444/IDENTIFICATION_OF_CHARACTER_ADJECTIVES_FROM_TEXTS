import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class P_f_s {

	private JFrame frmBcsbcsdb;
	private File s2;
	private JTextArea textArea;
	private JCheckBox chckbxCcCoordinatingConjunction;
	private boolean ccbo=false,cdbo=false,dtbo=false,exbo=false,fwbo=false,inbo=false,jjbo=false,jjrbo=false,jjsbo=false,lsbo=false,nnbo=false,mdbo=false,nnsbo=false,nnpsbo=false,pdtbo=false,posbo=false,prpbo=false,prp$bo=false,rbbo=false,rbrbo=false,rbsbo=false,rpbo=false,symbo=false,tobo=false,uhbo=false,vbbo=false,vbdbo=false,vbgbo=false,vbnbo=false,vbpbo=false,vbzbo=false,wdtbo=false,wpbo=false,wp$bo=false,wrbbo=false;
	private String cc="CC",cd="CD",dt="DT",ex="EX",fw="FW",in="IN",jj="JJ",jjr="JJR",jjs="JJS",ls="LS",nn="NN",md="MD",nns="NNS",nnps="NNPS",pdt="PDT",pos="POS",prp="PRP",prp$="PRP$",rb="RB",rbr="RBR",rbs="RBS",rp="RP",sym="SYM",to="TO",uh="UH",vb="VB",vbd="VBD",vbg="VBG",vbn="VBN",vbp="VBP",vbz="VBZ",wdt="WDT",wp="WP",wp$="WP$",wrb="WRB",nnp="NNP";
    private int k=0;
    private String ar[]=new String[40];
	private boolean nnpbo=false;
private boolean pob,exeb;
private JTextField textField;
private ArrayList ali,alo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_f_s window = new P_f_s();
					window.frmBcsbcsdb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public P_f_s() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBcsbcsdb = new JFrame();
		frmBcsbcsdb.setTitle("Parts of Speech Tokenization");
		frmBcsbcsdb.setVisible(true);
		frmBcsbcsdb.setBounds(-7, -1, 1382, 736);
		frmBcsbcsdb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBcsbcsdb.getContentPane().setLayout(null);
		
		
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea_1.setBounds(110, 131, 604, 511);
				frmBcsbcsdb.getContentPane().add(textArea_1);
				textArea_1.setEditable(false);
				
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
                        textArea_1.append("\n"+s1);
                   }
                   br.close();

				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}	
				}
				JScrollPane scroll = new JScrollPane(textArea_1);
				scroll.setBounds(110, 131, 604, 511);
				frmBcsbcsdb.getContentPane().add(scroll);
			}
		});
		btnBrowse.setBounds(6, 63, 89, 23);
		frmBcsbcsdb.getContentPane().add(btnBrowse);
		
		
		chckbxCcCoordinatingConjunction = new JCheckBox("CC");
		chckbxCcCoordinatingConjunction.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				ccbo=true;
					ar[k++]=cc;
			}
		});
		chckbxCcCoordinatingConjunction.setBounds(6, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxCcCoordinatingConjunction);
		
		
		JCheckBox chckbxCdCardinalNumber = new JCheckBox("CD");
		chckbxCdCardinalNumber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				cdbo=true;
					ar[k++]=cd;
			}
		});
		chckbxCdCardinalNumber.setBounds(58, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxCdCardinalNumber);
		
		
		JCheckBox chckbxDtDeterminer = new JCheckBox("DT");
		chckbxDtDeterminer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				dtbo=true;
					ar[k++]=dt;
			}
		});
		chckbxDtDeterminer.setBounds(110, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxDtDeterminer);
		
		
		JCheckBox chckbxExExistentialThere = new JCheckBox("EX");
		chckbxExExistentialThere.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				exbo=true;
				if(exbo==true){
					ar[k++]=ex;
				}
			}
		});
		chckbxExExistentialThere.setBounds(162, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxExExistentialThere);
		
		
		JCheckBox chckbxFwForeignWord = new JCheckBox("FW");
		chckbxFwForeignWord.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				fwbo=true;
				if(fwbo==true){
					ar[k++]=fw;
				}
			}
		});
		chckbxFwForeignWord.setBounds(214, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxFwForeignWord);
		
		
		JCheckBox chckbxInPrepositionOr = new JCheckBox("IN");
		chckbxInPrepositionOr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				inbo=true;
				if(inbo==true){
					ar[k++]=in;
				}
			}
		});
		chckbxInPrepositionOr.setBounds(266, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxInPrepositionOr);
		
		JCheckBox chckbxJjAdjective = new JCheckBox("JJ");
		chckbxJjAdjective.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				jjbo=true;
				if(jjbo==true){
					ar[k++]=jj;
				}
			}
		});
		chckbxJjAdjective.setBounds(318, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxJjAdjective);
		
		JCheckBox chckbxJjrAdjectiveComparative = new JCheckBox("JJR");
		chckbxJjrAdjectiveComparative.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				jjrbo=true;
				if(jjrbo==true){
					ar[k++]=jjr;
				}
			}
		});
		chckbxJjrAdjectiveComparative.setBounds(370, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxJjrAdjectiveComparative);
		
		JCheckBox chckbxJjsAdjectiveSuperlative = new JCheckBox("JJS");
		chckbxJjsAdjectiveSuperlative.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				jjsbo=true;
				if(jjsbo==true){
					ar[k++]=jjs;
				}
			}
		});
		chckbxJjsAdjectiveSuperlative.setBounds(422, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxJjsAdjectiveSuperlative);
		
		JCheckBox chckbxLsListItem = new JCheckBox("LS");
		chckbxLsListItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				lsbo=true;
				if(lsbo==true){
					ar[k++]=ls;
				}
			}
		});
		chckbxLsListItem.setBounds(474, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxLsListItem);
		
		JCheckBox chckbxMdModal = new JCheckBox("MD");
		chckbxMdModal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				mdbo=true;
				if(mdbo==true){
					ar[k++]=md;
				}
			}
		});
		chckbxMdModal.setBounds(526, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxMdModal);
		
		JCheckBox chckbxNnNounSingular = new JCheckBox("NN");
		chckbxNnNounSingular.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
					ar[k]=nn;
					k++;
			}
		});
		chckbxNnNounSingular.setBounds(578, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxNnNounSingular);
		
		JCheckBox chckbxNnsNounPlural = new JCheckBox("NNS");
		chckbxNnsNounPlural.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					
				nnsbo=true;
				if(nnsbo==true){
					ar[k++]=nns;
				}
			}
		});
		chckbxNnsNounPlural.setBounds(630, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxNnsNounPlural);
		
		JCheckBox chckbxNnpProperNoun = new JCheckBox("NNP");
		chckbxNnpProperNoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
					ar[k]=nnp;
					k++;
				
			}
		});
		chckbxNnpProperNoun.setBounds(682, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxNnpProperNoun);
		
		JCheckBox chckbxNnpsProperNoun = new JCheckBox("NNPS");
		chckbxNnpsProperNoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				nnpsbo=true;
				if(nnpsbo==true){
					ar[k++]=nnps;
				}
			}
		});
		chckbxNnpsProperNoun.setBounds(734, 7, 59, 23);
		frmBcsbcsdb.getContentPane().add(chckbxNnpsProperNoun);
		
		JCheckBox chckbxPdtPredeterminer = new JCheckBox("PDT");
		chckbxPdtPredeterminer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				pdtbo=true;
				if(pdtbo==true){
					ar[k++]=pdt;
				}
			}
		});
		chckbxPdtPredeterminer.setBounds(795, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxPdtPredeterminer);
		
		JCheckBox chckbxPosPossessiveEnding = new JCheckBox("POS");
		chckbxPosPossessiveEnding.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				posbo=true;
				if(posbo==true){
					ar[k++]=pos;
				}
			}
		});
		chckbxPosPossessiveEnding.setBounds(847, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxPosPossessiveEnding);
		
		JCheckBox chckbxPrpPersonalPronoun = new JCheckBox("PRP");
		chckbxPrpPersonalPronoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				prpbo=true;
				if(prpbo==true){
					ar[k++]=prp;
				}
			}
		});
		chckbxPrpPersonalPronoun.setBounds(899, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxPrpPersonalPronoun);
		
		JCheckBox chckbxPrpPossessivePronoun = new JCheckBox("PRP$");
		chckbxPrpPossessivePronoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				prp$bo=true;
				if(prp$bo==true){
					ar[k++]=prp$;
				}
			}
		});
		chckbxPrpPossessivePronoun.setBounds(951, 7, 59, 23);
		frmBcsbcsdb.getContentPane().add(chckbxPrpPossessivePronoun);
		
		JCheckBox chckbxRbAdverb = new JCheckBox("RB");
		chckbxRbAdverb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				rbbo=true;
				if(rbbo==true){
					ar[k++]=rb;
				}
			}
		});
		chckbxRbAdverb.setBounds(1012, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxRbAdverb);
		
		JCheckBox chckbxRbrAdverbComparative = new JCheckBox("RBR");
		chckbxRbrAdverbComparative.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				rbrbo=true;
				if(rbrbo==true){
					ar[k++]=rbr;
				}
			}
		});
		chckbxRbrAdverbComparative.setBounds(1064, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxRbrAdverbComparative);
		
		JCheckBox chckbxRbsAdverbSuperlative = new JCheckBox("RBS");
		chckbxRbsAdverbSuperlative.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				rbsbo=true;
				if(rbsbo==true){
					ar[k++]=rbs;
				}
			}
		});
		chckbxRbsAdverbSuperlative.setBounds(1116, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxRbsAdverbSuperlative);
		
		JCheckBox chckbxRpParticle = new JCheckBox("RP");
		chckbxRpParticle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				rpbo=true;
				if(rpbo==true){
					ar[k++]=rp;
				}
			}
		});
		chckbxRpParticle.setBounds(1168, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxRpParticle);
		
		JCheckBox chckbxSymSymbol = new JCheckBox("SYM");
		chckbxSymSymbol.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				symbo=true;
				if(symbo==true){
					ar[k++]=sym;
				}
			}
		});
		chckbxSymSymbol.setBounds(1220, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxSymSymbol);
		
		JCheckBox chckbxToTo = new JCheckBox("TO");
		chckbxToTo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				tobo=true;
				if(tobo==true){
					ar[k++]=to;
				}
			}
		});
		chckbxToTo.setBounds(1272, 7, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxToTo);
		
		JCheckBox chckbxUhInterjection = new JCheckBox("UH");
		chckbxUhInterjection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				uhbo=true;
				if(uhbo==true){
					ar[k++]=uh;
				}
			}
		});
		chckbxUhInterjection.setBounds(6, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxUhInterjection);
		
		JCheckBox chckbxVbVerbBase = new JCheckBox("VB");
		chckbxVbVerbBase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				vbbo=true;
				if(vbbo==true){
					ar[k++]=vb;
				}
			}
		});
		chckbxVbVerbBase.setBounds(58, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxVbVerbBase);
		
		JCheckBox chckbxVbdVerbPast = new JCheckBox("VBD");
		chckbxVbdVerbPast.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				vbdbo=true;
				if(vbdbo==true){
					ar[k++]=vbd;
				}
			}
		});
		chckbxVbdVerbPast.setBounds(110, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxVbdVerbPast);
		
		JCheckBox chckbxVbgVerbGerund = new JCheckBox("VBG");
		chckbxVbgVerbGerund.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					
				vbgbo=true;
				if(vbgbo==true){
					ar[k++]=vbg;
				}
			}
		});
		chckbxVbgVerbGerund.setBounds(162, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxVbgVerbGerund);
		
		JCheckBox chckbxVbnVerbPast = new JCheckBox("VBN");
		chckbxVbnVerbPast.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				vbnbo=true;
				if(vbnbo==true){
					ar[k++]=vbn;
				}
			}
		});
		chckbxVbnVerbPast.setBounds(214, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxVbnVerbPast);
		
		JCheckBox chckbxVbpVerbNonrd = new JCheckBox("VBP");
		chckbxVbpVerbNonrd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					
				vbpbo=true;
				if(vbpbo==true){
					ar[k++]=vbp;
				}
			}
		});
		chckbxVbpVerbNonrd.setBounds(266, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxVbpVerbNonrd);
		
		JCheckBox chckbxVbzVerbrd = new JCheckBox("VBZ");
		chckbxVbzVerbrd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				vbzbo=true;
				if(vbzbo==true){
					ar[k++]=vbz;
				}
			}
		});
		chckbxVbzVerbrd.setBounds(318, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxVbzVerbrd);
		
		JCheckBox chckbxWdtWhdeterminer = new JCheckBox("WDT");
		chckbxWdtWhdeterminer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
					
				wdtbo=true;
				if(wdtbo==true){
					ar[k++]=wdt;
				}
			}
		});
		chckbxWdtWhdeterminer.setBounds(370, 33, 60, 23);
		frmBcsbcsdb.getContentPane().add(chckbxWdtWhdeterminer);
		
		JCheckBox chckbxWpWhpronoun = new JCheckBox("WP");
		chckbxWpWhpronoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				wpbo=true;
				if(wpbo==true){
					ar[k++]=wp;
				}
			}
		});
		chckbxWpWhpronoun.setBounds(432, 33, 50, 23);
		frmBcsbcsdb.getContentPane().add(chckbxWpWhpronoun);
		
		JCheckBox chckbxWpPossessiveWhpronoun = new JCheckBox("WP$");
		chckbxWpPossessiveWhpronoun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				wp$bo=true;
				if(wp$bo==true){
					ar[k++]=wp$;
				}
			}
		});
		chckbxWpPossessiveWhpronoun.setBounds(484, 33, 59, 23);
		frmBcsbcsdb.getContentPane().add(chckbxWpPossessiveWhpronoun);
		
		JCheckBox chckbxWrbWhadverb = new JCheckBox("WRB");
		chckbxWrbWhadverb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				wrbbo=true;
				if(wrbbo==true){
					ar[k++]=wrb;
				}
			}
		});
		chckbxWrbWhadverb.setBounds(546, 33, 59, 23);
		frmBcsbcsdb.getContentPane().add(chckbxWrbWhadverb);
		
		
		
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			boolean exe=true;
			exeb=exe;
				int i=0;
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(748, 131, 604, 511);
				frmBcsbcsdb.getContentPane().add(textArea);
				textArea.setEditable(false);
				try{
					ArrayList all=mPOS();
					alo=all;
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
					scroll.setBounds(748, 131, 604, 511);
					frmBcsbcsdb.getContentPane().add(scroll);
			}
		});
		btnExecute.setBounds(370, 663, 89, 23);
		frmBcsbcsdb.getContentPane().add(btnExecute);
		
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
                        	 if(pob==true){
                        	 ArrayList al=ali;
                        	 for(int i=0;i<al.size();i++)
              				{
              					
              					fw.write("Line"+i+": ");
         			            fw.write(al.get(i).toString());
         			            fw.write("\n");
              				}
                        	 }
                        	 else if(exeb==true){
                        	ArrayList al=alo;                        	 
             				for(int i=0;i<al.size();i++)
             				{
             					
             					fw.write("Line"+i+": ");
        			            fw.write(al.get(i).toString());
        			            fw.write("\n");
             				}
                        	 }
             				fw.close();			     
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
                         
			    }
				
			}
		});
		btnSave.setBounds(977, 663, 89, 23);
		frmBcsbcsdb.getContentPane().add(btnSave);
		
		
		
		JButton btnPosTag = new JButton("POS Tag");   //pos tag
		btnPosTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean po=true;
				pob=po;
				int i=0;
				JTextArea textArea = new JTextArea();
				textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
				textArea.setBounds(748, 131, 604, 511);
				frmBcsbcsdb.getContentPane().add(textArea);
				textArea.setEditable(false);
				try{
					ArrayList all=myPOS();
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
					scroll.setBounds(748, 131, 604, 511);
					frmBcsbcsdb.getContentPane().add(scroll);
			}
		});
		btnPosTag.setBounds(6, 131, 89, 23);
		frmBcsbcsdb.getContentPane().add(btnPosTag);
		
		
		textField = new JTextField();
		textField.setBounds(120, 63, 219, 22);
		frmBcsbcsdb.getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}

	
	public void setVisible(boolean b) {
		
	}
	
	
	public ArrayList<String> myPOS() throws Exception
	{
		File s4=s2;
		String text;
		Properties props = new Properties();
    	props.setProperty("annotators", "tokenize, ssplit, pos");
    	StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    	Scanner sc=new Scanner(s4);
    	ArrayList<String> list = new ArrayList<String>();
    	ArrayList<String> list1 = new ArrayList<String>();
    	while(sc.hasNextLine()){
    		String s1=sc.nextLine(); 
            Annotation document = new Annotation(s1);
            pipeline.annotate(document);
            List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
            String sen="";
            for (CoreMap sentence : sentences) {
                for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                  String word = token.get(CoreAnnotations.TextAnnotation.class);
                    String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    sen=sen+" "+word+"<"+pos+">";
                }
                list1.add(sen);
            }
            
   		}
    	
			   return list1;
	}	
	
	
	public ArrayList<String> mPOS() throws Exception
	{
		File s4=s2;
		String text;
		Properties props = new Properties();
    	props.setProperty("annotators", "tokenize, ssplit, pos");
    	StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    	Scanner sc=new Scanner(s4);
    	ArrayList<String> list = new ArrayList<String>();
    	ArrayList<String> list1 = new ArrayList<String>();
    	while(sc.hasNextLine()){
    		String s1=sc.nextLine(); 
            Annotation document = new Annotation(s1);
            pipeline.annotate(document);
            List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
            String sen="";
            for (CoreMap sentence : sentences) {
                for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                  String word = token.get(CoreAnnotations.TextAnnotation.class);
                    String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    System.out.println(pos+word);
                        for(int i=0;i<k;i++){
                        	System.out.println("word + pos"+pos+ar[i]);
        				
                    	if(pos.equals(ar[i].toString())){	
                    	sen=sen+" "+word+"<"+pos+">"; 
                    	System.out.println(ar[i]);
                    	break;
                    	}
                        }
                    	                   	                    
                   
                }
                
                list1.add(sen);
                sen="";
            }
            
   		}
    	
			   return list1;
	}	
}
