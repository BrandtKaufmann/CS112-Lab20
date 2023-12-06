import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
class Merge{
	//Takes in file name, reads file into an ArrayList
	static ArrayList<Integer> read(String name){
		try{//in case file name is incorrect
			ArrayList<Integer> List1 = new ArrayList<Integer>();
			File list = new File(name);
			Scanner scan = new Scanner(list); 
				//takes each int and adds to the ArrayList
				while (scan.hasNextInt()){
				List1.add(scan.nextInt());
				}
			return List1;
		}catch(FileNotFoundException fnfe){
			System.err.println("FileNotFoundException");
		}
		return null;
	}
	/*
	check()
	Overloaded recursive constructor
	takes in however many ArrayLists are left with length>0
	simple logic to find the smallest value
	passes the smallest, and removes it from its respective array
	calls check(all qualifying arrays)
	*/
	static void check(ArrayList<Integer> L1, ArrayList<Integer> L2, ArrayList<Integer> L3, ArrayList<Integer> Merged){
		//assigns first value of each array to its own variable
		Integer a = L1.get(0);
		Integer b = L2.get(0);
		Integer c = L3.get(0);
		//Logic tree to find smallest value among variables
		if (a<=b){
			if (a<=c){
				Merged.add(a);
				L1.remove(0);	
			}else{
				Merged.add(c);
				L3.remove(0);
			}
		}else if (b<a){
			if(b<=c){
				Merged.add(b);
				L2.remove(0);
			}else{
				Merged.add(c);
				L3.remove(0);
			}
		}
		//checks sizes in order to know which lists to pass to the next check call
		if (L1.size()>0 && L2.size()>0 && L3.size()>0){
			check(L1,L2,L3,Merged);
		}else if (L3.size()==0){
			check(L1, L2, Merged);
		}else if (L2.size()==0){
			check(L1, L3, Merged);
		}else if (L1.size()==0){
			check(L2, L3, Merged);
		}
	}
	/*
	second check constructor:
	takes in 2 ArrayLists and Merged
	simple if else to find smallest value and act accordingly:
	add smaller to Merged, remove smaller from its lits
	check ArrayList(s) length, and call check again
	*/
	static void check(ArrayList<Integer> L1, ArrayList<Integer> L2, ArrayList<Integer> Merged){
		//assign smallest values to ints
		int a = L1.get(0);
		int b = L2.get(0);
		//find smallest
		if (a<=b){
			Merged.add(a);
			L1.remove(0);
		}else {
			Merged.add(b);
			L2.remove(0);
		}
		//make sure arrays have nums in them still, if not, call final check()
		if (L1.size()>0 &&L2.size()>0){
			check(L1, L2, Merged);
		}else if (L1.size()==0){
			check(L2, Merged);
		}else{
			check(L1, Merged);
		}
	}

	//if only 1 ArrayList remains, add all remaining values to Merged in order
	static void check(ArrayList<Integer> L1, ArrayList<Integer> Merged){
		Integer placeholder=0;
		for (int i=0; i<L1.size();i++){
			placeholder=L1.get(i);
			Merged.add(placeholder);
		}
	}

	public static void main(String[] args) {
		if (args.length==3){
			ArrayList<Integer> List1 = read(args[0]);
			ArrayList<Integer> List2 = read(args[1]);
			ArrayList<Integer> List3 = read(args[2]);
			ArrayList<Integer> Merged = new ArrayList<Integer>();
			check(List1, List2, List3, Merged);
			System.out.println(Merged);
		}else{
			System.err.println("Incorrect number of Files");
		}
		
	}
}