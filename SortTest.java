import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class SortTest{
	public static void main(String[] args) {
		try{
		File sort = new File("sort.txt");
		Scanner scan = new Scanner(sort);
		int[] values = new int[10000];
		int i=0;
			while (scan.hasNextInt()){
				values[i]=scan.nextInt();
				i++;
				}
		
		Boolean Correct = true;
		if (values[9999]!=0){
			for (int j = 0; j<values.length-1;j++)
				if (values[j]>values[j+1]){
					Correct = false;
				}
		}else {
			System.err.println("FAIL incorrect element amount");
		}
		if (Correct){
			System.out.println("PASS");
		}else{
			System.err.println("FAIL incorrect sort");
		}
		}
		catch(IndexOutOfBoundsException IOOBE){
			System.err.println("FAIL incorrect element amount");
		} catch(FileNotFoundException FNF){
			System.err.println("File not found");
		}
	}
}