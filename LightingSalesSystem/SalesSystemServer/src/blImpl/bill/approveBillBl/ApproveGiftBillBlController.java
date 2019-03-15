package blImpl.bill.approveBillBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.GiftBillPOVOConvertor;
import assistant.type.BillStateEnum;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.GiftBillBlService;
import blService.billService.approveBillBlService.ApproveGiftBillBlService;
import po.GiftBillPO;
import vo.GiftBillVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */

public class ApproveGiftBillBlController implements ApproveGiftBillBlService{

    private GiftBillBlService service 
    	= new BillBlInteractServiceFactory().getGiftBillBlService();//�ֽ���õ���ز���
	
    /**
	 * �õ���Ҫ�����ĵ����б�
	 * @return ArrayList<GiftBillVO> ��Ҫ�����ĵ����б�
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<GiftBillVO> getBillsList() throws RemoteException {
		ArrayList<GiftBillPO> list = service.getBillListByState(BillStateEnum.TBD);
		ArrayList<GiftBillVO> targetList =new ArrayList<GiftBillVO>();
		for(GiftBillPO po: list){
			GiftBillVO vo = GiftBillPOVOConvertor.giftBillPOtoVO(po) ;
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
	public boolean passBill(GiftBillVO billVO) throws RemoteException {
		GiftBillPO billPO = GiftBillPOVOConvertor.giftBillVOtoPO(billVO);
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
	public boolean denyBill(GiftBillVO billVO) throws RemoteException {
		GiftBillPO billPO = GiftBillPOVOConvertor.giftBillVOtoPO(billVO);
		service.denyBill(billPO);
		return true;
	}
}
