import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class tebakAngka extends Application {
    private int angkaTarget;
    private int jumlahTebakan;
    private final Random acak = new Random();

    private Label labelFeedback;
    private Label labelJumlahTebakan;
    private TextField kolomInput;
    private Button tombolAksi;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage panggungUtama) {
        buatAngkaAcak();

        Label labelJudul = new Label("\uD83C\uDFAF Tebak Angka 1–100 !");
        labelJudul.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 22));
        labelJudul.setTextFill(Color.HOTPINK);

        labelFeedback = new Label("Masukkan tebakanmu!");
        labelFeedback.setFont(Font.font("Comic Sans MS", 16));
        labelFeedback.setTextFill(Color.MEDIUMVIOLETRED);

        kolomInput = new TextField();
        kolomInput.setPromptText("Masukkan angka!");
        kolomInput.setFont(Font.font("Comic Sans MS", 14));
        kolomInput.setMaxWidth(160);
        kolomInput.setOnAction(e -> {
            if (tombolAksi.getText().equals("🔵 Main Lagi")) {
                resetPermainan();
            } else {
                prosesTebakan();
            }
        });

        tombolAksi = new Button("🟢 Coba Tebak!");
        tombolAksi.setFont(Font.font("Comic Sans MS", 14));
        tombolAksi.setStyle("-fx-background-color: pink; -fx-text-fill: black;");
        tombolAksi.setOnAction(e -> prosesTebakan());

        HBox kotakInput = new HBox(10, kolomInput, tombolAksi);
        kotakInput.setAlignment(Pos.CENTER);

        labelJumlahTebakan = new Label("Jumlah percobaan: 0");
        labelJumlahTebakan.setFont(Font.font("Comic Sans MS", 14));
        labelJumlahTebakan.setTextFill(Color.SADDLEBROWN);

        VBox akar = new VBox(20, labelJudul, labelFeedback, kotakInput, labelJumlahTebakan);
        akar.setAlignment(Pos.CENTER);
        akar.setPadding(new Insets(30));
        akar.setStyle("-fx-background-color: #fff0f5;");

        Scene adegan = new Scene(akar, 420, 300);
        panggungUtama.setTitle("Tebak Angka Nupi");
        panggungUtama.setScene(adegan);
        panggungUtama.setResizable(false);
        panggungUtama.show();
    }

    private void buatAngkaAcak() {
        angkaTarget = acak.nextInt(100) + 1;
        jumlahTebakan = 0;
        if (labelJumlahTebakan != null) {
            labelJumlahTebakan.setText("Jumlah percobaan: 0");
        }
    }

    private void resetPermainan() {
        buatAngkaAcak();
        labelFeedback.setText("Masukkan tebakanmu!");
        labelFeedback.setTextFill(Color.MEDIUMVIOLETRED);
        kolomInput.setDisable(false);
        kolomInput.setText("");
        tombolAksi.setText("🟢 Coba Tebak!");
        tombolAksi.setStyle("-fx-background-color: pink; -fx-text-fill: black;");
    }

    private void prosesTebakan() {
        if (tombolAksi.getText().equals("🔵 Main Lagi")) {
            resetPermainan();
            return;
        }

        String teksTebakan = kolomInput.getText();
        if (!teksTebakan.matches("\\d+")) {
            labelFeedback.setText("⚠ Masukkan angka yang valid!");
            labelFeedback.setTextFill(Color.ORANGERED);
            kolomInput.clear();
            return;
        }

        int tebakan = Integer.parseInt(teksTebakan);
        jumlahTebakan++;
        labelJumlahTebakan.setText("Jumlah percobaan: " + jumlahTebakan);

        if (tebakan < angkaTarget) {
            labelFeedback.setText("🔽 Terlalu kecil!");
            labelFeedback.setTextFill(Color.CORNFLOWERBLUE);
        } else if (tebakan > angkaTarget) {
            labelFeedback.setText("⚠ Terlalu besar!");
            labelFeedback.setTextFill(Color.CORNFLOWERBLUE);
        } else {
            labelFeedback.setText("✅ Tebakan kamu BENAR!");
            labelFeedback.setTextFill(Color.FORESTGREEN);
            kolomInput.setDisable(true);
            tombolAksi.setText("🔵 Main Lagi");
            tombolAksi.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        }

        kolomInput.clear();
    }
}
