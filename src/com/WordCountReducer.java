package com;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text,Text,Text,Text> {
	
  	int counts = 0;
  	
    public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {	
    	counts=0;
    	
    	String authorUnigram = key.toString();
    	String[] splitResult = authorUnigram.split("@");
    	
    	if(splitResult.length>=1)
    	{  
    		String author = splitResult[0];
    	  
    		if(splitResult.length>=2){
    			String Unigram = splitResult[1];
    		
    	    	for (Text val:values){
    	    		counts++;
    	    	}
    	    	
    	    	String unigramCountValue = "$"+Unigram+"@"+Integer.toString(counts);
    	    	
//    	    	System.out.println(author+"\t"+unigramCountValue);
    	    	
    	    	context.write(new Text(author), new Text(unigramCountValue));
    		
    		}else{
    			/**
    			 * Missing Unigram for the author
    			 * */
    		}
    	}else{
    		/**
    		 * There is nothing in key
    		 * continue;
    		 * */
    	}
    	
    }
}
