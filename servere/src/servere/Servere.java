package servere;

import java.io.*;
import static java.lang.System.out;
import java.net.*;
import java.sql.*;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Servere {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and listening on port " + PORT);
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String request = in.readLine();
                    String[] parts = request.split(";", 2);
                    String command = parts[0];
                    String data = parts.length > 1 ? parts[1] : "";
                    String response = handleCommand(command, data);
                    out.println(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String handleCommand(String command, String data) {
        switch (command.toLowerCase()) {
            case "!@#":
                return ElectionFinalize(data);    
            case "&$#!"://getElectionTime
                return loadElectionTime(data);
            case "!"://login
                return loginUser(data);
            case "@":// insert(@)//registration
                return insertVoter(data);
            case "#"://update(#)
                return updateVoter(data);
            case "$"://delete($)
                return deleteVoter(data);
            case "^": //search(^)
                return searchVoterByCnic(data);
            case "%":
                return showTableData();
            case "&":
                return conShowTable();
            //votings
            case "!@":
                return castNAVote(data);
            case "!!@@":
                return castPAVote(data);
            case "%%":
                return loadNACandidatesForVoting(data);
            case "%%%":
                return loadPACandidatesForVoting(data);
            //////candidate
            case "@@":// insert(@)
                return insertCandidate(data);
            case "##"://update(#)
                return updateCandidate(data);
            case "$$"://delete($)
                return deleteCandidate(data);
            case "^^":
                return searchCandidate(data);
            case "%%%%":
                return showCandidates();
            case "%%%%%":
                return getResultForCandidate(data);
            //result class
            case "%%%%%%":
                return getPAResultData();
            case "%%%%%%%":
                return getNAResultData();
            //constituency
            case "@@@":// insert(@)
                return insertConstituency(data);
            case "###"://update(#)
                return updateConstituency(data);
            case "$$$"://delete($)
                return deleteConstituency(data);
            case "^^^":
                return searchConstiyuency(data);
            ////////////////////party
            case "@@@@":// insert(@)
                return insertParty(data);
            case "####"://update(#)
                return updateParty(data);
            case "$$$$"://delete($)
                return deleteParty(data);
            case "^^^^":
                return searchParty(data);
            case "*":
                return loadPartiesData();
            ///////news
            case "@@@@@":// insert(@)
                return insertnews(data);
            case "$$$$$"://delete($)
                return deleteNews(data);
            case "#####"://load
                return loadAllNews();
            case "&&&&&"://show($)
                return showNews();
            case "%%%%%%%%"://tale($)
                return showinTable();
            case "!!":
                return startElection(data);

            default:
                return "Invalid Command";
        }
    }

    private static Connection getConnection() throws SQLException {
// String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
// String user = "root"; // replace
// String password = "UO2@iTSn"; // replace
// return DriverManager.getConnection(url, user, password);

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Election", "root", "UO2@iTSn");
    }

    private static String insertVoter(String data) {
        String[] fields = data.split(",");
        if (fields.length != 9) {
            return "Invalid Data";
        }

        try (Connection conn = getConnection()) {
            String vname = fields[0];
            String vcnic = fields[1];
            String vdob = fields[2];
            int vage = Integer.parseInt(fields[3]);
            String vcity = fields[4];
            String vpass = fields[5];
            String vquestion = fields[6];
            String vanswer = fields[7];
            String vgender = fields[8];

            // Fetch NA constituency
            PreparedStatement stmtNA = conn.prepareStatement(
                    "SELECT conname FROM constituency WHERE concity = ? AND contype = 'NA' LIMIT 1"
            );
            stmtNA.setString(1, vcity);
            ResultSet rsNA = stmtNA.executeQuery();
            String naCon = rsNA.next() ? rsNA.getString("conname") : null;

            // Fetch PA constituency
            PreparedStatement stmtPA = conn.prepareStatement(
                    "SELECT conname FROM constituency WHERE concity = ? AND contype = 'PA' LIMIT 1"
            );
            stmtPA.setString(1, vcity);
            ResultSet rsPA = stmtPA.executeQuery();
            String paCon = rsPA.next() ? rsPA.getString("conname") : null;

            if (naCon == null || paCon == null) {
                return "Error: Constituency not found for city: " + vcity;
            }

            // Insert into merged voters table
            PreparedStatement insertStmt = conn.prepareStatement(
                    "INSERT INTO voters (vcnic, vname, vdob, vage, vcity, vpass, vquestion, vanswer, vgender, "
                    + "na_conname, pa_conname, has_voted_na, has_voted_pa) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0)"
            );

            insertStmt.setString(1, vcnic);
            insertStmt.setString(2, vname);
            insertStmt.setString(3, vdob);
            insertStmt.setInt(4, vage);
            insertStmt.setString(5, vcity);
            insertStmt.setString(6, vpass);
            insertStmt.setString(7, vquestion);
            insertStmt.setString(8, vanswer);
            insertStmt.setString(9, vgender);
            insertStmt.setString(10, naCon);
            insertStmt.setString(11, paCon);

            int inserted = insertStmt.executeUpdate();

            return (inserted > 0)
                    ? "Voter Inserted Successfully"
                    : "Insert Failed";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String updateVoter(String data) {
        String[] fields = data.split(",");
        if (fields.length != 5) {
            return "Invalid Data";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "UPDATE voters SET vname = ?, vage = ?, vcity = ?, pa_conname = ? WHERE vcnic = ?")) {

            stmt.setString(1, fields[1]); // vname
            stmt.setInt(2, Integer.parseInt(fields[4])); // vage
            stmt.setString(3, fields[3]); // vcity
            stmt.setString(4, fields[2]); // pa_conname
            stmt.setString(5, fields[0]); // vcnic

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Voter updated successfully." : "No voter found with this CNIC.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String deleteVoter(String data) {
        System.out.println("delete data" + data);
        String cnic = data.trim();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM voters WHERE vcnic = ?")) {
            stmt.setString(1, cnic);
            int rows = stmt.executeUpdate();
            return rows > 0 ? "Voter deleted successfully." : "No voter found with that CNIC.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String getAllVoters() {
        StringBuilder sb = new StringBuilder();
        try (Connection conn = getConnection(); CallableStatement stmt = conn.prepareCall("{CALL GetAllVoters()}"); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                sb.append(rs.getString("cnic")).append(",")
                        .append(rs.getString("name")).append(",")
                        .append(rs.getString("constituation_no")).append(",")
                        .append(rs.getString("ph_no")).append(",")
                        .append(rs.getString("email")).append("\n");
            }
            return sb.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String loginUser(String data) {
        String[] fields = data.split(",");
        if (fields.length != 3) {
            return "Invalid login data";
        }

        String cnic = fields[0];
        String password = fields[1];
        String role = fields[2];

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM voters WHERE vcnic = ? AND vpass = ?")) {

            stmt.setString(1, cnic);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return "Success";
            } else {
                return "Invalid CNIC or Password";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String searchVoterByCnic(String cnic) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "SELECT vname, vcnic, vage, vcity, na_conname, has_voted_na, pa_conname, has_voted_pa FROM voters WHERE vcnic = ?")) {

            stmt.setString(1, cnic);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("vname") + ","
                        + rs.getString("vcnic") + ","
                        + rs.getInt("vage") + ","
                        + rs.getString("vcity") + ","
                        + rs.getString("na_conname") + ","
                        + rs.getBoolean("has_voted_na") + ","
                        + rs.getString("pa_conname") + ","
                        + rs.getBoolean("has_voted_pa");
            } else {
                return "Error: Voter not found.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String insertConstituency(String data) {
        String[] fields = data.split(",");
        if (fields.length != 4) {
            return "Invalid Constituency Data";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO constituency (conname, contype, concity, conprovience) VALUES (?, ?, ?, ?)"
        )) {

            stmt.setString(1, fields[0]); // conname
            stmt.setString(2, fields[1]); // contype
            stmt.setString(3, fields[2]); // concity
            stmt.setString(4, fields[3]); // conprovience

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Constituency added successfully." : "Failed to add constituency.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String updateConstituency(String data) {
        String[] fields = data.split(",");
        if (fields.length != 5) {
            return "Invalid Data";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "UPDATE constituency SET conname=?, contype=?, concity=?, conprovience=? WHERE constituency_id=?"
        )) {

            stmt.setString(1, fields[1]); // conname
            stmt.setString(2, fields[2]); // contype
            stmt.setString(3, fields[3]); // concity
            stmt.setString(4, fields[4]); // conprovience
            stmt.setInt(5, Integer.parseInt(fields[0])); // constituency_id

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Constituency updated successfully." : "No record updated.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String deleteConstituency(String data) {
        String id = data.trim();
        if (id.isEmpty()) {
            return "Invalid ID";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM constituency WHERE constituency_id = ?")) {

            stmt.setInt(1, Integer.parseInt(id));
            int rows = stmt.executeUpdate();

            return rows > 0 ? "Constituency deleted." : "No such constituency found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String searchConstiyuency(String name) {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM constituency WHERE conname LIKE ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                sb.append(rs.getInt("constituency_id")).append(",")
                        .append(rs.getString("conname")).append(",")
                        .append(rs.getString("contype")).append(",")
                        .append(rs.getString("concity")).append(",")
                        .append(rs.getString("conprovience")).append("\n");
            }

            return sb.length() > 0 ? sb.toString() : "No Records";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String insertParty(String data) {
        String[] fields = data.split(",");
        if (fields.length != 6) {
            return "Invalid party data format.";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO parties (pname, pfounder, pyear, pabbrevation, pleader, plogo) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, fields[0]); // pname
            stmt.setString(2, fields[1]); // pfounder
            stmt.setInt(3, Integer.parseInt(fields[2])); // pyear
            stmt.setString(4, fields[3]); // pabbrevation
            stmt.setString(5, fields[4]); // pleader
            stmt.setString(6, fields[5]); // plogo

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Party added successfully." : "Failed to add party.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String updateParty(String data) {

        String[] fields = data.split(",", -1);
        if (fields.length != 7) {
            return "Invalid data for update.";
        }

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(
                "UPDATE parties SET pname=?, pfounder=?, pyear=?, pabbrevation=?, pleader=?, plogo=? WHERE party_id=?")) {

            ps.setString(1, fields[1]); // pname
            ps.setString(2, fields[2]); // pfounder
            ps.setInt(3, Integer.parseInt(fields[3])); // pyear
            ps.setString(4, fields[4]); // pabbrevation
            ps.setString(5, fields[5]); // pleader
            ps.setString(6, fields[6]); // plogo
            ps.setInt(7, Integer.parseInt(fields[0])); // party_id

            int rows = ps.executeUpdate();
            return rows > 0 ? "Party updated successfully." : "Update failed.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Update Error: " + e.getMessage();
        }
    }

    private static String deleteParty(String id) {

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM parties WHERE party_id = ?")) {

            ps.setInt(1, Integer.parseInt(id));
            int rows = ps.executeUpdate();

            return rows > 0 ? "Party deleted successfully." : "Party not found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Delete error: " + e.getMessage();
        }
    }

    private static String searchParty(String abbrev) {
        StringBuilder sb = new StringBuilder();

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM parties WHERE pabbrevation LIKE ?")) {

            ps.setString(1, "%" + abbrev + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                sb.append(rs.getInt("party_id")).append(",")
                        .append(rs.getString("pname")).append(",")
                        .append(rs.getString("pfounder")).append(",")
                        .append(rs.getInt("pyear")).append(",")
                        .append(rs.getString("pabbrevation")).append(",")
                        .append(rs.getString("pleader")).append(",")
                        .append(rs.getString("plogo"))
                        .append("\n");
            }

            return sb.length() > 0 ? sb.toString() : "No matching party found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String insertCandidate(String data) {

        try (Connection con = getConnection()) {
            String[] fields = data.split(",");

            if (fields.length != 8) {
                return "Invalid candidate data.";
            }

            String cname = fields[0];
            String ccnic = fields[1];
            String cdob = fields[2];
            int cage = Integer.parseInt(fields[3]);
            String cgender = fields[4];
            String cconstituency = fields[5];
            String cparty = fields[6];
            String csymbol = fields[7];

            //  Check if candidate is a registered voter
            PreparedStatement checkVoter = con.prepareStatement("SELECT * FROM voters WHERE vcnic = ?");
            checkVoter.setString(1, ccnic);
            ResultSet rsVoter = checkVoter.executeQuery();
            if (!rsVoter.next()) {
                return "Candidate must be a registered voter first.";
            }

            //  Check if constituency exists
            PreparedStatement checkCon = con.prepareStatement("SELECT constituency_id FROM constituency WHERE conname = ?");
            checkCon.setString(1, cconstituency);
            ResultSet rsCon = checkCon.executeQuery();
            if (!rsCon.next()) {
                return "Constituency not found!";
            }
            int conId = rsCon.getInt("constituency_id");

            //  Check if party exists
            PreparedStatement checkParty = con.prepareStatement("SELECT party_id FROM parties WHERE pname = ?");
            checkParty.setString(1, cparty);
            ResultSet rsParty = checkParty.executeQuery();
            if (!rsParty.next()) {
                return "Party not found!";
            }
            int partyId = rsParty.getInt("party_id");

            // Check symbol uniqueness in constituency
            PreparedStatement checkSymbol = con.prepareStatement(
                    "SELECT * FROM candidates WHERE csymbol = ? AND constituency_id = ?"
            );
            checkSymbol.setString(1, csymbol);
            checkSymbol.setInt(2, conId);
            ResultSet rsSymbol = checkSymbol.executeQuery();
            if (rsSymbol.next()) {
                return "Symbol already used in this constituency.";
            }

            //  Insert into candidates
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO candidates (cname, ccnic, cdob, cage, cgender, constituency_id, party_id, csymbol) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, cname);
            ps.setString(2, ccnic);
            ps.setString(3, cdob);
            ps.setInt(4, cage);
            ps.setString(5, cgender);
            ps.setInt(6, conId);
            ps.setInt(7, partyId);
            ps.setString(8, csymbol);

            int rows = ps.executeUpdate();
            return rows > 0 ? "Candidate added successfully!" : "Candidate insertion failed.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String updateCandidate(String data) {

        String[] fields = data.split(",", 8);
        if (fields.length != 8) {
            return "Invalid data format for update.";
        }

        try (Connection con = getConnection()) {
            String cnic = fields[0];
            String name = fields[1];
            String dob = fields[2];
            int age = Integer.parseInt(fields[3]);
            String gender = fields[4];
            String constituency = fields[5];
            String party = fields[6];
            String symbol = fields[7];

            // Get constituency_id
            PreparedStatement psCon = con.prepareStatement("SELECT constituency_id FROM constituency WHERE conname = ?");
            psCon.setString(1, constituency);
            ResultSet rsCon = psCon.executeQuery();
            if (!rsCon.next()) {
                return "Invalid constituency.";
            }
            int conId = rsCon.getInt("constituency_id");

            // Get party_id
            PreparedStatement psParty = con.prepareStatement("SELECT party_id FROM parties WHERE pname = ?");
            psParty.setString(1, party);
            ResultSet rsParty = psParty.executeQuery();
            if (!rsParty.next()) {
                return "Invalid party.";
            }
            int partyId = rsParty.getInt("party_id");

            // Update candidate
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE candidates SET cname=?, cdob=?, cage=?, cgender=?, constituency_id=?, party_id=?, csymbol=? WHERE ccnic=?"
            );
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setInt(5, conId);
            ps.setInt(6, partyId);
            ps.setString(7, symbol);
            ps.setString(8, cnic);

            int rows = ps.executeUpdate();
            return rows > 0 ? "Candidate updated successfully." : "No candidate found with this CNIC.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String deleteCandidate(String cnic) {

        cnic = cnic.trim();
        if (cnic.isEmpty()) {
            return "Invalid CNIC";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM candidates WHERE ccnic = ?")) {

            stmt.setString(1, cnic);
            int rows = stmt.executeUpdate();

            return rows > 0 ? "Candidate deleted successfully." : "No candidate found with that CNIC.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String searchCandidate(String cnic) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(
                "SELECT c.cname, c.cdob, c.cage, c.cgender, cs.conname, p.pname, c.csymbol "
                + "FROM candidates c "
                + "JOIN constituency cs ON c.constituency_id = cs.constituency_id "
                + "JOIN parties p ON c.party_id = p.party_id "
                + "WHERE c.ccnic = ?"
        )) {

            ps.setString(1, cnic);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return String.join(",",
                        rs.getString("cname"),
                        rs.getString("cdob"),
                        String.valueOf(rs.getInt("cage")),
                        rs.getString("cgender"),
                        rs.getString("conname"),
                        rs.getString("pname"),
                        rs.getString("csymbol")
                );
            } else {
                return "NOT_FOUND";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String insertnews(String news) {

        if (news == null || news.trim().isEmpty()) {
            return "News content cannot be empty.";
        }

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement("INSERT INTO electionnews (news) VALUES (?)")) {

            stmt.setString(1, news.trim());
            int rows = stmt.executeUpdate();

            return rows > 0 ? "Election news added successfully." : "Failed to add news.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String deleteNews(String data) {

        String idText = data.trim();
        if (idText.isEmpty()) {
            return "Error: News ID is required.";
        }

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM electionnews WHERE id = ?")) {

            int id = Integer.parseInt(idText);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows > 0 ? "News deleted successfully." : "No news found with this ID.";

        } catch (NumberFormatException e) {
            return "Error: News ID must be a valid number.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting news: " + e.getMessage();
        }
    }

    private static String loadAllNews() {
        StringBuilder sb = new StringBuilder();

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT news, posted_at FROM electionnews ORDER BY posted_at DESC")) {

            while (rs.next()) {
                sb.append("Date: ").append(rs.getTimestamp("posted_at")).append("\n")
                        .append(rs.getString("news")).append("\n\n");
            }

            return sb.length() > 0 ? sb.toString() : "No news available.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading news: " + e.getMessage();
        }
    }

    private static String showNews() {

        StringBuilder newsBuilder = new StringBuilder();

        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT news FROM electionnews ORDER BY posted_at DESC")) {

            while (rs.next()) {
                newsBuilder.append("• ").append(rs.getString("news")).append("\n\n");
            }

            return newsBuilder.length() > 0 ? newsBuilder.toString() : "No news available.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading news: " + e.getMessage();
        }
    }

    private static String showinTable() {

        StringBuilder sb = new StringBuilder();
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, news, posted_at FROM electionnews ORDER BY id DESC")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String news = rs.getString("news").replace(",", " "); // Avoid breaking CSV format
                Timestamp postedAt = rs.getTimestamp("posted_at");
                String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(postedAt);

                sb.append(id).append(",")
                        .append(news).append(",")
                        .append(formattedTime).append("\n");
            }

            return sb.length() > 0 ? sb.toString() : "No data";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading news: " + e.getMessage();
        }
    }

    private static String showTableData() {
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement("SELECT vname, vcnic, vage, vcity, na_conname, pa_conname, has_voted_na, has_voted_pa FROM voters"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sb.append(rs.getString("vname")).append(",")
                        .append(rs.getString("vcnic")).append(",")
                        .append(rs.getInt("vage")).append(",")
                        .append(rs.getString("vcity")).append(",")
                        .append(rs.getString("na_conname")).append(",")
                        .append(rs.getString("pa_conname")).append(",")
                        .append(rs.getBoolean("has_voted_na") ? "Yes" : "No").append(",")
                        .append(rs.getBoolean("has_voted_pa") ? "Yes" : "No").append("\n");
            }

            return sb.length() > 0 ? sb.toString() : "No voters found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String castNAVote(String data) {
        String[] parts = data.split(",");
        if (parts.length != 2) {
            return "Invalid data received.";
        }

        String vcnic = parts[0].trim();
        String candidateCnic = parts[1].trim();

        try (Connection con = getConnection()) {
            // Check election active
            PreparedStatement electionStmt = con.prepareStatement(
                    "SELECT * FROM election WHERE NOW() BETWEEN "
                    + "STR_TO_DATE(CONCAT(start_date, ' ', start_time), '%Y-%m-%d %H:%i:%s') "
                    + "AND STR_TO_DATE(CONCAT(end_date, ' ', end_time), '%Y-%m-%d %H:%i:%s')"
            );
            ResultSet electionRS = electionStmt.executeQuery();
            if (!electionRS.next()) {
                return "Voting is currently not allowed. No active election.";
            }

            // Check if voter exists and has not voted
            PreparedStatement checkVoter = con.prepareStatement("SELECT has_voted_na FROM voters WHERE vcnic = ?");
            checkVoter.setString(1, vcnic);
            ResultSet voterRS = checkVoter.executeQuery();
            if (!voterRS.next()) {
                return "Voter not found.";
            }
            if (voterRS.getBoolean("has_voted_na")) {
                return "You have already voted in the NA election.";
            }

            // Increment vote count
            PreparedStatement updateVotes = con.prepareStatement("UPDATE candidates SET votes = votes + 1 WHERE ccnic = ?");
            updateVotes.setString(1, candidateCnic);
            int updated = updateVotes.executeUpdate();
            if (updated == 0) {
                return "Error updating candidate votes.";
            }

            // Update voter's voting status
            PreparedStatement markVoted = con.prepareStatement("UPDATE voters SET has_voted_na = 1 WHERE vcnic = ?");
            markVoted.setString(1, vcnic);
            markVoted.executeUpdate();

            return "Vote cast successfully for NA.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String castPAVote(String data) {
        String[] parts = data.split(",");
        if (parts.length != 2) {
            return "Invalid data received.";
        }

        String vcnic = parts[0].trim();
        String candidateCnic = parts[1].trim();

        try (Connection con = getConnection()) {
            // 1. Check election is active
            PreparedStatement electionStmt = con.prepareStatement(
                    "SELECT * FROM election WHERE NOW() BETWEEN "
                    + "STR_TO_DATE(CONCAT(start_date, ' ', start_time), '%Y-%m-%d %H:%i:%s') "
                    + "AND STR_TO_DATE(CONCAT(end_date, ' ', end_time), '%Y-%m-%d %H:%i:%s')"
            );
            ResultSet electionRS = electionStmt.executeQuery();
            if (!electionRS.next()) {
                return "Voting is currently not allowed. No active election.";
            }

            // 2. Check if voter has already voted
            PreparedStatement checkVoter = con.prepareStatement("SELECT has_voted_pa FROM voters WHERE vcnic = ?");
            checkVoter.setString(1, vcnic);
            ResultSet voterRS = checkVoter.executeQuery();
            if (!voterRS.next()) {
                return "Voter not found.";
            }
            if (voterRS.getBoolean("has_voted_pa")) {
                return "You have already voted in the PA election.";
            }

            // 3. Increment vote count for candidate
            PreparedStatement updateVotes = con.prepareStatement("UPDATE candidates SET votes = votes + 1 WHERE ccnic = ?");
            updateVotes.setString(1, candidateCnic);
            int updated = updateVotes.executeUpdate();
            if (updated == 0) {
                return "Error updating candidate vote.";
            }

            // 4. Mark voter as voted
            PreparedStatement markVoted = con.prepareStatement("UPDATE voters SET has_voted_pa = 1 WHERE vcnic = ?");
            markVoted.setString(1, vcnic);
            markVoted.executeUpdate();

            return "Vote cast successfully for PA.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String showCandidates() {
        StringBuilder sb = new StringBuilder();

        String query = """
        SELECT c.cname, c.ccnic, c.cdob, c.cage, c.cgender,
               cs.conname, p.pname, c.csymbol, c.votes, c.outcome
        FROM candidates c
        JOIN constituency cs ON c.constituency_id = cs.constituency_id
        JOIN parties p ON c.party_id = p.party_id
    """;

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sb.append(rs.getString("cname")).append(",")
                        .append(rs.getString("ccnic")).append(",")
                        .append(rs.getString("cdob")).append(",")
                        .append(rs.getInt("cage")).append(",")
                        .append(rs.getString("cgender")).append(",")
                        .append(rs.getString("conname")).append(",")
                        .append(rs.getString("pname")).append(",")
                        .append(rs.getString("csymbol")).append(",")
                        .append(rs.getInt("votes")).append(",")
                        .append(rs.getString("outcome")).append("\n");
            }

            return sb.length() > 0 ? sb.toString() : "No candidates found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String getResultForCandidate(String cnic) {
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection()) {

            // Step 0: Check if election is active
            PreparedStatement electionStmt = con.prepareStatement("""
            SELECT * FROM election
            WHERE NOW() BETWEEN
            STR_TO_DATE(CONCAT(start_date, ' ', start_time), '%Y-%m-%d %H:%i:%s')
            AND
            STR_TO_DATE(CONCAT(end_date, ' ', end_time), '%Y-%m-%d %H:%i:%s')
        """);
            ResultSet electionRS = electionStmt.executeQuery();
            if (!electionRS.next()) {
                return "Election is not currently active. Results cannot be viewed.";
            }

            // Step 1: Get candidate's constituency and city
            PreparedStatement candStmt = con.prepareStatement("""
            SELECT co.conname, co.concity
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
            WHERE c.ccnic = ?
        """);
            candStmt.setString(1, cnic);
            ResultSet rsCand = candStmt.executeQuery();
            if (!rsCand.next()) {
                return "Candidate not found.";
            }

            String conname = rsCand.getString("conname");
            String city = rsCand.getString("concity");

            // Step 2: Get all candidates in same constituency
            PreparedStatement ps = con.prepareStatement("""
            SELECT c.ccnic, c.cname, co.conname, co.concity, c.csymbol, c.votes
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
            WHERE co.conname = ? AND co.concity = ?
        """);
            ps.setString(1, conname);
            ps.setString(2, city);
            ResultSet rs = ps.executeQuery();

            List<String[]> rows = new ArrayList<>();
            int maxVotes = -1;

            while (rs.next()) {
                String[] row = {
                    rs.getString("ccnic"),
                    rs.getString("cname"),
                    rs.getString("conname"),
                    rs.getString("concity"),
                    rs.getString("csymbol"),
                    rs.getString("votes")
                };
                rows.add(row);
                maxVotes = Math.max(maxVotes, Integer.parseInt(row[5]));
            }

            // Determine how many have maxVotes
            int maxCount = 0;
            for (String[] r : rows) {
                if (Integer.parseInt(r[5]) == maxVotes) {
                    maxCount++;
                }
            }

            for (String[] r : rows) {
                String outcome = Integer.parseInt(r[5]) == maxVotes
                        ? (maxCount > 1 ? "Draw" : "Won")
                        : "Lost";

                sb.append(String.join(",", r)).append(",").append(outcome).append("\n");
            }

        } catch (Exception e) {
            return "Error fetching result: " + e.getMessage();
        }

        return sb.length() > 0 ? sb.toString() + "END_OF_RESULT" : "No data.";
    }

    private static String loadPartiesData() {
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM parties")) {

            while (rs.next()) {
                sb.append(rs.getInt("party_id")).append(",")
                        .append(rs.getString("pname")).append(",")
                        .append(rs.getString("pfounder")).append(",")
                        .append(rs.getInt("pyear")).append(",")
                        .append(rs.getString("pabbrevation")).append(",")
                        .append(rs.getString("pleader")).append(",")
                        .append(rs.getString("plogo")).append("\n");
            }

            return sb.length() > 0 ? sb.toString() + "END_OF_PARTIES" : "Error: No party data found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String getPAResultData() {
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection(); PreparedStatement psCon = con.prepareStatement("""
            SELECT DISTINCT c.constituency_id, co.conname, co.concity
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
            WHERE co.contype = 'PA'
         """); ResultSet rsCon = psCon.executeQuery()) {

            while (rsCon.next()) {
                int constituencyId = rsCon.getInt("constituency_id");
                String conname = rsCon.getString("conname");
                String concity = rsCon.getString("concity");

                PreparedStatement psCand = con.prepareStatement("""
                SELECT c.ccnic, c.cname, c.csymbol, c.votes, p.pname
                FROM candidates c
                JOIN parties p ON c.party_id = p.party_id
                WHERE c.constituency_id = ?
            """);
                psCand.setInt(1, constituencyId);
                ResultSet rsCand = psCand.executeQuery();

                List<Object[]> candidates = new ArrayList<>();
                int maxVotes = -1;

                while (rsCand.next()) {
                    String cnic = rsCand.getString("ccnic");
                    String name = rsCand.getString("cname");
                    String symbol = rsCand.getString("csymbol");
                    int votes = rsCand.getInt("votes");
                    String party = rsCand.getString("pname");

                    maxVotes = Math.max(maxVotes, votes);
                    candidates.add(new Object[]{cnic, name, conname, concity, symbol, votes, party});
                }

                // Determine winners
                int maxCount = 0;
                for (Object[] candidate : candidates) {
                    if ((int) candidate[5] == maxVotes) {
                        maxCount++;
                    }
                }

                for (Object[] candidate : candidates) {
                    int votes = (int) candidate[5];
                    String outcome = (votes == maxVotes)
                            ? (maxCount > 1 ? "Draw" : "Won")
                            : "Lost";

                    sb.append(candidate[0]).append(",") // CNIC
                            .append(candidate[1]).append(",") // Name
                            .append(candidate[2]).append(",") // Constituency
                            .append(candidate[3]).append(",") // City
                            .append(candidate[4]).append(",") // Symbol
                            .append(votes).append(",") // Votes
                            .append(outcome).append("\n");      // Outcome
                }

                rsCand.close();
                psCand.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

        return sb.length() > 0 ? sb.toString() + "END_OF_PA_RESULT" : "Error: No PA result found.";
    }

    private static String getNAResultData() {
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection(); PreparedStatement psCon = con.prepareStatement("""
            SELECT DISTINCT c.constituency_id, co.conname, co.concity
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
            WHERE co.contype = 'NA'
         """); ResultSet rsCon = psCon.executeQuery()) {

            while (rsCon.next()) {
                int constituencyId = rsCon.getInt("constituency_id");
                String conname = rsCon.getString("conname");
                String concity = rsCon.getString("concity");

                PreparedStatement psCand = con.prepareStatement("""
                SELECT c.ccnic, c.cname, c.csymbol, c.votes, p.pname
                FROM candidates c
                JOIN parties p ON c.party_id = p.party_id
                WHERE c.constituency_id = ?
            """);
                psCand.setInt(1, constituencyId);
                ResultSet rsCand = psCand.executeQuery();

                List<Object[]> candidates = new ArrayList<>();
                int maxVotes = -1;

                while (rsCand.next()) {
                    String cnic = rsCand.getString("ccnic");
                    String name = rsCand.getString("cname");
                    String symbol = rsCand.getString("csymbol");
                    int votes = rsCand.getInt("votes");
                    String party = rsCand.getString("pname");

                    maxVotes = Math.max(maxVotes, votes);
                    candidates.add(new Object[]{cnic, name, conname, concity, symbol, votes, party});
                }

                // Determine outcome
                int maxCount = 0;
                for (Object[] candidate : candidates) {
                    if ((int) candidate[5] == maxVotes) {
                        maxCount++;
                    }
                }

                for (Object[] candidate : candidates) {
                    int votes = (int) candidate[5];
                    String outcome = (votes == maxVotes)
                            ? (maxCount > 1 ? "Draw" : "Won")
                            : "Lost";

                    sb.append(candidate[0]).append(",") // CNIC
                            .append(candidate[1]).append(",") // Name
                            .append(candidate[2]).append(",") // Constituency
                            .append(candidate[3]).append(",") // City
                            .append(candidate[4]).append(",") // Symbol
                            .append(votes).append(",") // Votes
                            .append(outcome).append("\n");      // Outcome
                }

                rsCand.close();
                psCand.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

        return sb.length() > 0 ? sb.toString() + "END_OF_NA_RESULT" : "Error: No NA result found.";
    }

    private static String startElection(String data) {
        String[] parts = data.split(",");
        if (parts.length != 5) {
            return "Error: Invalid data format.";
        }

        try (Connection con = getConnection()) {
            int year = Integer.parseInt(parts[0]);
            String startDate = parts[1];
            String startTime = parts[2];
            String endDate = parts[3];
            String endTime = parts[4];

            String sql = "INSERT INTO election (election_year, start_date, start_time, end_date, end_time) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, year);
            ps.setString(2, startDate);
            ps.setString(3, startTime);
            ps.setString(4, endDate);
            ps.setString(5, endTime);

            int rows = ps.executeUpdate();
            return rows > 0 ? "Election started successfully." : "Failed to start the election.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String loadNACandidatesForVoting(String vcnic) {
        try (Connection con = getConnection()) {
            PreparedStatement voterStmt = con.prepareStatement(
                    "SELECT na_conname, has_voted_na, vcity FROM voters WHERE vcnic = ?");
            voterStmt.setString(1, vcnic);
            ResultSet voterRS = voterStmt.executeQuery();

            if (!voterRS.next()) {
                return "VOTER_NOT_FOUND";
            }

            if (voterRS.getBoolean("has_voted_na")) {
                return "ALREADY_VOTED";
            }

            String conname = voterRS.getString("na_conname");
            String city = voterRS.getString("vcity");

            PreparedStatement ps = con.prepareStatement("""
            SELECT c.ccnic, c.cname, c.cage, ?, co.conname, p.plogo
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
            JOIN parties p ON c.party_id = p.party_id
            WHERE co.conname = ? AND co.contype = 'NA'
        """);
            ps.setString(1, city);
            ps.setString(2, conname);
            ResultSet rs = ps.executeQuery();

            StringBuilder rows = new StringBuilder();
            while (rs.next()) {
                rows.append(rs.getString("ccnic")).append(",")
                        .append(rs.getString("cname")).append(",")
                        .append(rs.getInt("cage")).append(",")
                        .append(city).append(",")
                        .append(rs.getString("conname")).append(",")
                        .append(rs.getString("plogo")).append(";");
            }

            return rows.length() > 0 ? rows.toString() : "NO_CANDIDATES";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

private static String loadElectionTime(String data) {
    System.out.println(data);
    try (Connection con = getConnection()) {
        LocalDate today = LocalDate.now();

        PreparedStatement timeStmt = con.prepareStatement(
            "SELECT end_time FROM election WHERE election_year = ? AND end_date = ?");
        timeStmt.setString(1, data);
        timeStmt.setDate(2, java.sql.Date.valueOf(today));

        ResultSet timeRS = timeStmt.executeQuery();
        if (!timeRS.next()) {
            return "Election_Date_NOT_MATCHED";
        }
        return timeRS.getString("end_time");
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

    private static String loadPACandidatesForVoting(String vcnic) {
        try (Connection con = getConnection()) {
            PreparedStatement voterStmt = con.prepareStatement(
                    "SELECT pa_conname, has_voted_pa, vcity FROM voters WHERE vcnic = ?");
            voterStmt.setString(1, vcnic);
            ResultSet voterRS = voterStmt.executeQuery();

            if (!voterRS.next()) {
                return "VOTER_NOT_FOUND";
            }

            if (voterRS.getBoolean("has_voted_pa")) {
                return "ALREADY_VOTED";
            }

            String conname = voterRS.getString("pa_conname");
            String city = voterRS.getString("vcity");

            PreparedStatement ps = con.prepareStatement("""
            SELECT c.ccnic, c.cname, c.cage, ?, co.conname, p.plogo
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
            JOIN parties p ON c.party_id = p.party_id
            WHERE co.conname = ? AND co.contype = 'PA'
        """);
            ps.setString(1, city);
            ps.setString(2, conname);
            ResultSet rs = ps.executeQuery();

            StringBuilder rows = new StringBuilder();
            while (rs.next()) {
                rows.append(rs.getString("ccnic")).append(",")
                        .append(rs.getString("cname")).append(",")
                        .append(rs.getInt("cage")).append(",")
                        .append(city).append(",")
                        .append(rs.getString("conname")).append(",")
                        .append(rs.getString("plogo")).append(";");
            }

            return rows.length() > 0 ? rows.toString() : "NO_CANDIDATES";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String conShowTable() {
        StringBuilder sb = new StringBuilder();

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement("SELECT constituency_id, conname, contype, concity, conprovience FROM constituency"); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sb.append(rs.getInt("constituency_id")).append(",")
                        .append(rs.getString("conname")).append(",")
                        .append(rs.getString("contype")).append(",")
                        .append(rs.getString("concity")).append(",")
                        .append(rs.getString("conprovience")).append("\n");
            }

            return sb.length() > 0 ? sb.toString() : "No constituencies found.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private static String ElectionFinalize(String year) {
       try (Connection con = getConnection()) {
        // Get all constituencies
        PreparedStatement psCon = con.prepareStatement("""
            SELECT DISTINCT c.constituency_id, co.conname, co.concity
            FROM candidates c
            JOIN constituency co ON c.constituency_id = co.constituency_id
        """);
        ResultSet rsCon = psCon.executeQuery();

        while (rsCon.next()) {
            int constituencyId = rsCon.getInt("constituency_id");
            String conname = rsCon.getString("conname");
            String city = rsCon.getString("concity");

            // Fetch candidates in that constituency
            PreparedStatement psCand = con.prepareStatement("""
                SELECT c.ccnic, c.cname, c.csymbol, c.votes
                FROM candidates c
                WHERE c.constituency_id = ?
            """);
            psCand.setInt(1, constituencyId);
            ResultSet rsCand = psCand.executeQuery();

            List<Object[]> candidates = new ArrayList<>();
            int maxVotes = -1;

            while (rsCand.next()) {
                String cnic = rsCand.getString("ccnic");
                String name = rsCand.getString("cname");
                String symbol = rsCand.getString("csymbol");
                int votes = rsCand.getInt("votes");
                maxVotes = Math.max(maxVotes, votes);
                candidates.add(new Object[]{cnic, name, conname, city, symbol, votes});
            }

            int maxCount = 0;
            for (Object[] c : candidates) {
                if ((int) c[5] == maxVotes) maxCount++;
            }

            for (Object[] c : candidates) {
                String outcome = ((int) c[5] == maxVotes)
                        ? (maxCount > 1 ? "Draw" : "Won")
                        : "Lost";

                // Update outcome in candidates table
                PreparedStatement updateCand = con.prepareStatement("UPDATE candidates SET outcome = ? WHERE ccnic = ?");
                updateCand.setString(1, outcome);
                updateCand.setString(2, (String) c[0]);
                updateCand.executeUpdate();

                // Check if result exists
                PreparedStatement check = con.prepareStatement("SELECT * FROM results WHERE cnic = ? AND election_year = ?");
                check.setString(1, (String) c[0]);
                check.setString(2, year);
                ResultSet exist = check.executeQuery();

                if (exist.next()) {
                    // Update result
                    PreparedStatement update = con.prepareStatement("""
                        UPDATE results SET name = ?, constituency = ?, city = ?, symbol = ?, votes = ?, outcome = ?
                        WHERE cnic = ? AND election_year = ?
                    """);
                    update.setString(1, (String) c[1]);
                    update.setString(2, (String) c[2]);
                    update.setString(3, (String) c[3]);
                    update.setString(4, (String) c[4]);
                    update.setInt(5, (int) c[5]);
                    update.setString(6, outcome);
                    update.setString(7, (String) c[0]);
                    update.setString(8, year);
                    update.executeUpdate();
                } else {
                    // Insert result
                    PreparedStatement insert = con.prepareStatement("""
                        INSERT INTO results (cnic, name, constituency, city, symbol, votes, outcome, election_year)
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                    """);
                    insert.setString(1, (String) c[0]);
                    insert.setString(2, (String) c[1]);
                    insert.setString(3, (String) c[2]);
                    insert.setString(4, (String) c[3]);
                    insert.setString(5, (String) c[4]);
                    insert.setInt(6, (int) c[5]);
                    insert.setString(7, outcome);
                    insert.setString(8, year);
                    insert.executeUpdate();
                }
            }

            rsCand.close();
            psCand.close();
        }

        rsCon.close();
        psCon.close();
        return "Election results finalized for " + year;

    } catch (Exception e) {
        e.printStackTrace();
        return "Error finalizing election results: " + e.getMessage();
    }}

}
