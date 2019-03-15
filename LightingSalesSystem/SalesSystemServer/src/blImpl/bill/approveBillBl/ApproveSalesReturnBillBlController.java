package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.SalesmanBillsPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.SalesReturnBillBlService;
import blService.billService.approveBillBlService.ApproveSalesReturnBillBlService;
import po.SalesReturnBillPO;
import po.UserInfoPO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApproveSalesReturnBillBlController implements ApproveSalesReturnBillBlService{

    private SalesReturnBillBlService service 
    	= new BillBlInteractServiceFactory().getSalesReturnBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<SalesReturnBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getBillsList() throws RemoteException {
		ArrayList<SalesReturnBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<SalesReturnBillVO> targetList =new ArrayList<SalesReturnBillVO>();
		for(SalesReturnBillPO po: list){
			SalesReturnBillVO vo = SalesmanBillsPOVOConvertor.salesReturnBillPOtoVO(po) ;
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
	public boolean passBill(SalesReturnBillVO billVO) throws RemoteException {
		SalesReturnBillPO billPO = SalesmanBillsPOVOConvertor.salesReturnBillVOtoPO(billVO);
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
	public boolean denyBill(SalesReturnBillVO billVO) throws RemoteException {
		SalesReturnBillPO billPO = SalesmanBillsPOVOConvertor.salesReturnBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}

}
