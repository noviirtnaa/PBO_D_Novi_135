package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class MahasiswaDashboard extends BorderPane {

    public MahasiswaDashboard(Stage stage) {
        setStyle("-fx-background-color: #ffe4ec;");

        Label judul = new Label("📮 Laporan Barang Hilang");
        judul.setFont(new Font("Arial", 22));
        judul.setTextFill(Color.HOTPINK);
        judul.setStyle("-fx-font-weight: bold;");
        BorderPane.setAlignment(judul, Pos.CENTER);
        setTop(judul);
        BorderPane.setMargin(judul, new Insets(20, 0, 10, 0));



        VBox boxTengah = new VBox(15);
        boxTengah.setAlignment(Pos.TOP_CENTER);
        boxTengah.setPadding(new Insets(10));

        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama Barang");
        gayaInput(tfNama);

        TextField tfDeskripsi = new TextField();
        tfDeskripsi.setPromptText("Deskripsi Barang");
        gayaInput(tfDeskripsi);

        TextField tfLokasi = new TextField();
        tfLokasi.setPromptText("Lokasi Hilangnya Barang");
        gayaInput(tfLokasi);



        Button btnLapor = new Button("📮 Laporkan");
        btnLapor.setStyle(
                "-fx-background-color: #ff69b4; " +
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-padding: 8px 20px;"
        );

            btnLapor.setOnAction(e -> {
            String nama = tfNama.getText().trim();
            String deskripsi = tfDeskripsi.getText().trim();
            String lokasi = tfLokasi.getText().trim();

            if (nama.isEmpty() || deskripsi.isEmpty() || lokasi.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Semua kolom harus diisi!").show();
                return;
            }

            Item item = new Item(nama, deskripsi, lokasi, "Reported");
            LoginSystem.reportedItems.add(item);
            tfNama.clear();
            tfDeskripsi.clear();
            tfLokasi.clear();
            new Alert(Alert.AlertType.INFORMATION, "Barang berhasil dilaporkan!").show();
        });

        TableView<Item> tabel = buatTabelBarang();
        boxTengah.getChildren().addAll(tfNama, tfDeskripsi, tfLokasi, btnLapor, tabel);
        setCenter(boxTengah);

        Button btnKeluar = new Button("🚪 Keluar / Kembali");
        btnKeluar.setStyle(
                "-fx-background-color: #ffc0cb; " +
                        "-fx-text-fill: #333; " +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20px; " +
                        "-fx-padding: 8px 16px;"
        );
        btnKeluar.setOnAction(e -> stage.setScene(new Scene(new LoginPane(stage), 600, 400)));

        VBox boxBawah = new VBox(btnKeluar);
        boxBawah.setAlignment(Pos.CENTER);
        boxBawah.setPadding(new Insets(20));
        setBottom(boxBawah);
    }

    private TableView<Item> buatTabelBarang() {
        TableView<Item> tabel = new TableView<>(LoginSystem.reportedItems);
        tabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabel.setPrefHeight(300);
        tabel.setStyle("-fx-font-size: 13px;");

        TableColumn<Item, String> kolomNama = new TableColumn<>("Nama");
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Item, String> kolomDeskripsi = new TableColumn<>("Deskripsi");
        kolomDeskripsi.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> kolomLokasi = new TableColumn<>("Lokasi");
        kolomLokasi.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item, String> kolomStatus = new TableColumn<>("Status");
        kolomStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tabel.getColumns().addAll(kolomNama, kolomDeskripsi, kolomLokasi, kolomStatus);

        tabel.getColumns().forEach(this::aturStyleHeader);

        return tabel;
    }

    private void aturStyleHeader(TableColumn<?, ?> kolom) {
        kolom.setStyle("-fx-font-weight: bold; -fx-background-color: #ffb6c1;");
    }

    private void gayaInput(TextField tf) {
        tf.setMaxWidth(300);
        tf.setStyle("-fx-background-color: white; -fx-border-color: #ffb6c1; -fx-border-radius: 8px;");
    }
}