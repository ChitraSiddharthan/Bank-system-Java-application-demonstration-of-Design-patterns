package com.example.GUI;

import com.example.LoanPackage.Loan.Loan;
import com.example.LoanPackage.LoanIterator.Iterator;
import com.example.LoanPackage.LoanIterator.LoanRequestsRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserRequestsController implements Initializable {

    @FXML
    private TableView<Loan> loan_req_table;
    @FXML
    private TableColumn<Loan, Integer> account_col;
    @FXML
    private TableColumn<Loan, Integer> loan_id_col;
    @FXML
    private TableColumn<Loan, String> type_col;
    @FXML
    private TableColumn<Loan, LocalDate> start_col;
    @FXML
    private TableColumn<Loan, String> status_col;

    ObservableList<Loan> list = FXCollections.observableArrayList();

    public void initCol(){
        account_col.setCellValueFactory(new PropertyValueFactory<>("userId"));
        loan_id_col.setCellValueFactory(new PropertyValueFactory<>("loanId"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("loanType"));
        start_col.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    public void loadRequests() throws SQLException {
        LoanRequestsRepo requestsRepo = new LoanRequestsRepo(LayoutController.user.getUserId());
        for(Iterator iter = requestsRepo.getIterator(); iter.hasNext();)
        {
            Loan loan = (Loan) iter.next();
            list.add(loan);
        }
        loan_req_table.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        try {
            loadRequests();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
