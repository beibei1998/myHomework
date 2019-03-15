package ui.mainUi.managerMainUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.uiAssistants.StageFactory;
import ui.uiAssistants.StageSize;
import vo.UserInfoVO;

/**
 * �ܾ����������������
 * @author �Ű�  161250193
 * @version 2017.12.10
 */
public class ManagerMainUiStarter {
	static private Stage stage ;//����Ҫ�ڵ�ʱ��stage�����л�
	static private UserInfoVO userInfo;
	
   /**
   * �޲������췽��
   */
	public ManagerMainUiStarter(){
		this(new Stage());
	}
	
	/**
	* stage�ڽ���scene�л�
	* @param stage Ҫ�л���stage
	*/
	public ManagerMainUiStarter(Stage stage){
		this.stage = StageFactory.getManagerStage();
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(UserInfoVO user){
		try {
			userInfo = user;
			URL location = getClass().getResource("ManagerMainUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			ManagerMainUiController controller = flLoader.getController();
			controller.setUser(user);
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* �½�һ���ܾ���������
	*/
	public void start(){
		start(userInfo);
	}
}
