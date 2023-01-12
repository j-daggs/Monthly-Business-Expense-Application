/*
Randee Carter
John Daggs
Jonah Gloss
Drake Kvaall
Chase Richardet

4/21/22
CSC-331

Business Expense Pie Chart
 */





package com.example.piechart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TextField;

public class PieChartController {

    @FXML
    PieChart pieChart;

    @FXML
    private TextField totalSalesTextField;

    @FXML
    private TextField electricTextField;

    @FXML
    private TextField waterTextField;

    @FXML
    private TextField payRollTextField;

    @FXML
    private TextField rentTextField;

    @FXML
    private TextField officeSuppliesTextField;

    @FXML
    private TextField taxesTextField;


    public void generateChart(ActionEvent ae){

        double totalExpenses=0;
        //grabbing info from text field for sales and converting string to double so it can be used in pie chart and math
        String sales = totalSalesTextField.getText();
        double sales1 = Double.parseDouble(sales); //adding to the total expenses

        //grabbing electric from text field for sales and converting string to double so it can be used in pie chart and math
        String electric = electricTextField.getText();
        double electric1 = Double.parseDouble(electric);
        totalExpenses = totalExpenses + electric1; //adding to the total expenses

        //grabbing water from text field for sales and converting string to double so it can be used in pie chart and math
        String water = waterTextField.getText();
        double water1 = Double.parseDouble(water);
        totalExpenses = totalExpenses + water1; //adding to the total expenses

        //grabbing payRoll from text field for sales and converting string to double so it can be used in pie chart and math
        String payRoll = payRollTextField.getText();
        double payRoll1 = Double.parseDouble(payRoll);
        totalExpenses = totalExpenses + payRoll1; //adding to the total expenses

        //grabbing rent from text field for sales and converting string to double so it can be used in pie chart and math
        String rent = rentTextField.getText();
        double rent1 = Double.parseDouble(rent);
        totalExpenses = totalExpenses + rent1; //adding to the total expenses

        //grabbing info from text field for officeSupplies and converting string to double so it can be used in pie chart and math
        String officeSupplies = officeSuppliesTextField.getText();
        double officeSupplies1 = Double.parseDouble(officeSupplies);
        totalExpenses = totalExpenses + officeSupplies1; //adding to the total expenses

        //grabbing info from text field for taxes and converting string to double so it can be used in pie chart and math
        String taxes = taxesTextField.getText();
        double taxes1 = Double.parseDouble(taxes);
        taxes1= taxes1/100; //converting to a decimal for math
        taxes1 = sales1*taxes1; //detracting taxes from sales
        totalExpenses = totalExpenses + taxes1; //adding to the total expenses


        double profit = sales1 - (totalExpenses); //subtracting total expenses from sales to find profit/loss


        if(profit < 0){ //if profit was negative, the company took a loss and the pie chart will show it
            ObservableList<Data> list=FXCollections.observableArrayList(
                    new PieChart.Data("Loss",profit),
                    new PieChart.Data("Electricity bill",electric1),
                    new PieChart.Data("Water bill",water1),
                    new PieChart.Data("Pay roll",payRoll1),
                    new PieChart.Data("Rent",rent1),
                    new PieChart.Data("Office supplies",officeSupplies1),
                    new PieChart.Data("Taxes",taxes1)
            );
            pieChart.setData(list);
        }
        else if(profit == 0){ //if the profit was 0, no profit will be shown
            ObservableList<Data> list=FXCollections.observableArrayList(
                    new PieChart.Data("Electricity bill",electric1),
                    new PieChart.Data("Water bill",water1),
                    new PieChart.Data("Pay roll",payRoll1),
                    new PieChart.Data("Rent",rent1),
                    new PieChart.Data("Office supplies",officeSupplies1),
                    new PieChart.Data("Taxes",taxes1)
            );
            pieChart.setData(list);

        }


        else{ //if the profit was above 0, profit will be shown
            ObservableList<Data> list=FXCollections.observableArrayList(
                    new PieChart.Data("Profit",profit),
                    new PieChart.Data("Electricity bill",electric1),
                    new PieChart.Data("Water bill",water1),
                    new PieChart.Data("Pay roll",payRoll1),
                    new PieChart.Data("Rent",rent1),
                    new PieChart.Data("Office supplies",officeSupplies1),
                    new PieChart.Data("Taxes",taxes1)
            );
            pieChart.setData(list);
        }




    }
}