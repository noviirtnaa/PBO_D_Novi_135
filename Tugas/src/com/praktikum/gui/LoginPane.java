package com.praktikum.gui;

import com.praktikum.users.*;
import com.praktikum.main.LoginSystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPane extends StackPane {

    private ComboBox<String> comboPeran;
    private TextField fieldNama;
    private PasswordField fieldPassword;
    private Label labelError;

    public LoginPane(Stage stage) {
        aturTampilanDasar();
        inisialisasiDataAwal();
        tampilkanFormLogin(stage);
    }

    private void aturTampilanDasar() {
        setStyle("-fx-background-color: #ffe4ec;");
    }

    private void inisialisasiDataAwal() {
        if (LoginSystem.userList.isEmpty()) {
            LoginSystem.userList.add(new Admin("novi", "135"));
            LoginSystem.userList.add(new Mahasiswa("novi", "135"));
        }
    }

    private void tampilkanFormLogin(Stage stage) {
        VBox containerUtama = buatContainerUtama();

        comboPeran = buatComboPeran();
        fieldNama = buatFieldNama();
        fieldPassword = buatFieldPassword();
        labelError = buatLabelError();

        aturEventHandlerEnterKey(stage);

        Button tombolLogin = buatTombolLogin(stage);
        Button tombolKeluar = buatTombolKeluar(stage);

        containerUtama.getChildren().addAll(
                buatJudul(),
                comboPeran,
                fieldNama,
                fieldPassword,
                tombolLogin,
                tombolKeluar,
                labelError
        );

        getChildren().add(containerUtama);
    }

    private void aturEventHandlerEnterKey(Stage stage) {
        fieldNama.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                prosesLogin(stage);
            }
        });

        fieldPassword.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                prosesLogin(stage);
            }
        });
    }

    private VBox buatContainerUtama() {
        VBox container = new VBox(15);
        container.setPadding(new Insets(30));
        container.setAlignment(Pos.CENTER);
        container.setMaxWidth(350);
        container.setStyle("-fx-background-color: #fff0f5; -fx-background-radius: 15px;");
        return container;
    }

    private Label buatJudul() {
        Label judul = new Label("🌸 Login Sistem");
        judul.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #d63384;");
        return judul;
    }

    private ComboBox<String> buatComboPeran() {
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Admin", "Mahasiswa");
        combo.setValue("Mahasiswa");
        combo.setPrefWidth(250);
        combo.setStyle("-fx-background-color: white; -fx-border-color: #ffc0cb;");
        return combo;
    }

    private TextField buatFieldNama() {
        TextField field = new TextField();
        field.setPromptText("Nama Pengguna");
        field.setPrefWidth(250);
        field.setStyle("-fx-background-color: white; -fx-border-color: #ffb6c1; -fx-border-radius: 8px;");
        return field;
    }

    private PasswordField buatFieldPassword() {
        PasswordField field = new PasswordField();
        field.setPromptText("Kata Sandi");
        field.setPrefWidth(250);
        field.setStyle("-fx-background-color: white; -fx-border-color: #ffb6c1; -fx-border-radius: 8px;");
        return field;
    }

    private Button buatTombolLogin(Stage stage) {
        Button tombol = new Button("Masuk");
        tombol.setStyle(
                "-fx-background-color: #ff69b4; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-padding: 10px 20px;"
        );
        tombol.setOnAction(e -> prosesLogin(stage));
        return tombol;

    }



    private Button buatTombolKeluar(Stage stage) {
        Button tombol = new Button("Keluar");
        tombol.setStyle(
                "-fx-background-color: #ffc0cb; " +
                        "-fx-text-fill: #333; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 20px; " +
                        "-fx-padding: 10px 20px;"
        );
        tombol.setOnAction(e -> stage.close());
        return tombol;
    }

    private Label buatLabelError() {
        Label label = new Label();
        label.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        return label;
    }

    private void prosesLogin(Stage stage) {
        String peran = comboPeran.getValue();
        String nama = fieldNama.getText().trim();
        String password = fieldPassword.getText().trim();

        if (nama.isEmpty() || password.isEmpty()) {
            labelError.setText("❌ Nama dan kata sandi harus diisi!");
            return;
        }

        for (User pengguna : LoginSystem.userList) {
            if (peran.equals("Admin") && pengguna instanceof Admin admin) {
                if (admin.username.equals(nama) && admin.password.equals(password)) {
                    stage.setScene(new Scene(new AdminDashboard(stage), 600, 400));
                    return;
                }
            }
            else if (peran.equals("Mahasiswa") && pengguna instanceof Mahasiswa mahasiswa) {
                if (mahasiswa.getNama().equals(nama) && mahasiswa.getNim().equals(password)) {
                    stage.setScene(new Scene(new MahasiswaDashboard(stage), 600, 400));
                    return;
                }
            }
        }

        labelError.setText("❌ Login gagal. Periksa kembali data Anda!");
    }
}