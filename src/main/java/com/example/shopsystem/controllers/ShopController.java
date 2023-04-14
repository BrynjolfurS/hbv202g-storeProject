package com.example.shopsystem.controllers;

import com.example.shopsystem.dummyData.DummyDataGenerator;
import com.example.shopsystem.storeItems.ElectronicItem;
import com.example.shopsystem.ui.StoreListCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.example.shopsystem.storeItems.StoreItem;

public class ShopController implements Initializable {
    @FXML
    private ListView<StoreListCell> fxShopItemList;
    @FXML
    private ListView fxCartItemList;

    // Data
    private List<StoreItem> storeItems;
    private DummyDataGenerator dummyDataGenerator;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dummyDataGenerator = new DummyDataGenerator();
        storeItems = dummyDataGenerator.getStoreItems();
        generateListViewElements();
    }

    private void generateListViewElements() {

        List<StoreListCell> list = new ArrayList<>();
        for (StoreItem item : storeItems) {
            list.add(new StoreListCell(
                    item.getName(),
                    item.getPrice(),
                    item.getTypeDependantString())
            );
        }
        ObservableList<StoreListCell> observableList = FXCollections.observableList(list);
        fxShopItemList = new ListView<>();
        // TODO: Láta þetta virka eða hafa bara tvo takka (add & remove) og sækja item sem er valið í ListView

    }
}