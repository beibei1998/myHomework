package blImpl.customerBl;

import java.rmi.RemoteException;
import java.security.Provider.Service;
import java.util.ArrayList;

import assistant.convertors.CustomerPOVOConvertor;
import assistant.exception.Myexception;
import blInteract.userInteract.GetUserInfoByUserNameService;
import blInteract.userInteract.GetUserService;
import blInteract.userInteract.GetUserServiceFactory;
import dataImpl.customerData.CustomerData;
import dataService.customerDataService.CustomerDataService;
import po.CustomerPO;
import vo.CustomerInfoVO;
import vo.CustomerVO;
import vo.UserInfoVO;
import vo.UserVO;

/**
 * ����������Ա�ͻ�����ľ���ʵ��
 * @author ����һ
 * @version 2017.11.7
 * 
 */
public class CustomerBl {

	private CustomerDataService data=new CustomerData();
	
	/**
	 * �޸Ŀͻ���Ӧ��Ӧ���ľ���ʵ��
	 * @param ID
	 * @param amount
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean ModifyCustomerMoney(String number, double amount) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerArray = new ArrayList<CustomerVO>();
		customerArray=QueryCustomer(number);
		CustomerVO customer=customerArray.get(0);
		
		if(!customer.getId().equals(number)) {
			return false;
		}
		
		if(customer.getId().charAt(0)=='i') {//������ Ӧ��
			customer.setShouldPay(amount);
		}else {//������ Ӧ��
			customer.setShouldReceive(amount);
		}
//		customer.setShouldReceive(amount);
		boolean success=ModCustomer(customer);
		return success;
	}
	
	/**
	 * �����ͻ��ľ���ʵ��
	 * @param CustomerVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean AddCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		CustomerPO customer=CustomerPOVOConvertor.customerVOtoPO(vo);
		boolean success=data.insert(customer);
		return success;
	}
	
	/**
	 * ɾ���ͻ��ľ���ʵ��
	 * @param ID
	 * @param name
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean DelCustomer(String number, String name) {
		// TODO Auto-generated method stub
		boolean success=data.delete(number, name);
		return success;
	}
	
	/**
	 * �޸Ŀͻ���Ϣ�ľ���ʵ��
	 * @param CustomerVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean ModCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		CustomerPO customer=CustomerPOVOConvertor.customerVOtoPO(vo);
		boolean success=data.update(customer);
		return success;
	}
	
	/**
	 * ��ѯ�ͻ���Ϣ�ľ���ʵ��
	 * @param name(�ؼ���)
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected ArrayList<CustomerVO> QueryCustomer(String name) {
		// TODO Auto-generated method stub
		if(data.find(name)!=null) {
			ArrayList<CustomerPO> initInfo=data.find(name);
			int size=initInfo.size();
			ArrayList<CustomerVO> info = new ArrayList<CustomerVO>();
			for(int i=0;i<size;i++) {
				info.add(CustomerPOVOConvertor.customerPOtoVO(initInfo.get(i)));
			}
			
			return info;
		}else {
			return null;
		}
		
	}
		
	/**
	 * �õ�ҵ��Ա
	 * @return ArrayList<UserInfoVO>
	 */
	protected ArrayList<UserInfoVO> GetUsers() {
		GetUserServiceFactory factory=new GetUserServiceFactory();
		GetUserService userService=factory.getGetUserService();
		if(userService.getSalesman()!=null) {
			ArrayList<UserVO> userList=userService.getSalesman();
			
			ArrayList<UserInfoVO> users=new ArrayList<>();
			UserVO temp=new UserVO();
			UserInfoVO toFillIn=new UserInfoVO();
			for(int i=0;i<userList.size();i++) {
				temp=userList.get(i);
				toFillIn.setId(temp.getId());
				toFillIn.setName(temp.getName());
				toFillIn.setUserPositionEnum(temp.getPosition());
				users.add(toFillIn);
			}
			
			return users;
		}else {
			return null;
		}
		
	}
	
	/**
	 * �õ����пͻ��Ĳ�����Ϣ����������Ա��
	 * @return ArrayList<CustomerInfoVO>
	 */
	protected ArrayList<CustomerInfoVO> GetCustomers(){
		
		ArrayList<CustomerPO> allInfos=new ArrayList<CustomerPO>();
		ArrayList<CustomerInfoVO> result=new ArrayList<CustomerInfoVO>();
		allInfos=data.getAll();
		
		for(int i=0;i<allInfos.size();i++) {
			CustomerInfoVO customer=new CustomerInfoVO();
			customer.setId(allInfos.get(i).getId());
			customer.setName(allInfos.get(i).getName());
			customer.setType(allInfos.get(i).getType());		
			customer.setLevel(allInfos.get(i).getLevel());
			System.out.println(customer.getId());
			result.add(customer);
		}
		return result;
	}
	
	/**
	 * ���������õ�ҵ��Ա
	 */
	protected UserInfoVO getUserByName(String name) throws RemoteException {
		
		GetUserServiceFactory factory=new GetUserServiceFactory();
		GetUserInfoByUserNameService service=factory.getUserInfoByUserNameService();
		try {
			UserInfoVO user=service.getUserInfoByUserName(name);
			return user;
		} catch (Myexception e) {
			e.printStackTrace();
		}
		return null;
	}
}
