package com.mycompany.moviedb;

/**
 *
 * @author andersjorgensen
 */
public class ResultGui extends javax.swing.JPanel {

    MainGui maingui;
    Logik lg;
    InfoGui ig;
    /**
     * Creates new form ResultGui
     */
    public GuiController ejer;
    public ResultGui() {
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

        jTextField1 = new javax.swing.JTextField();
        jScrollBar1 = new javax.swing.JScrollBar();
        reguiTitle = new javax.swing.JLabel();
        returnB = new javax.swing.JButton();
        movie1B = new javax.swing.JButton();
        movieOneTitle = new javax.swing.JLabel();
        movieTwoTitle = new javax.swing.JLabel();
        movie2B = new javax.swing.JButton();
        movieOneID = new javax.swing.JLabel();
        movieTwoID = new javax.swing.JLabel();
        movieThreeTitle = new javax.swing.JLabel();
        movieThreeID = new javax.swing.JLabel();
        movie3B = new javax.swing.JButton();
        movieFourTitle = new javax.swing.JLabel();
        movieFourID = new javax.swing.JLabel();
        movie4B = new javax.swing.JButton();
        movieFiveTitle = new javax.swing.JLabel();
        movieFiveID = new javax.swing.JLabel();
        movie5B = new javax.swing.JButton();
        moreResults = new javax.swing.JButton();
        backB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        poster = new javax.swing.JLabel();
        moreInfo = new javax.swing.JButton();
        choiceOne = new javax.swing.JLabel();
        choiceTwo = new javax.swing.JLabel();
        choiceThree = new javax.swing.JLabel();
        choiceFour = new javax.swing.JLabel();
        choiceFive = new javax.swing.JLabel();
        addB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setPreferredSize(new java.awt.Dimension(830, 515));

        reguiTitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        reguiTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reguiTitle.setText("Result");

        returnB.setText("Return");
        returnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBActionPerformed(evt);
            }
        });

        movie1B.setText("See poster");
        movie1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie1BActionPerformed(evt);
            }
        });

        movieOneTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieOneTitle.setText("movieOneTitle");

        movieTwoTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieTwoTitle.setText("movieTwoTitle");

        movie2B.setText("See poster");
        movie2B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie2BActionPerformed(evt);
            }
        });

        movieOneID.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieOneID.setText("movieOneID");

        movieTwoID.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieTwoID.setText("movieTwoID");

        movieThreeTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieThreeTitle.setText("movieThreeTitle");

        movieThreeID.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieThreeID.setText("movieThreeID");

        movie3B.setText("See poster");
        movie3B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie3BActionPerformed(evt);
            }
        });

        movieFourTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieFourTitle.setText("movieFourTitle");

        movieFourID.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieFourID.setText("movieFourID");

        movie4B.setText("See poster");
        movie4B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie4BActionPerformed(evt);
            }
        });

        movieFiveTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieFiveTitle.setText("movieFiveTitle");

        movieFiveID.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        movieFiveID.setText("movieFiveID");

        movie5B.setText("See poster");
        movie5B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie5BActionPerformed(evt);
            }
        });

        moreResults.setText("Next Page");
        moreResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreResultsActionPerformed(evt);
            }
        });

        backB.setText("Back");
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel2.setText("Poster:");

        moreInfo.setText("More information");
        moreInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreInfoActionPerformed(evt);
            }
        });

        choiceOne.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        choiceOne.setText("<-");

        choiceTwo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        choiceTwo.setText("<-");

        choiceThree.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        choiceThree.setText("<-");

        choiceFour.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        choiceFour.setText("<-");

        choiceFive.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        choiceFive.setText("<-");

        addB.setText("Add movie");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reguiTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moreResults)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                        .addComponent(addB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moreInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(returnB))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(movie1B)
                                .addGap(18, 18, 18)
                                .addComponent(choiceOne))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(movie2B)
                                .addGap(18, 18, 18)
                                .addComponent(choiceTwo))
                            .addComponent(movieOneTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(movieOneID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieTwoTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieTwoID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(movie3B)
                                .addGap(18, 18, 18)
                                .addComponent(choiceThree))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(movie4B)
                                .addGap(18, 18, 18)
                                .addComponent(choiceFour))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(movie5B)
                                .addGap(18, 18, 18)
                                .addComponent(choiceFive))
                            .addComponent(movieThreeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieThreeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieFourTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieFourID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieFiveTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(movieFiveID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(238, 238, 238))
                            .addComponent(poster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reguiTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(movieOneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(poster, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(movieOneID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(movie1B)
                                    .addComponent(choiceOne))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieTwoTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieTwoID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(movie2B)
                                    .addComponent(choiceTwo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieThreeTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieThreeID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(movie3B)
                                    .addComponent(choiceThree))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieFourTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieFourID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(movie4B)
                                    .addComponent(choiceFour))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(movieFiveTitle))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movieFiveID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movie5B)
                    .addComponent(choiceFive))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnB)
                    .addComponent(moreResults)
                    .addComponent(backB)
                    .addComponent(moreInfo)
                    .addComponent(addB))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void returnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBActionPerformed
        // TODO add your handling code here:
        ejer.skift(ejer.maingui);
        lg.parameter = 0;
        lg.setLatest();
    }//GEN-LAST:event_returnBActionPerformed

    private void movie1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie1BActionPerformed
        // TODO add your handling code here:
        lg.choice = 0;
        choiceOne.setText("<-");
        choiceTwo.setText("");
        choiceThree.setText("");
        choiceFour.setText("");
        choiceFive.setText("");
        lg.setPosterResult(0);
    }//GEN-LAST:event_movie1BActionPerformed

    private void movie2BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie2BActionPerformed
        // TODO add your handling code here:
        lg.choice = 1;
        choiceOne.setText("");
        choiceTwo.setText("<-");
        choiceThree.setText("");
        choiceFour.setText("");
        choiceFive.setText("");
        lg.setPosterResult(1);
    }//GEN-LAST:event_movie2BActionPerformed

    private void moreResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreResultsActionPerformed
        // TODO add your handling code here
        if(lg.page >= lg.pageNum){
            if(lg.page == lg.pageNum){
               lg.parameter = (int) (lg.page * 5);
            }else{
              lg.parameter += 5;
              lg.pageNum ++;  
            }
        }
        choiceOne.setText("<-");
        choiceTwo.setText("");
        choiceThree.setText("");
        choiceFour.setText("");
        choiceFive.setText("");
        lg.setPosterResult(0);
        lg.setMovie();
    }//GEN-LAST:event_moreResultsActionPerformed

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
        // TODO add your handling code here:
        if(lg.pageNum == 0){
                lg.parameter = 0;
        }else{
            lg.parameter -= 5;
            lg.pageNum--;  
        }
        choiceOne.setText("<-");
        choiceTwo.setText("");
        choiceThree.setText("");
        choiceFour.setText("");
        choiceFive.setText("");
        lg.setMovie();
        lg.setPosterResult(0);
    }//GEN-LAST:event_backBActionPerformed

    private void movie3BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie3BActionPerformed
        // TODO add your handling code here:
        lg.choice = 2;
        choiceOne.setText("");
        choiceTwo.setText("");
        choiceThree.setText("<-");
        choiceFour.setText("");
        choiceFive.setText("");
        lg.setPosterResult(2);
    }//GEN-LAST:event_movie3BActionPerformed

    private void movie4BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie4BActionPerformed
        // TODO add your handling code here:
        lg.choice = 3;
        choiceOne.setText("");
        choiceTwo.setText("");
        choiceThree.setText("");
        choiceFour.setText("<-");
        choiceFive.setText("");
        lg.setPosterResult(3);
    }//GEN-LAST:event_movie4BActionPerformed

    private void movie5BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie5BActionPerformed
        // TODO add your handling code here:
        lg.choice = 4;
        choiceOne.setText("");
        choiceTwo.setText("");
        choiceThree.setText("");
        choiceFour.setText("");
        choiceFive.setText("<-");
        lg.setPosterResult(4);
    }//GEN-LAST:event_movie5BActionPerformed

    private void moreInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreInfoActionPerformed
        // TODO add your handling code here:
        ig.movieTitle.setText(lg.title.get(lg.choice + lg.parameter));
        ig.movieRelease.setText(lg.splitRelease(lg.choice + lg.parameter));
        ig.movieID.setText(lg.id.get(lg.choice + lg.parameter));
        lg.splitPlot((int) (lg.choice + lg.parameter));
        lg.setPoster(lg.choice);
        ejer.skift(ejer.ingui); 
    }//GEN-LAST:event_moreInfoActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        // TODO add your handling code here:
        lg.addMovie(lg.id.get(lg.choice + lg.parameter));
    }//GEN-LAST:event_addBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private javax.swing.JButton backB;
    public javax.swing.JLabel choiceFive;
    public javax.swing.JLabel choiceFour;
    public javax.swing.JLabel choiceOne;
    public javax.swing.JLabel choiceThree;
    public javax.swing.JLabel choiceTwo;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton moreInfo;
    private javax.swing.JButton moreResults;
    private javax.swing.JButton movie1B;
    private javax.swing.JButton movie2B;
    private javax.swing.JButton movie3B;
    private javax.swing.JButton movie4B;
    private javax.swing.JButton movie5B;
    public javax.swing.JLabel movieFiveID;
    public javax.swing.JLabel movieFiveTitle;
    public javax.swing.JLabel movieFourID;
    public javax.swing.JLabel movieFourTitle;
    public javax.swing.JLabel movieOneID;
    public javax.swing.JLabel movieOneTitle;
    public javax.swing.JLabel movieThreeID;
    public javax.swing.JLabel movieThreeTitle;
    public javax.swing.JLabel movieTwoID;
    public javax.swing.JLabel movieTwoTitle;
    public javax.swing.JLabel poster;
    public javax.swing.JLabel reguiTitle;
    private javax.swing.JButton returnB;
    // End of variables declaration//GEN-END:variables
}
