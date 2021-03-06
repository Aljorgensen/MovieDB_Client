/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviedb;

import java.awt.Desktop;
import java.net.URL;

/**
 *
 * @author andersjorgensen
 */
public class InfoGui extends javax.swing.JPanel {

    Logik lg;
    ResultGui regui;
    /**
     * Creates new form InfoGui
     */
    public GuiController ejer;
    public InfoGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        returnB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        moviePlot = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        poster = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        returnToSearchB = new javax.swing.JButton();
        addB = new javax.swing.JButton();
        movieTitle = new javax.swing.JLabel();
        movieRelease = new javax.swing.JLabel();
        movieID = new javax.swing.JLabel();
        deleteMovie = new javax.swing.JButton();
        TrailerB = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movie Information");

        returnB.setText("Return to menu");
        returnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel2.setText("Title:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel3.setText("Release date:");

        idLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        idLabel.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel4.setText("Plot:");

        moviePlot.setColumns(20);
        moviePlot.setRows(5);
        jScrollPane1.setViewportView(moviePlot);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel6.setText("Poster:");

        returnToSearchB.setText("Return to search results");
        returnToSearchB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnToSearchBActionPerformed(evt);
            }
        });

        addB.setText("Add to database");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        movieTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieTitle.setText("movieTitle");

        movieRelease.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieRelease.setText("movieRelease");

        movieID.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieID.setText("movieID");

        deleteMovie.setText("Delete from database");
        deleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMovieActionPerformed(evt);
            }
        });

        TrailerB.setText("Trailer");
        TrailerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrailerBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteMovie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnToSearchB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnB)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(movieTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieRelease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(idLabel)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6)
                            .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TrailerB)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movieTitle)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movieRelease)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(movieID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrailerB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnB)
                    .addComponent(returnToSearchB)
                    .addComponent(addB)
                    .addComponent(deleteMovie))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBActionPerformed
        // TODO add your handling code here:
        ejer.skift(ejer.maingui);
        lg.setLatest();
    }//GEN-LAST:event_returnBActionPerformed

    private void returnToSearchBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnToSearchBActionPerformed
        // TODO add your handling code here:
        lg.setMovie();
        ejer.skift(ejer.regui);
    }//GEN-LAST:event_returnToSearchBActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        // TODO add your handling code here:
        lg.addMovie(movieID.getText());
    }//GEN-LAST:event_addBActionPerformed

    private void deleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMovieActionPerformed
        // TODO add your handling code here:
        lg.deleteMovie(movieID.getText());
        if(lg.type == 1){
            lg.getMovielist();
            lg.setPosterResult(0);
        }
        lg.setMovie();
        ejer.skift(ejer.regui);
    }//GEN-LAST:event_deleteMovieActionPerformed

    private void TrailerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrailerBActionPerformed
        // TODO add your handling code here:
        String url = lg.getTrailerUrl(movieID.getText());
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URL(url).toURI()); 
            } catch (Exception ex) {
                
            }
        }
    }//GEN-LAST:event_TrailerBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TrailerB;
    private javax.swing.JButton addB;
    private javax.swing.JButton deleteMovie;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel movieID;
    public javax.swing.JTextArea moviePlot;
    public javax.swing.JLabel movieRelease;
    public javax.swing.JLabel movieTitle;
    public javax.swing.JLabel poster;
    private javax.swing.JButton returnB;
    private javax.swing.JButton returnToSearchB;
    // End of variables declaration//GEN-END:variables
}
