package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.FinanceBillsPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.ReceiptBillBlService;
import blInteract.financeInteract.AutoAddEntryService;
import blInteract.financeInteract.BankAccountSumUpdateBlService;
import blInteract.financeInteract.FinanceBlFactory;
import blService.billService.approveBillBlService.ApproveReceiptBillBlService;
import po.ReceiptBillPO;
import po.UserInfoPO;
import vo.ReceiptBillVO;
import vo.SingleEntryVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApproveReceiptBillBlController implements ApproveReceiptBillBlService{

    private ReceiptBillBlService service 
    	= new BillBlInteractServiceFactory().getReceiptBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<ReceiptBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<ReceiptBillVO> getBillsList() throws RemoteException {
		ArrayList<ReceiptBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<ReceiptBillVO> targetList =new ArrayList<ReceiptBillVO>();
		for(ReceiptBillPO po: list){
			ReceiptBillVO vo = FinanceBillsPOVOConvertor.receiptBillPOtoVO(po) ;
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
	public boolean passBill(ReceiptBillVO billVO) throws RemoteException {
		ReceiptBillPO billPO = FinanceBillsPOVOConvertor.receiptBillVOtoPO(billVO);
		service.passBill(billPO);
		
		//�޸������˻�
		BankAccountSumUpdateBlService bankAccountSumUpdateBlService= new FinanceBlFactory().getBankAccountSumUpdateBlService();
		bankAccountSumUpdateBlService.updateRemainingSum(billPO.getBankAccount(),billPO.getSum());
		
		AutoAddEntryService entryService=new FinanceBlFactory().getAutoAddEntryService();
		Date date=new Date();
		String year=date.getDate().substring(0, 4);
		SingleEntryVO single=new SingleEntryVO(year, date.getDate(),"�տ�","+"+String.valueOf(billPO.getSum()));
		entryService.autoAddEntry(single);
		
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
	public boolean denyBill(ReceiptBillVO billVO) throws RemoteException {
		ReceiptBillPO billPO = FinanceBillsPOVOConvertor.receiptBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}

}
