import java.io.Console;
import java.sql.SQLOutput;
import java.util.List;
/**
 * The View class that interacts with the user.
 */
public class ViewModel implements ViewActions {
    /**
     * @description: Prints greeting statement
     * @param: []
     * @return: void
     * @date: 2020-11-14
     */
    @Override
    public void Introduction() {

        System.out.println("Welcome to the 0173 Conference!");
    }
    /**
     * @description: Asks user if he/she/they have registered or not
     * @param: []
     * @return: returns 1 if user has already registered
     * returns 0 if not
     * @date: 2020-11-14
     */

    @Override
    public int AreURegistered() {
        int i = - 1;
        Console c = System.console();
        System.out.println("Do you have an account? Type: Yes/No");
        String n = c.readLine();
        if (n.equals("Yes")) {
            i = 1;
        } else if (n.equals("No")) {
            i = 0;
        }else{
            System.out.println("Invalid input! Please Type: Yes/No");
            AreURegistered();
        }
        return i;
    }
    /**
     * @description: Interacts with the user and takes its username from the console
     * @param: []
     * @return: returns user's username
     * @date: 2020-11-14
     */

    @Override
    public String username() {
        Console c = System.console();
        System.out.println("Enter your username here:");
        String username = c.readLine();
        return username;
    }
    /**
     * @Description: Interacts with the user and takes its password from the console
     * @param: []
     * @return: returns user's password
     * @Date: 2020-11-14
     */


    @Override
    public String Pass() {
        Console c=System.console();
        System.out.println("Enter your password here: ");
        char[] ch=c.readPassword();
        String pass = String.valueOf(ch);//converting char array into string
        return pass;
    }
    /**
     * @Description: Interacts with the user to sign in
     * @param: []
     * @return: returns the String[username, password]
     * @Date: 2020-11-14
     */

    @Override
    public String[] SignIn(){
        Console c = System.console();
        System.out.println("To sign in enter your username here:");
        String n = c.readLine();
        System.out.println("To sign in enter your password here:");
        String k = c.readLine();
        return new String[]{n, k};
    }
    /**
     * @Description: Greets the user if user successfully log in
     * @param username  User name of the user attempting to log in
     * @return: void
     * @Date: 2020-11-14
     */

    @Override
    public void Credentials(String username) {
        System.out.println("Welcome" + username + "!");
    }
    /**
     * @Description: Generates the message if user failed to log in
     * @param: []
     * @return: void
     * @Date: 2020-11-14
     */

    @Override
    public void CredentialsFail(){
        System.out.println("Oops, something went wrong. Please try again");
    }
    /**
     * @Description: Interacts with the user to open a messenger
     * @param: []
     * @return returns 1 if user wants to send a message
     * returns 2 if user want to view messages
     * returns 3 if user want to reply to a message
     * @Date: 2020-11-14
     */

    public int Messenger(){
        System.out.println("Welcome to Messenger!");
        System.out.println("Type 1 If you want to send a message: ");
        System.out.println("Type 2 If you want to view your messages: ");
        System.out.println("Type 3 If you want to reply to a message");
        exit();
        return answer();
    }

    private int answer(){
        int i = 0;
        Console c = System.console();
        String answer = c.readLine();
        i = Integer.parseInt(answer);
        return i;
    }


    /**
     * @Description: Interacts with the Attendee to open a messenger
     * @param: []
     * @return returns 1 if user wants to send a message to attendee
     * returns 2 if user wants to send a message to a speaker
     * @Date: 2020-11-14
     */


    @Override
    public int MessengerAttendee() {
        System.out.println("Type 1 If you want to send a message to an attendee: ");
        System.out.println("TYpe 2 If you want to send a message to a speaker: ");
        exit();
        return answer();

    }

    @Override
    public int MessengerOrganizer() {
        System.out.println("Type 1 If you want to send a message to an attendee: ");
        System.out.println("TYpe 2 If you want to send a message to a speaker: ");
        System.out.println("Type 3 If you want to send a message to all attendees: ");
        System.out.println("Type 4 If you want to send a message to all speakers: ");
        exit();
        return answer();
    }

    @Override
    public int MessengerSpeaker() {
        System.out.println("Type 1 If you want to send a message to all attendees in one event: '");
        System.out.println("Type 2 If you want to send a message to all attendees in all your events: ");
        System.out.println("Type 3 If you want to send a specific user in your events: ");
        exit();
        return answer();
    }

    private void exit(){
        System.out.println("Type other numbers if you want to return to the previous page: ");
    }

    public String back(){
        System.out.println("Type any thing to go back to previous page");
        Console c = System.console();
        String answer = c.readLine();
        return answer;
    }





    @Override
    public int AttendeeMenu() {
        System.out.println("Welcome to the menu!");
        System.out.println("Type 1 if you want to open the Messenger: ");
        System.out.println("Type 2 if you want to browse all the events in the conference: ");
        System.out.println("Type 3 if you want to see your schedule: ");
        System.out.println("Type 4 if you want to see what events you can sign up now: ");
        System.out.println("Type 5 if you want to sign up a new event: ");
        System.out.println("Type 6 if you want to cancel an event: ");
        return answer();
    }

    @Override
    public int OrganizerMenu() {
        System.out.println("Welcome to the menu!");
        System.out.println("Type 1 if you want to open the Messenger: ");
        System.out.println("Type 2 if you want to create a new room: ");
        System.out.println("Type 3 if you want to create a new speaker: ");
        System.out.println("Type 4 if you want to assign a speaker to an event: ");
        System.out.println("Type 5 if you want to create a new event: ");
        return answer();
    }

    @Override
    public int SpeakerMenu() {
        System.out.println("Welcome to the menu!");
        System.out.println("Type 1 if you want to open the Messenger: ");
        System.out.println("Type 2 if you want to see a list of talks you are given: ");
        return answer();
    }

    @Override
    public void SorryMessenger() {
        System.out.println("Sorry! You can't reply to a message, since no one can send a message to you!");
    }

    @Override
    public void SignUpEventMessage() {
        System.out.println("Hey! You just sign up a new event! Arrive on time! ");
    }

    @Override
    public void SignUpEventErr() {
        System.out.println("Sorry! You can't sign up for the event. Please check again!");
    }

    @Override
    public void AddNewRoom() {
        System.out.println("Hey! You just make a new room");
    }

    @Override
    public void AddNewRoomErr() {
        System.out.println("Sorry! We can not add the room. Please check again!");
    }

    @Override
    public void SpeakerAccCreated() {
        System.out.println("Hey! You just make a new speaker account!");

    }

    @Override
    public void SpeakerAccCreatedErr() {
        System.out.println("Sorry! We can not add the speaker. Please check again!");
    }

    @Override
    public void SpeakerSet() {
        System.out.println("Hey! You just make set a speaker for event!");

    }

    @Override
    public void SpeakerSetErr() {
        System.out.println("Sorry! We can not set the speaker for the event. Please check again!");
    }

    @Override
    public void CancelEventMessage() {
        System.out.println("You have just canceled an amazing event!");

    }

    @Override
    public void MessageErr() {
        System.out.println("Oops, something went wrong! Please check again!");

    }

    @Override
    public void MessageSuccess() {
        System.out.println("Message sent successfully!");

    }

    public void invalidInput(){
        System.out.println("Hey! That's an invalid input! please try again!");
    }


    public String SignUpEvent(){
        Console c=System.console();
        System.out.println("Enter the event id you would like to attend");
        String eventID = c.readLine();
        return eventID;
    }


    public String addRoom(){
        Console c = System.console();
        System.out.println("Enter the room name you want to add");
        String room = c.readLine();
        return room;
    }

    public String[]  speakerAdder(){
        Console c=System.console();
        System.out.println("Enter the username of the speaker you want to add: ");
        String speaker_name = c.readLine();
        System.out.println("Enter the password of the speaker you want to add: ");
        String speaker_pass = c.readLine();
        String[] l = new String[]{speaker_name, speaker_pass};
        return l;
    }

    public String[] setSpeakerEvent(){
        Console c = System.console();
        System.out.println("Enter the ID of the speaker you want to set for an event: ");
        String speaker_id = c.readLine();
        System.out.println("Enter the event ID you want to set the speaker for: ");
        String event_id = c.readLine();
        String[] l = {speaker_id, event_id};
        return l;
    }
    public String cancelEnrollment(){
        Console c = System.console();
        System.out.println("Enter the ID of the event you want to cancel: ");
        String event_id = c.readLine();
        return event_id;
    }

    private String AskForUser(){
        Console c = System.console();
        System.out.println("What is the ID of the User you want to send message to?");
        String user_id = c.readLine();
        return user_id;
    }

    private String AskForEvent(){
        Console c = System.console();
        System.out.println("What is the ID of the event the user you want to message to is in?");
        String event_id = c.readLine();
        return event_id;
    }

    private String AskForMessage(){
        Console c = System.console();
        System.out.println("Type what you want to send there");
        String message = c.readLine();
        return message;
    }

    public String[] replyMessage(List<String> receive_message){
        int i = 0;
        for (String m: receive_message){
            System.out.println("Message" + i + ": " + m);
            i = i + 1;
        }
        Console c = System.console();
        System.out.println("Enter the number of the message you want to reply here: ");
        String num = c.readLine();
        System.out.println("Enter what you want to reply here: ");
        String reply = c.readLine();
        String[] l = {num, reply};
        return l;
    }

    public String[] MessageAllAttendeeEvent(){
        String event_id = AskForEvent();
        String message = AskForMessage();
        String[] l = {event_id, message};
        return l;
    }

    public String messageAllUsersInAllSpeakingEvents(){
        String message = AskForMessage();
        return message;
    }

    public String[] messageOneSpecificUserInEvent(){
        String event_id = AskForEvent();
        String user_id = AskForUser();
        String message = AskForMessage();
        String[] l = {event_id, user_id, message};
        return l;
    }

    public String messageAllSpeakers(){
        String message = AskForMessage();
        return message;
    }

    public String[] messageSpeaker(){
        String user_id = AskForUser();
        String message = AskForMessage();
        String[] l = {user_id,message};
        return l;
    }

    public String messageAllAttendee(){
        String message = AskForMessage();
        return message;
    }


    public String[] messageAttendee() {
        String n = AskForUser();
        String k = AskForMessage();
        String[] l = new String[]{n, k};
        return l;
    }

    private String AskStartTime(){
        Console c = System.console();
        System.out.println("When does the event start at? Format: YYYY--MM--DD HH-MM");
        String start = c.readLine();
        return start;
    }

    private String AskTopic(){
        Console c = System.console();
        System.out.println("What is the topic of the event");
        String topic = c.readLine();
        return topic;
    }

    public String[] newEvent(){
        String start = AskStartTime();
        String user_id = AskForUser();
        String topic = AskTopic();
        Console c = System.console();
        System.out.println("What is the room number where the event takes place?");
        String room = c.readLine();
        String[] l = {start, user_id, topic, room};
        return l;
    }

}
