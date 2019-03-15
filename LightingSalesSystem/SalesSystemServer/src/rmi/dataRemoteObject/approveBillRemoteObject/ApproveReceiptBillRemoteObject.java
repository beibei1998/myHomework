package rmi.dataRemoteObject.approveBillRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import blImpl.bill.approveBillBl.ApproveReceiptBillBlController;
import blService.billService.approveBillBlService.ApproveReceiptBillBlService;
import vo.ReceiptBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */
public class ApproveReceiptBillRemoteObject extends UnicastRemoteObject implements ApproveReceiptBillBlService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476794552195113588L;

	public ApproveReceiptBillRemoteObject() throws RemoteException {
		super();
	}

	private ApproveReceiptBillBlService service = new ApproveReceiptBillBlController();
	
	@Override
	public ArrayList<ReceiptBillVO> getBillsList() throws RemoteException {
		return service.getBillsList();
	}

	@Override
	public boolean passBill(ReceiptBillVO billVO) throws RemoteException {
		return service.passBill(billVO);
	}

	@Override
	public boolean denyBill(ReceiptBillVO billVO) throws RemoteException {
		return service.denyBill(billVO);
	}

}
