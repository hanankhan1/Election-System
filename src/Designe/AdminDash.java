package Designe;

import electionSystem.Candidatecla;
import electionSystem.Constituencycla;
import electionSystem.Electionnewscla;
import electionSystem.Partycla;
import electionSystem.Resultcla;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import electionSystem.Voterscla;
import javax.swing.JOptionPane;

public class AdminDash extends javax.swing.JFrame {

    public AdminDash() {
        initComponents();
        Voterscla.loadVoterData(voters);
        Constituencycla.loadConstituencies(constituencies);
        Partycla.loadParties(parties);
        Candidatecla.loadCandidates(candidates);
        Electionnewscla.showNewsInTable(news);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        Candidate = new javax.swing.JLabel();
        party = new javax.swing.JLabel();
        Voter = new javax.swing.JLabel();
        EN1 = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        constituence = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Welcome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Candidate_panel = new javax.swing.JPanel();
        cadd = new javax.swing.JButton();
        cremove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        candidates = new javax.swing.JTable();
        cname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cdob = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ccnic = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cconstituency = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        csymbol = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cgender = new javax.swing.JTextField();
        csearch = new javax.swing.JButton();
        cupdate = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cparty = new javax.swing.JTextField();
        party_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        parties = new javax.swing.JTable();
        psearch = new javax.swing.JButton();
        premove = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pfounder = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pyear = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pleader = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        pabbrevation = new javax.swing.JTextField();
        plogo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        padd = new javax.swing.JButton();
        pupdate = new javax.swing.JButton();
        EN = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        electionnews = new javax.swing.JTextArea();
        addnews = new javax.swing.JButton();
        removenews = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        news = new javax.swing.JTable();
        newsid = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        Selection = new javax.swing.JButton();
        Voter_Panel = new javax.swing.JPanel();
        vadd = new javax.swing.JButton();
        vremove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        voters = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        vsearch = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        ucnic = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        uage = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ucity = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        uconname = new javax.swing.JTextField();
        voted = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        Consituency_Panel = new javax.swing.JPanel();
        Constituency = new javax.swing.JScrollPane();
        constituencies = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        conname = new javax.swing.JTextField();
        conprovience = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        contype = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        concity = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        consearch = new javax.swing.JButton();
        conremove = new javax.swing.JButton();
        addcon = new javax.swing.JButton();
        updatecon = new javax.swing.JButton();
        Result = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        patable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        paresult = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        natable = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        naresult = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1025, 718));
        setMinimumSize(new java.awt.Dimension(1025, 718));

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

        Candidate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Candidate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group.png"))); // NOI18N
        Candidate.setText("Candidate Panel");
        Candidate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CandidateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CandidateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CandidateMouseExited(evt);
            }
        });

        party.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        party.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group.png"))); // NOI18N
        party.setText("Parties Panel");
        party.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                partyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                partyMouseExited(evt);
            }
        });

        Voter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Voter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group.png"))); // NOI18N
        Voter.setText("Voters Panel");
        Voter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VoterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VoterMouseExited(evt);
            }
        });

        EN1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newspaper.png"))); // NOI18N
        EN1.setText("Election News");
        EN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EN1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EN1MouseExited(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        Logout.setText("Logout");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
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

        constituence.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        constituence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group.png"))); // NOI18N
        constituence.setText("Constituency Panel");
        constituence.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                constituenceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                constituenceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                constituenceMouseExited(evt);
            }
        });

        result.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/goal (2).png"))); // NOI18N
        result.setText("Results");
        result.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resultMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resultMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(constituence)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Candidate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EN1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Voter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(party, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(Home)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Candidate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(party, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Voter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(constituence, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(EN1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flag (1).png"))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(151, 242, 154));

        Welcome.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.gif"))); // NOI18N

        javax.swing.GroupLayout WelcomeLayout = new javax.swing.GroupLayout(Welcome);
        Welcome.setLayout(WelcomeLayout);
        WelcomeLayout.setHorizontalGroup(
            WelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        WelcomeLayout.setVerticalGroup(
            WelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Welcome", Welcome);

        Candidate_panel.setBackground(new java.awt.Color(0, 153, 0));

        cadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        cadd.setText(" Add Candidate");
        cadd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });

        cremove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cremove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact.png"))); // NOI18N
        cremove.setText(" Remove Candidate");
        cremove.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        cremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cremoveActionPerformed(evt);
            }
        });

        candidates.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        candidates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "CNIC", "D-O-B", "Age", "Gender", "Constituency", "Party", "Symbol", "Votes", "Outcome"
            }
        ));
        candidates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                candidatesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(candidates);

        cname.setBackground(new java.awt.Color(0, 153, 0));
        cname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("D-O-B");

        cdob.setBackground(new java.awt.Color(0, 153, 0));
        cdob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cdob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("CNIC");

        ccnic.setBackground(new java.awt.Color(0, 153, 0));
        ccnic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ccnic.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Age");

        cage.setBackground(new java.awt.Color(0, 153, 0));
        cage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Constituency");

        cconstituency.setBackground(new java.awt.Color(0, 153, 0));
        cconstituency.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cconstituency.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Symbol");

        csymbol.setBackground(new java.awt.Color(0, 153, 0));
        csymbol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        csymbol.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Gender");

        cgender.setBackground(new java.awt.Color(0, 153, 0));
        cgender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cgender.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        csearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        csearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        csearch.setText("Search Candidate");
        csearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        csearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csearchActionPerformed(evt);
            }
        });

        cupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        cupdate.setText("Update Candidate");
        cupdate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        cupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdateActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Party");

        cparty.setBackground(new java.awt.Color(0, 153, 0));
        cparty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cparty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout Candidate_panelLayout = new javax.swing.GroupLayout(Candidate_panel);
        Candidate_panel.setLayout(Candidate_panelLayout);
        Candidate_panelLayout.setHorizontalGroup(
            Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Candidate_panelLayout.createSequentialGroup()
                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Candidate_panelLayout.createSequentialGroup()
                                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ccnic, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Candidate_panelLayout.createSequentialGroup()
                                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cdob, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cage, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Candidate_panelLayout.createSequentialGroup()
                                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(csymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cgender, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cconstituency, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cadd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cremove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(Candidate_panelLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(cparty, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(csearch, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Candidate_panelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        Candidate_panelLayout.setVerticalGroup(
            Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Candidate_panelLayout.createSequentialGroup()
                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(cgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(cconstituency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cremove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(cparty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(Candidate_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))))
                    .addGroup(Candidate_panelLayout.createSequentialGroup()
                        .addComponent(csearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(csymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Candidate", Candidate_panel);

        party_panel.setBackground(new java.awt.Color(0, 153, 0));

        parties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Founder Name", "Founding Year", "Abbrevation", "Leader Name", "Party Logo"
            }
        ));
        parties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partiesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(parties);

        psearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        psearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        psearch.setText("Search Party");
        psearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        psearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psearchActionPerformed(evt);
            }
        });

        premove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        premove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact.png"))); // NOI18N
        premove.setText("Remove Party");
        premove.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        premove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                premoveActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Party Name");

        pname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Founder Name");

        pfounder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pfounder.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Founding Year");

        pyear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pyear.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Leader Name");

        pleader.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pleader.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Abbrevation");

        pabbrevation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pabbrevation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        plogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        plogo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Party Logo");

        padd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        padd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        padd.setText("Add Party");
        padd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        padd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paddActionPerformed(evt);
            }
        });

        pupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        pupdate.setText("Update Party");
        pupdate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout party_panelLayout = new javax.swing.GroupLayout(party_panel);
        party_panel.setLayout(party_panelLayout);
        party_panelLayout.setHorizontalGroup(
            party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(party_panelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(party_panelLayout.createSequentialGroup()
                        .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pname, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(pfounder)
                            .addComponent(pyear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(party_panelLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(33, 33, 33)
                                .addComponent(plogo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(party_panelLayout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pabbrevation, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(party_panelLayout.createSequentialGroup()
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pleader, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, party_panelLayout.createSequentialGroup()
                        .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(padd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(premove, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(psearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(133, 133, 133))))
            .addGroup(party_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        party_panelLayout.setVerticalGroup(
            party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(party_panelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(pabbrevation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(pfounder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(pleader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(pyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(plogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(padd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(party_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(premove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parties", party_panel);

        EN.setBackground(new java.awt.Color(0, 153, 0));

        electionnews.setColumns(20);
        electionnews.setRows(5);
        jScrollPane4.setViewportView(electionnews);

        addnews.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addnews.setText("Add News");
        addnews.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        addnews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewsActionPerformed(evt);
            }
        });

        removenews.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        removenews.setText("Remove News");
        removenews.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        removenews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removenewsActionPerformed(evt);
            }
        });

        news.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        news.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "News", "Postted At"
            }
        ));
        news.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(news);

        newsid.setBackground(new java.awt.Color(0, 153, 0));
        newsid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newsid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("News Id");

        Selection.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Selection.setText("Start Election");
        Selection.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 204, 204)));
        Selection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ENLayout = new javax.swing.GroupLayout(EN);
        EN.setLayout(ENLayout);
        ENLayout.setHorizontalGroup(
            ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ENLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removenews, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(addnews, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ENLayout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(newsid, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        ENLayout.setVerticalGroup(
            ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ENLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ENLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(addnews, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(ENLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(46, 46, 46)
                        .addComponent(removenews, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(Selection, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ENLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Election news", EN);

        Voter_Panel.setBackground(new java.awt.Color(0, 153, 0));

        vadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        vadd.setText("Update Voter");
        vadd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        vadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaddActionPerformed(evt);
            }
        });

        vremove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vremove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact.png"))); // NOI18N
        vremove.setText("Remove Voter");
        vremove.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        vremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vremoveActionPerformed(evt);
            }
        });

        voters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "CNIC", "Age", "City", "Na Connstituency", "Pa Constituency", "Na Vote", "Pa Vote"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        voters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                votersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(voters);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Name");

        uname.setBackground(new java.awt.Color(0, 153, 0));
        uname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        vsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        vsearch.setText("Search Voter");
        vsearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        vsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsearchActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("CNIC");

        ucnic.setBackground(new java.awt.Color(0, 153, 0));
        ucnic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ucnic.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        ucnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucnicActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Age");

        uage.setBackground(new java.awt.Color(0, 153, 0));
        uage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        uage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uageActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("City");

        ucity.setBackground(new java.awt.Color(0, 153, 0));
        ucity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ucity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        ucity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucityActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("constituency");

        uconname.setBackground(new java.awt.Color(0, 153, 0));
        uconname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uconname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        uconname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uconnameActionPerformed(evt);
            }
        });

        voted.setBackground(new java.awt.Color(0, 153, 0));
        voted.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        voted.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        voted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votedActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Vote");

        javax.swing.GroupLayout Voter_PanelLayout = new javax.swing.GroupLayout(Voter_Panel);
        Voter_Panel.setLayout(Voter_PanelLayout);
        Voter_PanelLayout.setHorizontalGroup(
            Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Voter_PanelLayout.createSequentialGroup()
                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                        .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Voter_PanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ucnic, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                                        .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Voter_PanelLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Voter_PanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(uconname, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ucity, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Voter_PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(uage, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(vadd, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(Voter_PanelLayout.createSequentialGroup()
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(voted, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(Voter_PanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vremove, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        Voter_PanelLayout.setVerticalGroup(
            Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Voter_PanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(uconname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(ucnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(uage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ucity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(vsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vremove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vadd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Voter_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(Voter_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(voted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        jTabbedPane1.addTab("Voter", Voter_Panel);

        Consituency_Panel.setBackground(new java.awt.Color(0, 153, 0));

        constituencies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Name", "Type", "City", "Provience"
            }
        ));
        constituencies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                constituenciesMouseClicked(evt);
            }
        });
        Constituency.setViewportView(constituencies);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Name");

        conname.setBackground(new java.awt.Color(0, 153, 0));
        conname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        conname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        conname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connameActionPerformed(evt);
            }
        });

        conprovience.setBackground(new java.awt.Color(0, 153, 0));
        conprovience.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        conprovience.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        conprovience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conprovienceActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Proviency");

        contype.setBackground(new java.awt.Color(0, 153, 0));
        contype.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contype.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        contype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contypeActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Type");

        concity.setBackground(new java.awt.Color(0, 153, 0));
        concity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        concity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        concity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concityActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("City");

        consearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        consearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        consearch.setText("Search Constituency");
        consearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        consearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consearchActionPerformed(evt);
            }
        });

        conremove.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        conremove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact.png"))); // NOI18N
        conremove.setText("Remove Constituency");
        conremove.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        conremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conremoveActionPerformed(evt);
            }
        });

        addcon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        addcon.setText("Add Constituency");
        addcon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        addcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addconActionPerformed(evt);
            }
        });

        updatecon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updatecon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        updatecon.setText("Update Constituency");
        updatecon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 153)));
        updatecon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Consituency_PanelLayout = new javax.swing.GroupLayout(Consituency_Panel);
        Consituency_Panel.setLayout(Consituency_PanelLayout);
        Consituency_PanelLayout.setHorizontalGroup(
            Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Consituency_PanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Consituency_PanelLayout.createSequentialGroup()
                        .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conname, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contype, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Consituency_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(concity, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Consituency_PanelLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conprovience, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Consituency_PanelLayout.createSequentialGroup()
                        .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addcon, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conremove, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updatecon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Consituency_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Constituency, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Consituency_PanelLayout.setVerticalGroup(
            Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Consituency_PanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(conname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(concity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(conprovience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24))
                    .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(contype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)))
                .addGap(100, 100, 100)
                .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(Consituency_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatecon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conremove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Constituency, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Constituency", Consituency_Panel);

        Result.setBackground(new java.awt.Color(0, 153, 0));

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

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel19.setText("NA Candidate Result");

        paresult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paresult.setText("PA Results");
        paresult.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 204, 204)));
        paresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paresultActionPerformed(evt);
            }
        });

        natable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        natable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNIC", "Name", "Constituency", "City", "Party Symbol", "Votes", "OutCome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

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
        jScrollPane7.setViewportView(natable);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel30.setText("PA Candidate Result");

        naresult.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        naresult.setText("NA Results");
        naresult.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 204, 204)));
        naresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naresultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ResultLayout = new javax.swing.GroupLayout(Result);
        Result.setLayout(ResultLayout);
        ResultLayout.setHorizontalGroup(
            ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(naresult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addComponent(paresult, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ResultLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(603, Short.MAX_VALUE)))
        );
        ResultLayout.setVerticalGroup(
            ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultLayout.createSequentialGroup()
                .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(paresult, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ResultLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(naresult, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ResultLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(642, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Result", Result);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1039, 726));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        Home.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_HomeMouseEntered

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_HomeMouseClicked

    private void CandidateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_CandidateMouseClicked

    private void VoterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoterMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_VoterMouseClicked

    private void partyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partyMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_partyMouseClicked

    private void EN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EN1MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_EN1MouseClicked

    private void CandidateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateMouseEntered
        Candidate.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_CandidateMouseEntered

    private void CandidateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateMouseExited
        Candidate.setBorder(null);
    }//GEN-LAST:event_CandidateMouseExited

    private void VoterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoterMouseEntered
        Voter.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_VoterMouseEntered

    private void VoterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoterMouseExited
        Voter.setBorder(null);
    }//GEN-LAST:event_VoterMouseExited

    private void partyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partyMouseEntered
        party.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_partyMouseEntered

    private void partyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partyMouseExited
        party.setBorder(null);
    }//GEN-LAST:event_partyMouseExited

    private void EN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EN1MouseEntered
        EN1.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_EN1MouseEntered

    private void EN1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EN1MouseExited
        EN1.setBorder(null);
    }//GEN-LAST:event_EN1MouseExited

    private void LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseEntered
        Logout.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_LogoutMouseEntered

    private void LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseExited
        Logout.setBorder(null);
    }//GEN-LAST:event_LogoutMouseExited

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setBorder(null);
    }//GEN-LAST:event_HomeMouseExited

    private void LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMousePressed
        this.setVisible(false);
        this.dispose();
        Welcome w = new Welcome();
        w.setVisible(true);
    }//GEN-LAST:event_LogoutMousePressed

    private void premoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_premoveActionPerformed
        int selectedRow = parties.getSelectedRow();

        if (selectedRow >= 0) {
            String id = parties.getValueAt(selectedRow, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this party?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Partycla.delete(id);                    // Delete from database
                Partycla.loadParties(parties);        // Refresh table
                pname.setText("");
                pfounder.setText("");
                pyear.setText("");
                pabbrevation.setText("");
                pleader.setText("");
                plogo.setText("");                            // Reset all text fields
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a party from the table to delete.");
        }
    }//GEN-LAST:event_premoveActionPerformed

    private void cremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cremoveActionPerformed
        String cnic = ccnic.getText().trim();

        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter CNIC to delete candidate.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this candidate?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Candidatecla.deleteCandidate(cnic);
            Candidatecla.loadCandidates(candidates);// Refresh table
            cname.setText("");
            ccnic.setText("");
            cdob.setText("");
            cage.setText("");
            cgender.setText("");
            cconstituency.setText("");
            cparty.setText("");
            csymbol.setText("");
        }
    }//GEN-LAST:event_cremoveActionPerformed

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed
        String name = cname.getText();
        String cnic = ccnic.getText();
        String dob = cdob.getText();
        String ageText = cage.getText();
        String gender = cgender.getText();
        String constituency = cconstituency.getText();
        String party = cparty.getText();
        String symbol = csymbol.getText();

// Validate fields
        if (name.isEmpty() || cnic.isEmpty() || dob.isEmpty() || ageText.isEmpty() || gender.isEmpty()
                || constituency.isEmpty() || party.isEmpty() || symbol.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            Candidatecla.addCandidate(name, cnic, dob, age, gender, constituency, party, symbol);
            // Optionally refresh the table here
            Candidatecla.loadCandidates(candidates);
            cname.setText("");
            ccnic.setText("");
            cdob.setText("");
            cage.setText("");
            cgender.setText("");
            cconstituency.setText("");
            cparty.setText("");
            csymbol.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be a number.");
        }
    }//GEN-LAST:event_caddActionPerformed

    private void vaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaddActionPerformed
        String cnic = ucnic.getText().trim();
        String name = uname.getText().trim();
        String conname = uconname.getText().trim();
        String city = ucity.getText().trim();
        String age = uage.getText().trim();

        Voterscla.updateVoterDirect(cnic, name, conname, city, age);
        Voterscla.loadVoterData(voters);
    }//GEN-LAST:event_vaddActionPerformed

    private void psearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psearchActionPerformed
        String abbrev = pabbrevation.getText();
        Partycla.searchByAbbreviation(abbrev, parties);
    }//GEN-LAST:event_psearchActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void vsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsearchActionPerformed
        String cnicToSearch = ucnic.getText().trim(); // This is your CNIC input field
        Voterscla.searchVoterByCnic(voters, cnicToSearch);
    }//GEN-LAST:event_vsearchActionPerformed

    private void csearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csearchActionPerformed
        String cnic = ccnic.getText().trim();
        Candidatecla.searchCandidateByCNIC(cnic, cname, cdob, cage, cgender, cconstituency, cparty, csymbol);


    }//GEN-LAST:event_csearchActionPerformed

    private void cupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdateActionPerformed
        String cnic = ccnic.getText().trim();
        String name = cname.getText().trim();
        String dob = cdob.getText().trim();
        String ageText = cage.getText().trim();
        String gender = cgender.getText().trim();
        String constituency = cconstituency.getText().trim();
        String party = cparty.getText().trim();
        String symbol = csymbol.getText().trim();

        if (cnic.isEmpty() || name.isEmpty() || dob.isEmpty() || ageText.isEmpty()
                || gender.isEmpty() || constituency.isEmpty() || party.isEmpty() || symbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields before updating.");
            return;
        }
        int age;

        try {
            age = Integer.parseInt(ageText);
            Candidatecla.updateCandidate(cnic, name, dob, ageText, gender, constituency, party, symbol);
            Candidatecla.loadCandidates(candidates);
            cname.setText("");
            ccnic.setText("");
            cdob.setText("");
            cage.setText("");
            cgender.setText("");
            cconstituency.setText("");
            cparty.setText("");
            csymbol.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number.");
        }
    }//GEN-LAST:event_cupdateActionPerformed

    private void paddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paddActionPerformed
        Partycla.addParty(
                pname.getText(),
                pfounder.getText(),
                pyear.getText(),
                pabbrevation.getText(),
                pleader.getText(),
                plogo.getText()
        );

        Partycla.loadParties(parties);
        pname.setText("");
        pfounder.setText("");
        pyear.setText("");
        pabbrevation.setText("");
        pleader.setText("");
        plogo.setText("");
    }//GEN-LAST:event_paddActionPerformed

    private void pupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pupdateActionPerformed
        int selectedRow = parties.getSelectedRow();

        if (selectedRow >= 0) {
            String id = parties.getValueAt(selectedRow, 0).toString();

            Partycla.update(
                    id,
                    pname.getText(),
                    pfounder.getText(),
                    pyear.getText(),
                    pabbrevation.getText(),
                    pleader.getText(),
                    plogo.getText()
            );

            Partycla.loadParties(parties);
            pname.setText("");
            pfounder.setText("");
            pyear.setText("");
            pabbrevation.setText("");
            pleader.setText("");
            plogo.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a party to update from the table.");
        }

    }//GEN-LAST:event_pupdateActionPerformed

    private void ucnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ucnicActionPerformed

    private void uageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uageActionPerformed

    private void ucityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ucityActionPerformed

    private void uconnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uconnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uconnameActionPerformed

    private void vremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vremoveActionPerformed
        String cnicToDelete = ucnic.getText().trim();  // or any CNIC input field
        Voterscla.deleteVoterByCnic(cnicToDelete);
        Voterscla.loadVoterData(voters);

    }//GEN-LAST:event_vremoveActionPerformed

    private void votersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_votersMouseClicked
        int selectedRow = voters.getSelectedRow();

        if (selectedRow >= 0) {
            String name = voters.getValueAt(selectedRow, 0).toString();      // vname
            String cnic = voters.getValueAt(selectedRow, 1).toString();      // vcnic
            String age = voters.getValueAt(selectedRow, 2).toString();       // vage
            String city = voters.getValueAt(selectedRow, 3).toString();      // vcity
            String conname = voters.getValueAt(selectedRow, 4).toString();   // vconname
            String hasVoted = voters.getValueAt(selectedRow, 5).toString();  // has_voted (Yes/No)

            // Set these to your form fields (update variable names to match your actual text fields)
            uname.setText(name);
            ucnic.setText(cnic);
            uage.setText(age);
            ucity.setText(city);
            uconname.setText(conname);
            voted.setText(hasVoted); // Optional: only if you want to show vote status
        }
    }//GEN-LAST:event_votersMouseClicked

    private void connameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connameActionPerformed

    private void conprovienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conprovienceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conprovienceActionPerformed

    private void contypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contypeActionPerformed

    private void concityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_concityActionPerformed

    private void consearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consearchActionPerformed
        String keyword = consearch.getText().trim();
        Constituencycla.searchByName(keyword, constituencies);

    }//GEN-LAST:event_consearchActionPerformed

    private void conremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conremoveActionPerformed
        String id = constituencies.getValueAt(constituencies.getSelectedRow(), 0).toString();
        Constituencycla.delete(id);
        Constituencycla.loadConstituencies(constituencies);

    }//GEN-LAST:event_conremoveActionPerformed

    private void addconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addconActionPerformed
        String conname = this.conname.getText().trim();
        String contype = this.contype.getText().trim();
        String concity = this.concity.getText().trim();
        String conprovience = this.conprovience.getText().trim();

        Constituencycla.addConstituency(conname, contype, concity, conprovience);
        Constituencycla.loadConstituencies(constituencies);
    }//GEN-LAST:event_addconActionPerformed

    private void updateconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateconActionPerformed
        String id = constituencies.getValueAt(constituencies.getSelectedRow(), 0).toString();
        Constituencycla.update(id, conname.getText(), contype.getText(), concity.getText(), conprovience.getText());
        Constituencycla.loadConstituencies(constituencies);
// After updating and reloading the table
        conname.setText("");
        contype.setText("");
        concity.setText("");
        conprovience.setText("");


    }//GEN-LAST:event_updateconActionPerformed

    private void constituenceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constituenceMouseEntered
        constituence.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_constituenceMouseEntered

    private void constituenceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constituenceMouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_constituenceMouseClicked

    private void constituenceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constituenceMouseExited
        constituence.setBorder(null);
    }//GEN-LAST:event_constituenceMouseExited

    private void constituenciesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constituenciesMouseClicked
        int row = constituencies.getSelectedRow();

        if (row >= 0) {
            conname.setText(constituencies.getValueAt(row, 1).toString());
            contype.setText(constituencies.getValueAt(row, 2).toString());
            concity.setText(constituencies.getValueAt(row, 3).toString());
            conprovience.setText(constituencies.getValueAt(row, 4).toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_constituenciesMouseClicked

    private void partiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partiesMouseClicked
        int row = parties.getSelectedRow();

        pname.setText(parties.getValueAt(row, 1).toString());
        pfounder.setText(parties.getValueAt(row, 2).toString());
        pyear.setText(parties.getValueAt(row, 3).toString());
        pabbrevation.setText(parties.getValueAt(row, 4).toString());
        pleader.setText(parties.getValueAt(row, 5).toString());
        plogo.setText(parties.getValueAt(row, 6).toString());
    }//GEN-LAST:event_partiesMouseClicked

    private void candidatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candidatesMouseClicked
        int selectedRow = candidates.getSelectedRow();
        if (selectedRow >= 0) {
            cname.setText(candidates.getValueAt(selectedRow, 0).toString());
            ccnic.setText(candidates.getValueAt(selectedRow, 1).toString());
            cdob.setText(candidates.getValueAt(selectedRow, 2).toString());
            cage.setText(candidates.getValueAt(selectedRow, 3).toString());
            cgender.setText(candidates.getValueAt(selectedRow, 4).toString());
            cconstituency.setText(candidates.getValueAt(selectedRow, 5).toString());
            cparty.setText(candidates.getValueAt(selectedRow, 6).toString());
            csymbol.setText(candidates.getValueAt(selectedRow, 7).toString());
        }
    }//GEN-LAST:event_candidatesMouseClicked

    private void addnewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewsActionPerformed
        String newsText = electionnews.getText().trim();
        Electionnewscla.addNews(newsText, news);
        electionnews.setText(""); // Clear field


    }//GEN-LAST:event_addnewsActionPerformed

    private void removenewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removenewsActionPerformed
        Electionnewscla.deleteNewsByTextField(newsid, news, electionnews, electionnews);

    }//GEN-LAST:event_removenewsActionPerformed

    private void newsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsMouseClicked
        int selectedRow = news.getSelectedRow();

        if (selectedRow != -1) {
            // Get the news ID from column 0 (assuming ID is the first column)
            String newsId = news.getValueAt(selectedRow, 0).toString();

            // Set the ID in the newsid JTextField
            newsid.setText(newsId);
        }
    }//GEN-LAST:event_newsMouseClicked

    private void votedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_votedActionPerformed

    private void resultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultMouseClicked
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_resultMouseClicked

    private void resultMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultMouseEntered
        result.setBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
    }//GEN-LAST:event_resultMouseEntered

    private void resultMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultMouseExited
        result.setBorder(null);
    }//GEN-LAST:event_resultMouseExited

    private void natableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_natableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_natableAncestorAdded

    private void paresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paresultActionPerformed
        Resultcla.getPAResult(patable);
    }//GEN-LAST:event_paresultActionPerformed

    private void naresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naresultActionPerformed
        Resultcla.getNAResult(natable);
    }//GEN-LAST:event_naresultActionPerformed

    private void SelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionActionPerformed
        electiontime e = new electiontime();
        e.setVisible(true);
    }//GEN-LAST:event_SelectionActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Candidate;
    private javax.swing.JPanel Candidate_panel;
    private javax.swing.JPanel Consituency_Panel;
    private javax.swing.JScrollPane Constituency;
    private javax.swing.JPanel EN;
    private javax.swing.JLabel EN1;
    private javax.swing.JLabel Home;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel Result;
    private javax.swing.JButton Selection;
    private javax.swing.JLabel Voter;
    private javax.swing.JPanel Voter_Panel;
    private javax.swing.JPanel Welcome;
    private javax.swing.JButton addcon;
    private javax.swing.JButton addnews;
    private javax.swing.JButton cadd;
    private javax.swing.JTextField cage;
    private javax.swing.JTable candidates;
    private javax.swing.JTextField ccnic;
    private javax.swing.JTextField cconstituency;
    private javax.swing.JTextField cdob;
    private javax.swing.JTextField cgender;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField concity;
    private javax.swing.JTextField conname;
    private javax.swing.JTextField conprovience;
    private javax.swing.JButton conremove;
    private javax.swing.JButton consearch;
    private javax.swing.JLabel constituence;
    private javax.swing.JTable constituencies;
    private javax.swing.JTextField contype;
    private javax.swing.JTextField cparty;
    private javax.swing.JButton cremove;
    private javax.swing.JButton csearch;
    private javax.swing.JTextField csymbol;
    private javax.swing.JButton cupdate;
    private javax.swing.JTextArea electionnews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton naresult;
    private javax.swing.JTable natable;
    private javax.swing.JTable news;
    private javax.swing.JTextField newsid;
    private javax.swing.JTextField pabbrevation;
    private javax.swing.JButton padd;
    private javax.swing.JButton paresult;
    private javax.swing.JTable parties;
    private javax.swing.JLabel party;
    private javax.swing.JPanel party_panel;
    private javax.swing.JTable patable;
    private javax.swing.JTextField pfounder;
    private javax.swing.JTextField pleader;
    private javax.swing.JTextField plogo;
    private javax.swing.JTextField pname;
    private javax.swing.JButton premove;
    private javax.swing.JButton psearch;
    private javax.swing.JButton pupdate;
    private javax.swing.JTextField pyear;
    private javax.swing.JButton removenews;
    private javax.swing.JLabel result;
    private javax.swing.JTextField uage;
    private javax.swing.JTextField ucity;
    private javax.swing.JTextField ucnic;
    private javax.swing.JTextField uconname;
    private javax.swing.JTextField uname;
    private javax.swing.JButton updatecon;
    private javax.swing.JButton vadd;
    private javax.swing.JTextField voted;
    private javax.swing.JTable voters;
    private javax.swing.JButton vremove;
    private javax.swing.JButton vsearch;
    // End of variables declaration//GEN-END:variables
}
