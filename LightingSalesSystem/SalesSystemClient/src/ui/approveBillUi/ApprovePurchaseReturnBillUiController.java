package ui.approveBillUi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;

import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blService.billService.approveBillBlService.ApprovePurchaseReturnBillBlService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.billUi.viewBillUi.ViewSalesmanBillsUiStarter;
import vo.BillVO;
import vo.PurchaseReturnBillVO;
import vo.UserInfoVO;

public class ApprovePurchaseReturnBillUiController {

	
	private static final String DEFAULT_APPROVER_COMENT = "�ܾ����������㣬��˦����һ�ŵ���";
	private ObservableList<PurchaseReturnBillVO> bills = FXCollections.observableArrayList();
	private UserInfoVO user;
	private ApprovePurchaseReturnBillBlService service 
		= RemoteHelperFactory.getApproveBillRemoteHelper().getApprovePurchaseReturnBillBlService(); 
	
	/**
	 * ����bottom����
	 * ͨ��������ť
	 * �ܾ�������ť
	 * */
	@FXML
	private Button passButton;
	@FXML
	private Button denyButton;
	
	/**
	 * ����center����
	 * ������Ϣtableview
	 * */
	@FXML
	private TableView<PurchaseReturnBillVO> billTableView;
	@FXML
	private TableColumn<PurchaseReturnBillVO, String> billIdColumn;
	@FXML
	private TableColumn<PurchaseReturnBillVO, String> billCreateDateColumn;
	@FXML
	private TableColumn<PurchaseReturnBillVO, String> billCreaterColumn;
	@FXML
	private TableColumn<PurchaseReturnBillVO, Button> viewBillColumn;	
	@FXML
	private TableColumn<PurchaseReturnBillVO, CheckBox> chooseBillColumn;
	@FXML
	private TableColumn<PurchaseReturnBillVO,Button> remarkTableColumn;
	@FXML
	private TableColumn<PurchaseReturnBillVO, Button> assignTableColumn;
	
	private void initTableView(){
		setBillIdColumn();
		setBillCreateDateColumn();
		setBillCreaterColumn();
		setViewBillColumn();
		setChooseBillColumn();
		setRemarkTableColumn();
		setAssignTableColumn();
		billTableView.setItems(bills);
	}

	private void setBillIdColumn(){
		billIdColumn.setCellValueFactory(cellDataFeatures->{
			BillVO bill = cellDataFeatures.getValue();
			ObservableValue<String> billId = new SimpleStringProperty(bill.getId());
			return billId;
		});
	}
	
	private void setBillCreateDateColumn(){
		billCreateDateColumn.setCellValueFactory(cellDataFeatures->{
			BillVO bill = cellDataFeatures.getValue();
			Date date = bill.getCreateDate();
			ObservableValue<String> dateString = new SimpleStringProperty(date.getYMDDate());
			return dateString;
		});
	}
	
	private void setBillCreaterColumn(){
		billCreaterColumn.setCellValueFactory(cellDataFeatures->{
			BillVO bill = cellDataFeatures.getValue();
			UserInfoVO user = bill.getCreater();
			ObservableValue<String> userName = new SimpleStringProperty(user.getName());
			return userName;
		});
	}
	
	private void setChooseBillColumn(){
		chooseBillColumn.setCellValueFactory(cellDataFeatures->{
			CheckBox checkBox = new CheckBox();
			checkBox.setAlignment(Pos.CENTER);
			checkBox.selectedProperty().addListener((x,oldValue,newValue)->{
				BillVO bill = cellDataFeatures.getValue();
				bill.setSelected(newValue);
			});
			ObservableValue<CheckBox> box = new SimpleObjectProperty<CheckBox>(checkBox);
			return box;
		});
	}
	
	private void setViewBillColumn(){
		viewBillColumn.setCellValueFactory(cellDataFeatures->{
			Button button = new Button();
			button.setText("�鿴");
			button.setAlignment(Pos.CENTER);
			button.setOnMouseClicked(e->{
				PurchaseReturnBillVO bill = (PurchaseReturnBillVO)cellDataFeatures.getValue();
				String billId = bill.getId();
				ViewSalesmanBillsUiStarter starter = new ViewSalesmanBillsUiStarter();
				starter.viewPurchaseReturnBill(billId);
				//TODO ������͵�view starter
			});
			ObservableValue<Button> btn = new SimpleObjectProperty<Button>(button);
			return btn;
 		});
	}
	
	private void setRemarkTableColumn(){
		remarkTableColumn.setCellValueFactory(cellDataFeature->{
			Button button = new Button("��ע");
			button.setOnMouseClicked(e->{
				PurchaseReturnBillVO bill = (PurchaseReturnBillVO)cellDataFeature.getValue();
				CommentDialog dialog = new CommentDialog(bill.getApproverComment());
				String comment = dialog.showAndWait();
				bill.setApproverComment(comment);
			});
			ObservableValue<Button> btn = new SimpleObjectProperty<Button>(button);
			return btn;
		});
	}
	
	private void setAssignTableColumn(){
		assignTableColumn.setCellValueFactory(cellDataFeature->{
			Button button = new Button("����");
			button.setOnMouseClicked(e->{
				BillVO bill = cellDataFeature.getValue();
				AssignUiStarter starter = new AssignUiStarter();
				starter.startAndWait(bill);
			});
			ObservableValue<Button> btn = new SimpleObjectProperty<Button>(button);
			return btn;
		});
	}
	
	/**
	 * ��ʼ��controller
	 * */
	protected void init(UserInfoVO user){
		this.user = user;
		initBillList();
		initTableView();
		initPassButton();
		initDenyButton();
	}
	
	private void initBillList(){
		ArrayList<PurchaseReturnBillVO> PurchaseReturnBills = new ArrayList<>();
		try {
			PurchaseReturnBills = service.getBillsList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bills.addAll(PurchaseReturnBills);
	}
	
	private void initPassButton(){
		passButton.setOnMouseClicked(e->{
			Alert alert = new Alert(AlertType.CONFIRMATION,"�Ƿ����ͨ��ѡ�е��ݵ�����");
			//alert.getDialogPane().getScene().getStylesheets().add(" TODO ");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.isPresent()&&result.get()==ButtonType.OK){
				try{
					for(int i=0;i<bills.size();i++){
						PurchaseReturnBillVO bill = bills.get(i);
						if(bill.isSelected()){
							bill.setBillStateEnum(BillStateEnum.TODO);
							setApproveInfo(bill);
							service.passBill(bill);
							bills.remove(bill);
							i--;
						}
					}
				}catch (RemoteException e1) {
					// TODO: handle exception
				}
				billTableView.refresh();
			}
		});
	}
	
	private void initDenyButton(){
		denyButton.setOnMouseClicked(e->{
			Alert alert = new Alert(AlertType.CONFIRMATION,"�Ƿ������ͨ��ѡ�е��ݵ�����");
			//alert.getDialogPane().getScene().getStylesheets().add(" TODO ");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.isPresent()&&result.get()==ButtonType.OK){
				try{
					for(int i=0;i<bills.size();i++){
						PurchaseReturnBillVO bill = bills.get(i);
						if(bill.isSelected()){
							bill.setBillStateEnum(BillStateEnum.DENIED);
							setApproveInfo(bill);
							service.denyBill(bill);
							bills.remove(bill);
							i--;
						}
					}
				}catch (RemoteException e1) {
					// TODO: handle exception
				}
				billTableView.refresh();
			}
		});
	}
	
	/**
	 * �����ύǰ��׼��
	 * ���õ���ִ������Ϣ�������������ڣ������ˣ������˱�ע
	 * @param billҪ���õ�bill
	 * */
	private void setApproveInfo(BillVO bill){
		bill.setApproveDate(new Date());
		bill.setApprover(user);
		if(bill.getApproverComment()==null){bill.setApproverComment(DEFAULT_APPROVER_COMENT);}
		
		//�������δͨ����������ִ����
		if(bill.getBillStateEnum()==BillStateEnum.DENIED){return;}
		
		//����ѷ���ִ���ߣ���ֱ�ӷ���
		if(bill.getExecutor()!=null){
			return;
		}
		//û�з���ִ����
		//����д����ߣ�Ĭ�ϴ�����ִ��
		if((bill.getCreater())!=null){
			bill.setExecutor(bill.getCreater());
		}
		if(bill.getCreater()==null){
			//bill.setExecutor(); TODO �����Աroll��
		}
	}
}