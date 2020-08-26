package com.sessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
public class SessionStorage {
	static ArrayList<LocalDate> array = new ArrayList<LocalDate>();
	
    public void writeArray(LocalDate date) {
    	array.add(date);
    }
	
	public static void write() throws IOException, ClassNotFoundException {
		//array = new ArrayList<LocalDate>();
		//array = SessionStorage.read();
//		array.add(date);
		if(array.size()>100)
		{
			array.remove(0);
			System.out.println("Trimming session storage to 100");
		}
	    FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\HP\\Desktop\\pjp2.0\\week2\\Assignment\\data1.ser");

	    try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
	        objectOutputStream.writeInt(array.size());
	        for(LocalDate train: array) {
	            objectOutputStream.writeObject(train);
	        }
	    }
	}
	public static ArrayList<LocalDate> read() throws IOException, ClassNotFoundException {
		//ArrayList<LocalDate> array = new ArrayList<LocalDate>();
	    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\Desktop\\pjp2.0\\week2\\Assignment\\data1.ser");

	    try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
	        int trainCount = objectInputStream.readInt();
	         for (int i = 0; i < trainCount; i++) {
	            array.add((LocalDate)objectInputStream.readObject());
	           
	        }
	         System.out.println("Session storage Memory");
	        // DisplayDate.displayArray(array);
	         return array;
	    }
	}
	public void displaySession() {
		array.stream().forEach((e) -> System.out.println(e));
	}
}
