package com.fdmgroup.serialization.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WizardSerializer {

	private String saveLocation;

	public WizardSerializer(String saveLocation) {
		this.saveLocation = saveLocation;
	}

	public void serialize(Wizard game) {
		File file = new File(this.saveLocation);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// Throws FileNotFoundException
			fos = new FileOutputStream(file);
			// Throws IOException
			oos = new ObjectOutputStream(fos);
			// Throws IOException as well
			oos.writeObject(game);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Wizard deserialize() {
		Wizard deserializedWizard = null;
		File file = new File(this.saveLocation);
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Object readObject = ois.readObject();

			if (readObject instanceof Wizard) {
				deserializedWizard = (Wizard) readObject;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return deserializedWizard;
	}
}
