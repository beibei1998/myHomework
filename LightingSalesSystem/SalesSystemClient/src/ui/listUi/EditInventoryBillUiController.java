package ui.listUi;

import java.rmi.RemoteException;

import assistant.type.UserPositionEnum;
import blService.commodityBlService.SaveBillBlService;
import blStubs.commodityBlStubs.SaveBillService_Stub;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import rmi.remoteHelper.CommodityRemoteHelper;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;

public class EditInventoryBillUiController {
	@FXML private Text billNameText;
	@FXML private Text BillID;
	@FXML private Text createDateText;
	@FXML private Text Operator;
	@FXML private Text GoodsName;
	@FXML private Text GoodsID;
	@FXML private Text GoodsType;
	@FXML private TextField GoodsPrice;
	@FXML private TextField SysInvenAmount;
	@FXML private Text RealOrWarningLabel;
	@FXML private TextField RealOrWarningAmount;
	@FXML private Text dAmountLabel;
	@FXML private TextField dAmount;

	@FXML private Label billStateLabel;
	@FXML private Text approverText;
	@FXML private Text executorText;
	@FXML private Text approveDateText;
	@FXML private Text finishDateText;
	@FXML private TextArea approverCommentArea;

	private InventoryWarningBillVO warningBill=null;
	private InventoryLossBillVO lossBill=null;
	private InventoryOverBillVO overBill=null;

	private SaveBillBlService saveBillSer=CommodityRemoteHelper.getInstance().getSaveBillBlService();


	private Stage billStage;

	public void editInventoryWarningBill(Stage stage,InventoryWarningBillVO bill,String type){
    	warningBill=bill;

    	billStage=stage;
    	if(bill.getCategoryEnum()!=null)
    		billNameText.setText(bill.getCategoryEnum().toChineseString());
   		if(bill.getId()!=null)
   			BillID.setText(bill.getId());
   		if(bill.getCreateDate()!=null)
   			createDateText.setText(bill.getCreateDate().getDate());
   		if(bill.getCreater()!=null)
   			Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
   		if(bill.getGoodsName()!=null)
   			GoodsName.setText(bill.getGoodsName());
   		if(bill.getGoodsID()!=null)
   			GoodsID.setText(bill.getGoodsID());
   		if(bill.getGoodsType()!=null)
   			GoodsType.setText(bill.getGoodsType());
   		RealOrWarningLabel.setText("����ֵ��");
   		dAmountLabel.setText("ȱ��ֵ��");
   		if(type.equals("��岢����")){
   			if(bill.getGoodsPrice()!=null)
   				GoodsPrice.setText(bill.getGoodsPrice());
   			if(bill.getSystemAmount()!=null)
   				SysInvenAmount.setText(bill.getSystemAmount());
   			if(bill.getWarningAmount()!=null)
   				RealOrWarningAmount.setText(bill.getWarningAmount());
   			if(bill.getLossAmount()!=null)
   				dAmount.setText(bill.getLossAmount());
   		}else{
   			if(bill.getGoodsPrice()!=null)
   				GoodsPrice.setText("-"+bill.getGoodsPrice());
   			if(bill.getSystemAmount()!=null)
   				SysInvenAmount.setText("-"+bill.getSystemAmount());
   			if(bill.getWarningAmount()!=null)
   				RealOrWarningAmount.setText("-"+bill.getWarningAmount());
   			if(bill.getLossAmount()!=null)
   				dAmount.setText("-"+bill.getLossAmount());
   		}

   		if(bill.getBillStateEnum()!=null)
   			billStateLabel.setText(bill.getBillStateEnum().toString());
   		if(bill.getApprover()!=null)
   			approverText.setText(bill.getApprover().getName());
   		if(bill.getExecutor()!=null)
   			executorText.setText(bill.getExecutor().getName());
   		if(bill.getApproveDate()!=null)
   			approveDateText.setText(bill.getApproveDate().getDate());
   		if(bill.getFinishDate()!=null)
   			finishDateText.setText(bill.getFinishDate().getDate());
   		if(bill.getApproverComment()!=null)
   			approverCommentArea.setText(bill.getApproverComment());

       }
       public void editInventoryLossBill(Stage stage,InventoryLossBillVO bill,String type){
    	lossBill=bill;

    	billStage=stage;
    	if(bill.getCategoryEnum()!=null)
    		billNameText.setText(bill.getCategoryEnum().toChineseString());
   		if(bill.getId()!=null)
   			BillID.setText(bill.getId());
   		if(bill.getCreateDate()!=null)
   			createDateText.setText(bill.getCreateDate().getDate());
   		if(bill.getCreater()!=null)
   			Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
   		if(bill.getGoodsName()!=null)
   			GoodsName.setText(bill.getGoodsName());
   		if(bill.getGoodsID()!=null)
   			GoodsID.setText(bill.getGoodsID());
   		if(bill.getGoodsType()!=null)
   			GoodsType.setText(bill.getGoodsType());
   		RealOrWarningLabel.setText("ʵ�ʿ�棺");
   		dAmountLabel.setText("ȱ��ֵ��");

   		if(type.equals("��岢����")){
   			if(bill.getGoodsPrice()!=null)
   				GoodsPrice.setText(bill.getGoodsPrice());
   			if(bill.getSystemAmount()!=null)
   				SysInvenAmount.setText(bill.getSystemAmount());
   			if(bill.getRealAmount()!=null)
   				RealOrWarningAmount.setText(bill.getRealAmount());
   			if(bill.getLossAmount()!=null)
   				dAmount.setText(bill.getLossAmount());
   		}else{
   			if(bill.getGoodsPrice()!=null)
   				GoodsPrice.setText("-"+bill.getGoodsPrice());
   			if(bill.getSystemAmount()!=null)
   				SysInvenAmount.setText("-"+bill.getSystemAmount());
   			if(bill.getRealAmount()!=null)
   				RealOrWarningAmount.setText("-"+bill.getRealAmount());
   			if(bill.getLossAmount()!=null)
   				dAmount.setText("-"+bill.getLossAmount());
   		}

   		if(bill.getBillStateEnum()!=null)
   			billStateLabel.setText(bill.getBillStateEnum().toString());
   		if(bill.getApprover()!=null)
   			approverText.setText(bill.getApprover().getName());
   		if(bill.getExecutor()!=null)
   			executorText.setText(bill.getExecutor().getName());
   		if(bill.getApproveDate()!=null)
   			approveDateText.setText(bill.getApproveDate().getDate());
   		if(bill.getFinishDate()!=null)
   			finishDateText.setText(bill.getFinishDate().getDate());
   		if(bill.getApproverComment()!=null)
   			approverCommentArea.setText(bill.getApproverComment());
       }

       public void editInventoryOverBill(Stage stage,InventoryOverBillVO bill,String type){
    	overBill=bill;

        billStage=stage;
        if(bill.getCategoryEnum()!=null)
    		billNameText.setText(bill.getCategoryEnum().toChineseString());
   		if(bill.getId()!=null)
   			BillID.setText(bill.getId());
   		if(bill.getCreateDate()!=null)
   			createDateText.setText(bill.getCreateDate().getDate());
   		if(bill.getCreater()!=null)
   			Operator.setText(bill.getCreater().getName()+" "+bill.getCreater().getId());
   		if(bill.getGoodsName()!=null)
   			GoodsName.setText(bill.getGoodsName());
   		if(bill.getGoodsID()!=null)
   			GoodsID.setText(bill.getGoodsID());
   		if(bill.getGoodsType()!=null)
   			GoodsType.setText(bill.getGoodsType());
   		RealOrWarningLabel.setText("ʵ�ʿ�棺");
   		dAmountLabel.setText("���ֵ��");

   		if(type.equals("��岢����")){
   			if(bill.getGoodsPrice()!=null)
   				GoodsPrice.setText(bill.getGoodsPrice());
   			if(bill.getSystemAmount()!=null)
   				SysInvenAmount.setText(bill.getSystemAmount());
   			if(bill.getRealAmount()!=null)
   				RealOrWarningAmount.setText(bill.getRealAmount());
   			if(bill.getOverAmount()!=null)
   				dAmount.setText(bill.getOverAmount());
   		}else{
   			if(bill.getGoodsPrice()!=null)
   				GoodsPrice.setText("-"+bill.getGoodsPrice());
   			if(bill.getSystemAmount()!=null)
   				SysInvenAmount.setText("-"+bill.getSystemAmount());
   			if(bill.getRealAmount()!=null)
   				RealOrWarningAmount.setText("-"+bill.getRealAmount());
   			if(bill.getOverAmount()!=null)
   				dAmount.setText("-"+bill.getOverAmount());
   		}

   		if(bill.getBillStateEnum()!=null)
   			billStateLabel.setText(bill.getBillStateEnum().toString());
   		if(bill.getApprover()!=null)
   			approverText.setText(bill.getApprover().getName());
   		if(bill.getExecutor()!=null)
   			executorText.setText(bill.getExecutor().getName());
   		if(bill.getApproveDate()!=null)
   			approveDateText.setText(bill.getApproveDate().getDate());
   		if(bill.getFinishDate()!=null)
   			finishDateText.setText(bill.getFinishDate().getDate());
   		if(bill.getApproverComment()!=null)
   			approverCommentArea.setText(bill.getApproverComment());
       }

       @FXML protected void confirmTheBill(){
//�����嵥
    	   if(warningBill==null){

    	   }else{
    		   warningBill.setGoodsPrice(GoodsPrice.getText());
    		   warningBill.setSystemAmount(SysInvenAmount.getText());
    		   warningBill.setWarningAmount(RealOrWarningAmount.getText());
    		   warningBill.setLossAmount(dAmount.getText());
    		   //���������ܳ��ָĶ�
    		   try{
    		   saveBillSer.saveInventoryWarningBill(warningBill);
    		   }catch(RemoteException e){
                e.printStackTrace();
               }
    		   Alert saveBillSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ������汨����");
    		   saveBillSuccess.showAndWait();
    	   }
           if(lossBill==null){

    	   }else{
    		   lossBill.setGoodsPrice(GoodsPrice.getText());
    		   lossBill.setSystemAmount(SysInvenAmount.getText());
    		   lossBill.setRealAmount(RealOrWarningAmount.getText());
    		   lossBill.setLossAmount(dAmount.getText());
    		   //���������ܳ��ָĶ�
    		   try{
    		   saveBillSer.saveInventoryLossBill(lossBill);
    		   }catch(RemoteException e){
                e.printStackTrace();
               }
    		   Alert saveBillSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ������汨��");
    		   saveBillSuccess.showAndWait();
    	   }
           if(overBill==null){

           }else{
        	   overBill.setGoodsPrice(GoodsPrice.getText());
        	   overBill.setSystemAmount(SysInvenAmount.getText());
    		   overBill.setRealAmount(RealOrWarningAmount.getText());
    		   overBill.setOverAmount(dAmount.getText());
    		   //���������ܳ��ָĶ�
    		   try{
    		   saveBillSer.saveInventoryOverBill(overBill);
    		   }catch(RemoteException e){
                e.printStackTrace();
               }
    		   Alert saveBillSuccess=new Alert(Alert.AlertType.INFORMATION,"�ɹ������汨�絥");
    		   saveBillSuccess.showAndWait();
           }
       }

       @FXML
       protected void backButtonListener(){
   			BusinessProcessListUiStarter starter=new BusinessProcessListUiStarter();
   			starter.businessProcessListUi(UserPositionEnum.FINANCE);
       }
}
