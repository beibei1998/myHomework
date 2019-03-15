package blService.billService.approveBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.PaymentBillVO;
import vo.UserInfoVO;

public interface ApprovePaymentBillBlService extends Remote{

	/**
	 * �õ�������δ���������嵥
	 * @throws RemoteException
	 * */
	public ArrayList<PaymentBillVO> getBillsList() throws RemoteException;
	
	/**
	 * ���ݵ��ݱ��ͨ����������
	 * @throws RemoteException
	 * */
	public boolean passBill(PaymentBillVO billVO) 
			throws RemoteException;
	 
	/**
	 * ͨ�����ݱ�žܾ���������
	 * @throws RemoteException
	 * */
	public boolean denyBill(PaymentBillVO billVO) 
			throws RemoteException;
}
