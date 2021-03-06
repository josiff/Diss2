/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.chart.NumberAxis;
import model.Car;
import model.Stavba;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Jožko
 */
public class GUI extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form GUI
     */
    Stavba core;
    XYSeries avgSeries;
    
    public GUI() {
        initComponents();
        prgMnozstvo.setValue(100);
        core = new Stavba(Double.parseDouble(txtTrvanieSim.getText()) * 24 * 60);
        core.addObserver(this);
        core.initCar();
        core.setVariant(1);
        carView1.setCar(core.getCar("A1"));
        carView2.setCar(core.getCar("A2"));
        carView3.setCar(core.getCar("A3"));
        carView4.setCar(core.getCar("A4"));
        core.getRefreshEvent().setPlan(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rsSim = new javax.swing.ButtonGroup();
        rsVariant = new javax.swing.ButtonGroup();
        prgMnozstvo = new javax.swing.JProgressBar();
        slidRychlost = new javax.swing.JSlider();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        txtTrvanieSim = new javax.swing.JTextField();
        rsSoSim = new javax.swing.JRadioButton();
        rsBezSim = new javax.swing.JRadioButton();
        lblRychlost = new javax.swing.JLabel();
        panelGraf = new javax.swing.JPanel();
        carView1 = new gui.CarView();
        carView2 = new gui.CarView();
        carView3 = new gui.CarView();
        carView4 = new gui.CarView();
        rsVar1 = new javax.swing.JRadioButton();
        rsVar2 = new javax.swing.JRadioButton();
        rsVar3 = new javax.swing.JRadioButton();
        prgDovez = new javax.swing.JProgressBar();
        sliderSleep = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        txtPocRep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblSleep = new javax.swing.JLabel();
        lblHours = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCisRep = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPriemTrv = new javax.swing.JLabel();
        lblInterval = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblDobaNakl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDobaVyk = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblPriemPocNak = new javax.swing.JLabel();
        lblPriemPocVyk = new javax.swing.JLabel();
        txtOdrezanie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        slidRychlost.setMinimum(1);
        slidRychlost.setToolTipText("Uspatie");
        slidRychlost.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidRychlostStateChanged(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        txtTrvanieSim.setText("1440000");

        rsSim.add(rsSoSim);
        rsSoSim.setSelected(true);
        rsSoSim.setText("so Simulaciou");
        rsSoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsSoSimActionPerformed(evt);
            }
        });

        rsSim.add(rsBezSim);
        rsBezSim.setText("bez Simulacie");
        rsBezSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsBezSimActionPerformed(evt);
            }
        });

        lblRychlost.setText("50");

        panelGraf.setBackground(new java.awt.Color(102, 102, 102));
        panelGraf.setLayout(new java.awt.BorderLayout());

        rsVariant.add(rsVar1);
        rsVar1.setSelected(true);
        rsVar1.setText("Variant 1");
        rsVar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsVar1ActionPerformed(evt);
            }
        });

        rsVariant.add(rsVar2);
        rsVar2.setText("Variant 2");
        rsVar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsVar2ActionPerformed(evt);
            }
        });

        rsVariant.add(rsVar3);
        rsVar3.setText("Variant 3");
        rsVar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rsVar3ActionPerformed(evt);
            }
        });

        sliderSleep.setMajorTickSpacing(10);
        sliderSleep.setMaximum(10);
        sliderSleep.setMinimum(1);
        sliderSleep.setMinorTickSpacing(1);
        sliderSleep.setPaintLabels(true);
        sliderSleep.setPaintTicks(true);
        sliderSleep.setSnapToTicks(true);
        sliderSleep.setToolTipText("Ako často planovat");
        sliderSleep.setValue(1);
        sliderSleep.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sliderSleep.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderSleepStateChanged(evt);
            }
        });

        jLabel1.setText("Trvanie");

        txtPocRep.setText("10000");

        jLabel2.setText("Počet replik");

        lblSleep.setText("50");

        lblHours.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHours.setText("00");

        jLabel3.setText("Cislo replikacie");

        lblCisRep.setText("0");

        jLabel4.setText("Priemerny cas trvania");

        jLabel5.setText("90% interval spolahlivosti");

        lblPriemTrv.setText("0");

        lblInterval.setText("0");

        jLabel6.setText("Priem. doba pred nakladacom");

        lblDobaNakl.setText("0");

        jLabel8.setText("Priem. doba pred vykladacom");

        lblDobaVyk.setText("0");

        jLabel10.setText("Priem. pocet pred nakladacom");

        jLabel11.setText("Priem. pocet pred vykladacom");

        lblPriemPocNak.setText("0");

        lblPriemPocVyk.setText("0");

        txtOdrezanie.setText("40");

        jLabel7.setText("Odrezat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prgMnozstvo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prgDovez, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHours, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(lblSleep))
                                    .addComponent(sliderSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(lblRychlost))
                                    .addComponent(slidRychlost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rsSoSim)
                                .addGap(6, 6, 6)
                                .addComponent(rsBezSim)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCisRep)
                            .addComponent(lblPriemTrv)
                            .addComponent(lblInterval)
                            .addComponent(lblDobaNakl)
                            .addComponent(lblDobaVyk)
                            .addComponent(lblPriemPocNak)
                            .addComponent(lblPriemPocVyk)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carView3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carView4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rsVar1)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rsVar2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(rsVar3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTrvanieSim, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtOdrezanie, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPocRep, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(carView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(prgMnozstvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(prgDovez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblHours)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSleep)
                                .addGap(1, 1, 1)
                                .addComponent(sliderSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRychlost)
                                .addGap(6, 6, 6)
                                .addComponent(slidRychlost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rsSoSim)
                            .addComponent(rsBezSim)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblCisRep)
                        .addGap(6, 6, 6)
                        .addComponent(lblPriemTrv)
                        .addGap(6, 6, 6)
                        .addComponent(lblInterval)
                        .addGap(16, 16, 16)
                        .addComponent(lblDobaNakl)
                        .addGap(6, 6, 6)
                        .addComponent(lblDobaVyk)
                        .addGap(26, 26, 26)
                        .addComponent(lblPriemPocNak)
                        .addGap(6, 6, 6)
                        .addComponent(lblPriemPocVyk)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(carView3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(carView4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rsVar1)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rsVar2)
                                    .addComponent(rsVar3))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtOdrezanie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTrvanieSim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(txtPocRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(panelGraf, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        sliderSleep.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        core.setRunning(false);
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
        core.setRunning(core.isStop());
        if (!core.isRunning()) {
            core.setRunning(true);
        } else {
            
            core.setStop(false);
            prgMnozstvo.setValue(100);
            prgDovez.setValue(0);
            core.setTrvanie(Double.parseDouble(txtTrvanieSim.getText()));
            
            core.runRest();
            avgSeries = new XYSeries("AVG");
            XYSeriesCollection dataset = new XYSeriesCollection(avgSeries);
            
            JFreeChart lineChart = ChartFactory.createXYLineChart(null, null, null, dataset);
            final org.jfree.chart.axis.NumberAxis rangeAxis = (org.jfree.chart.axis.NumberAxis) lineChart.getXYPlot().getRangeAxis();
            rangeAxis.setAutoRangeIncludesZero(false);
            ChartPanel chartPanel = new ChartPanel(lineChart);
            panelGraf.removeAll();
            panelGraf.add(chartPanel, BorderLayout.CENTER);
            panelGraf.validate();
            
            core.setPocRep(Double.parseDouble(txtPocRep.getText()));
            
            if (rsVar1.isSelected()) {
                rsVar1ActionPerformed(null);
            } else if (rsVar2.isSelected()) {
                rsVar2ActionPerformed(null);
            } else {
                rsVar3ActionPerformed(evt);
            }
            
            if (rsBezSim.isSelected()) {
                rsBezSimActionPerformed(null);
            } else {
                rsSoSimActionPerformed(null);
            }
            
            slidRychlostStateChanged(null);
            sliderSleepStateChanged(null);
            
            core.runReplikacie();
            
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void rsSoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsSoSimActionPerformed
        core.getRefreshEvent().setPlan(true);
        

    }//GEN-LAST:event_rsSoSimActionPerformed

    private void rsBezSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsBezSimActionPerformed
        core.getRefreshEvent().setPlan(false);
        

    }//GEN-LAST:event_rsBezSimActionPerformed

    private void slidRychlostStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidRychlostStateChanged
        core.getRefreshEvent().setHowTime(slidRychlost.getValue() / 100.0);
        
        lblRychlost.setText(String.valueOf(slidRychlost.getValue()));
    }//GEN-LAST:event_slidRychlostStateChanged

    private void rsVar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsVar1ActionPerformed
        core.setVariant(1);
        carView4.setVisible(true);
        carView1.setCar(core.getCar("A1"));
        carView2.setCar(core.getCar("A2"));
        carView3.setCar(core.getCar("A3"));
        carView4.setCar(core.getCar("A4"));

    }//GEN-LAST:event_rsVar1ActionPerformed

    private void rsVar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsVar2ActionPerformed
        core.setVariant(2);
        carView1.setCar(core.getCar("A1"));
        carView2.setCar(core.getCar("A3"));
        carView3.setCar(core.getCar("A5"));
        carView4.setVisible(false);
    }//GEN-LAST:event_rsVar2ActionPerformed

    private void rsVar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rsVar3ActionPerformed
        core.setVariant(3);
        carView1.setCar(core.getCar("A2"));
        carView2.setCar(core.getCar("A3"));
        carView3.setCar(core.getCar("A4"));
        carView4.setVisible(false);
    }//GEN-LAST:event_rsVar3ActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        
        core.setStop(true);
        core.runRest();

    }//GEN-LAST:event_btnStopActionPerformed

    private void sliderSleepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderSleepStateChanged
        core.getRefreshEvent().setSleep(sliderSleep.getValue());
        
        lblSleep.setText(String.valueOf(sliderSleep.getValue()));
    }//GEN-LAST:event_sliderSleepStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private gui.CarView carView1;
    private gui.CarView carView2;
    private gui.CarView carView3;
    private gui.CarView carView4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCisRep;
    private javax.swing.JLabel lblDobaNakl;
    private javax.swing.JLabel lblDobaVyk;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblInterval;
    private javax.swing.JLabel lblPriemPocNak;
    private javax.swing.JLabel lblPriemPocVyk;
    private javax.swing.JLabel lblPriemTrv;
    private javax.swing.JLabel lblRychlost;
    private javax.swing.JLabel lblSleep;
    private javax.swing.JPanel panelGraf;
    private javax.swing.JProgressBar prgDovez;
    private javax.swing.JProgressBar prgMnozstvo;
    private javax.swing.JRadioButton rsBezSim;
    private javax.swing.ButtonGroup rsSim;
    private javax.swing.JRadioButton rsSoSim;
    private javax.swing.JRadioButton rsVar1;
    private javax.swing.JRadioButton rsVar2;
    private javax.swing.JRadioButton rsVar3;
    private javax.swing.ButtonGroup rsVariant;
    private javax.swing.JSlider slidRychlost;
    private javax.swing.JSlider sliderSleep;
    private javax.swing.JTextField txtOdrezanie;
    private javax.swing.JTextField txtPocRep;
    private javax.swing.JTextField txtTrvanieSim;
    // End of variables declaration//GEN-END:variables

    public String pom = "";
    
    @Override
    
    public void update(Observable o, Object arg) {
        
        lblHours.setText(String.valueOf(core.getAktCas() / 60.0));
        
        if (rsBezSim.isSelected()) {
            lblCisRep.setText(String.valueOf(core.getStatistic().getAktReplikacia() + 1));
            lblPriemTrv.setText(String.valueOf(core.getStatistic().getAvgTrvania()));
            lblInterval.setText("< " + String.valueOf(core.getStatistic().getSpodny90PercIS()) + " ; " + String.valueOf(core.getStatistic().getHorny90PercIS() + " >"));
            lblDobaNakl.setText(String.valueOf(core.getStatistic().getAvgTimeNakladac()));
            lblDobaVyk.setText(String.valueOf(core.getStatistic().getAvgTimeVykladac()));
            lblPriemPocNak.setText(String.valueOf(core.getStatistic().getAvgRadNakPocet()));
            
            if (core.getStatistic().getAktReplikacia() > Integer.parseInt(txtOdrezanie.getText()) / 100.0 * core.getPocRep()) {
                avgSeries.add(core.getStatistic().getAktReplikacia(), core.getStatistic().getAvgTrvania());
                
            }
        } else {
            prgMnozstvo.setValue((int) core.getMnozMat() * 100 / (int) core.getSklad());
            prgDovez.setValue((int) core.getDovezene() * 100 / (int) core.getSklad());
            Car car;
            switch (((Stavba) core).getVariant()) {
                case 1:
                    car = core.getCar("A1");
                    carView1.setCar(core.getAktCas());
                    car = core.getCar("A2");
                    carView2.setCar(core.getAktCas());
                    car = core.getCar("A3");
                    carView3.setCar(core.getAktCas());
                    car = core.getCar("A4");
                    carView4.setCar(core.getAktCas());
                    break;
                
                case 2:
                    car = core.getCar("A1");
                    carView1.setCar(core.getAktCas());
                    car = core.getCar("A3");
                    carView2.setCar(core.getAktCas());
                    car = core.getCar("A5");
                    carView3.setCar(core.getAktCas());
                    break;
                
                case 3:
                    car = core.getCar("A2");
                    carView1.setCar(core.getAktCas());
                    car = core.getCar("A3");
                    carView2.setCar(core.getAktCas());
                    car = core.getCar("A4");
                    carView3.setCar(core.getAktCas());
                    break;
            }
        }
        
    }
    
}
