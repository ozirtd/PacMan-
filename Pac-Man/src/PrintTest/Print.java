package PrintTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;




public class Print implements Serializable  {
	
	private File test;
	private String path = "Test.txt";
	
	public Print() {
		test = new File(path);
	}
	
	public void PrintLife() throws IOException {
	
		PrintWriter pw = new PrintWriter(test);
		pw.write("Hola esto funciono" + "\n");
		pw.write("segunda linea");
		pw.close();
		System.out.println("Done");
	}
	
	public void readFile() throws IOException {
		FileReader fr = new FileReader(test);
		BufferedReader bf = new BufferedReader(fr);
		
		String line = bf.readLine();
		System.out.println(line);
		while(line != null) {
			
			line += bf.readLine();
			System.out.println(line);
		}
		
		fr.close();
		bf.close();
	
		
		
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}



//public static void main(String [] args) throws IOException {
	//Print p = new Print();
	//p.PrintLife();
	//p.readFile();
}