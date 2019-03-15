package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.SalesmanBillsPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.PurchaseReturnBillBlService;
import blService.billService.approveBillBlService.ApprovePurchaseReturnBillBlService;
import po.PurchaseReturnBillPO;
import po.UserInfoPO;
import vo.PurchaseReturnBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApprovePurchaseReturnBillBlController implements ApprovePurchaseReturnBillBlService{

    private PurchaseReturnBillBlService service 
    	= new BillBlInteractServiceFactory().getPurchaseReturnBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<PurchaseReturnBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getBillsList() throws RemoteException {
		ArrayList<PurchaseReturnBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<PurchaseReturnBillVO> targetList =new ArrayList<PurchaseReturnBillVO>();
		for(PurchaseReturnBillPO po: list){
			PurchaseReturnBillVO vo = SalesmanBillsPOVOConvertor.purchaseReturnBillPOtoVO(po) ;
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
	public boolean passBill(PurchaseReturnBillVO billVO) throws RemoteException {
		PurchaseReturnBillPO billPO = SalesmanBillsPOVOConvertor.purchaseReturnBillVOtoPO(billVO);
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
	public boolean denyBill(PurchaseReturnBillVO billVO) throws RemoteException {
		PurchaseReturnBillPO billPO = SalesmanBillsPOVOConvertor.purchaseReturnBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}

}
