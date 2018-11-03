package com.fdmgroup.serialization.game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Wizard extends Player implements Serializable {
	private static final long serialVersionUID = 1L;

	private int shieldHitPoints;
	private String power;
	private transient Backpack backPack = new Backpack();
	private int NumOfPacks;

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();

		String wizardName = getName();
		oos.writeObject(wizardName);

		int wizardHealthPoints = getHealthPoints();
		oos.writeInt(wizardHealthPoints);

		if (backPack != null) {
			int wizardNumPacks = backPack.getNumPacks();
			oos.writeInt(wizardNumPacks);
			ArrayList<Integer> listOfHealthPoints = new ArrayList<Integer>();
			if (wizardNumPacks != 0) {
				while (backPack.getNumPacks() !=0) {
					HealthPack usedHealthPack = backPack.useHealthPack();
					int usedPoints = usedHealthPack.getHealthPoints();
					listOfHealthPoints.add(usedPoints);
				}
			}
			oos.writeObject(listOfHealthPoints);
		}

	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();

		String deserializedName;
		Object nameStringObject = new Object();
		nameStringObject = ois.readObject();
		if (nameStringObject instanceof String) {
			deserializedName = (String) nameStringObject;
			this.setName(deserializedName);
		}

		int loadedHealthPoints;
		loadedHealthPoints = ois.readInt();
		this.setHealthPoints(loadedHealthPoints);

		int deserializedHp;
		deserializedHp = ois.readInt();
		this.setNumOfPacks(deserializedHp);
		Backpack backPack = new Backpack();
		this.setBackPack(backPack);

		Object healthPointsObject = new Object();
		healthPointsObject = ois.readObject();
		if (healthPointsObject instanceof ArrayList) {
			ArrayList<Integer> listOfHealthPoints;
			listOfHealthPoints = (ArrayList) healthPointsObject;
			for (Integer healthPointsFromList : listOfHealthPoints) {
				HealthPack wizardPack = new HealthPack(healthPointsFromList);
				backPack.addHealthPack(wizardPack);
			}

		}

	}

	public int getShieldHitPoints() {
		return shieldHitPoints;

	}

	public void setShieldHitPoints(int shieldHitPoints) {
		this.shieldHitPoints = shieldHitPoints;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Backpack getBackPack() {
		return backPack;
	}

	public void setBackPack(Backpack backPack) {
		this.backPack = backPack;
	}

	public int getNumOfPacks() {
		return NumOfPacks;
	}

	public void setNumOfPacks(int numOfPacks) {
		NumOfPacks = numOfPacks;
	}

	public void addHealthPack(int hp) {
		HealthPack healthPack = new HealthPack(hp);
		backPack.addHealthPack(healthPack);
	}

}