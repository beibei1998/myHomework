package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.FinanceBillsPOVOConvertor;
import assistant.type.BillStateEnum;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.CashExpenseBillBlService;
import blService.billService.approveBillBlService.ApproveCashExpenseBillBlService;
import po.CashExpenseBillPO;
import vo.CashExpenseBillVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApproveCashExpenseBillBlController implements ApproveCashExpenseBillBlService{

    private CashExpenseBillBlService service 
    	= new BillBlInteractServiceFactory().getCashExpenseBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<CashExpenseBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<CashExpenseBillVO> getBillsList() throws RemoteException {
		ArrayList<CashExpenseBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<CashExpenseBillVO> targetList =new ArrayList<CashExpenseBillVO>();
		for(CashExpenseBillPO po: list){
			CashExpenseBillVO vo = FinanceBillsPOVOConvertor.cashExpenseBillPOtoVO(po) ;
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
	public boolean passBill(CashExpenseBillVO billVO) throws RemoteException {
		CashExpenseBillPO billPO = FinanceBillsPOVOConvertor.cashExpenseBillVOtoPO(billVO);
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
	public boolean denyBill(CashExpenseBillVO billVO) throws RemoteException {
		CashExpenseBillPO billPO = FinanceBillsPOVOConvertor.cashExpenseBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}


}
