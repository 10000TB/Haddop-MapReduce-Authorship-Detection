package com;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper extends Mapper<Object, Text, Text, Text>{
	
//  	private Scanner scanner;
  	
  	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {	
  		
//  		String valueString = new String(value.copyBytes(),"UTF-8");
  		
//  		scanner = new Scanner(valueString);
  		
//		String lines[] = valueString.split("\\r?\\n");
  		
//  		while(scanner.hasNextLine()){
//  			String newLine = scanner.nextLine();
//  			
//  			String[] result = newLine.split("<===>");
//  			String author = result[0];
//  			String lineBody = result[1];
//  			
//  			String[] words = lineBody.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
//  			
//  			for (int i=0;i<words.length;i++){
//  				String authorUnigramKey = author+"@"+words[i];
//  				
//  				context.write(new Text(authorUnigramKey), new Text(""));
//  			}
//  		} 
//		for (int i=0;i<lines.length;i++){
			
			String newLine = value.toString();
			
			String[] result = newLine.split("<===>");
			String author = result[0];
			String lineBody = result[1];
			
			String[] words = lineBody.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			
			for (int j=0;j<words.length;j++){
				String authorUnigramKey = author+"@"+words[j];
				
				context.write(new Text(authorUnigramKey), new Text(""));
			}

//		}
  	} 

}
