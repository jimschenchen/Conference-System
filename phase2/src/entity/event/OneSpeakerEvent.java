package entity.event;

import java.time.LocalDateTime;

public abstract class OneSpeakerEvent extends Event{
    private int speakerId;
    public OneSpeakerEvent(int speakerId, LocalDateTime startTime, LocalDateTime endTime,
                           int eventId, String title, int roomId, int capacity) {
        super(startTime, endTime, eventId, title, roomId, capacity);
        this.speakerId = speakerId;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }
}