package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.AlreadyExistingVariableException;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.StringVar;
import org.talentboost.interpreter.variables.Variable;

public class MemoryTest {

	Memory mem;
	Variable strVar; 
	Variable intVar;
	
	@Before
	public void setU() {
		this.mem = new Memory();
		this.strVar = new StringVar("humpty", "dumpty");
		this.intVar = new NumberVar("boo", 2);
	}
	
	@Test
	public void createVarTest() throws AlreadyExistingVariableException {
		mem.create(strVar);
	}

	@Test
	public void findVarTest() throws AlreadyExistingVariableException {
		mem.create(strVar);
		assertEquals(true, mem.contains("humpty"));
	}
	
	@Test
	public void getVarTest() throws AlreadyExistingVariableException {
		mem.create(strVar);
		
		Variable found = mem.find("humpty");
		assertEquals(strVar, found);
	}
	
	@Test
	public void getAnotherVarTest() throws AlreadyExistingVariableException {
		mem.create(strVar);
		mem.create(intVar);
		
		Variable found = mem.find("boo");
		assertEquals(intVar, found);
	}
}
