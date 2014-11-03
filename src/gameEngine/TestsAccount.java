package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import automat.Billetautomat;

public class TestsAccount {
	
	Account acc1;
	
	@Before
	public void setUp() throws Exception {
		acc1 = new Account();
	}
	
	@Test
	public void testAccount() {
		assertEquals(1000, acc1.getBalance());
	}

	@Test
	public void testDeposit() {
		acc1.deposit(100);
		assertEquals(1100, acc1.getBalance());
	}

	@Test
	public void testWithdraw() {
		acc1.withdraw(100);
		assertEquals(900, acc1.getBalance());
	}

	@Test
	public void testGetBalance() {
		acc1.setBalance(10000);
		assertEquals(10000, acc1.getBalance());
	}

	@Test
	public void testSetBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
