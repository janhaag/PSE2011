package test.misc;


import static org.junit.Assert.*;

import gui.Console;

import java.util.ArrayList;

import misc.Message;
import misc.MessageCategories;
import misc.MessageSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageTest {
	private Message msg;
	private Message msg2;
	private MessageSystem msgsys;

	@Before
	public void setUp() {
		this.msg = new Message(MessageCategories.ERROR, 0, "Error");
		this.msg2 = new Message(MessageCategories.ERROR, 0, "Error", "Result");
		this.msgsys = new MessageSystem();
	}

	/* Message tests */
	@Test
	public void getCategoriesTest() {
		assertEquals(MessageCategories.ERROR, this.msg.getCategory());
	}
	
	@Test
	public void getPositionTest() {
		assertEquals(0, this.msg.getPosition());
	}
	
	@Test
	public void getTextTest() {
		assertEquals("Error", this.msg.getText());
	}
	
	@Test
	public void getResultTest() {
		assertEquals("Result", this.msg2.getResult());
	}
	
	/* MessageSystem tests */
	@Test
	public void getConsolesTest() {
		ArrayList<Console> list = new ArrayList<Console>();
		assertEquals(list, this.msgsys.getConsoles());
	}
	
	@Test
	public void getMessagesTest() {
		ArrayList<Message> list = new ArrayList<Message>();
		assertEquals(list, this.msgsys.getMessages());
	}
	
	@Test
	public void addAndRemoveConsoleTest() {
		this.msgsys.addConsole(null);
		this.msgsys.removeConsole(null);
		ArrayList<Console> list = new ArrayList<Console>();
		assertEquals(list, this.msgsys.getConsoles());
	}
	
	@Test
	public void addAndClearMessageTest() {
		this.msgsys.addMessage(MessageCategories.ERROR, 0, "Error");
		this.msgsys.addMessage(MessageCategories.MISC, 0, "Error");
		this.msgsys.addMessage(MessageCategories.VERIFYERROR, 0, "Error", "Result");	
		assertEquals(3, this.msgsys.getMessages().size());
		this.msgsys.clear(MessageCategories.ERROR);
		this.msgsys.clear(MessageCategories.MISC);
		this.msgsys.clear(MessageCategories.VERIFYERROR);
		assertEquals(0, this.msgsys.getMessages().size());
	}
	
	@After
	public void tearDown() {
		this.msg = null;
		this.msg2 = null;
	}

}
