import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

//!!!ADD FUNCTION NAMES IF YOU THINK NECESSARY!!!!!!
// FEEL FREE TO ADD THEM!!! THANKSSSS :)

public class UserManager {

    public void createSpeaker(String password, String name, DataBase d){
        Speaker s = new Speaker(d.getNextUserId(), password, name);
        d.addUser(s); //汤zheng，jim， 这里是不是应该也在database里面加上一个类似于addMessage（）的方法？
    }

    // 檢查是否能addEventToSpeaker
    // 如果沒有情況是不能新增event to speaker那把method刪掉就好
    // jenna & Lihang 麻煩你們implement了
    public boolean canAddEventToSpeaker(Event event, int speakerId, DataBase d){
        Speaker s = d.getSpeakerById(speakerId);
        if (s == null) {
            return false;
        }
        else {
            ArrayList<Integer> events = s.get_GivingEventList();
            for (int i = 0; i < events.size(); i++) {
                if (d.getEventById(events.get(i)).getStart_time().equals(event.getStart_time())) {
                    return false;
                }
            }
            return true;
        }
    }

    public void addEventToSpeaker(int eventId, int speakerId, DataBase d){
        d.getSpeakerById(speakerId).addGivingEvent(eventId);
    }

    public boolean canSignUpForEvent(int eventId, int userId, DataBase d) {
        return d.getOrganizerById(userId).getEventList().contains(eventId) | d.getAttendeeById(userId).getEventList().contains(eventId);
    }

    public void addEventToAttendeeOrOrganizer(int eventId, int userId, DataBase d){
        if (d.getAttendeeById(userId) == null){
            d.getOrganizerById(userId).signUpEvent(eventId);
        }
        else{
            d.getAttendeeById(userId).signUpEvent(eventId);
        }
    }

    public void cancelEventToAttendeeOrOrganizer(int eventId, int userId, DataBase d) {
        if (d.getOrganizerById(userId) == null) {
            d.getAttendeeById(userId).cancelEvent(eventId);
        } else {
            d.getOrganizerById(userId).cancelEvent(eventId);
        }
    }

    public void setPassword(int userId,String password, DataBase d) {
        d.getUserById(userId).setPassword(password);
    }

    public String getUserName(int userId,DataBase d) {
        return d.getUserById(userId).getUserName();
    }

    public ArrayList<Integer> getOrganizerOrAttendeeEventList(int Id, DataBase d){
        if (d.getAttendeeById(Id) == null){
            return d.getOrganizerById(Id).getEventList();
        }else {
            return d.getAttendeeById(Id).getEventList();
        }
    }

    // 加了這幾個method，jenna & Lihang 可以檢查看看有沒有錯嗎？ -grace
    public List<Integer> getSpeakerEventList(int speakerID, DataBase d){
        return d.getSpeakerById(speakerID).get_GivingEventList();
    }

    public String getUserPassword(int userID, DataBase d){
        return d.getUserById(userID).getPassword();
    }

    // 不肯定這個應該放在controller還是use case，如果應該在controller請把它搬過去吧
    public int getUserCategory(int id, DataBase d){
        if (d.getSpeakerById(id) != null){
            // return 0 when id is a speaker
            return 0;
        }
        else if (d.getOrganizerById(id) != null){
            // return 1 when id is an organizer
            return 1;
        }
        else{
            // return 2 when id is an attendee
            return 2;
        }
    }


}