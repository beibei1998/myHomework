/**
 * �ֿ����Ա��½�������棬����������������в����İ�ť
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package ui.mainUi.wareKeeperMainUi;

import assistant.type.UserPositionEnum;
import assistant.utility.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.billUi.billStateUi.WareKeeperBillStateUiStarter;
import ui.commodityUi.ActualInventoryCheckUiStarter;
import ui.commodityUi.AddGoodsUiStarter;
import ui.commodityUi.DeleteGoodsUiStarter;
import ui.commodityUi.GoodsClassificationUiStarter;
import ui.commodityUi.GoodsInforManagementUiStarter;
import ui.commodityUi.InventoryCheckUiStarter;
import ui.commodityUi.StockCheckUiStarter;
import vo.UserInfoVO;

public class WareKeeperMainUiController {
	//��ʼ���ֿ������Ա������
	@FXML private Text operatorName;
	@FXML private Text operatorID;
	@FXML private Text Date;

	private Stage currentStage;
	private static String opeName;
	private static String opeID;

	public void setInitInfor(String name,String id,Stage stage){
		Date date=new Date();
		Date.setText("���ڣ�"+date.getYMDDate());
		currentStage=stage;
        if(name==null){

        }else{
        	opeName=name;
        }

        if(id==null){

        }else{
        	opeID=id;
        }
        operatorName.setText("������Ա���ƣ�"+opeName);
		operatorID.setText("������Ա��ţ�"+opeID);
	}
	@FXML protected void toViewBills(){
        WareKeeperBillStateUiStarter starter=new WareKeeperBillStateUiStarter();
        UserInfoVO user=new UserInfoVO();
        user.setId(opeID);
        user.setName(opeName);
        user.setUserPositionEnum(UserPositionEnum.WAREKEPPER);
        starter.wareKeeperBillStateUi(currentStage,user);
	}
	@FXML protected void toClassMana(){
          GoodsClassificationUiStarter starter=new GoodsClassificationUiStarter();
          starter.initGoodsClassificationUi(currentStage);
	}
	@FXML protected void toAddGoods(){
          AddGoodsUiStarter starter=new AddGoodsUiStarter();
          starter.initAddGoodsUi(currentStage,opeName);
	}
	@FXML protected void toDeleteGoods(){
		DeleteGoodsUiStarter starter=new DeleteGoodsUiStarter();
        starter.initDeleteGoodsUi(currentStage,opeID, opeName);
	}
	@FXML protected void toGoodsInfor(){
          GoodsInforManagementUiStarter starter=new GoodsInforManagementUiStarter();
          starter.initGoodsInforManagementUi(currentStage);

	}
	@FXML protected void toStoCheck(){
          StockCheckUiStarter starter=new StockCheckUiStarter();
          starter.initStockCheckUi(currentStage);
	}
	@FXML protected void toInvenCheck(){
	    //�κ�ʱ�򶼿��Խ��п���̵㣬ֻ����һ���������̵�Ƚ�ȫ�����
		InventoryCheckUiStarter starter=new InventoryCheckUiStarter();
        starter.initInventoryCheckUi(currentStage);
	//	}
	}
	@FXML protected void toActualInven(){
         ActualInventoryCheckUiStarter starter=new ActualInventoryCheckUiStarter();
         starter.initActualInventoryCheckUi(currentStage,opeName,opeID);
	}
	@FXML protected void exit(){
         currentStage.close();
	}

}
