import java.util.ArrayList;
import java.util.List;

/*
 * CSC207.Store All the Data
 */
public class DataBase {
    /**
     * Attributes
     * NOTE: Use @SerializeName("total_number") to change the serilization rule
     */
    private int nextUserId = 0;
    private int nextEventId = 0;
    private int nextRoomId = 0;
    private int nextMessageId = 0;
    private List<User> userList = new ArrayList<>();
    private List<Event> eventList = new ArrayList<>();
    private List<Room> roomList = new ArrayList<>();
    private List<Message> messageList = new ArrayList<>();


    /**
     * === Getter & Setter ===
     */

    /** Return the next user id and self increase by 1 */
    public int getNextUserId() {
        return nextUserId++;
    }

    /** Return the next event id and self increase by 1 */
    public int getNextEventId() {
        return nextEventId++;
    }

    /** Return the next room id and self increase by 1 */
    public int getNextRoomId() {
        return nextRoomId++;
    }

    /** Return the next message id and self increase by 1 */
    public int getNextMessageId() {
        return nextMessageId++;
    }

    /**
    * @Description:
    * @Param: [id]
    * @return: User
    * @Author:
    * @Date: 2020-11-11
    */
    public User getUserById(int id) {
        ArrayList<User> userList = (ArrayList<User>) getUserList();
        for (User u : userList) {
            if (u.getUser_id() == id) {
                return u;
            }
        }
        return null;
    }
    /**
    * @Description: Return Attendee by given <id>, if the user does not exist or is not Attendee, return null
    * @Param: [id]
    * @return: Attendee
    * @Author: 
    * @Date: 2020-11-12
    */
    public Attendee getAttendeeById(int id) {
        User user = this.getUserById(id);
        if (user instanceof Attendee) {
            return (Attendee)user;
        }
        return null;
    }
    /**
    * @Description: Return Speaker by given <id>, if the user does not exist or is not Speaker, return null
    * @Param: [id]
    * @return: Speaker
    * @Author:
    * @Date: 2020-11-12
    */
    public Speaker getSpeakerById(int id) {
        User user = this.getUserById(id);
        if (user instanceof Speaker) {
            return (Speaker)user;
        }
        return null;
    }
    /**
    * @Description: Return Organizer by given <id>, if the user does not exist or is not Organizer, return null
    * @Param: [id]
    * @return: Organizer
    * @Author:
    * @Date: 2020-11-12
    */
    public Organizer getOrganizerById(int id) {
        User user = this.getUserById(id);
        if (user instanceof Organizer) {
            return (Organizer)user;
        }
        return null;
    }

    /**
    * @Description:
    * @Param: []
    * @return: java.util.List<User>
    * @Author:
    * @Date: 2020-11-11
    */
    public List<User> getUserList() {
        return userList;
    }
    /**
    * @Description: add user to user list
    * @Param: [user]
    * @return: void
    * @Author: 
    * @Date: 2020-11-12
    */
    public void addUser(User user) {   
        this.userList.add(user);
    }

    
    /**
    * @Description:
    * @Param: []
    * @return: java.util.List<Event>
    * @Author:
    * @Date: 2020-11-11
    */
    public List<Event> getEventList() {
        return eventList;
    }
    /**
    * @Description:
    * @Param: [id]
    * @return: Event
    * @Author:
    * @Date: 2020-11-11
    */
    public Event getEventById(int id) {
        ArrayList<Event> eventList = (ArrayList<Event>) getEventList();
        for (Event e : eventList) {
            if (e.getEvent_id() == id) {
                return e;
            }
        }
        return null;
    }
    /**
    * @Description: add event to event list
    * @Param: [event]
    * @return: void
    * @Author:
    * @Date: 2020-11-12
    */
    public void addEvent(Event event) {
        this.eventList.add(event);
    }

    /**
    * @Description:
    * @Param: []
    * @return: java.util.List<Room>
    * @Author:
    * @Date: 2020-11-11
    */
    public List<Room> getRoomList() {
        return roomList;
    }
    /**
    * @Description:
    * @Param: [id]
    * @return: Room
    * @Author:
    * @Date: 2020-11-11
    */
    public Room getRoomById(int id) {
        ArrayList<Room> roomList = (ArrayList<Room>) getRoomList();
        for (Room r : roomList) {
            if (r.getRid() == id) {
                return r;
            }
        }
        return null;
    }
    /**
    * @Description: add room to room list
    * @Param: [room]
    * @return: void
    * @Author: 
    * @Date: 2020-11-12
    */
    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    /**
    * @Description:
    * @Param: []
    * @return: java.util.List<Message>
    * @Date: 2020-11-11
    */
    public List<Message> getMessageList() {
        return messageList;
    }
    /**
    * @Description: Return the List of messages related to <userId>; Cannot add message
    * @Param: [userId]
    * @return: java.util.List<Message>
    * @Date: 2020-11-11
    */
    public List<Message> getMessageListByUserId(int userId) {
        ArrayList<Message> messageList = (ArrayList<Message>) getMessageList();
        List<Message> ret = new ArrayList<>();
        for (Message m : messageList) {
            if (m.getReceiverId() == userId || m.getSenderId() == userId) {
                ret.add(m);
            }
        }
        return ret;
    }
    /**
    * @Description: add Message to the Message List
    * @Param: [message]
    * @return: void
    * @Author: 
    * @Date: 2020-11-12
    */
    public void addMessage(Message message) {
        this.messageList.add(message);
    }

}
