package Designe;

import electionSystem.ClientConnection;
import electionSystem.Electionnewscla;
import electionSystem.Resultcla;
import electionSystem.Voterscla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 *
 * @author pc
 */
public class VoterDash extends javax.swing.JFrame {

    private long endTime_milis;
    private String logcnic;

    public VoterDash(String cnic) {
        this.logcnic = cnic;
        initComponents();
        pacnic.setText(cnic);
        pacnic.setEnabled(false);
        nacnic.setText(cnic);
        nacnic.setEnabled(false);
        getTimeFromServer();

        if (endTime_milis > 0) {
            setTimer(endTime_milis);
        }

        Electionnewscla.loadNewsIntoTextArea(electionnews);
        electionnews.setEnabled(false);
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
        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        Vote = new javax.swing.JLabel();
        EN = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        HomePa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        VotingPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        patable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        pacnic = new javax.swing.JTextField();
        pasearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nacnic = new javax.swing.JTextField();
        nasearch = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        natable = new javax.swing.JTable();
        navote = new javax.swing.JButton();
        pavote = new javax.swing.JButton();
        time_stop_watch = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ENpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        electionnews = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1038, 751));
        setSize(new java.awt.Dimension(725, 595));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flag (1).png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));

        Home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        Home.setText("Home");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });

        Vote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Vote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voting-box.png"))); // NOI18N
        Vote.setText("Cast Vote");
        Vote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VoteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VoteMouseExited(evt);
            }
        });

        EN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newspaper.png"))); // NOI18N
        EN.setText("Election New");
        EN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ENMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ENMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ENMouseExited(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogoutMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(Home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Vote)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(EN)
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(Vote, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(EN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 153));

        HomePa.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.gif"))); // NOI18N

        javax.swing.GroupLayout HomePaLayout = new javax.swing.GroupLayout(HomePa);
        HomePa.setLayout(HomePaLayout);
        HomePaLayout.setHorizontalGroup(
            HomePaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePaLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        HomePaLayout.setVerticalGroup(
            HomePaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("Home", HomePa);

        VotingPanel.setBackground(new java.awt.Color(0, 153, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("PA Candidate");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("NA Candidate");

        patable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        patable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNIC", "Name", "Age", "City", "Constituency", "Party symbol", "Vote"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(patable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Voter CNIC");

        pacnic.setBackground(new java.awt.Color(0, 153, 0));
        pacnic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pacnic.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        pacnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacnicActionPerformed(evt);
            }
        });

        pasearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        pasearch.setText("Search Candidate");
        pasearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasearchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Voter CNIC");

        nacnic.setBackground(new java.awt.Color(0, 153, 0));
        nacnic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nacnic.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        nacnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nacnicActionPerformed(evt);
            }
        });

        nasearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nasearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        nasearch.setText("Search Candidate");
        nasearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nasearchActionPerformed(evt);
            }
        });

        natable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        natable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNIC", "Name", "Age", "City", "ConstituencyTitle 5", "Party Symbol", "Vote"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        natable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                natableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(natable);

        navote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        navote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voting-box.png"))); // NOI18N
        navote.setText("Cast Vote");
        navote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navoteActionPerformed(evt);
            }
        });

        pavote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pavote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voting-box.png"))); // NOI18N
        pavote.setText("Cast Vote");
        pavote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pavoteActionPerformed(evt);
            }
        });

        time_stop_watch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        time_stop_watch.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Remainig Time");

        javax.swing.GroupLayout VotingPanelLayout = new javax.swing.GroupLayout(VotingPanel);
        VotingPanel.setLayout(VotingPanelLayout);
        VotingPanelLayout.setHorizontalGroup(
            VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VotingPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(VotingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VotingPanelLayout.createSequentialGroup()
                        .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(VotingPanelLayout.createSequentialGroup()
                                .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VotingPanelLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(navote, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(VotingPanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(nasearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(83, 83, 83))
                            .addGroup(VotingPanelLayout.createSequentialGroup()
                                .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VotingPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nacnic, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(VotingPanelLayout.createSequentialGroup()
                        .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VotingPanelLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(pacnic, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(VotingPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(pasearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VotingPanelLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(pavote, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VotingPanelLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(time_stop_watch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)))
                        .addGap(11, 11, 11))))
        );
        VotingPanelLayout.setVerticalGroup(
            VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VotingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(time_stop_watch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VotingPanelLayout.createSequentialGroup()
                        .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pacnic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addComponent(pasearch)
                        .addGap(38, 38, 38)
                        .addComponent(pavote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VotingPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(VotingPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(VotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nacnic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(nasearch)
                                .addGap(30, 30, 30)
                                .addComponent(navote)
                                .addGap(33, 33, 33))))
                    .addGroup(VotingPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Voting Status", VotingPanel);

        ENpanel.setBackground(new java.awt.Color(0, 153, 0));

        electionnews.setColumns(20);
        electionnews.setRows(5);
        jScrollPane1.setViewportView(electionnews);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("News From Election Commision");

        javax.swing.GroupLayout ENpanelLayout = new javax.swing.GroupLayout(ENpanel);
        ENpanel.setLayout(ENpanelLayout);
        ENpanelLayout.setHorizontalGroup(
            ENpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ENpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                    .addGroup(ENpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ENpanelLayout.setVerticalGroup(
            ENpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(345, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Election News", ENpanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1052, 748));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_HomeMouseClicked

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        Home.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_HomeMouseEntered

    private void VoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoteMouseClicked
        if (endTime_milis > 0)
            jTabbedPane1.setSelectedIndex(1);
        else
            JOptionPane.showMessageDialog(null, "Election not scheduled yet ...!");
    }//GEN-LAST:event_VoteMouseClicked

    private void ENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_ENMouseClicked

    private void LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseEntered
        Logout.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_LogoutMouseEntered

    private void LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseExited
        Logout.setBorder(null);
    }//GEN-LAST:event_LogoutMouseExited

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutMouseClicked

    private void LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMousePressed
        this.setVisible(false);
        this.dispose();
        Welcome w = new Welcome();
        w.setVisible(true);
    }//GEN-LAST:event_LogoutMousePressed

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setBorder(null);
    }//GEN-LAST:event_HomeMouseExited

    private void VoteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoteMouseEntered
        Vote.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_VoteMouseEntered

    private void VoteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoteMouseExited
        Vote.setBorder(null);
    }//GEN-LAST:event_VoteMouseExited

    private void ENMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENMouseEntered
        EN.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_ENMouseEntered

    private void ENMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENMouseExited
        EN.setBorder(null);
    }//GEN-LAST:event_ENMouseExited

    private void natableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_natableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_natableAncestorAdded

    private void pasearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasearchActionPerformed
        String cnic = pacnic.getText().trim();

        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your CNIC.");
            return;
        }
        Voterscla.loadPACandidatesForVoting(cnic, patable);
    }//GEN-LAST:event_pasearchActionPerformed

    private void nasearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nasearchActionPerformed
        String cnic = nacnic.getText().trim();

        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your CNIC.");
            return;
        }
        Voterscla.loadNACandidatesForVoting(cnic, natable);
    }//GEN-LAST:event_nasearchActionPerformed

    private void navoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navoteActionPerformed
        String cnic = nacnic.getText().trim();
        Voterscla.castNAVote(cnic, natable);
    }//GEN-LAST:event_navoteActionPerformed

    private void pavoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pavoteActionPerformed
        String cnic = pacnic.getText().trim();
        Voterscla.castPAVote(cnic, patable);
    }//GEN-LAST:event_pavoteActionPerformed

    private void nacnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nacnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nacnicActionPerformed

    private void pacnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacnicActionPerformed

    }//GEN-LAST:event_pacnicActionPerformed

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
            java.util.logging.Logger.getLogger(VoterDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoterDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoterDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoterDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String cnic = null;
                new VoterDash(cnic).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EN;
    private javax.swing.JPanel ENpanel;
    private javax.swing.JLabel Home;
    private javax.swing.JPanel HomePa;
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel Vote;
    private javax.swing.JPanel VotingPanel;
    private javax.swing.JTextArea electionnews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nacnic;
    private javax.swing.JButton nasearch;
    private javax.swing.JTable natable;
    private javax.swing.JButton navote;
    private javax.swing.JTextField pacnic;
    private javax.swing.JButton pasearch;
    private javax.swing.JTable patable;
    private javax.swing.JButton pavote;
    private javax.swing.JLabel time_stop_watch;
    // End of variables declaration//GEN-END:variables

}
