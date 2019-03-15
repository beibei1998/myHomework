package test.adminBlTest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import assistant.exception.Myexception;
import blImpl.adminBl.GetUserInfoByUserNameBl;

/**
 * ������:100%
 * */
public class GetUserInfoByNameBlTest {
	private  GetUserInfoByUserNameBl bl = new GetUserInfoByUserNameBl();
	
	@Before
	public void setUp() throws Exception {
	}

	
	/**
	 * T140600
	 * */
	@Test
	public void test1() throws RemoteException, Myexception {
		assertEquals("�Ű�", bl.getUserInfoByUserName("�Ű�").getName());
	}

	/**
	 * T140601
	 * */
	@Test
	public void test2() throws RemoteException, Myexception {
		assertEquals("�ű���", bl.getUserInfoByUserName("�ű���").getName());
	}
	
	/**
	 * T140602
	 * */
	@Test
	public void test3() throws RemoteException, Myexception {
		assertEquals("����һ", bl.getUserInfoByUserName("����һ").getName());
	}
	
	/**
	 * T140603
	 * */
	@Test
	public void test4() throws RemoteException, Myexception {
		assertEquals(null, bl.getUserInfoByUserName("rhweuifhiweu"));
	}
	
	/**
	 * T140604
	 * */
	@Test
	public void test5() throws RemoteException, Myexception {
		assertEquals(null, bl.getUserInfoByUserName(""));
	}
}
