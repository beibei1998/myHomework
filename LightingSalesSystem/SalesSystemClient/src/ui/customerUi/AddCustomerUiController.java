package ui.customerUi;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

import java.rmi.RemoteException;
import java.util.Optional;

import assistant.type.CustomerLevelEnum;
import assistant.type.UserPositionEnum;
import blService.customerBlService.CustomerBlService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.util.Pair;
import rmi.remoteHelper.CustomerRemoteHelper;
import rmi.remoteHelper.RemoteHelperFactory;
import ui.mainUi.salesmanMainUi.SalesmanMainUiStarter;
import vo.CustomerVO;
import vo.UserInfoVO;

/**
 * @author ����һ
 *
 */
public class AddCustomerUiController {
	private CustomerVO newCustomer;
	
	private UserInfoVO user;
	
	@FXML
	private Label userNameText;
	
	@FXML
	private TextField idText;
	
	@FXML
	private TextField typeText;
	
	@FXML
	private ComboBox<String> levelComboBox;
	
	@FXML
	private TextField nameText;
	
	@FXML
	private TextField telText;
	
	@FXML
	private TextField addressText;
	
	@FXML
	private TextField postText;
	
	@FXML
	private TextField emailText;
	
	@FXML
	private TextField defaultSalesmanText;
	
	@FXML
	private TextField shouldReceiveCreditText;
	
	@FXML
	private Text shouldReceive;
	
	@FXML
	private Text shouldPay;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancleButton;
	
	ObservableList<String> options=FXCollections.observableArrayList(
			CustomerLevelEnum.VIP1.toString(),
			CustomerLevelEnum.VIP2.toString(),
			CustomerLevelEnum.VIP3.toString(),
			CustomerLevelEnum.VIP4.toString(),
			CustomerLevelEnum.VIP5.toString()
		);
	
	private CustomerRemoteHelper remoteHelper=RemoteHelperFactory.getCustomerRemoteHelper();
	
	private CustomerBlService service=remoteHelper.getCustomerBlService();
	
	//private CustomerBlService service=new CustomerBlService_Stub();
	
	public void init(UserInfoVO user) {
		this.user=user;
		String id=user.getId();
		String name=user.getName();
		UserPositionEnum position=user.getUserPositionEnum();
		newCustomer=new CustomerVO();
		
		userNameText.setText(id+System.lineSeparator()+name);
		
		levelComboBox.setItems(options);
		levelComboBox.setEditable(false);		

		levelComboBox.setOnAction(eve->{
			newCustomer.setLevel(CustomerLevelEnum.valueOf(levelComboBox.getSelectionModel().getSelectedItem()));
		});
		
		shouldReceive.setText("������");
		shouldPay.setText("������");
		
		if(position.equals(UserPositionEnum.MANAGER)) {//���Ȩ��
			shouldReceiveCreditText.setEditable(true);
		}else {
			shouldReceiveCreditText.setEditable(false);
			shouldReceiveCreditText.setText("δ�ﵽȨ��");
		}
		
	}
	
	@FXML
	protected void confirmButtonListener() {
		
		newCustomer.setAddress(addressText.getText());
		String name=defaultSalesmanText.getText();
		try {
			if(null==service.getUserByName(name)) {
				newCustomer.setDefaultSalesman(null);
				Alert alert=new Alert(AlertType.ERROR);
				alert.setTitle("����");
				alert.setHeaderText(null);
				alert.setContentText("�����ڸ�ҵ��Ա!");
				alert.showAndWait();
			}else {
				UserInfoVO businessman=service.getUserByName(name);
				newCustomer.setDefaultSalesman(businessman);
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		newCustomer.setEmail(emailText.getText());
		newCustomer.setId(idText.getText());				
		
		newCustomer.setName(nameText.getText());
		newCustomer.setPost(postText.getText());
		double credit;
		if(shouldReceiveCreditText.getText().equals("δ�ﵽȨ��")) {
			credit=0;
		}else {
			credit=Double.valueOf(shouldReceiveCreditText.getText());
		}
		
		newCustomer.setShouldReceiveCredit(credit);
		newCustomer.setTel(telText.getText());
		newCustomer.setType(typeText.getText());
		try {
			if(service.AddCustomer(newCustomer)) {
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("ϵͳ��Ϣ");
				alert.setHeaderText(null);
				alert.setContentText("�½��ͻ��ɹ�!");
				alert.showAndWait();
			}else {
				Alert alert=new Alert(AlertType.ERROR);
				alert.setTitle("����");
				alert.setHeaderText(null);
				alert.setContentText("�½��ͻ�ʧ��!");
				alert.showAndWait();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		SalesmanMainUiStarter starter=new SalesmanMainUiStarter();
		starter.startSalesman(user);
	}
	
	@FXML
	protected void cancleButtonListener() {
		SalesmanMainUiStarter starter=new SalesmanMainUiStarter();
		starter.startSalesman(user);
	}

	@FXML
	protected void shouldReceiveCreditChanged() {
		Dialog<Pair<String, String>> dialog=new Dialog<>();
		dialog.setTitle("�����֤");
		dialog.setHeaderText("��ȷ������Ȩ��");
		
		ButtonType loginButtonType=new ButtonType("ȷ��", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField userId = new TextField();
		userId.setPromptText("UserID");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("UserID:"), 0, 0);
		grid.add(userId, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		
		userId.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		Platform.runLater(()->userId.requestFocus());
		
		dialog.setResultConverter(dialogButton->{
			if(dialogButton==loginButtonType) {
				return new Pair<>(userId.getText(),password.getText());
			}
			return null;
		});
		
		Optional<Pair<String, String>> result=dialog.showAndWait();
		
		result.ifPresent(idPw->{
			//��֤�˺�����
			String id=idPw.getKey();
			String pw=idPw.getValue();
			//���Ȩ��
			if(user.getUserPositionEnum().toString().equals("manager")) {
				shouldReceiveCreditText.setEditable(true);
				dialog.close();
			}else {
				dialog.setContentText("��û��Ȩ��");
				shouldReceiveCreditText.setEditable(false);
				shouldReceiveCreditText.setText("��û��Ȩ��");
			}
		});

	}

	/**
	 * @param user
	 */
	public void setUser(UserInfoVO user) {
		// TODO Auto-generated method stub
		this.user=user;
	}
	
	
}
























