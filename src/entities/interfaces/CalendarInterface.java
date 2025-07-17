package entities.interfaces;

import entities.utils.returnPost;

import java.time.LocalDate;
import java.util.List;

public interface CalendarInterface {
    public boolean addNote(String note,String Title,LocalDate date);
    public void deleteNote(LocalDate date);
    public List<returnPost> showNote(LocalDate day);
    public List<returnPost> showAllNotesofYear();

}
