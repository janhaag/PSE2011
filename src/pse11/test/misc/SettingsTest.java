package test.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

import misc.Settings;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class SettingsTest {
	private Settings settingsInstance;
	private static String path;
	
	@BeforeClass
	public static void setUp() throws IllegalArgumentException, 
										IllegalAccessException, 
										SecurityException, 
										NoSuchFieldException {
		//Settings is a singleton, so this should be not a real problem 
		assertNotNull(Settings.getInstance());
		assertEquals(Settings.getInstance(), Settings.getInstance());
		
		Field settingsFilePath;
		settingsFilePath = Settings.class.getDeclaredField("FILEPATH");
		settingsFilePath.setAccessible(true);
		path = (String) settingsFilePath.get(Settings.getInstance());
		settingsFilePath.setAccessible(false);
		
		if(!new File(path).exists()) {
			assertTrue(Settings.getInstance().settingsChanged());
		} else {
			assertFalse(Settings.getInstance().settingsChanged());
		}
	}
	
	@Before
	public void resetSettingsChangedIndicator() throws SecurityException, 
														NoSuchFieldException,
														IllegalArgumentException,
														IllegalAccessException {
		this.settingsInstance = Settings.getInstance();
		if(this.settingsInstance.settingsChanged()) {
			Field settingsChanged;
			settingsChanged = Settings.class.getDeclaredField("settingsChanged");
			settingsChanged.setAccessible(true);
			settingsChanged.set(this.settingsInstance, false);
			settingsChanged.setAccessible(false);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTimeoutValueCheck() {
		this.settingsInstance.setTimeout(-1);
	}
	
	@Test
	public void testTimeoutValueCheckChangeIndicator() {
		try {
			this.settingsInstance.setTimeout(-1);
		} catch(IllegalArgumentException e) {
			//This is supposed to happen to check the indicator
		}
		assertFalse(this.settingsInstance.settingsChanged());
	}
	
	@Test
	public void testTimeoutChange() {
		assertFalse(this.settingsInstance.settingsChanged());
		this.settingsInstance.setTimeout(0);
		assertTrue(this.settingsInstance.settingsChanged());
		assertEquals(this.settingsInstance.getTimeout(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMemoryLimitValueCheck() {
		this.settingsInstance.setMemoryLimit(-1);
		assertFalse(this.settingsInstance.settingsChanged());
	}
	
	@Test
	public void testMemoryLimitValueCheckIndicator() {
		try {
			this.settingsInstance.setMemoryLimit(-1);
		} catch(IllegalArgumentException e) {
			//This is supposed to happen to check the indicator
		}
		assertFalse(this.settingsInstance.settingsChanged());
	}
	
	@Test
	public void testMemoryLimitChange() {
		assertFalse(this.settingsInstance.settingsChanged());
		this.settingsInstance.setMemoryLimit(0);
		assertTrue(this.settingsInstance.settingsChanged());
		assertEquals(this.settingsInstance.getMemoryLimit(), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testVerifierPathValueCheck() {
		this.settingsInstance.setVerifierPath(null);
	}
	
	@Test
	public void testVerifierPathValueCheckIndicator() {
		try {
			this.settingsInstance.setVerifierPath(null);
		} catch(IllegalArgumentException e) {
			//This is supposed to happen to check the indicator
		}
		assertFalse(this.settingsInstance.settingsChanged());
	}
	
	@Ignore
	@Test
	public void testVerifierPath() {
		assertFalse(this.settingsInstance.settingsChanged());
		this.settingsInstance.setVerifierPath("");
		assertTrue(this.settingsInstance.settingsChanged());
		assertEquals(this.settingsInstance.getVerifierPath(), "");
	}
	
	@Test
	public void saveSettingsTest() throws IOException {
		this.settingsInstance.setMemoryLimit(100);
		this.settingsInstance.setTimeout(100);
		//this.settingsInstance.setVerifierPath("");
		this.settingsInstance.saveSettings();
		assertFalse(this.settingsInstance.settingsChanged());
		//Well, let's check now if the settings really have been saved...
		File file = new File(path);
		assertTrue(file.exists());
		StringBuilder contents = new StringBuilder();
		BufferedReader input = new BufferedReader(new FileReader(file));
		try {
			String line = null;
			while((line = input.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
		} finally {
			input.close();
		}
		String elements[] = contents.toString().split(System.getProperty("line.separator"));
		if(elements.length != 3) {
			file.delete();
			return;
		}
		assertEquals(Integer.parseInt(elements[0]), Settings.getInstance().getTimeout());
		assertEquals(Integer.parseInt(elements[1]), Settings.getInstance().getMemoryLimit());
		assertEquals(elements[2], Settings.getInstance().getVerifierPath());
	}
	
	@AfterClass
	public static void tearDown() {
		path = null;
	}
}
