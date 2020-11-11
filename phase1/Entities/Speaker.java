import java.util.ArrayList;
import java.util.List;

public class Speaker extends User{

    private ArrayList<Integer> giving_event_list;


    public Speaker(int uid, String password, String name) {
        super(uid, password, name);
        this.giving_event_list = new ArrayList<>();
    }

    public boolean addGivingEvent (int eid){
        if (giving_event_list.contains(eid)) {
            return false;
        }
        else {
        giving_event_list.add(eid);
        return true;
        }
    }

    public ArrayList<Integer> get_GivingEventList(){
        return giving_event_list;
    }
}
