package Designe;

import electionSystem.Candidatecla;
import electionSystem.ClientConnection;
import electionSystem.Electionnewscla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CandidateDash extends javax.swing.JFrame {

    private long endTime_milis;
    private String logcnic;

    public CandidateDash(String cnic) {
        initComponents();
        this.logcnic = cnic;
        caCNIC.setText(cnic);
        caCNIC.setEnabled(false);

        getTimeFromServer();

        if (endTime_milis > 0) {
            setTimer(endTime_milis); // countdown starts
        }

        Electionnewscla.loadNewsIntoTextArea(electionews);
        electionews.setEnabled(false);
    }

    private void getTimeFromServer() {
        try {
            ClientConnection.connectToServer();
            LocalDate date = LocalDate.now();
            int curr_year = date.getYear();

            ClientConnection.out.println("&$#!;" + curr_year);
            String endTime = ClientConnection.in.readLine();

            // Handle date mismatch or missing election
            if ("Election_Time_NOT_FOUND".equals(endTime) || "Election_Date_NOT_MATCHED".equals(endTime)) {
                ClientConnection.socketClose();
                return;
            }

            // Parse and set timer
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            Date timePart = simpleDateFormat.parse(endTime);

            LocalTime endLocalTime = timePart.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            LocalDateTime endDateTime = LocalDateTime.of(LocalDate.now(), endLocalTime);
            ZonedDateTime endZonedDateTime = endDateTime.atZone(ZoneId.systemDefault());

            ZonedDateTime now = ZonedDateTime.now();
            endTime_milis = Duration.between(now, endZonedDateTime).toMillis();

            if (endTime_milis > 0) {
                setTimer(endTime_milis);
            }

            ClientConnection.socketClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void setTimer(long durationInMillis) {
//        Timer timer = new Timer(1000, new ActionListener() {
//            long remaining = durationInMillis;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (remaining <= 0) {
//                    ((Timer) e.getSource()).stop();
//                    time_stop_watch.setText("00:00:00");
//                    JOptionPane.showMessageDialog(null, "Election time is over!");
//                    return;
//                }
//
//                long seconds = remaining / 1000;
//                long hrs = seconds / 3600;
//                long mins = (seconds % 3600) / 60;
//                long secs = seconds % 60;
//
//                String timeFormatted = String.format("%02d:%02d:%02d", hrs, mins, secs);
//                time_stop_watch.setText(timeFormatted);
//
//                remaining -= 1000; // Decrease by 1 second
//            }
//        });
//        timer.start();
//    }
    private void setTimer(long durationInMillis) {
    Timer timer = new Timer(1000, new ActionListener() {
        long remaining = durationInMillis;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (remaining <= 0) {
                ((Timer) e.getSource()).stop();
                time_stop_watch.setText("00:00:00");
                JOptionPane.showMessageDialog(null, "Election time is over!");

                try {
                    int curr_year = LocalDate.now().getYear();
                    ClientConnection.connectToServer();
                    ClientConnection.out.println("!@#;" + curr_year);
                    String resultResponse = ClientConnection.in.readLine();

                    System.out.println("Finalization Response: " + resultResponse);

                    ClientConnection.socketClose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to finalize election results:\n" + ex.getMessage());
                }

                return;
            }

            long seconds = remaining / 1000;
            long hrs = seconds / 3600;
            long mins = (seconds % 3600) / 60;
            long secs = seconds % 60;

            String timeFormatted = String.format("%02d:%02d:%02d", hrs, mins, secs);
            time_stop_watch.setText(timeFormatted);

            remaining -= 1000;
        }
    });

    timer.start();
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        home = new javax.swing.JLabel();
        vote = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        news = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        homepanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        votes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        patable = new javax.swing.JTable();
        Sresult = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        caCNIC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        time_stop_watch = new javax.swing.JLabel();
        EN = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        electionews = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(725, 595));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flag (1).png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
        });

        vote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voting-box.png"))); // NOI18N
        vote.setText("Vote Recivied");
        vote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voteMouseExited(evt);
            }
        });

        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setText("Logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });

        news.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        news.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newspaper.png"))); // NOI18N
        news.setText("Election News");
        news.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(news, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vote, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(home)
                .addGap(55, 55, 55)
                .addComponent(vote, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(news, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(151, 242, 154));

        homepanel.setBackground(new java.awt.Color(0, 153, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.gif"))); // NOI18N

        javax.swing.GroupLayout homepanelLayout = new javax.swing.GroupLayout(homepanel);
        homepanel.setLayout(homepanelLayout);
        homepanelLayout.setHorizontalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        homepanelLayout.setVerticalGroup(
            homepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", homepanel);

        votes.setBackground(new java.awt.Color(0, 153, 0));

        patable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        patable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNIC", "Name", "constituency", "City", "Party symbol", "Votes", "Outcome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(patable);

        Sresult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Sresult.setText("Get Result");
        Sresult.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 204, 204)));
        Sresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SresultActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Candidate CNIC ");

        caCNIC.setBackground(new java.awt.Color(0, 153, 0));
        caCNIC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        caCNIC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Remainig Time");

        time_stop_watch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        time_stop_watch.setText("jLabel7");

        javax.swing.GroupLayout votesLayout = new javax.swing.GroupLayout(votes);
        votes.setLayout(votesLayout);
        votesLayout.setHorizontalGroup(
            votesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(votesLayout.createSequentialGroup()
                .addGroup(votesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(votesLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(Sresult, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(votesLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(votesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(votesLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(caCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(time_stop_watch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        votesLayout.setVerticalGroup(
            votesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(votesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(votesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time_stop_watch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(Sresult, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Votes", votes);

        EN.setBackground(new java.awt.Color(0, 153, 0));

        electionews.setColumns(20);
        electionews.setRows(5);
        jScrollPane1.setViewportView(electionews);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setText("News From Election Commision");

        javax.swing.GroupLayout ENLayout = new javax.swing.GroupLayout(EN);
        EN.setLayout(ENLayout);
        ENLayout.setHorizontalGroup(
            ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ENLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        ENLayout.setVerticalGroup(
            ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Election News", EN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(939, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        this.setVisible(false);
        this.dispose();
        Welcome w = new Welcome();
        w.setVisible(true);
    }//GEN-LAST:event_logoutMousePressed

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBorder(null);
    }//GEN-LAST:event_logoutMouseExited

    private void newsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsMouseEntered
        news.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_newsMouseEntered

    private void newsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsMouseExited
        news.setBorder(null);
    }//GEN-LAST:event_newsMouseExited

    private void voteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voteMouseEntered
        vote.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_voteMouseEntered

    private void voteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voteMouseExited
        vote.setBorder(null);
    }//GEN-LAST:event_voteMouseExited

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        home.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        home.setBorder(null);
    }//GEN-LAST:event_homeMouseExited

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_homeMouseClicked

    private void voteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voteMouseClicked
        if (endTime_milis > 0)
            jTabbedPane1.setSelectedIndex(1);
        else
            JOptionPane.showMessageDialog(null, "Election not scheduled yet ...!");
    }//GEN-LAST:event_voteMouseClicked

    private void newsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_newsMouseClicked

    private void SresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SresultActionPerformed
        String loggedInCnic = caCNIC.getText().trim(); 
        if (loggedInCnic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CNIC is empty.");
            return;
        }

        Candidatecla.getResultForCandidate(patable, loggedInCnic);


    }//GEN-LAST:event_SresultActionPerformed

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
            java.util.logging.Logger.getLogger(CandidateDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandidateDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandidateDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandidateDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String cnic = null;
                new CandidateDash(cnic).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EN;
    private javax.swing.JButton Sresult;
    private javax.swing.JTextField caCNIC;
    private javax.swing.JTextArea electionews;
    private javax.swing.JLabel home;
    private javax.swing.JPanel homepanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel news;
    private javax.swing.JTable patable;
    private javax.swing.JLabel time_stop_watch;
    private javax.swing.JLabel vote;
    private javax.swing.JPanel votes;
    // End of variables declaration//GEN-END:variables
}
