package com.example.shopsystem.controllers;

import com.example.shopsystem.ShoppingCart;
import com.example.shopsystem.currency.CurrencyConverter;
import com.example.shopsystem.currency.CurrencySelector;
import com.example.shopsystem.dummyData.DummyDataGenerator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.example.shopsystem.storeItems.StoreItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

public class ShopController implements Initializable {
    private final DecimalFormat df = new DecimalFormat("#.00");
    @FXML
    private ListView<StoreItem> fxShopItemList;
    @FXML
    private ListView<StoreItem> fxCartItemList;
    @FXML
    private RadioButton fxRbUSD;
    @FXML
    private RadioButton fxRbISK;
    @FXML
    private RadioButton fxRbEURO;
    @FXML
    private Label fxCartTotalCost;
    private ToggleGroup currencyRadioButtons;

    // Data & Business logic
    private List<StoreItem> storeItems;
    private DummyDataGenerator dummyDataGenerator;
    private CurrencySelector currencySelector;
    private ShoppingCart shoppingCart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shoppingCart = new ShoppingCart();
        currencySelector = new CurrencySelector();
        currencyRadioButtons = new ToggleGroup();

        dummyDataGenerator = new DummyDataGenerator();
        storeItems = dummyDataGenerator.getStoreItems();
        for (StoreItem item: storeItems) {
            currencySelector.attach(item);
        }

        generateListViewElements();
        currencySelectionSetup();
    }

    private void currencySelectionSetup() {
        fxRbUSD.setToggleGroup(currencyRadioButtons);
        fxRbISK.setToggleGroup(currencyRadioButtons);
        fxRbEURO.setToggleGroup(currencyRadioButtons);

        // Get the text value of the selected RadioButton and pass it to the (observable) currencySelector
        currencyRadioButtons.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton selectedButton = (RadioButton) currencyRadioButtons.getSelectedToggle();
            String selectedCurrency = selectedButton.getText();
            currencySelector.selectCurrency(selectedCurrency);
            fxShopItemList.refresh();
            fxCartItemList.refresh();
            updateCartTotalCostLabel();
        });

        // Set USD as the default value
        fxRbUSD.setSelected(true);
    }

    private void generateListViewElements() {
        ObservableList<StoreItem> list = FXCollections.observableList(storeItems);
        fxShopItemList.setItems(list);
        fxShopItemList.setCellFactory(storeItemListView -> new StoreListCell());

        ObservableList<StoreItem> list2 = FXCollections.observableList(new ArrayList<>());
        fxCartItemList.setItems(list2);
        fxCartItemList.setCellFactory(cartItemListView -> new CartListCell());
    }

    private void updateCartTotalCostLabel() {
        Double newTotalCost = shoppingCart.getTotalCost();
        fxCartTotalCost.setText("Total cost: " + df.format(newTotalCost) + " " + currencySelector.getSymbol());
    }

    public class StoreListCell extends ListCell<StoreItem> {

        @Override
        protected void updateItem(StoreItem item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                HBox cellLayout = new HBox(10);
                cellLayout.setAlignment(Pos.CENTER_LEFT);

                Label nameLabel = new Label(item.getName());
                Label descriptionLabel = new Label(item.getTypeDependantString());
                Label priceLabel = new Label(df.format(item.getPrice()) + " " + currencySelector.getSymbol());
                Pane pane = new Pane();

                Button addButton = new Button("Add");
                addButton.setOnAction(event -> {
                    fxCartItemList.getItems().add(item);
                    shoppingCart.addItem(item);
                    updateCartTotalCostLabel();
                });

                Button removeButton = new Button("Remove");
                removeButton.setOnAction(event -> {
                    fxCartItemList.getItems().remove(item);
                    shoppingCart.removeItem(item);
                    updateCartTotalCostLabel();
                });

                cellLayout.getChildren().addAll(nameLabel, descriptionLabel, priceLabel, pane, addButton, removeButton);
                cellLayout.setHgrow(pane, Priority.ALWAYS);
                setGraphic(cellLayout);
            }
        }
    }

    public class CartListCell extends ListCell<StoreItem> {
        @Override
        protected void updateItem(StoreItem item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                HBox cellLayout = new HBox(10);
                cellLayout.setAlignment(Pos.CENTER_LEFT);

                Label nameLabel = new Label(item.getName());
                Label descriptionLabel = new Label(item.getTypeDependantString());
                Label priceLabel = new Label(df.format(item.getPrice()) + " " + currencySelector.getSymbol());

                cellLayout.getChildren().addAll(nameLabel, descriptionLabel, priceLabel);
                setGraphic(cellLayout);
            }
        }
    }
}