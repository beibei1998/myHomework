package ui.promotionUi.updatePromotionUi;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.promotionUi.PromotionUiController;
import ui.promotionUi.bLobj.Gift;
import ui.promotionUi.bLobj.Goods;
import ui.uiAssistants.StageSize;
import vo.GiftVO;

public class UpdateGiftUiStarter {
	private Stage stage ;//可能要在当时的stage进行切换
	private PromotionUiForGiftsUiController controller;
	private GiftVO goods;//页面初始化时将要现实的goods
	
   /**
   * 无参数构造方法
   */
	public UpdateGiftUiStarter(PromotionUiForGiftsUiController controller){
		this(new Stage(),controller);
	}
	
	/**
	* stage内进行scene切换
	* @param stage 要切换的stage
	*/
	public UpdateGiftUiStarter(Stage stage,PromotionUiForGiftsUiController controller){
		this.controller = controller;
		this.stage = stage;
	}
	
	/**
	* 新建一个总经理主界面
	*/
	public void start(){
		try {
			URL location = getClass().getResource("UpdateGiftUi.fxml");
			FXMLLoader flLoader = new FXMLLoader(location);
			Parent root = flLoader.load();
			
			Scene scene = new Scene(root,StageSize.STAGE_WIDTH, StageSize.STAGE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			
			//设置controller并且初始化
			UpdateGiftUiController contoller = flLoader.getController();
			contoller.setAddPromotionUiController(this.controller);
			contoller.init();
			if(goods!=null){
				contoller.setCurrentShowGoods(goods);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startAndShowGoods(GiftVO goods){
		this.goods = goods;
		start();
	}
}
