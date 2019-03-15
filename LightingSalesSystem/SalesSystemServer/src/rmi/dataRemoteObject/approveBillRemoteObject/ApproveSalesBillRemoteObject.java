 package rmi.dataRemoteObject.approveBillRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import blImpl.bill.approveBillBl.ApproveSalesBillBlController;
import blService.billService.approveBillBlService.ApproveSalesBillBlService;
import vo.SalesBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */
public class ApproveSalesBillRemoteObject extends UnicastRemoteObject implements ApproveSalesBillBlService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476794552195113588L;

	public ApproveSalesBillRemoteObject() throws RemoteException {
		super();
	}

	private ApproveSalesBillBlService service = new ApproveSalesBillBlController();
	
	@Override
	public ArrayList<SalesBillVO> getBillsList() throws RemoteException {
		return service.getBillsList();
	}

	@Override
	public boolean passBill(SalesBillVO billVO) throws RemoteException {
		return service.passBill(billVO);
	}

	@Override
	public boolean denyBill(SalesBillVO billVO) throws RemoteException {
		return service.denyBill(billVO);
	}

}
