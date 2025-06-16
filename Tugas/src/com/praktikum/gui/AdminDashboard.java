package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.Mahasiswa;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AdminDashboard extends BorderPane {

    public AdminDashboard(Stage stage) {
        aturTampilanDasar();
        inisialisasiKomponenUI(stage);
    }

    private void aturTampilanDasar() {
        setStyle("-fx-background-color: #ffe4ec;");
    }

    private void inisialisasiKomponenUI(Stage stage) {
        Label judul = buatJudulDashboard();
        setTop(judul);

        TabPane tabUtama = new TabPane();
        tabUtama.getTabs().addAll(
                buatTabKelolaBarang(stage),
                buatTabKelolaMahasiswa(stage)
        );
        setCenter(tabUtama);
    }

    private Label buatJudulDashboard() {
        Label judul = new Label("\uD83D\uDD10 Dashboard Admin");
        judul.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        judul.setStyle("-fx-text-fill: #d63384;");
        BorderPane.setAlignment(judul, Pos.CENTER);
        BorderPane.setMargin(judul, new Insets(20, 0, 10, 0));
        return judul;
    }

    private Tab buatTabKelolaBarang(Stage stage) {
        Tab tabBarang = new Tab("Kelola Barang");
        tabBarang.setClosable(false);
        tabBarang.setContent(buatTampilanKelolaBarang(stage));
        return tabBarang;
    }

    private VBox buatTampilanKelolaBarang(Stage stage) {
        VBox containerUtama = new VBox(15);
        containerUtama.setAlignment(Pos.TOP_CENTER);
        containerUtama.setPadding(new Insets(10));

        TableView<Item> tabelBarang = buatTabelBarang();
        ScrollPane scrollPane = new ScrollPane(tabelBarang);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(300);

        Button tombolClaim = buatTombolClaim(tabelBarang);
        Button tombolLogout = buatTombolLogout(stage);

        containerUtama.getChildren().addAll(scrollPane, tombolClaim, tombolLogout);
        return containerUtama;
    }

    private TableView<Item> buatTabelBarang() {
        TableView<Item> tabel = new TableView<>(LoginSystem.reportedItems);
        tabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabel.setPrefHeight(300);
        tabel.setStyle("-fx-font-size: 13px;");

        TableColumn<Item, String> kolomNama = new TableColumn<>("Nama");
        kolomNama.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getItemName()));

        TableColumn<Item, String> kolomDeskripsi = new TableColumn<>("Deskripsi");
        kolomDeskripsi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));

        TableColumn<Item, String> kolomLokasi = new TableColumn<>("Lokasi");
        kolomLokasi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocation()));

        TableColumn<Item, String> kolomStatus = new TableColumn<>("Status");
        kolomStatus.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStatus()));

        tabel.getColumns().addAll(kolomNama, kolomDeskripsi, kolomLokasi, kolomStatus);

        tabel.getColumns().forEach(this::aturStyleHeader);

        return tabel;
    }

    private Button buatTombolClaim(TableView<Item> tabel) {
        Button tombol = new Button("✅ Tandai sebagai Claimed");
        tombol.setStyle("-fx-background-color: #ff69b4; -fx-text-fill: white; -fx-background-radius: 20px; -fx-font-weight: bold; -fx-padding: 8px 20px;");

        tombol.setOnAction(e -> {
            Item terpilih = tabel.getSelectionModel().getSelectedItem();
            if (terpilih != null) {
                if (terpilih.getStatus().equalsIgnoreCase("Dilaporkan") ||
                        terpilih.getStatus().equalsIgnoreCase("Reported")) {
                    terpilih.setStatus("Claimed");
                    tabel.refresh();
                    tampilkanAlert("Barang telah ditandai Claimed.", Alert.AlertType.INFORMATION);
                } else {
                    tampilkanAlert("Hanya barang dengan status Dilaporkan/Reported yang bisa di-claim.",
                            Alert.AlertType.WARNING);
                }
            } else {
                tampilkanAlert("Pilih barang terlebih dahulu!", Alert.AlertType.WARNING);
            }
        });

        return tombol;
    }

    private Tab buatTabKelolaMahasiswa(Stage stage) {
        Tab tabMahasiswa = new Tab("Kelola Mahasiswa");
        tabMahasiswa.setClosable(false);
        tabMahasiswa.setContent(buatTampilanKelolaMahasiswa(stage));
        return tabMahasiswa;
    }

    private VBox buatTampilanKelolaMahasiswa(Stage stage) {
        VBox containerUtama = new VBox(20);
        containerUtama.setAlignment(Pos.CENTER);
        containerUtama.setPadding(new Insets(20));

        Label judul = new Label("Tambah Mahasiswa Baru");
        judul.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        judul.setStyle("-fx-text-fill: #d63384;");

        GridPane formInput = buatFormInputMahasiswa();

        Button tombolTambah = buatTombolTambahMahasiswa(formInput);
        Button tombolLogout = buatTombolLogout(stage);

        containerUtama.getChildren().addAll(judul, formInput, tombolTambah, tombolLogout);
        return containerUtama;
    }

    private GridPane buatFormInputMahasiswa() {
        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setHgap(15);
        form.setVgap(15);
        form.setPadding(new Insets(20));

        Label labelNama = new Label("Nama:");
        labelNama.setStyle("-fx-font-weight: bold;");
        TextField fieldNama = new TextField();
        fieldNama.setPromptText("Nama Mahasiswa");
        fieldNama.setPrefWidth(250);

        Label labelNIM = new Label("NIM:");
        labelNIM.setStyle("-fx-font-weight: bold;");
        TextField fieldNIM = new TextField();
        fieldNIM.setPromptText("Nomor Induk Mahasiswa");
        fieldNIM.setPrefWidth(250);

        ColumnConstraints kolomLabel = new ColumnConstraints();
        kolomLabel.setHalignment(HPos.RIGHT);

        ColumnConstraints kolomField = new ColumnConstraints();
        kolomField.setHalignment(HPos.LEFT);

        form.getColumnConstraints().addAll(kolomLabel, kolomField);
        form.add(labelNama, 0, 0);
        form.add(fieldNama, 1, 0);
        form.add(labelNIM, 0, 1);
        form.add(fieldNIM, 1, 1);

        return form;
    }

    private Button buatTombolTambahMahasiswa(GridPane form) {
        Button tombol = new Button("Tambah Mahasiswa");
        tombol.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 20px; -fx-font-weight: bold; -fx-padding: 8px 20px;");

        tombol.setOnAction(e -> {
            TextField fieldNama = (TextField) form.getChildren().get(1);
            TextField fieldNIM = (TextField) form.getChildren().get(3);

            String nama = fieldNama.getText().trim();
            String nim = fieldNIM.getText().trim();

            if (nama.isEmpty() || nim.isEmpty()) {
                tampilkanAlert("Nama dan NIM tidak boleh kosong!", Alert.AlertType.WARNING);
                return;
            }

            LoginSystem.userList.add(new Mahasiswa(nama, nim));
            fieldNama.clear();
            fieldNIM.clear();
            tampilkanAlert("Mahasiswa berhasil ditambahkan!", Alert.AlertType.INFORMATION);
        });

        return tombol;
    }

    private Button buatTombolLogout(Stage stage) {
        Button tombol = new Button("🚪 Logout / Kembali ke Login");
        tombol.setStyle("-fx-background-color: #ffc0cb; -fx-text-fill: #333; -fx-font-weight: bold; -fx-background-radius: 20px; -fx-padding: 8px 16px;");

        tombol.setOnAction(e -> stage.setScene(new Scene(new LoginPane(stage), 600, 400)));
        return tombol;
    }

    private void aturStyleHeader(TableColumn<?, ?> kolom) {
        kolom.setStyle("-fx-font-weight: bold; -fx-background-color: #ffb6c1; -fx-text-fill: black;");
    }

    private void tampilkanAlert(String pesan, Alert.AlertType tipe) {
        new Alert(tipe, pesan).show();
    }
}