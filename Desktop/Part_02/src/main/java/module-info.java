module com.example.part_02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.part_02 to javafx.fxml;
    exports com.example.part_02;
}