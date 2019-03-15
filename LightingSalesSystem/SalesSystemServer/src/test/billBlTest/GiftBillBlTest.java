package test.billBlTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assistant.type.BillCategoryEnum;
import assistant.type.BillStateEnum;
import assistant.type.UserPositionEnum;
import assistant.utility.Date;
import blImpl.bill.billBl.GiftBillBl;
import po.GiftBillPO;
import po.GiftPO;
import po.UserInfoPO;

/**
 * ��Ϊ����������������أ�����Щֻ�ܲ���һ��
 * */
public class GiftBillBlTest {

	static final BillCategoryEnum CATEGORY_ENUM = BillCategoryEnum.GIFT_BILL;
	GiftBillBl testBl = new GiftBillBl();//��Ҫ���Ե��߼�����
	
	@Before
	public void setUp() throws Exception {
		GiftBillBlSetUp s = new GiftBillBlSetUp();
		s.setUp();
	}

	@After
	public void cleanUp()throws Exception{
		
	}
	
	/**
	 * �������Դ����µ���
	 * */
	@Test
	public void driveGiftCreateBill(){
		GiftBillPO bill = new GiftBillPO();
		bill.setCreateDate(new Date());
		bill.setCategoryEnum(CATEGORY_ENUM);
		ArrayList<GiftPO> gifts = new ArrayList<>();
		GiftPO po = new GiftPO();
		po.setId("465");
		po.setName("a��");
		po.setPrice(1000);
		po.setGiftAmount(100);
		gifts.add(po);
		bill.setGifts(gifts);
		UserInfoPO userInfo = new UserInfoPO();
		userInfo.setId("12345");
		userInfo.setName("zaa");
		userInfo.setUserPositionEnum(UserPositionEnum.MANAGER);
		bill.setCreater(userInfo);

		bill.setCategoryEnum(CATEGORY_ENUM);
		assertEquals(true, testBl.createBill(bill));
	}
	
	/**
	 * �������Բ�ѯ����
	 * */
	@Test
	public void driveGetBill(){
		String billId ;
		
		billId = "KCZSD-20171231-00001";
		assertEquals(billId,testBl.getBillById(billId).getId());
		
		billId = "KCZSD-20171231-00002";
		assertEquals(billId, testBl.getBillById(billId).getId());
		
		billId = "KCZSD-20171228-00006";
		assertEquals(billId,testBl.getBillById(billId).getId());
	}

	/**
	 * �������Խ����ݴ���Ϊ�ݸ�
	 * */
	@Test
	public void driveSaveAsDraftBill(){
		GiftBillPO bill = new GiftBillPO();
		
		UserInfoPO userInfo = new UserInfoPO();
		userInfo.setId("12345");
		userInfo.setName("za");
		userInfo.setUserPositionEnum(UserPositionEnum.MANAGER);
		bill.setCreater(userInfo);
		bill.setId("KCZSD_2017-11-30_11_56_39");
		
		bill.setCategoryEnum(CATEGORY_ENUM);
		bill.setCreaterComment("�����òݸ嵥��7");
		assertEquals(true, testBl.saveAsDraftBill(bill));
	}
	
	/**
	 * �������Ը��²ݸ嵥��
	 * */
	@Test
	public void driveUpdateDraftBill(){
		String billId = "KCZSD_2017-11-30_11_56_39";
		GiftBillPO billPO = new GiftBillPO();
		billPO.setCreaterComment("update1�����òݸ嵥��3");
		testBl.updateDraftBill(billPO);
		
		billId = "KCZSD_2017-11-30_11_56_39";
		billPO = testBl.getBillById(billId);
		assertEquals("update1�����òݸ嵥��3", billPO.getCreaterComment());
	}
	
	/**
	 * ��������ɾ���ݸ嵥��
	 * */
	@Test
	public void driveDeleteDraftBill(){
		String billId = "KCZSD_2017-11-30_11_56_39";
		testBl.deleteDraftBill(billId);
		assertEquals(null, testBl.getBillById("KCZSD_2017-11-30_11_56_39"));
	}
	
	/**
	 * ���������ύ�ݸ嵥��
	 * */
	@Test
	public void driveSubmitBill(){
		String billId = "KCZSD_2018-01-10_04_54_07";
		assertEquals(false,testBl.submitBill(billId));
	}
	
	/**
	 * ��������pass����
	 * */
	@Test
	public void drivePassBill(){
		String billId= "KCZSD-20171231-00001";
		GiftBillPO bill = testBl.getBillById(billId);
		assertEquals(true,testBl.passBill(bill));
		assertEquals(BillStateEnum.TODO, testBl.getBillById(billId).getBillStateEnum());
	}
	
	/**
	 * ��������deny����
	 * */
	@Test
	public void driveDenyBill(){
		String billId= "KCZSD-20171231-00002";
		GiftBillPO bill = testBl.getBillById(billId);
		assertEquals(true,testBl.denyBill(bill));
		assertEquals(BillStateEnum.DENIED, testBl.getBillById(billId).getBillStateEnum());
	}
	
	/**
	 * ��������done����
	 * */
	@Test
	public void driveDoneBill(){
		String billId= "KCZSD-20171231-00001";
		GiftBillPO bill = testBl.getBillById(billId);
		assertEquals(true,testBl.doneBill(bill));
		assertEquals(BillStateEnum.DONE, testBl.getBillById(billId).getBillStateEnum());
	}
	
	/**
	 * ��������hide����
	 * */
	@Test
	public void driveHideBill(){
		String billId= "KCZSD-20171231-00002";
		GiftBillPO bill = testBl.getBillById(billId);
		assertEquals(true,testBl.hideBill(bill));
		assertEquals(BillStateEnum.HIDDEN, testBl.getBillById(billId).getBillStateEnum());
	}
	
	/**
	 * ��������ͨ��״̬��ѯ����
	 * */
	@Test
	public void driveGetBillListByState(){
		BillStateEnum billState = BillStateEnum.TBD;
		ArrayList<GiftBillPO> billPOs = testBl.getBillListByState(billState);
		for(GiftBillPO billPO: billPOs){
			assertEquals(BillStateEnum.TBD, billPO.getBillStateEnum());
		}
	}
	
	@Test
	public void driveGetDraftBillsListByCreater(){
		UserInfoPO userInfoPO = new UserInfoPO();
		userInfoPO.setId("12345");
		userInfoPO.setName("�Ű�");
		userInfoPO.setUserPositionEnum(UserPositionEnum.MANAGER);
		ArrayList<GiftBillPO> billPOs=testBl.getDraftBillsListByCreater(userInfoPO);
		for(GiftBillPO billPO:billPOs){
			assertEquals(userInfoPO, billPO.getCreater());
		}
	}
	
	@Test
	public void driveGetDeniedBillsListByCreater(){
		UserInfoPO userInfoPO = new UserInfoPO();
		userInfoPO.setId("12345");
		userInfoPO.setName("�Ű�");
		userInfoPO.setUserPositionEnum(UserPositionEnum.MANAGER);
		ArrayList<GiftBillPO> billPOs=testBl.getDeniedBillsListByCreater(userInfoPO);
		for(GiftBillPO billPO:billPOs){
			assertEquals(userInfoPO, billPO.getCreater());
		}
	}
	
	public void driveGetDoneBillsListByExecutor(){
		UserInfoPO userInfoPO = new UserInfoPO();
		userInfoPO.setId("12345");
		userInfoPO.setName("�Ű�");
		userInfoPO.setUserPositionEnum(UserPositionEnum.MANAGER);
		ArrayList<GiftBillPO> billPOs=testBl.getDoneBillsListByExecutor(userInfoPO);
		for(GiftBillPO billPO:billPOs){
			assertEquals(userInfoPO, billPO.getExecutor());
		}
	}
	@Test
	public void driveGetTBDBillsListByCreater(){
		UserInfoPO userInfoPO = new UserInfoPO();
		userInfoPO.setId("12345");
		userInfoPO.setName("�Ű�");
		userInfoPO.setUserPositionEnum(UserPositionEnum.MANAGER);
		ArrayList<GiftBillPO> billPOs=testBl.getTBDBillsListByCreater(userInfoPO);
		for(GiftBillPO billPO:billPOs){
			assertEquals(userInfoPO.getId(), billPO.getCreater().getId());
		}
	}
	@Test
	public void driveGetToDoBillsListByExecutor(){
		UserInfoPO userInfoPO = new UserInfoPO();
		userInfoPO.setId("12345");
		userInfoPO.setName("�Ű�");
		userInfoPO.setUserPositionEnum(UserPositionEnum.MANAGER);
		ArrayList<GiftBillPO> billPOs=testBl.getToDoBillsListByExecutor(userInfoPO);
		for(GiftBillPO billPO:billPOs){
			assertEquals(userInfoPO, billPO.getExecutor());
		}
	}
}
