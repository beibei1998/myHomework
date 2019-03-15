package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.CommodityPOVOConvertor;
import assistant.convertors.InOutPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.InventoryLossBillBlService;
import blService.billService.approveBillBlService.ApproveInventoryLossBillBlService;
import po.InventoryLossBillPO;
import po.UserInfoPO;
import vo.InventoryLossBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApproveInventoryLossBillBlController implements ApproveInventoryLossBillBlService{

    private InventoryLossBillBlService service 
    	= new BillBlInteractServiceFactory().getInventoryLossBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<InventoryLossBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<InventoryLossBillVO> getBillsList() throws RemoteException {
		ArrayList<InventoryLossBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<InventoryLossBillVO> targetList =new ArrayList<InventoryLossBillVO>();
		for(InventoryLossBillPO po: list){
			InventoryLossBillVO vo = CommodityPOVOConvertor.inventoryLossBillPOtoVO(po) ;
			targetList.add(vo);
		}
		return targetList;
	}

	  /**
	  * ����Idͨ�����ݵ�����
	  * @param String billId���ݵ�Id
	  * @param UserInfoVO approver ��������Ϣ
	  * @param String approverComment �����˵���ע 
	  * @throws RemoteException
	  */
	@Override
	public boolean passBill(InventoryLossBillVO billVO) throws RemoteException {
		InventoryLossBillPO billPO = CommodityPOVOConvertor.inventoryLossBillVOtoPO(billVO);
		service.passBill(billPO);
		return true;
	}

	 /**
	  * ����Id�ܾ�ͨ�����ݵ�����
	  * @param String billId���ݵ�Id
	  * @param UserInfoVO approver ��������Ϣ
	  * @param String approverComment �����˵���ע 
	  * @throws RemoteException
	  */
	@Override
	public boolean denyBill(InventoryLossBillVO billVO) throws RemoteException {
		InventoryLossBillPO billPO = CommodityPOVOConvertor.inventoryLossBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}

}
