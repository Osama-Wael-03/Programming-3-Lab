/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class CurrencyConversionPage extends Stage {

    HBox hbox1;
    HBox hbox2;
    HBox hbox3;
    VBox vbox;
    FlowPane centerPage;
    Label title;
    Label usd;
    Label nis;
    Label to;
    TextField enterUsd;
    TextField enterNis;
    Button convert;

    Button logout;
    BorderPane container;

    public CurrencyConversionPage() throws IOException {
        this.title = new Label("Currency Conversion System");
        this.logout = new Button("Logout");
        this.logout.setId("log");
        this.logout.setOnAction(event -> {
            new LoginPage().show();
            this.close();

        });
        this.hbox1 = new HBox(65, this.title, this.logout);
        this.hbox1.setPadding(new Insets(20));

        this.usd = new Label("USD");
        this.nis = new Label("NIS");
        this.hbox2 = new HBox(170, this.usd, this.nis);
        this.hbox2.setAlignment(Pos.CENTER);

        this.enterUsd = new TextField();
        this.to = new Label("TO");
        this.convert = new Button("Convert");
        this.convert.setId("convert");
        this.convert.setOnAction(new Converter());
        this.enterNis = new TextField();
        this.hbox3 = new HBox(15, this.enterUsd, this.to, this.enterNis);
        this.vbox = new VBox(30, hbox2, hbox3, this.convert);
        this.vbox.setAlignment(Pos.CENTER);
        this.centerPage = new FlowPane(vbox);

        this.centerPage.setAlignment(Pos.CENTER);
        this.container = new BorderPane();
        this.container.setTop(hbox1);
        this.container.setCenter(this.centerPage);

        Scene scene = new Scene(container, 400, 400);
        scene.getStylesheets().add("file:src/css/conversionStyle.css");
        this.setScene(scene);
        this.setTitle("Currency Conversion System");
    }

    class Converter implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            if (event.getSource() == convert) {

                double usd = Double.parseDouble(enterUsd.getText());
                double conversioning = (usd * 3.65);
                String x = String.valueOf(conversioning);
                enterNis.setText(x);
            }

        }
    }
}
