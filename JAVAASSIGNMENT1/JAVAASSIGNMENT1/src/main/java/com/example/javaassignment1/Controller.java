package com.example.javaassignment1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.example.javaassignment1.ProductData;

public class Controller implements Initializable {
    @FXML
    private BarChart<String, Number> barChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<ProductData> productRecommendations = getData();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (ProductData product : productRecommendations) {
            series.getData().add(new XYChart.Data<>(product.getProductName(), product.getRecommendationCount()));
        }

        barChart.getData().add(series);
    }

    private List<ProductData> getData() {
        List<ProductData> productRecommendations = new ArrayList<>();
        String query = "SELECT * FROM product_recommendations";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                int recommendationCount = resultSet.getInt("recommendation_count");
                productRecommendations.add(new ProductData(id, productName, recommendationCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productRecommendations;
    }
}
