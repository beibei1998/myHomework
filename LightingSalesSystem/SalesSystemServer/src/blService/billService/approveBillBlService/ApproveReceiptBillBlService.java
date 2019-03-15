package blService.billService.approveBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ReceiptBillVO;
import vo.UserInfoVO;

public interface ApproveReceiptBillBlService extends Remote{

	/**
	 * �õ�������δ���������嵥
	 * @throws RemoteException
	 * */
	public ArrayList<ReceiptBillVO> getBillsList() throws RemoteException;
	
	/**
	 * ���ݵ��ݱ��ͨ����������
	 * @throws RemoteException
	 * */
	public boolean passBill(ReceiptBillVO billVO) 
			throws RemoteException;
	 
	/**
	 * ͨ�����ݱ�žܾ���������
	 * @throws RemoteException
	 * */
	public boolean denyBill(ReceiptBillVO billVO) 
			throws RemoteException;
}
