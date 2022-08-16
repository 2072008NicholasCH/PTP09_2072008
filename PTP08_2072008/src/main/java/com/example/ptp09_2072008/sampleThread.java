package com.example.ptp09_2072008;

import com.example.ptp09_2072008.util.utilConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class sampleThread extends Thread{
    private int laporan;
    public sampleThread(int report) {
        this.laporan = report;
    }

    @Override
    public void run() {
        if(laporan == 1){
            Connection conn = utilConnection.getConnection();
            JasperPrint jp;
            Map param = new HashMap();
            try {
                jp = JasperFillManager.fillReport("report/SimpleGroup_PTP06.jasper", param, conn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setTitle("Simple Report");
                jv.setVisible(true);
            } catch (JRException e) {
                throw new RuntimeException(e);
            }
        } else if(laporan == 2) {
            Connection conn = utilConnection.getConnection();
            JasperPrint jp;
            Map param = new HashMap();
            try {
                jp = JasperFillManager.fillReport("report/GroupReport_PTP06.jasper", param, conn);
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setTitle("Group Report");
                jv.setVisible(true);
            } catch (JRException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
