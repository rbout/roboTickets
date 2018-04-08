// Author			Robert Boutillier
// Date created		3/24/18
// Date updated		4/1/18
// Version			1.0
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
import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.io.File;
import java.io.*;
import java.util.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.nio.file.*;

public class main extends Application {
	private Text welcomeText = new Text("Sign in");
	private Text loginWarningText = new Text("Can't contain spaces or any \nspecial characters.");
	private Text mainMenuText = new Text();
	private Text userWarningText = new Text("Enter your first and last name.");
	private Text mainMenuWelcomeText = new Text("Welcome");
	private Font welcomeFont = Font.font("arial", FontWeight.BOLD, FontPosture.REGULAR, 36);
	private Font warningFont = Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 9);
	private Font invisibleFont = Font.font("arial", FontWeight.NORMAL, FontPosture.REGULAR, 0);
	private Font mainMenuWelcomeFont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 24);
	private Font listUserFont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15);
	private TextField userNameField = new TextField();
	private TextField loginNameField = new TextField();
	private Button loginEnterButton = new Button("Enter");
	private Button enterUserButton = new Button("Enter Users");
	private Button ownerEnterUserButton = new Button("Enter Users");
	private Button listUserButton = new Button("List Users");
	private Button exitWelcomeButton = new Button("Exit");
	private Button backButton = new Button("Back");
	private Button logInButton = new Button("Log In");
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<String> loginNames = new ArrayList<>();
	public static ArrayList<String> userNames = new ArrayList<>();
	public static ArrayList<User> newUsers = new ArrayList<>();
	
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
		userNameField.setPromptText("User Name");
		loginNameField.setPromptText("Login Name");
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		
		loginEnterButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				boolean userMatch = false;
				int userThatIsIn = 0;
				
				for(int i = 0; i < newUsers.size(); i++) {
					if(newUsers.get(i).getUserName().equals(userNameField.getText()) && newUsers.get(i).getLoginName().equals(loginNameField.getText())) {
						userMatch = true;
						userThatIsIn = i;
						break;
					}
				}
				
				if(userMatch) {
					mainMenuText.setText(newUsers.get(userThatIsIn).getUserName());
					
					stage.setScene(buildMainMenuGUI());
					stage.show();
					
					loginNameField.clear();
					userNameField.clear();
				}
				else {
					Matcher matcher = pattern.matcher(loginNameField.getText());
					if((!loginNameField.getText().contains(" ") && matcher.matches()) && userNameField.getText().contains(" ")) {
						loginNames.add(loginNameField.getText());
						userNames.add(userNameField.getText());
						mainMenuText.setText(userNameField.getText());
						
						stage.setScene(buildMainMenuGUI());
						stage.show();
						
						loginNameField.clear();
						userNameField.clear();
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
				stage.setScene(buildMainMenuGUI());
				stage.show();
			}
		});
		
		exitWelcomeButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		
		listUserButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				VBox listUserVbox = new VBox(8);
				listUserVbox.getChildren().addAll(backButton);
				for(int i = 0; i < newUsers.size(); i++){
					Text userNameText = new Text(newUsers.get(i).getUserName());
					userNameText.setFont(listUserFont);
					Text loginNameText = new Text(newUsers.get(i).getLoginName());
					loginNameText.setFont(listUserFont);
					HBox userHbox = new HBox(8);
					userHbox.getChildren().addAll(userNameText, loginNameText);
					listUserVbox.getChildren().addAll(userHbox);
				}
				Pane listUserPane = new Pane();
				listUserPane.getChildren().addAll(listUserVbox);
				listUserVbox.setLayoutX(45);
				listUserVbox.setLayoutY(50);
				Scene listUserScene = new Scene(listUserPane, 250, 250);
				stage.setScene(listUserScene);
				stage.show();
			}
		});
		
		logInButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.setScene(buildWelcomeMenuGUI());
				stage.show();
			}
		});
		
		stage.setTitle("RoboTickets");
		stage.setScene(buildWelcomeMenuGUI());
		stage.show();
		
	}
	
	public static void main(String[] args) {
		int userID = 0;
		int oldUI;
		String lN;
		String uN;
		boolean iU;
		String dateAsString;
		Calendar date;
		double pTD;
		System.out.print("RoboTickets running....");
		
		File file = new File("users.txt");
		
		
		try{
			
			Scanner scan = new Scanner(file);
			boolean txtIsNotEmpty = true;
		
			if(!scan.hasNextInt()) {
				txtIsNotEmpty = false;
			}
			else {
				userID = scan.nextInt();
			}
			
			//Scanning in the old users from users.txt
			while(scan.hasNext()) {
				
				oldUI = scan.nextInt();
				lN = scan.next();
				uN = scan.next();
				uN = uN + " " + scan.next();
				iU = checkTruth(scan.next());
				dateAsString = scan.next();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				try{
					Date desiredDate = sdf.parse(dateAsString);
					date = Calendar.getInstance();
					date.setTime(desiredDate);
					pTD = scan.nextDouble();
					newUsers.add(new User(oldUI, lN, uN, iU, (GregorianCalendar)date, pTD));
				}
				catch(ParseException e) {
					e.printStackTrace();
				}
			}
			
		
			PrintWriter pw = new PrintWriter(file);
			
			
			for(int i = 0; i < newUsers.size(); i++) {
				users.add(newUsers.get(i));
			}
			
			launch(args);
			
			//checking if the .txt file was just created
			if(!txtIsNotEmpty) {
				users = createUsers(loginNames, userNames, userID);
				userID++;
				pw.printf("%05d", userID);
				pw.println();
			} 
			else {
				for(int i = 0; i < loginNames.size(); i++) {
					users.add(new User(loginNames.get(i), userNames.get(i), newUsers.size() + i));
				}
				pw.printf("%05d", users.size());
				pw.println();
			}
			
			for(int i = 0; i < users.size(); i++) {
				users.get(i).setIsUser(false);
				pw.println(users.get(i).toString());
			}
			
			pw.close();
			scan.close();
		} catch (FileNotFoundException e) {
			try {
				System.out.print(" FILE NOT FOUND...");
				file.createNewFile();
				System.out.print(" FILE CREATED... RESTART PROGRAM...");
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.print(" RoboTickets finished");
	}
	
	//createUsers takes two arraylists of strings and an int that is the UserID and returns a arraylist of users
	public static ArrayList<User> createUsers(ArrayList<String> ln, ArrayList<String> un, int ui) {
		ArrayList<User> users = new ArrayList<>();
		for(int i = 0; i < ln.size(); i++) {
			users.add(new User(ln.get(i), un.get(i), ui));
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
	
	public Scene buildWelcomeMenuGUI() {
		HBox welcomeHbox = new HBox(8);
		welcomeHbox.getChildren().addAll(loginEnterButton, exitWelcomeButton);
		VBox welcomeVbox = new VBox(8);
		welcomeVbox.getChildren().addAll(welcomeText, loginNameField, loginWarningText, userNameField, welcomeHbox);
		Pane welcomePane = new Pane();
		welcomePane.getChildren().addAll(welcomeVbox);
		welcomeVbox.setLayoutX(40);
		welcomeVbox.setLayoutY(50);
		Scene welcomeScene = new Scene(welcomePane, 250, 250);
		return welcomeScene;
	}
	public Scene buildMainMenuGUI() {
		HBox mainMenuHbox = new HBox(8);
		VBox mainMenuVbox = new VBox(8);
		mainMenuHbox.getChildren().addAll(logInButton, enterUserButton, listUserButton);
		mainMenuVbox.getChildren().addAll(mainMenuWelcomeText, mainMenuText, mainMenuHbox, exitWelcomeButton);
		Pane mainMenuPane = new Pane();
		mainMenuPane.getChildren().addAll(mainMenuVbox);
		mainMenuVbox.setLayoutX(30);
		mainMenuVbox.setLayoutY(50);
		Scene mainMenuScene = new Scene(mainMenuPane, 250, 250);
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
		Scene welcomeScene = new Scene(welcomePane, 250, 250);
		return welcomeScene;
	}
}