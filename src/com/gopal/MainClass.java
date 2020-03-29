package com.gopal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainClass {
	public static void main(String [] gopal) throws IOException {
		
		ArrayList<String> inputList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("sampleinput.txt"));
		String input;
			while ((input = br.readLine()) != null) {
				inputList.add(input);
			}
		
		for(int i=0; i< inputList.size()-3; i=i+3) {
		int caloriRequired = Integer.parseInt(inputList.get(i+3));


		Map<Character, Integer> outputMap =  newList(inputList.get(i+1), inputList.get(i+2));
		
		output(outputMap, caloriRequired);
		}
		
    }
	
	private static void output(Map<Character, Integer> outputMap, int caloriRequired){
		int count =0;
		String finalOutPut = "";
		for (Map.Entry<Character, Integer> entry : outputMap.entrySet())
		{
			//System.out.println(entry+"entry value");
			if (outputMap.containsValue(caloriRequired)){				
				System.out.println(entry.getKey());				
			}else if (entry.getValue() < caloriRequired){
				count += entry.getValue();
				finalOutPut += entry.getKey();
				//System.out.println(finalOutPut);
			}
		}
		if (count == caloriRequired){
			System.out.println(finalOutPut);
			
		}else{
			System.out.println("SORRY, YOU JUST HAVE WATER");
		}
	}
	
	
	public static Map<Character, Integer> newList(String uniqueCaories, String actualFruit){
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Character> uniqueFruitList = new ArrayList<Character>();
		
		String [] delimatedString = uniqueCaories.split(" ");

        char[] chars = actualFruit.toCharArray();
        Arrays.sort(chars);
        Set<Character> uniqKeys = new TreeSet<Character>();
        for(char eachChar : chars) {
        	uniqKeys.add(eachChar);
        }
        
        for (Character character : uniqKeys) {
			uniqueFruitList.add(character);
		}
        
        for (int i=0 ; i < (uniqueFruitList.size());i++){
        	
        	map.put(uniqueFruitList.get(i), Integer.parseInt(delimatedString[i+1]));
        }
        
      //  System.out.println(uniqueFruitList);
		return map;
	}
}