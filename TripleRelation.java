
import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.util.CoreMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;

/** A demo illustrating how to call the OpenIE system programmatically.
 */
public class Open {

  public static void main(String[] args) throws Exception {
	  File file = new File("C:\\Users\\dutta\\Desktop\\maha.txt");
		 
	  Scanner sc=new Scanner(file);
	 // String sb=" ";
	//  StringBuffer sen=new StringBuffer();
	// while((sb=br.readLine())!=null){
	//	 sen.append(sb);
	// }
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    File fil = new File("C:\\Users\\dutta\\Desktop\\out1.txt"); //Your file
    FileOutputStream fos = new FileOutputStream(fil);
    PrintStream ps = new PrintStream(fos);
    PrintStream console = System.out;
   // ArrayList
    // Annotate an example document.
    while(sc.hasNextLine()){
		String s1=sc.nextLine();
    Annotation doc = new Annotation(s1);
    pipeline.annotate(doc);
    // Loop over sentences in the document
    for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
      // Get the OpenIE triples for the sentence
    	
      Collection<RelationTriple> triples =
	          sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
      
     // System.out.println("This will be written to the text file");

      // Print the triples
     for (RelationTriple triple : triples) {
    	 System.setOut(ps);
        System.out.println(triple.confidence + "\t" +
            triple.subjectLemmaGloss() + "\t" +
            triple.relationLemmaGloss() + "\t" +
            triple.objectLemmaGloss());
      }
      
    }
    }
    
    
  }
}