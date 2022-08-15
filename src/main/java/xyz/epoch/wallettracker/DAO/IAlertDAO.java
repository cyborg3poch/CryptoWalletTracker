package xyz.epoch.wallettracker.DAO;

import xyz.epoch.wallettracker.Model.AlertDTO;

import java.util.List;

public interface IAlertDAO {

    int AddAlert(AlertDTO alertDTO);
    int DeleteAlerts();
    List<AlertDTO> getAllAlerts();
}
