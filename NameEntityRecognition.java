import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.simple.*;
/** A simple corenlp example ripped directly from the Stanford CoreNLP website using text from wikinews. */
public class Ner {
  public static void main(String[] args) throws IOException {
    // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution 
	  try{
	     	 FileWriter fw = new FileWriter("C:\\Users\\dutta\\Desktop\\out4.txt");	
	     	 ArrayList<String> ali=ner();
	     	 
	     		 for(int i=0;i<ali.size();i++)
					{
						
						fw.write("Line"+i+": ");
			            fw.write(ali.get(i).toString());
			            fw.write("\n");
					}
				
				fw.close();			     
	 } catch (Exception ex) {
	     ex.printStackTrace();
	 }
	  
  }
	  
	  
  public static ArrayList<String> ner() throws Exception
	{
    Properties props = new Properties();
    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    File file = new File("C:\\Users\\dutta\\Desktop\\Canto_1_Chapter_1.txt");
    ArrayList<String> list1 = new ArrayList<String>();
	  Scanner sc=new Scanner(file);
	  while(sc.hasNextLine()){
			String s1=sc.nextLine();
    Annotation document = new Annotation(s1);

    // run all Annotators on this text
    pipeline.annotate(document);
   // FileWriter fw = new FileWriter("C:\\Users\\dutta\\Desktop\\out.txt");
    /*File fil = new File("C:\\Users\\dutta\\Desktop\\out.txt"); //Your file
    FileOutputStream fos = new FileOutputStream(fil);
    PrintStream ps = new PrintStream(fos);
    PrintStream console = System.out;*/
    // these are all the sentences in this document
    // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
    List<CoreMap> sentences = document.get(SentencesAnnotation.class);

    for(CoreMap sentence: sentences) {
    	ArrayList<String> list = new ArrayList<String>();
      // traversing the words in the current sentence
      // a CoreLabel is a CoreMap with additional token-specific methods
      for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
        // this is the text of the token
        String word = token.get(TextAnnotation.class);
        
        list.add(word.toString());
        // this is the POS tag of the token
        String pos = token.get(PartOfSpeechAnnotation.class);
        
        list.add(pos.toString());
        // this is the NER label of the token
        String ne = token.get(NamedEntityTagAnnotation.class);
        
        list.add(ne.toString());
     //  System.setOut(ps);
        System.out.println("word: " + word + " pos: " + pos + " ne:" + ne);
      }
list1.add(list.toString());
      // this is the parse tree of the current sentence
    //  Tree tree = sentence.get(TreeAnnotation.class);
    //  System.out.println("parse tree:\n" + tree);

      // this is the Stanford dependency graph of the current sentence
      //SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
     // System.out.println("dependency graph:\n" + dependencies);
    }
	  }
	  return list1;

}
}