package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.FinanceBillsPOVOConvertor;

import assistant.convertors.UserInfoPOVOConvertor;
import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.PaymentBillBlService;
import blInteract.financeInteract.AutoAddEntryService;
import blInteract.financeInteract.BankAccountSumUpdateBlService;
import blInteract.financeInteract.FinanceBlFactory;
import blService.billService.approveBillBlService.ApprovePaymentBillBlService;
import po.PaymentBillPO;
import po.UserInfoPO;
import vo.PaymentBillVO;
import vo.SingleEntryVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApprovePaymentBillBlController implements ApprovePaymentBillBlService{

    private PaymentBillBlService service 
    	= new BillBlInteractServiceFactory().getPaymentBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<PaymentBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PaymentBillVO> getBillsList() throws RemoteException {
		ArrayList<PaymentBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<PaymentBillVO> targetList =new ArrayList<PaymentBillVO>();
		for(PaymentBillPO po: list){
			PaymentBillVO vo = FinanceBillsPOVOConvertor.paymentBillPOtoVO(po) ;
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
	public boolean passBill(PaymentBillVO billVO) throws RemoteException {
		PaymentBillPO billPO = FinanceBillsPOVOConvertor.paymentBillVOtoPO(billVO);
		service.passBill(billPO);
		
		//�޸������˻�
		BankAccountSumUpdateBlService bankAccountSumUpdateBlService= new FinanceBlFactory().getBankAccountSumUpdateBlService();
		bankAccountSumUpdateBlService.updateRemainingSum(billPO.getBankAccount(),-billPO.getSum());
		
		AutoAddEntryService entryService=new FinanceBlFactory().getAutoAddEntryService();
		Date date=new Date();
		String year=date.getDate().substring(0, 4);
		SingleEntryVO single=new SingleEntryVO(year, date.getDate(),"����","-"+String.valueOf(billPO.getSum()));
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
	public boolean denyBill(PaymentBillVO billVO) throws RemoteException {
		PaymentBillPO billPO = FinanceBillsPOVOConvertor.paymentBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}

}
