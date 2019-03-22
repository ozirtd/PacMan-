package PrintTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serial {
	
	private static Print object;
	private String filename;
	
	public Serial() {
		
	}
	
	public static void load(String string) throws IOException, ClassNotFoundException {

		FileInputStream fi = new FileInputStream(string);
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		object = (Print)oi.readObject();
		
		;
		oi.close();
	}
	
	public static void save() throws FileNotFoundException, IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Prueba.txt"));
		os.writeObject(object);
		System.out.println("Listo");
		
	}

	
	public String getFilename() {
		return filename;
	}
	
	public static void main(String [] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//object = new Print();
		//object.setPath("Hola");
		//save();
		
		load("Prueba.txt");
		System.out.println(object.getPath());
	}
}
