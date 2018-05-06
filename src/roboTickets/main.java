// Author			Robert Boutillier
// Date created		3/24/18
// Date updated		5/1/18
// Version			2.0
// All Rights Reserved©
package roboTickets;
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 

import javafx.scene.Scene; 
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.css.*;
import javafx.scene.paint.*;
import javafx.collections.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

import java.nio.file.Paths;
import java.io.*;
import java.util.*;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.nio.file.*;
import javafx.scene.control.ChoiceBox;

public class main extends Application {
	private Text welcomeText = new Text("Robo Tickets");
	private Text loginWarningText = new Text("Can't contain spaces or any \nspecial characters.");
	private Text mainMenuText = new Text();
	private Text userWarningText = new Text("Enter your first and last name.");
	private Text mainMenuWelcomeText = new Text("Welcome");
	private Text choosePaymentText = new Text("Choose Payment Type");
	private Text adultTicketsText = new Text("Adult: ");
	private Text childTicketsText = new Text("Child: ");
	private Text elderTicketsText = new Text("Elder: ");
	private Text adultTicketPriceText = new Text("50");
	private Text childTicketPriceText = new Text(Double.toString(50/2));
	private Text elderTicketPriceText = new Text(Double.toString(50 * 0.75));
	private Text adultTicketCountText = new Text("0");
	private Text childTicketCountText = new Text("0");
	private Text elderTicketCountText = new Text("0");
	private Text creditCardText = new Text("Credit Card");
	private Text amountPayedText = new Text("$0");
	private Font welcomeFont = Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR, 36);
	private Font warningFont = Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 9);
	private Font invisibleFont = Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 0);
	private Font mainMenuWelcomeFont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 24);
	private Font listUserFont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15);
	private TextField userNameField = new TextField();
	private TextField loginNameField = new TextField();
	private TextField firstNameField = new TextField();
	private TextField lastNameField = new TextField();
	private TextField ccNumField = new TextField();
	private TextField ccSecNumField = new TextField();
	private TextField streetAddressField = new TextField();
	private TextField zipCodeField = new TextField();
	private TextField googleUserNameField = new TextField();
	private PasswordField googlePasswordField = new PasswordField();
	private TextField appleUserNameField = new TextField();
	private PasswordField applePasswordField = new PasswordField();
	private PasswordField passwordTextField = new PasswordField();
	private Button signUpEnterButton = new Button("Enter");
	private Button enterUserButton = new Button("Enter Users");
	private Button ownerEnterUserButton = new Button("Enter Users");
	private Button listUserButton = new Button("List Users");
	private Button exitWelcomeButton = new Button("Exit");
	private Button backButton = new Button("Back");
	private Button logInButton = new Button("Log In");
	private Button signUpButton = new Button("Sign Up");
	private Button backSignUpButton = new Button("Back");
	private Button buyTicketsButton = new Button("Buy Tickets");
	private Button purchaseTicketsButton = new Button("Purchase");
	private Button adultUpButton = new Button("▲");
	private Button adultDownButton = new Button("▼");
	private Button childUpButton = new Button("▲");
	private Button childDownButton = new Button("▼");
	private Button elderUpButton = new Button("▲");
	private Button elderDownButton = new Button("▼");
	private Button creditCardEnterButton = new Button("Enter");
	private Button ticketPayButton = new Button("Pay");
	private Button enterAppleInfoButton = new Button("Enter");
	private Button showPayButton = new Button("Show Amount Paid");
	private RadioButton sportTicketButton = new RadioButton("Sport Tickets");
	private RadioButton theaterTicketButton = new RadioButton("Theater Tickets");
	private RadioButton concertTicketButton = new RadioButton("Concert Tickets");
	private Button chooseCreditCardButton = new Button("Credit Card");
	private Button chooseApplePayButton = new Button("Apple Pay");
	private Button chooseGooglePayButton = new Button("Google Pay");
	private Button enterGoogleInfoButton = new Button("Enter");
	private ChoiceBox monthPickerBox = new ChoiceBox();
	private ChoiceBox yearPickerBox = new ChoiceBox();
	private ChoiceBox statePickerBox = new ChoiceBox();
	private ToggleGroup ticketGroup = new ToggleGroup();
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<String> loginNames = new ArrayList<>();
	public static ArrayList<String> userNames = new ArrayList<>();
	public static ArrayList<User> newUsers = new ArrayList<>();
	public static ArrayList<String> passwords = new ArrayList<>();
	public static File file = new File("users.dat");
	public int userID = 0;
	
	public void start(Stage stage) {
		welcomeText.setFont(welcomeFont);
		welcomeText.setFill(Color.BLACK);
		loginWarningText.setFont(invisibleFont);
		userWarningText.setFont(invisibleFont);
		loginWarningText.setVisible(false);
		mainMenuText.setFont(mainMenuWelcomeFont);
		mainMenuText.setFill(Color.BLACK);
		mainMenuWelcomeText.setFont(mainMenuWelcomeFont);
		mainMenuWelcomeText.setFill(Color.BLACK);
		creditCardText.setFont(mainMenuWelcomeFont);
		creditCardText.setFill(Color.BLACK);
		userNameField.setPromptText("User Name");
		loginNameField.setPromptText("Login Name");
		firstNameField.setPromptText("First Name");
		lastNameField.setPromptText("Last Name");
		ccNumField.setPromptText("Credit Card Number");
		ccSecNumField.setPromptText("Security Number");
		passwordTextField.setPromptText("Password");
		streetAddressField.setPromptText("Enter Street Address");
		zipCodeField.setPromptText("Enter Zip Code");
		googleUserNameField.setPromptText("Enter Google Username");
		googlePasswordField.setPromptText("Enter Google Password");
		appleUserNameField.setPromptText("Enter Apple Username");
		applePasswordField.setPromptText("Enter Apple Password");
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		amountPayedText.setFont(welcomeFont);
		monthPickerBox.getItems().add("1");
		monthPickerBox.getItems().add("2");
		monthPickerBox.getItems().add("3");
		monthPickerBox.getItems().add("4");
		monthPickerBox.getItems().add("5");
		monthPickerBox.getItems().add("6");
		monthPickerBox.getItems().add("7");
		monthPickerBox.getItems().add("8");
		monthPickerBox.getItems().add("9");
		monthPickerBox.getItems().add("10");
		monthPickerBox.getItems().add("11");
		monthPickerBox.getItems().add("12");
		yearPickerBox.getItems().add("2019");
		yearPickerBox.getItems().add("2020");
		yearPickerBox.getItems().add("2021");
		yearPickerBox.getItems().add("2022");
		yearPickerBox.getItems().add("2023");
		yearPickerBox.getItems().add("2024");
		statePickerBox.getItems().add("AL");
		statePickerBox.getItems().add("AK");
		statePickerBox.getItems().add("AS");
		statePickerBox.getItems().add("AZ");
		statePickerBox.getItems().add("AR");
		statePickerBox.getItems().add("CA");
		statePickerBox.getItems().add("CO");
		statePickerBox.getItems().add("CT");
		statePickerBox.getItems().add("DE");
		statePickerBox.getItems().add("DC");
		statePickerBox.getItems().add("FM");
		statePickerBox.getItems().add("FL");
		statePickerBox.getItems().add("GA");
		statePickerBox.getItems().add("GU");
		statePickerBox.getItems().add("HI");
		statePickerBox.getItems().add("ID");
		statePickerBox.getItems().add("IL");
		statePickerBox.getItems().add("IN");
		statePickerBox.getItems().add("IA");
		statePickerBox.getItems().add("KS");
		statePickerBox.getItems().add("KY");
		statePickerBox.getItems().add("LA");
		statePickerBox.getItems().add("ME");
		statePickerBox.getItems().add("MH");
		statePickerBox.getItems().add("MD");
		statePickerBox.getItems().add("MA");
		statePickerBox.getItems().add("MI");
		statePickerBox.getItems().add("MN");
		statePickerBox.getItems().add("MS");
		statePickerBox.getItems().add("MO");
		statePickerBox.getItems().add("MT");
		statePickerBox.getItems().add("NE");
		statePickerBox.getItems().add("NV");
		statePickerBox.getItems().add("NH");
		statePickerBox.getItems().add("NJ");
		statePickerBox.getItems().add("NM");
		statePickerBox.getItems().add("NY");
		statePickerBox.getItems().add("NC");
		statePickerBox.getItems().add("ND");
		statePickerBox.getItems().add("MP");
		statePickerBox.getItems().add("OH");
		statePickerBox.getItems().add("OK");
		statePickerBox.getItems().add("OR");
		statePickerBox.getItems().add("PW");
		statePickerBox.getItems().add("PA");
		statePickerBox.getItems().add("PR");
		statePickerBox.getItems().add("RI");
		statePickerBox.getItems().add("SC");
		statePickerBox.getItems().add("SD");
		statePickerBox.getItems().add("TN");
		statePickerBox.getItems().add("TX");
		statePickerBox.getItems().add("UT");
		statePickerBox.getItems().add("VT");
		statePickerBox.getItems().add("VI");
		statePickerBox.getItems().add("VA");
		statePickerBox.getItems().add("WA");
		statePickerBox.getItems().add("WV");
		statePickerBox.getItems().add("WI");
		statePickerBox.getItems().add("WY");
		
		signUpEnterButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				Matcher matcher = pattern.matcher(loginNameField.getText());
				if((!loginNameField.getText().contains(" ") && matcher.matches()) && userNameField.getText().contains(" ")) {
					loginNames.add(loginNameField.getText());
					userNames.add(userNameField.getText());
					passwords.add(passwordTextField.getText());
					mainMenuText.setText(userNameField.getText());
					
					if(users.size() == 0) {
						stage.setScene(buildOwnerMenuGUI());
						stage.show();
					}
					else {
						stage.setScene(buildMainMenuGUI());
						stage.show();
					}
					
					
					loginNameField.clear();
					userNameField.clear();
					passwordTextField.clear();
				}
				else {
					//FIX LOGIN WARNING TEXT
					loginWarningText.setFont(warningFont);
					loginWarningText.setFill(Color.RED);
					userWarningText.setFont(warningFont);
					userWarningText.setFill(Color.RED);
					loginWarningText.setVisible(true);
					loginNameField.clear();
				}
			}
		});
		
		enterUserButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(buildEnterUserGUI());
				stage.show();
			}
		});
		
		ownerEnterUserButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				loginNames.add(loginNameField.getText());
				userNames.add(userNameField.getText());
				
				loginNameField.clear();
				userNameField.clear();
			}
		});
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int userThatIsIn = 0;
				
				for(int i = 0; i < users.size(); i++) {
					if(users.get(i).getUserName().equals(userNameField.getText()) && users.get(i).checkPassword(passwordTextField.getText())) {
						userThatIsIn = i;
						users.get(i).setIsUser(true);
						break;
					}
				}
				mainMenuText.setText(users.get(userThatIsIn).getUserName());
				
				//Checks if the user is owner, builds the main menu GUI
				if(users.get(userThatIsIn).getNextID() != 0) {
					stage.setScene(buildOwnerMenuGUI());
					stage.show();
				}
				else {
					stage.setScene(buildMainMenuGUI());
					stage.show();
				}
				
				stage.setScene(buildMainMenuGUI());
				stage.show();
			}
		});
		
		backSignUpButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(buildSignInMenuGUI());
				stage.show();
			}
		});
		
		exitWelcomeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				for(int i = 0; i < users.size(); i++) {
					if(users.get(i).getIsUser())
						users.get(i).setIsUser(false);
				}
				stage.close();
			}
		});
		
		signUpButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(buildSignUpGUI());
				stage.show();
			}
		});
		
		listUserButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				VBox listUserVbox = new VBox(8);
				listUserVbox.getChildren().addAll(backButton);
				for(int i = 0; i < users.size(); i++){
					Text userNameText = new Text(users.get(i).getUserName());
					userNameText.setFont(listUserFont);
					Text loginNameText = new Text(users.get(i).getLoginName());
					loginNameText.setFont(listUserFont);
					HBox userHbox = new HBox(8);
					userHbox.getChildren().addAll(userNameText, loginNameText);
					listUserVbox.getChildren().addAll(userHbox);
				}
				Pane listUserPane = new Pane();
				listUserPane.getChildren().addAll(listUserVbox);
				listUserVbox.setLayoutX(45);
				listUserVbox.setLayoutY(50);
				Scene listUserScene = new Scene(listUserPane, 400, 400);
				stage.setScene(listUserScene);
				stage.show();
			}
		});
		
		logInButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int userThatIsIn = 0;
				
				for(int i = 0; i < users.size(); i++) {
					System.out.println(users.get(i + 1).getLoginName());
					System.out.println(loginNameField.getText());
					if((users.get(i).getLoginName().equals(loginNameField.getText())) && (users.get(i).checkPassword(passwordTextField.getText()))) {
						userThatIsIn = i;
						users.get(i).setIsUser(true);
						break;
					}
				}
				mainMenuText.setText(users.get(userThatIsIn).getUserName());
				
				//Checks if the user is owner, builds the main menu GUI
				if(users.get(userThatIsIn).getNextID() != 0) {
					stage.setScene(buildMainMenuGUI());
					stage.show();
				}
				else {
					stage.setScene(buildOwnerMenuGUI());
					stage.show();
				}
				
				loginNameField.clear();
				userNameField.clear();
			}
		});
		
		buyTicketsButton.setOnAction((ActionEvent event) -> {
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					if(users.get(i).getPaymentInfo() == null) {
						stage.setScene(buildChoosePaymentGUI());
						stage.show();
					}
					else {
						stage.setScene(buildBuyTicketsGUI());
						stage.show();
					}
				}
			}
		});
		
		chooseCreditCardButton.setOnAction((ActionEvent event) -> {
			stage.setScene(buildCreditCardInfoGUI());
			stage.show();
		});
		
		chooseGooglePayButton.setOnAction((ActionEvent event) -> {
			stage.setScene(buildGoogleInfoGUI());
			stage.show();
		});
		
		chooseApplePayButton.setOnAction((ActionEvent event) -> {
			stage.setScene(buildAppleInfoGUI());
			stage.show();
		});
		
		creditCardEnterButton.setOnAction((ActionEvent event) -> {
			String name = firstNameField.getText() + " " + lastNameField.getText();
			String expirationDate = (String) monthPickerBox.getValue() + "/" + (String) yearPickerBox.getValue();
			String state = (String) statePickerBox.getValue();
			
			CreditCard cc = new CreditCard(name, Integer.parseInt(ccNumField.getText()), Integer.parseInt(ccSecNumField.getText()), expirationDate, streetAddressField.getText(), 
					zipCodeField.getText(), state);
			
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					users.get(i).setUserPayment(cc);
				}
			}
			firstNameField.clear();
			lastNameField.clear();
			monthPickerBox.getSelectionModel().clearSelection();
			yearPickerBox.getSelectionModel().clearSelection();
			statePickerBox.getSelectionModel().clearSelection();
			ccNumField.clear();
			ccSecNumField.clear();
			zipCodeField.clear();
			streetAddressField.clear();
		});
		
		enterAppleInfoButton.setOnAction((ActionEvent event) -> {
			ApplePay applePay = new ApplePay(appleUserNameField.getText(), applePasswordField.getText());
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					users.get(i).setUserPayment(applePay);
				}
			}
			appleUserNameField.clear();
			applePasswordField.clear();
			
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					if(users.get(i).getNextID() != 0) {
						stage.setScene(buildMainMenuGUI());
						stage.show();
					}
					else {
						stage.setScene(buildOwnerMenuGUI());
						stage.show();
					}
				}
			}
		});
		
		enterGoogleInfoButton.setOnAction((ActionEvent event) -> {
			GooglePay googlePay = new GooglePay(googleUserNameField.getText(), googlePasswordField.getText());
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					users.get(i).setUserPayment(googlePay);
				}
			}
			googleUserNameField.clear();
			googlePasswordField.clear();
			
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					if(users.get(i).getNextID() != 0) {
						stage.setScene(buildMainMenuGUI());
						stage.show();
					}
					else {
						stage.setScene(buildOwnerMenuGUI());
						stage.show();
					}
				}
			}
		});
		
		adultUpButton.setOnAction((ActionEvent event) -> {
			int num = Integer.parseInt(adultTicketCountText.getText());
			if(!(num + 1 > 10)) {
				num++;
				adultTicketCountText.setText(String.valueOf(num));
			}
		});
		
		adultDownButton.setOnAction((ActionEvent event) -> {
			int num = Integer.parseInt(adultTicketCountText.getText());
			if(!(num - 1 < 0)) {
				num--;
				adultTicketCountText.setText(String.valueOf(num));
			}
		});
		
		childUpButton.setOnAction((ActionEvent event) -> {
			int num = Integer.parseInt(childTicketCountText.getText());
			if(!(num + 1 > 10)) {
				num++;
				childTicketCountText.setText(String.valueOf(num));
			}
		});
		
		childDownButton.setOnAction((ActionEvent event) -> {
			int num = Integer.parseInt(childTicketCountText.getText());
			if(!(num - 1 < 0)) {
				num--;
				childTicketCountText.setText(String.valueOf(num));
			}
		});
		
		elderUpButton.setOnAction((ActionEvent event) -> {
			int num = Integer.parseInt(elderTicketCountText.getText());
			if(!(num + 1 > 10)) {
				num++;
				elderTicketCountText.setText(String.valueOf(num));
			}
		});
		
		elderDownButton.setOnAction((ActionEvent event) -> {
			int num = Integer.parseInt(elderTicketCountText.getText());
			if(!(num - 1 < 0)) {
				num--;
				elderTicketCountText.setText(String.valueOf(num));
			}
		});
		
		sportTicketButton.setOnAction((ActionEvent event) -> {
			double sportTicketPrice = 50;
			adultTicketPriceText.setText(Double.toString(sportTicketPrice));
			childTicketPriceText.setText(Double.toString(sportTicketPrice/2));
			elderTicketPriceText.setText(Double.toString(sportTicketPrice * 0.75));
		});
		
		theaterTicketButton.setOnAction((ActionEvent event) -> {
			double theaterTicketPrice = 125;
			adultTicketPriceText.setText(Double.toString(theaterTicketPrice));
			childTicketPriceText.setText(Double.toString(theaterTicketPrice/2));
			elderTicketPriceText.setText(Double.toString(theaterTicketPrice * 0.75));
		});
		
		concertTicketButton.setOnAction((ActionEvent event) -> {
			double concertTicketPrice = 150;
			adultTicketPriceText.setText(Double.toString(concertTicketPrice));
			childTicketPriceText.setText(Double.toString(concertTicketPrice/2));
			elderTicketPriceText.setText(Double.toString(concertTicketPrice * 0.75));
		});
		
		ticketPayButton.setOnAction((ActionEvent event) -> {
			double moneyPayed;
			moneyPayed = Double.parseDouble(adultTicketCountText.getText()) * Double.parseDouble(adultTicketPriceText.getText());
			moneyPayed = moneyPayed + (Double.parseDouble(childTicketCountText.getText()) * Double.parseDouble(childTicketPriceText.getText()));
			moneyPayed = moneyPayed + (Double.parseDouble(elderTicketCountText.getText()) * Double.parseDouble(elderTicketPriceText.getText()));
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					users.get(i).addPayTicket(moneyPayed);
				}
			}
			adultTicketCountText.setText("0");
			childTicketCountText.setText("0");
			elderTicketCountText.setText("0");
			adultTicketPriceText.setText("50");
			childTicketPriceText.setText("50");
			elderTicketPriceText.setText("50");
			
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					if(users.get(i).getNextID() != 0) {
						stage.setScene(buildMainMenuGUI());
						stage.show();
					}
					else {
						stage.setScene(buildOwnerMenuGUI());
						stage.show();
					}
				}
			}
		});
		
		showPayButton.setOnAction((ActionEvent event) -> {
			double amountPaid = 0;
			for(int i = 0; i < users.size(); i++) {
				if(users.get(i).getIsUser()) {
					amountPaid = amountPaid + users.get(i).getPaidToDate();
				}
			}
			amountPayedText.setText("$" + Double.toString(amountPaid));
			stage.setScene(buildShowPayToDateGUI());
			stage.show();
		});
		
		stage.setTitle("RoboTickets");
		stage.setScene(buildSignInMenuGUI());
		stage.show();
		
	}
	
	//main, a lot of things with the .dat file happen in here.
	public static void main(String[] args) {
		
		System.out.print("RoboTickets running....");
		
		try{
			
			if(!(file.length() == 0)) {
				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				
				users = (ArrayList<User>)oi.readObject();
				
				oi.close();
				fi.close();
			}
			launch(args);
			
			
			newUsers = createUsers(loginNames, userNames, passwords, users.size());
			
			FileOutputStream fout = new FileOutputStream(file, true);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			for(int i = 0; i < newUsers.size(); i++) {
				users.add(newUsers.get(i));
			}
			oos.writeObject(users);
			
			fout.close(); 
			oos.close();
			
		} catch (FileNotFoundException e) {
			try {
				System.out.print(" FILE NOT FOUND...");
				file.createNewFile();
				System.out.print(" FILE CREATED... RESTART PROGRAM...");
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.print(" RoboTickets finished");
	}
	
	//createUsers takes two arraylists of strings and an int that is the UserID and returns a arraylist of users
	public static ArrayList<User> createUsers(ArrayList<String> ln, ArrayList<String> un, ArrayList<String> pw, int ui) {
		ArrayList<User> users = new ArrayList<>();
		for(int i = 0; i < ln.size(); i++) {
			users.add(new User(ln.get(i), un.get(i), pw.get(i), ui));
			ui++;
		}
		return users;
	}
	
	//checking if the string is true, returns a boolean
	public static boolean checkTruth(String line) {
		if(line.equals("true"))
			return true;
		return false;
	}
	
	public Scene buildSignInMenuGUI() {
		welcomeText.setText("Robo Tickets");
		HBox welcomeHbox = new HBox(8);
		welcomeHbox.getChildren().addAll(logInButton, exitWelcomeButton);
		VBox welcomeVbox = new VBox(8);
		welcomeVbox.getChildren().addAll(welcomeText, loginNameField, passwordTextField, welcomeHbox, signUpButton);
		Pane welcomePane = new Pane();
		welcomePane.getChildren().addAll(welcomeVbox);
		welcomeVbox.setLayoutX(40);
		welcomeVbox.setLayoutY(50);
		Scene welcomeScene = new Scene(welcomePane, 400, 400);
		return welcomeScene;
	}
	public Scene buildOwnerMenuGUI() {
		HBox mainMenuHbox = new HBox(8);
		VBox mainMenuVbox = new VBox(8);
		mainMenuHbox.getChildren().addAll(enterUserButton, listUserButton, buyTicketsButton, showPayButton);
		mainMenuVbox.getChildren().addAll(mainMenuWelcomeText, mainMenuText, mainMenuHbox, exitWelcomeButton);
		Pane mainMenuPane = new Pane();
		mainMenuPane.getChildren().addAll(mainMenuVbox);
		mainMenuVbox.setLayoutX(30);
		mainMenuVbox.setLayoutY(50);
		Scene mainMenuScene = new Scene(mainMenuPane, 400, 400);
		return mainMenuScene;
	}
	public Scene buildEnterUserGUI() {
		HBox welcomeHbox = new HBox(8);
		welcomeHbox.getChildren().addAll(ownerEnterUserButton, backButton);
		VBox welcomeVbox = new VBox(8);
		welcomeVbox.getChildren().addAll(loginNameField, loginWarningText, userNameField, userWarningText, welcomeHbox);
		Pane welcomePane = new Pane();
		welcomePane.getChildren().addAll(welcomeVbox);
		welcomeVbox.setLayoutX(40);
		welcomeVbox.setLayoutY(50);
		Scene welcomeScene = new Scene(welcomePane, 400, 400);
		return welcomeScene;
	}
	
	public Scene buildSignUpGUI() {
		welcomeText.setText("Sign Up");
		HBox signUpHbox = new HBox(8);
		signUpHbox.getChildren().addAll(signUpEnterButton, exitWelcomeButton);
		VBox signUpVbox = new VBox(8);
		signUpVbox.getChildren().addAll(welcomeText, loginNameField, loginWarningText, userNameField, userWarningText, passwordTextField, signUpHbox, backSignUpButton);
		Pane signUpPane = new Pane();
		signUpPane.getChildren().addAll(signUpVbox);
		signUpVbox.setLayoutX(40);
		signUpVbox.setLayoutY(50);
		Scene signUpScene = new Scene(signUpPane, 400, 400);
		return signUpScene;
	}
	public Scene buildMainMenuGUI() {
		HBox mainMenuHbox = new HBox(8);
		VBox mainMenuVbox = new VBox(8);
		mainMenuHbox.getChildren().addAll(buyTicketsButton, showPayButton);
		mainMenuVbox.getChildren().addAll(mainMenuWelcomeText, mainMenuText, mainMenuHbox, exitWelcomeButton);
		Pane mainMenuPane = new Pane();
		mainMenuPane.getChildren().addAll(mainMenuVbox);
		mainMenuVbox.setLayoutX(40);
		mainMenuVbox.setLayoutY(50);
		Scene mainMenuScene = new Scene(mainMenuPane, 400, 400);
		return mainMenuScene;
	}
	public Scene buildChoosePaymentGUI() {
		HBox choosePaymentHbox = new HBox(8);
		VBox choosePaymentVbox = new VBox(8);
		choosePaymentHbox.getChildren().addAll(chooseCreditCardButton, chooseApplePayButton, chooseGooglePayButton);
		choosePaymentText.setFont(welcomeFont);
		choosePaymentVbox.getChildren().addAll(choosePaymentText, choosePaymentHbox, backButton);
		Pane choosePaymentPane = new Pane();
		choosePaymentPane.getChildren().addAll(choosePaymentVbox);
		choosePaymentVbox.setLayoutX(40);
		choosePaymentVbox.setLayoutY(50);
		Scene choosePaymentScene = new Scene(choosePaymentPane, 400, 400);
		return choosePaymentScene;
	}
	public Scene buildBuyTicketsGUI() {
		HBox ticketTypeHbox = new HBox(8);
		HBox adultTicketsHbox = new HBox(8);
		HBox childTicketsHbox = new HBox(8);
		HBox elderTicketsHbox = new HBox(8);
		HBox buyTicketHbox = new HBox(8);
		VBox adultUpDownVbox = new VBox(3);
		VBox childUpDownVbox = new VBox(3);
		VBox elderUpDownVbox = new VBox(3);
		VBox buyTicketsVbox = new VBox(8);
		sportTicketButton.setToggleGroup(ticketGroup);
		sportTicketButton.setSelected(true);
		theaterTicketButton.setToggleGroup(ticketGroup);
		concertTicketButton.setToggleGroup(ticketGroup);
		adultUpDownVbox.getChildren().addAll(adultUpButton, adultDownButton);
		childUpDownVbox.getChildren().addAll(childUpButton, childDownButton);
		elderUpDownVbox.getChildren().addAll(elderUpButton, elderDownButton);
		adultTicketsHbox.getChildren().addAll(adultTicketsText, adultTicketPriceText, adultUpDownVbox, adultTicketCountText);
		childTicketsHbox.getChildren().addAll(childTicketsText, childTicketPriceText, childUpDownVbox, childTicketCountText);
		elderTicketsHbox.getChildren().addAll(elderTicketsText, elderTicketPriceText, elderUpDownVbox, elderTicketCountText);
		ticketTypeHbox.getChildren().addAll(sportTicketButton, theaterTicketButton, concertTicketButton);
		buyTicketHbox.getChildren().addAll(backButton, ticketPayButton);
		buyTicketsVbox.getChildren().addAll(ticketTypeHbox, adultTicketsHbox, childTicketsHbox, elderTicketsHbox, buyTicketHbox);
		Pane buyTicketPane = new Pane();
		buyTicketPane.getChildren().addAll(buyTicketsVbox);
		buyTicketsVbox.setLayoutX(40);
		buyTicketsVbox.setLayoutY(50);
		Scene buyTicketScene = new Scene(buyTicketPane, 400, 400);
		return buyTicketScene;
	}
	public Scene buildCreditCardInfoGUI() {
		HBox firstLastNameHbox = new HBox(8);
		HBox ccNumSecurityCodeHbox = new HBox(8);
		HBox expirationDateHbox = new HBox(8);
		HBox streetAddressHbox = new HBox(8);
		HBox enterCCHbox = new HBox(8);
		VBox creditCardVbox = new VBox(8);
		firstLastNameHbox.getChildren().addAll(firstNameField, lastNameField);
		ccNumSecurityCodeHbox.getChildren().addAll(ccNumField, ccSecNumField);
		expirationDateHbox.getChildren().addAll(monthPickerBox, yearPickerBox);
		streetAddressHbox.getChildren().addAll(streetAddressField, statePickerBox, zipCodeField);
		enterCCHbox.getChildren().addAll(backButton, creditCardEnterButton);
		creditCardVbox.getChildren().addAll(creditCardText, firstLastNameHbox, ccNumSecurityCodeHbox, expirationDateHbox, streetAddressHbox, enterCCHbox);
		Pane creditCardPane = new Pane();
		creditCardPane.getChildren().addAll(creditCardPane);
		creditCardVbox.setLayoutX(40);
		creditCardVbox.setLayoutY(50);
		Scene creditCardScene = new Scene(creditCardPane, 400, 400);
		return creditCardScene;
	}
	public Scene buildGoogleInfoGUI() {
		HBox enterGoogleHbox = new HBox(8);
		VBox googleInfoVbox = new VBox(8);
		enterGoogleHbox.getChildren().addAll(backButton, enterGoogleInfoButton);
		googleInfoVbox.getChildren().addAll(googleUserNameField, googlePasswordField, enterGoogleHbox);
		Pane googleInfoPane = new Pane();
		googleInfoPane.getChildren().addAll(googleInfoVbox);
		googleInfoVbox.setLayoutX(40);
		googleInfoVbox.setLayoutY(50);
		Scene googleInfoScene = new Scene(googleInfoPane, 400, 400);
		return googleInfoScene;
	}
	public Scene buildAppleInfoGUI() {
		HBox enterAppleHbox = new HBox(8);
		VBox appleInfoVbox = new VBox(8);
		enterAppleHbox.getChildren().addAll(backButton, enterAppleInfoButton);
		appleInfoVbox.getChildren().addAll(appleUserNameField, applePasswordField, enterAppleHbox);
		Pane appleInfoPane = new Pane();
		appleInfoPane.getChildren().addAll(appleInfoVbox);
		appleInfoVbox.setLayoutX(40);
		appleInfoVbox.setLayoutY(50);
		Scene appleInfoScene = new Scene(appleInfoPane, 400, 400);
		return appleInfoScene;
	}
	public Scene buildShowPayToDateGUI() {
		VBox showPayVbox = new VBox(8);
		showPayVbox.getChildren().addAll(amountPayedText, backButton);
		Pane showPayPane = new Pane();
		showPayPane.getChildren().addAll(showPayVbox);
		showPayVbox.setLayoutX(40);
		showPayVbox.setLayoutY(50);
		Scene showPayScene = new Scene(showPayPane, 400, 400);
		return showPayScene;
	}
}