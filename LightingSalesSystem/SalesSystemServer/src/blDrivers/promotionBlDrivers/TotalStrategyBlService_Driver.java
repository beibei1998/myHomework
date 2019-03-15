package blDrivers.promotionBlDrivers;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import assistant.exception.Myexception;
import assistant.type.StrategyCategoryEnum;
import assistant.utility.Date;
import blImpl.promotionBl.TotalStrategyBlController;
import blService.promotionBlService.TotalStrategyBlService;
import vo.TotalStrategyVO;

public class TotalStrategyBlService_Driver {
	private TotalStrategyBlService service = new TotalStrategyBlController(); 
	
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * T240700
	 * */
	@Test
	public  void driveAddStrategy() throws RemoteException, Myexception{
		TotalStrategyVO vo = new TotalStrategyVO();
		vo.setId("2017-1204-02-58-48");
		vo.setCoupon(1000);
		vo.setDiscount(0.8);
		vo.setStartDate(new Date(2017,12,4,2,52));
		vo.setEndDate(new Date(2017,12,27,2,52));
		vo.setName("�û���������Vip4");
		vo.setRemark("��Ը߶˻�Ա1");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.TOTALSTRATEGY);
		assertEquals(true, service.addStrategy(vo));
	}
	
	/**
	 * T240400
	 * ȱ��1:����ʱû��Ĭ�����ô�����������
	 * */
	@Test
	public void driveGetStrategyList() throws RemoteException, Myexception{
		ArrayList<TotalStrategyVO> list = service.getStrategyList();
		for(TotalStrategyVO vo:list){
			assertEquals(StrategyCategoryEnum.TOTALSTRATEGY, vo.getStrategyCategoryEnum());
		}
	}
	
	/**
	 * T240600
	 * ����
	 * */
	@Test
	public void driveUpdate() throws RemoteException, Myexception{
		TotalStrategyVO vo = new TotalStrategyVO();
		vo.setId("2017-1204-02-58-48");
		vo.setCoupon(1000);
		vo.setDiscount(0.8);
		vo.setStartDate(new Date(2017,12,4,2,52));
		vo.setEndDate(new Date(2017,12,27,2,52));
		vo.setName("update�û���������Vip4");
		vo.setRemark("��Ը߶˻�Ա1");
		vo.setStrategyCategoryEnum(StrategyCategoryEnum.USRESTRATEGY);
		service.updateStrategy(vo);
		TotalStrategyVO updatedVo= service.getStrategyList().stream()
				.filter(v->v.getId().equals("2017-1204-02-58-48"))
				.findFirst().get(); //lambda���ʽ�õ��ô�������
		assertEquals("update�û���������Vip4", updatedVo.getName());
	}
	
	/**
	 * T240500
	 * T240501
	 * */
	@Test
	public void driveDelete() throws RemoteException, Myexception{
		assertEquals(true, service.deleteStrategy("2017-1204-02-58-48"));
		assertEquals(false, service.deleteStrategy("666"));
	}
}
