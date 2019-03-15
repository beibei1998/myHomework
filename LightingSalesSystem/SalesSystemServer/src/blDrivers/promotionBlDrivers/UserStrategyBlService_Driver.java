package blDrivers.promotionBlDrivers;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import assistant.exception.Myexception;
import assistant.type.CustomerLevelEnum;
import assistant.type.StrategyCategoryEnum;
import assistant.utility.Date;
import blImpl.promotionBl.UserStrategyBlController;
import blService.promotionBlService.UserStrategyBlService;
import vo.UserStrategyVO;

public class UserStrategyBlService_Driver {

	private UserStrategyBlService service = new UserStrategyBlController(); 
	
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * T240300
	 * */
	@Test
	public  void driveAddStrategy() throws RemoteException, Myexception{
		UserStrategyVO vo = new UserStrategyVO();
		vo.setId("2017-1204-02-58-48");
		vo.setCoupon(1000);
		vo.setCustomerLevel(CustomerLevelEnum.VIP4);
		vo.setDiscount(0.8);
		vo.setStartDate(new Date(2017,12,4,2,52));
		vo.setEndDate(new Date(2017,12,27,2,52));
		vo.setName("�û���������Vip4");
		vo.setRemark("��Ը߶˻�Ա1");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.USRESTRATEGY);
		assertEquals(true, service.addStrategy(vo));
	}
	
	/**
	 * T240000
	 * ȱ��1:����ʱû��Ĭ�����ô�����������
	 * */
	@Test
	public void driveGetStrategyList() throws RemoteException, Myexception{
		ArrayList<UserStrategyVO> list = service.getStrategyList();
		for(UserStrategyVO vo:list){
			assertEquals(StrategyCategoryEnum.USRESTRATEGY, vo.getStrategyCategoryEnum());
		}
	}
	
	/**
	 * T240200
	 * ����
	 * */
	@Test
	public void driveUpdate() throws RemoteException, Myexception{
		UserStrategyVO vo = new UserStrategyVO();
		vo.setId("2017-1204-02-58-48");
		vo.setCoupon(1000);
		vo.setCustomerLevel(CustomerLevelEnum.VIP4);
		vo.setDiscount(0.8);
		vo.setStartDate(new Date(2017,12,4,2,52));
		vo.setEndDate(new Date(2017,12,27,2,52));
		vo.setName("update�û���������Vip4");
		vo.setRemark("��Ը߶˻�Ա1");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.USRESTRATEGY);
		service.updateStrategy(vo);
		UserStrategyVO updatedVo= service.getStrategyList().stream()
				.filter(v->v.getId().equals("2017-1204-02-58-48"))
				.findFirst().get(); //lambda���ʽ�õ��ô�������
		assertEquals("update�û���������Vip4", updatedVo.getName());
	}
	
	/**
	 * T240100
	 * T240101
	 * */
	@Test
	public void driveDelete() throws RemoteException, Myexception{
		assertEquals(true, service.deleteStrategy("2017-1204-02-58-48"));
		assertEquals(false, service.deleteStrategy("666"));
	}
	

}
