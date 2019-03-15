package blImpl.adminBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.exception.Myexception;
import blService.adminBlService.AdminBlService;
import vo.UserVO;

public class AdminBlController implements AdminBlService {
	
	private AdminBl bl = new AdminBl();
	
	/**
	 * ͨ��id�õ��û���Ϣ
	 * @param userId �û���id
	 * @return UserVO �û���Ϣ
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	@Override
	public UserVO getUser(String userId) throws RemoteException,Myexception {
		return bl.getUser(userId);
	}

	/**
	 * �����û�
	 * @param user �������û���Ϣ
	 * @return String ���ɵ��û���Id
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	@Override
	public String addUser(UserVO user)throws RemoteException,Myexception {
		
		return bl.addUser(user);
	}

	/**
	 * ɾ���û�
	 * @param userId Ҫɾ�����û�ID
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	@Override
	public boolean deleteUser( String userId)throws RemoteException,Myexception {
		
		return bl.deleteUser(userId);
	}
	
	/**
	 * �����û���Ϣ
	 * @param user Ҫ���µ��û���Ϣ
	 * @return �Ƿ���³ɹ�
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	@Override
	public boolean updateUser(UserVO user)throws RemoteException,Myexception  {
		return bl.updateUser(user);
	}

	
	/**
	 * �õ���ǰ�û��嵥
	 * @return ArrayList<UserVO> ��ǰ�û��嵥
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	@Override
	public ArrayList<UserVO> getUserList()throws RemoteException,Myexception  {
		return bl.getUserList();
	}

}
