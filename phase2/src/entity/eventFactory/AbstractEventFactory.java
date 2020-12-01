package entity.eventFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import entity.event.*;

public abstract class AbstractEventFactory {

    public abstract Event getNonSpeakerEvent(int type, LocalDateTime startTime, LocalDateTime endTime,
                                             int eventId, String title, int roomId, int capacity);
    public abstract Event getOneSpeakerEvent(int type, int speakerId, LocalDateTime startTime, LocalDateTime endTime,
                                             int eventId, String title, int roomId, int capacity);
    public abstract Event getMultiSpeakerEvent(int type, ArrayList<Integer> speakerList, LocalDateTime startTime, LocalDateTime endTime,
                                               int eventId, String title, int roomId, int capacity);
}