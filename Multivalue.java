import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.trees.tregex.TregexMatcher;
import edu.stanford.nlp.trees.tregex.TregexPattern;
import edu.stanford.nlp.util.CoreMap;

public class Multivalue {

	public static void main(String[] args)throws Exception {
		
		Properties props = new Properties();
	    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	    FileWriter fw=new FileWriter("F:\\AABKS.txt");
		
	    
		File dir = new File("E:\\sam");
		File[] file=dir.listFiles();
		  
	  
		  for (File f : file) {
	            if(f.isFile()) {
	            	Scanner sc=new Scanner(f);
	    while(sc.hasNextLine()){
			String s1=sc.nextLine();
	    Annotation document = new Annotation(s1);
	    pipeline.annotate(document);
	    List<CoreMap> sentences = document.get(SentencesAnnotation.class);
	    //System.out.println(sentences);
	    for(CoreMap sentence: sentences) {
	    	Tree tree = sentence.get(TreeAnnotation.class);
	    	//System.out.println(tree);
		// TODO Auto-generated method stub
			for(Tree t: tree){
				TregexPattern p = TregexPattern.compile("NP<NNP");
				TregexMatcher m = p.matcher(t);
				while(m.findNextMatchingNode()){
					
					Tree match = m.getMatch();
					 List<Tree> leaves = match.getLeaves();
					 //System.out.println(leaves);
					 for (Tree leaf : leaves){ 
				            List<Word> words = leaf.yieldWords();
				            for (Word word: words)   
				            	fw.write(word.toString()+" ");
				                //System.out.print(words.toString()+" ");
				          }
					 fw.write("\n");
					
				}
				
				TregexPattern p1 = TregexPattern.compile("NP<NNP $++ (VP<VBD)");
				TregexMatcher m1 = p1.matcher(t);
while(m1.findNextMatchingNode()){
					
					Tree match = m1.getMatch();
					 List<Tree> leaves = match.getLeaves();
					 for (Tree leaf : leaves){ 
				            List<Word> words = leaf.yieldWords();
				            for (Word word: words)   
				            	fw.write(word.toString()+" ");
				                //System.out.print(words.toString()+" ");
				          }
					 fw.write("\n");
					
				}

TregexPattern p2 = TregexPattern.compile("NP<NNP $++ (VP<VBG)");
TregexMatcher m2 = p2.matcher(t);
while(m2.findNextMatchingNode()){
	
	Tree match = m2.getMatch();
	 List<Tree> leaves = match.getLeaves();
	 for (Tree leaf : leaves){ 
            List<Word> words = leaf.yieldWords();
            for (Word word: words)   
            	fw.write(word.toString()+" ");
                //System.out.print(words.toString()+" ");
          }
	 fw.write("\n");
	
}


TregexPattern p3 = TregexPattern.compile("NP<NNP $++ (VP<VBN)");
TregexMatcher m3 = p3.matcher(t);
while(m3.findNextMatchingNode()){
	
	Tree match = m3.getMatch();
	 List<Tree> leaves = match.getLeaves();
	 for (Tree leaf : leaves){ 
            List<Word> words = leaf.yieldWords();
            for (Word word: words)   
            	fw.write(word.toString()+" ");
                //System.out.print(words.toString()+" ");
          }
	 fw.write("\n");
	
}


TregexPattern p4 = TregexPattern.compile("NP<NNP $++ (VP<VBP)");
TregexMatcher m4 = p4.matcher(t);
while(m4.findNextMatchingNode()){
	
	Tree match = m4.getMatch();
	 List<Tree> leaves = match.getLeaves();
	 for (Tree leaf : leaves){ 
            List<Word> words = leaf.yieldWords();
            for (Word word: words)   
            	fw.write(word.toString()+" ");
                //System.out.print(words.toString()+" ");
          }
	 fw.write("\n");
	
}


TregexPattern p5 = TregexPattern.compile("NP<NNP $++ (VP<VBZ)");
TregexMatcher m5 = p5.matcher(t);
while(m5.findNextMatchingNode()){
	
	Tree match = m5.getMatch();
	 List<Tree> leaves = match.getLeaves();
	 for (Tree leaf : leaves){ 
            List<Word> words = leaf.yieldWords();
            for (Word word: words)   
            	fw.write(word.toString()+" ");
                //System.out.print(words.toString()+" ");
          }
	 fw.write("\n");
	
}



			}
		}
	    }
	            }
		  }
	    fw.close();
		
		
		
	}

}

