package blImpl.adminBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.UserPOVOConvertor;
import assistant.exception.Myexception;
import dataImpl.userData.UserData;
import dataService.userDataService.UserDataService;
import po.UserPO;
import vo.UserVO;

/**
 * �û���bl����
 * @author zhangao 
 * @version 2017.12.26
 * */
public class AdminBl {
	
	UserDataService service =  new UserData();//���ݲ����
	
	/**
	 * ͨ��id�õ��û���Ϣ
	 * @param userId �û���id
	 * @return UserVO �û���Ϣ
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	public UserVO getUser( String userId) throws RemoteException, Myexception{
		UserPO po = service.getUser(userId);
		return UserPOVOConvertor.poToVO(po);
	}

	/**
	 * �õ���ǰ�û��嵥
	 * @return ArrayList<UserVO> ��ǰ�û��嵥
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	public ArrayList<UserVO> getUserList() throws RemoteException, Myexception{
		ArrayList<UserVO> vos = new ArrayList<>();
		ArrayList<UserPO> pos = service.getUserList();
		for(UserPO po:pos){
			UserVO vo = UserPOVOConvertor.poToVO(po);
			vos.add(vo);
		}
		return vos;
	}
	
	/**
	 * �����û�
	 * @param user �������û���Ϣ
	 * @return String ���ɵ��û���Id
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	public String addUser(UserVO user) throws RemoteException, Myexception{
		String id = SetUserIdBl.getInstance().generateId();
		UserPO po = UserPOVOConvertor.voToPO(user);
		po.setId(id);
		service.addUser(po);
		return id;
	}

	/**
	 * ɾ���û�
	 * @param userId Ҫɾ�����û�ID
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	public boolean deleteUser( String userId) throws RemoteException, Myexception{
		return service.deleteUser(userId);
	}

	/**
	 * �����û���Ϣ
	 * @param user Ҫ���µ��û���Ϣ
	 * @return �Ƿ���³ɹ�
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣����д
	 * */
	public boolean updateUser(UserVO user) throws RemoteException, Myexception{
		UserPO po = UserPOVOConvertor.voToPO(user);
		return service.updateUser(po);
	}
}
