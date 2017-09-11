package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import geometry.Shape;

public class ShapeSerialization {

	public void serialize(ArrayList<Shape> shapes, String file){

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){

			out.writeObject(shapes);

		}catch(IOException i) {
			i.printStackTrace();
		}

	}
	//citanje
	public ArrayList<Shape> deserialilize(ArrayList<Shape> serializableShapes, String file){
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			serializableShapes = (ArrayList<Shape>) in.readObject();
		}catch(IOException | ClassNotFoundException i) {
			i.printStackTrace();        
		}
		return serializableShapes;
	}
}
