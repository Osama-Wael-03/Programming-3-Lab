/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class LoginPage extends Stage {

    Image img;
    ImageView imgV;
    TextField userName;
    PasswordField password;
    Label user;
    Label pass;
    Button login;
    FlowPane container;
    VBox vbox;
    Label error;

    public LoginPage() {
        this.img = new Image("file:src/view/log.jpg");
        this.imgV = new ImageView(this.img);
        this.imgV.setFitWidth(160);
        this.imgV.setFitHeight(140);

        this.user = new Label("User Name");
        this.userName = new TextField();

        this.pass = new Label("Password");
        this.password = new PasswordField();

        this.login = new Button("Login");
        this.error = new Label();
        this.error.setId("error");
        this.login.setOnAction(event -> {

            if (this.userName.getText().equals("user") && this.password.getText().equals("userpass")) {

                try {
                    new CurrencyConversionPage().show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.close();

            } else if (this.userName.getText().equals("") || this.password.getText().equals("")) {

                this.error.setText("Please Fill Fields!!");

            } else {

                this.error.setText("Invalid User!!");

            }

        });

        this.vbox = new VBox(10, this.imgV, this.user, this.userName, this.pass, this.password, this.login, this.error);
        this.vbox.setAlignment(Pos.CENTER);
        this.container = new FlowPane(vbox);
        this.container.setId("flow");

        this.container.setAlignment(Pos.CENTER);
        Scene scene = new Scene(this.container, 300, 450);
        scene.getStylesheets().add("file:src/css/myStyle.css");
        this.setScene(scene);
        this.setTitle("Login Page");
    }
}
