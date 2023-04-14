package com.example.shopsystem.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

/***********************************************************
 * Nafn: Brynjólfur Steingrímsson
 * Email: brs26@hi.is
 *
 * Lýsing:
 *
 *
 ***********************************************************/
public class StoreListCell extends ListCell<String> {
    HBox hBox = new HBox();
    Pane pane = new Pane();
    Label itemName = new Label("");
    Label itemTypeDependantString = new Label("");
    Label itemPrice = new Label("");
    Button addToCartButton = new Button(">>");
    Button removeFromCartButton = new Button("<<");

    public StoreListCell(String name, double price, String typeDepentandString) {
        super();

        itemName.setText(name);
        itemTypeDependantString.setText(typeDepentandString);
        itemPrice.setText(String.valueOf(price));

        hBox.getChildren().addAll(
                itemName,
                itemTypeDependantString,
                itemPrice,
                pane,
                addToCartButton,
                removeFromCartButton);
        HBox.setHgrow(pane, Priority.ALWAYS);

        addToCartButton.setOnAction(e -> {

        });

        removeFromCartButton.setOnAction(e -> {

        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        setGraphic(null);
        if (item != null && !empty) {
            setGraphic(hBox);
        }
    }

}
