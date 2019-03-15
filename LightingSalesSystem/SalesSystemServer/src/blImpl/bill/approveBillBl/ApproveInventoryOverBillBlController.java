package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.CommodityPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.InventoryOverBillBlService;
import blService.billService.approveBillBlService.ApproveInventoryOverBillBlService;
import po.InventoryOverBillPO;
import po.UserInfoPO;
import vo.InventoryOverBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApproveInventoryOverBillBlController implements ApproveInventoryOverBillBlService{

    private InventoryOverBillBlService service 
    	= new BillBlInteractServiceFactory().getInventoryOverBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<InventoryOverBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<InventoryOverBillVO> getBillsList() throws RemoteException {
		ArrayList<InventoryOverBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<InventoryOverBillVO> targetList =new ArrayList<InventoryOverBillVO>();
		for(InventoryOverBillPO po: list){
			InventoryOverBillVO vo = CommodityPOVOConvertor.inventoryOverBillPOtoVO(po) ;
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
	public boolean passBill(InventoryOverBillVO billVO) throws RemoteException {
		InventoryOverBillPO billPO = CommodityPOVOConvertor.inventoryOverBillVOtoPO(billVO); 
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
	public boolean denyBill(InventoryOverBillVO billVO) throws RemoteException {
		InventoryOverBillPO billPO = CommodityPOVOConvertor.inventoryOverBillVOtoPO(billVO); 
		service.denyBill(billPO);
		return true;
	}

	

}
