package ru.turumbay.demo.notes;

import junit.framework.Test;
import junit.framework.TestCase;
import lotus.domino.*;

public class AppTest extends TestCase {
    public void testApp() throws NotesException {
        Session session = null;
        try {
            NotesThread.sinitThread();
            session = NotesFactory.createSession();
            System.out.println(session.getUserName());
            Database db = session.getDatabase("", "names.nsf");
            assertEquals("StdR4PublicAddressBook", db.getDesignTemplateName());
        } finally {
            try {
                if (null != session) {session.recycle();}
            } catch (NotesException ignored) {}
            NotesThread.stermThread();
        }
    }
}
