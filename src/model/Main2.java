package model;

import java.util.Collections;
import datastructure.HashTable;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//The number of test cases
		int testCases = Integer.parseInt(br.readLine());
							
		br.readLine();	
		
		for(int i = 0 ; i < testCases ; i++) {		
			
			//Initialize
			double totalTrees = 0;
			
			//Initialize a hash table for saving the trees in the tables array (Specie, number)
			HashTable<String, Integer> trees = new HashTable<>();			
			
			//Initialize Array List of tree species for this test case
			ArrayList<String> species = new ArrayList<>();			
			
			//Reads trees of test case i
			String line = br.readLine();
			while(line != null && !line.isEmpty()){	
				
				//Checks if the element is already in the table, if not it adds with 1 tree of the specie if yes it removes the specie and adds 1 to the count
				if(trees.search(line) != null) {
					int currentCountSpecie = trees.search(line);
					trees.insert(line, currentCountSpecie + 1);
				}
				else {
					trees.insert(line, 1);
					species.add(line);	
				}					
				
				//Increases the number of trees
				totalTrees ++;		
				
				//Reads next line
				line = br.readLine();				
			}
			
			//Sorts the species
			Collections.sort(species);
			
			//Output						
			for(String currentSpecie : species) {							
				System.out.printf("%s %.4f\n", currentSpecie, (trees.search(currentSpecie)/totalTrees)*100.0);							
			}
			
			if(i != testCases -1) {
				System.out.println();
			}								
		}		
		br.close();
	}
}
