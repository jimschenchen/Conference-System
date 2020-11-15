public interface ViewActions {
    void Introduction();
    int AreURegistered();
    String username();
    String[] SignIn();
    String Pass();
    void Credentials(String username);
    void CredentialsFail();
    int MessengerAttendee();
    int MessengerOrganizer();
    int MessengerSpeaker();
    int AttendeeMenu();
    int OrganizerMenu();
    int SpeakerMenu();
    void SorryMessenger();
    void SignUpEventMessage();
    void SignUpEventErr();
    void AddNewRoom();
    void AddNewRoomErr();
    void SpeakerAccCreated();
    void SpeakerAccCreatedErr();
    void SpeakerSet();
    void SpeakerSetErr();
    void CancelEventMessage();
    void MessageErr();
    void MessageSuccess();
}
