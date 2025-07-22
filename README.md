PROJECT ABSTRACT
The Election Management System (EMS) is designed to conduct and manage national and provincial elections digitally. This system enables secure voter registration, candidate and party management, real-time vote casting, result generation, and election timing control. Built in Java with a client-server architecture and backed by MySQL, the EMS ensures accurate vote processing, prevents double voting, and enhances transparency. It offers separate roles for voters, candidates, and administrators, and supports features like constituency-based results, secure authentication, and timer-based election tracking.

INTRODUCTION:

The EMS modernizes the traditional election process through:

Voter Registration: Storing CNIC, name, constituency, and voting history.

Candidate & Party Management: Registration of candidates/parties, symbol assignment.

Voting: National and Provincial voting with one-vote-per-election enforcement.

Election Timing: Start and end time control with countdown timers.

Result Reporting: Real-time result display, candidate-specific reports.

News Broadcast: Posting and viewing election news.

Client-Server Communication: All operations are securely handled via a central server.

BUSINESS REQUIREMENTS:
BR1: System shall allow online secure vote casting.

BR2: Prevent a voter from voting more than once for NA or PA.

BR3: Admin can control the election timing.

BR4: Only registered users can participate.

BR5: Display real-time results for NA and PA.

BR6: Candidates can view performance in their constituency.

BR7: Admin can add news updates; voters and candidates can view them.

BR8: System must prevent vote casting outside election time.

BR9: The system should scale to support up to 1000 concurrent users.

BR10: Record audit logs for vote casting and result access.


 USER REQUIREMENTS: 
ID	Requirement
UR1	Voter shall login using CNIC and password.
UR2	Voter shall cast vote once for NA and PA each.
UR3	Candidate shall view votes obtained in their constituency.
UR4	Admin shall start/end elections.
UR5	Admin shall add election news.
UR6	Users shall view real-time countdown till election end.
UR7	System shall load NA/PA candidates based on voter's constituency.
UR8	Admin can delete or update voter/candidate profiles.
UR9	System shall show confirmation after vote is casted.
UR10	Results shall only be viewable after election ends.


FUNCTIONAL REQUIREMENTS:
ID	Requirement
FR1	Login system for Voter, Candidate, Admin
FR2	Register voter with CNIC, city, NA & PA constituency
FR3	Register candidate with symbol, party, and constituency
FR4	Cast NA vote (only once per voter)
FR5	Cast PA vote (only once per voter)
FR6	Display NA & PA candidates by voter's constituency
FR7	Admin can start and end the election (with countdown)
FR8	Show live timer to users
FR9	Generate result reports for candidates and admin
FR10	Admin posts election-related news; users view it
FR11	Delete voters, candidates, and news
FR12	Load and display users/candidates/news in tables
FR13	Secure communication between client and server
FR14	Error messages for invalid operations (e.g., voting twice)


NON-FUNCTIONAL REQUIREMENTS:

Performance: Must support 1000+ voters with <1s response time.

Security: CNIC and password must be encrypted; votes cannot be spoofed.

Reliability: Vote count is atomic; no double updates.

Usability: Swing GUI with clear instructions and confirmations.

Maintainability: Modular client-server codebase.

Portability: Java-based system runs on Windows, Linux.

Availability: Server uptime must exceed 99%.

Data Integrity: Voter cannot vote twice; vote reflects in DB.

Compliance: Data stored in MySQL using standard date/time formats.

Scalability: System must scale with constituency size and user count.


BUSINESS RULES :

BSR1: A voter may cast only one NA and one PA vote.

BSR2: A vote can only be cast during an active election period.

BSR3: A candidate belongs to only one party and one constituency.

BSR4: A voter's CNIC must be unique.

BSR5: Admin must start the election before votes can be cast.

BSR6: Election timer must be synchronized from server.

BSR7: Once casted, a vote cannot be changed.

BSR8: Admin-only access for managing users and news.

BSR9: A candidate can’t view another constituency’s result.

BSR10: News once deleted cannot be recovered.


QUALITY ATTRIBUTES:

QA1: Login authentication within 2 seconds.

QA2: Real-time vote casting with <1s delay.

QA3: Vote database must ensure atomic updates.

QA4: Timer displayed accurately on user interfaces.

QA5: Tables must load and refresh without crashes.

QA6: Result boards reflect up-to-date totals.

QA7: Each function logs success/failure for audit.

QA8: Only authorized clients can send/receive commands.

QA9: System must recover from server crash within 10 seconds.

QA10: Must support day-long election with no memory leaks.

EXTERNAL INTERFACES:

ER1: Java Swing GUI on client side.

ER2: JDBC interface to MySQL.

ER3: Socket communication (Client ↔ Server).

ER4: JTable used for real-time candidate/voter/news loading.

ER5: Election time synchronized from MySQL DB.

ER6: End time broadcasted to clients to show countdown.


CONSTRAINTS:
CN1: Implemented in Java (JDK 17+).

CN2: Uses MySQL as backend DB.

CN3: GUI built with Java Swing only.

CN4: No third-party frameworks (pure Java + MySQL).

CN5: Deployed on LAN; future version may support Web.

CN6: Only server updates the database.

CN7: Candidate CNIC must be unique.

CN8: Election time must be controlled by admin.
