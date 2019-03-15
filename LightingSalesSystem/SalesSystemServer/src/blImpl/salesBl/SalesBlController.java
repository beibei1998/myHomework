package blImpl.salesBl;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.CustomerLevelEnum;
import blService.salesBlService.SalesBlService;
import vo.UserInfoVO;
import vo.UserStrategyVO;
import vo.ComboStrategyVO;
import vo.GiftBillVO;
import vo.GoodsVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesGoodsVO;
import vo.SalesReturnBillVO;
import vo.TotalStrategyVO;

/**
 * ����������Ա�ƶ����ݵ�ҵ���߼�������
 * @author ����һ
 * @version 2017.11.7
 *
 */

public class SalesBlController implements SalesBlService {

	private SalesBl Impl=new SalesBl();
	/**
	 * �½�һ�Ź�Ӧ�̽�����
	 * @param PurchaseBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewPurchase(PurchaseBillVO vo) {
		// TODO Auto-generated method stub
		boolean success=Impl.NewPurchase(vo);
		return success;
	}

	/**
	 * �½�һ�Ź�Ӧ�̽������ݸ�
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewPurchaseDraft(PurchaseBillVO vo) {
		boolean success=Impl.NewPurchaseDraft(vo);
		return success;
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdatePurchaseDraft(PurchaseBillVO vo) {
		boolean success=Impl.UpdatePurchaseDraft(vo);
		return success;
	}
	
	/**
	 * ͨ��Idɾ��һ�Ž������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeletePurchaseDraft(String Id) {
		boolean success=Impl.DeletePurchaseDraft(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitPurchase(String Id) {
		boolean success=Impl.SubmitPurchase(Id);
		return success;
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻���
	 * @param PurchaseReturnBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewPurReturn(PurchaseReturnBillVO vo) {
		boolean success=Impl.NewPurReturn(vo);
		return success;
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewPurReturnDraft(PurchaseReturnBillVO vo) {
		boolean success=Impl.NewPurReturnDraft(vo);
		return success;
	}
	
	/**
	 * ����һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdatePurReturnDraft(PurchaseReturnBillVO vo) {
		boolean success=Impl.UpdatePurReturnDraft(vo);
		return success;
	}

	/**
	 * ͨ��Idɾ��һ�Ž����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeletePurReturnDraft(String Id) {
		boolean success=Impl.DeletePurReturnDraft(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitPurReturn(String Id) {
		boolean success=Impl.SubmitPurReturn(Id);
		return success;
	}
	
	/**
	 * �½�һ�������̳�����
	 * @param SalesBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewSales(SalesBillVO vo) {
		boolean success=Impl.NewSales(vo);
		return success;
	}

	/**
	 * �½�һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewSalesDraft(SalesBillVO vo) {
		boolean success=Impl.NewSalesDraft(vo);
		return success;
	}
	
	/**
	 * ����һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdateSalesDraft(SalesBillVO vo) {
		boolean success=Impl.UpdateSalesDraft(vo);
		return success;
	}
	
	/**
	 * ͨ��Idɾ��һ�ų������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeleteSalesDraft(String Id) {
		boolean success=Impl.DeleteSalesDraft(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitSales(String Id) {
		boolean success=Impl.SubmitSales(Id);
		return success;
	}
	
	/**
	 * �½�һ�������̳����˻���
	 * @param SalesReturnBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewSalReturn(SalesReturnBillVO vo) {
		boolean success=Impl.NewSalReturn(vo);
		return success;
	}

	/**
	 * �½�һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewSalReturnDraft(SalesReturnBillVO vo) {
		boolean success=Impl.NewSalReturnDraft(vo);
		return success;
	}
	
	/**
	 * ����һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdateSalReturnDraft(SalesReturnBillVO vo) {
		boolean success=Impl.UpdateSalReturnDraft(vo);
		return success;
	}
	
	/**
	 * ͨ��Idɾ��һ�ų����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeleteSalReturnDraft(String Id) {
		boolean success=Impl.DeleteSalReturnDraft(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitSalReturn(String Id) {
		boolean success=Impl.SubmitSalReturn(Id);
		return success;
	}
	
	/**
	 * �ƶ�����ʱ�ṩ��Ʒ�б�
	 * @return ArrayList<GoodsVO>��ArrayList��ÿһ��Ϊһ����Ʒ
	 */
	@Override
	public ArrayList<GoodsVO> CommoditySelect() {
		ArrayList<GoodsVO> result=new ArrayList<>();
		result=Impl.CommoditySelect();
		return result;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseBillVO> list=Impl.getPurchaseDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseBillVO> list=Impl.getPurchaseTBDBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseBillVO> list=Impl.getPurchaseDeniedBillsListByCreater(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseReturnBillVO> list=Impl.getPurchaseReturnDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseReturnBillVO> list=Impl.getPurchaseReturnTBDBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseReturnBillVO> list=Impl.getPurchaseReturnDeniedBillsListByCreater(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesBillVO> list=Impl.getSalesDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesBillVO> list=Impl.getSalesTBDBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesBillVO> list=Impl.getSalesDeniedBillsListByCreater(UserInfo);
		return list;
	}
	
	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesReturnBillVO> list=Impl.getSalesReturnDeniedBillsListByCreater(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesReturnBillVO> list=Impl.getSalesReturnDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesReturnBillVO> list=Impl.getSalesReturnTBDBillsList(UserInfo);
		return list;
	}

	/*
	 * ���Ƿָ��ߣ���������
	 */
	
	/**
	 * @see blService.salesBlService.SalesBlService#getTotalStrategy(double)
	 * @param consumption
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public TotalStrategyVO getTotalStrategy(double consumption) throws RemoteException {
		// TODO Auto-generated method stub
		TotalStrategyVO strategy=new TotalStrategyVO();
		strategy=Impl.getTotalStrategy(consumption);
		return strategy;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getComboStrategy(java.util.ArrayList, double)
	 * @param salesManCommodityVOs
	 * @param consumption
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ComboStrategyVO getComboStrategy(ArrayList<SalesGoodsVO> salesManCommodityVOs, double consumption)
			throws RemoteException {
		// TODO Auto-generated method stub
		ComboStrategyVO strategy=new ComboStrategyVO();
		strategy=Impl.getComboStrategy(salesManCommodityVOs, consumption);
		return strategy;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getUserStrategy(assistant.type.CustomerLevelEnum, double)
	 * @param customerLevel
	 * @param consumption
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public UserStrategyVO getUserStrategy(CustomerLevelEnum customerLevel, double consumption) throws RemoteException {
		// TODO Auto-generated method stub
		UserStrategyVO strategy=new UserStrategyVO();
		strategy=Impl.getUserStrategy(customerLevel, consumption);
		return strategy;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#generateGiftBillByTotalStrategy(vo.TotalStrategyVO)
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public GiftBillVO generateGiftBillByTotalStrategy(TotalStrategyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		GiftBillVO gift=new GiftBillVO();
		gift=Impl.generateGiftBillByTotalStrategy(vo);
		return gift;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#generateGiftBillByUserStrategy(vo.UserStrategyVO)
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public GiftBillVO generateGiftBillByUserStrategy(UserStrategyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		GiftBillVO gift=new GiftBillVO();
		gift=Impl.generateGiftBillByUserStrategy(vo);
		return gift;
	}

	
}
