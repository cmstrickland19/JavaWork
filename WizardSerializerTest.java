package com.fdmgroup.serialization.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.serialization.game.Wizard;
import com.fdmgroup.serialization.game.WizardSerializer;

public class WizardSerializerTest {
	private String savedData;
	private WizardSerializer wizardSerializer;
	private Wizard wizard;
	private int wizardShieldHp = 100;
	private String wizardPower = "Water Bender";

	@Before
	public void setUp() throws Exception {
		savedData = "saveData.txt";
		wizardSerializer = new WizardSerializer(savedData);
		wizard = new Wizard();

	}

	@Test
	public void testWizardsShieldHitpointsIsOneHundredWhenWizardisDeserialized() {
		wizard.setShieldHitPoints(wizardShieldHp);
		
		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		int deserializedShieldHp = deserializedWizard.getShieldHitPoints();

		assertEquals(wizardShieldHp, deserializedShieldHp);
	}

	@Test
	public void testWizardPowerisWaterBenderWhenWizardIsDeserialized() {
		wizard.setPower(wizardPower);
		
		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		String deserializedPower = deserializedWizard.getPower();

		assertEquals(wizardPower, deserializedPower);
	}

	@Test
	public void testWizardNameisWizardWhenWizardIsDeserialized() {
		String testWizardName = "wizard";
		wizard.setName(testWizardName);
		String expectedWizardName = "wizard";

		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		String deserializedName = deserializedWizard.getName();

		assertEquals(expectedWizardName, deserializedName);
	}

	@Test
	public void testWizardHealthPointsisOneHundredWhenWizardIsDeserialized() {
		int testHP = 100;
		int expectedWizardHP = 100;
		wizard.setHealthPoints(testHP);

		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		int deserializedHealthPoints = deserializedWizard.getHealthPoints();

		assertEquals(expectedWizardHP, deserializedHealthPoints);
	}

	@Test
	public void testWizardNumberOfHealthPacksisOneWhenWizardIsDeserialized() {
		int expectedNumHealthPacks = 1;
		Backpack wizardBackPack = wizard.getBackPack();
		HealthPack wizardPack0 = new HealthPack();
		wizardBackPack.addHealthPack(wizardPack0);
		wizard.setBackPack(wizardBackPack);

		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		int actualNumOfPacks = deserializedWizard.getNumOfPacks();

		assertEquals(expectedNumHealthPacks, actualNumOfPacks);
	}
	@Test
	public void testWizardNumberOfHealthPacksisThreeWhenWizardIsDeserialized() {
		int expectedNumHealthPacks = 3;
		Backpack wizardBackPack = wizard.getBackPack();
		HealthPack wizardPack0 = new HealthPack();
		HealthPack wizardPack1 = new HealthPack();
		HealthPack wizardPack2 = new HealthPack();
		wizardBackPack.addHealthPack(wizardPack0);
		wizardBackPack.addHealthPack(wizardPack1);
		wizardBackPack.addHealthPack(wizardPack2);
		wizard.setBackPack(wizardBackPack);

		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		int actualNumOfPacks = deserializedWizard.getNumOfPacks();

		assertEquals(expectedNumHealthPacks, actualNumOfPacks);
	}
	@Test
	public void testWizardNumberOfHealthPacksisFiveWhenWizardIsDeserialized() {
		int expectedNumHealthPacks = 5;
		Backpack wizardBackPack = wizard.getBackPack();
		HealthPack wizardPack0 = new HealthPack();
		HealthPack wizardPack1 = new HealthPack();
		HealthPack wizardPack2 = new HealthPack();
		HealthPack wizardPack3 = new HealthPack();
		HealthPack wizardPack4 = new HealthPack();
		wizardBackPack.addHealthPack(wizardPack0);
		wizardBackPack.addHealthPack(wizardPack1);
		wizardBackPack.addHealthPack(wizardPack2);
		wizardBackPack.addHealthPack(wizardPack3);
		wizardBackPack.addHealthPack(wizardPack4);
		wizard.setBackPack(wizardBackPack);

		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		int actualNumOfPacks = deserializedWizard.getNumOfPacks();

		assertEquals(expectedNumHealthPacks, actualNumOfPacks);
	}
	
	@Test
	public void testSerializedBackPackIsNotNull(){
		Backpack wizardBackPack = wizard.getBackPack();
		
		wizard.setBackPack(wizardBackPack);
		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		Backpack backPack=deserializedWizard.getBackPack();
		
		assertNotNull(backPack);
	}
	@Test 
	public void testFindHealthpointsInHealthPack(){
		wizard.addHealthPack(600);
		int expectedHp=600;
		
		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		Backpack deserializedBackPack=deserializedWizard.getBackPack();
		HealthPack deserializedHealthPack=deserializedBackPack.useHealthPack();
		int actualHp=deserializedHealthPack.getHealthPoints();
		
		assertEquals(expectedHp,actualHp);
	}
	@Test 
	public void testFindHealthpointsInSecondHealthPack(){
		wizard.addHealthPack(600);
		wizard.addHealthPack(300);
		int expectedHp=300;
		
		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		Backpack deserializedBackPack=deserializedWizard.getBackPack();
		deserializedBackPack.useHealthPack();
		HealthPack deserializedHealthPack=deserializedBackPack.useHealthPack();
		int actualHp=deserializedHealthPack.getHealthPoints();
		
		assertEquals(expectedHp,actualHp);
	}
	@Test 
	public void testFindHealthpointsInThirdHealthPack(){
		wizard.addHealthPack(600);
		wizard.addHealthPack(300);
		wizard.addHealthPack(100);
		int expectedHp=100;
		
		wizardSerializer.serialize(wizard);
		Wizard deserializedWizard = wizardSerializer.deserialize();
		Backpack deserializedBackPack=deserializedWizard.getBackPack();
		deserializedBackPack.useHealthPack();
		deserializedBackPack.useHealthPack();
		HealthPack deserializedHealthPack=deserializedBackPack.useHealthPack();
		int actualHp=deserializedHealthPack.getHealthPoints();
		
		assertEquals(expectedHp,actualHp);
	}
	


}
