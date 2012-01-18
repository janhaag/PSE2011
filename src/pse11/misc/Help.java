package misc;

import gui.MainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Help {
	private static Help help;
	private Map<String, String> tableOfContents;
	private Map<String, String> tags;

	private Help() {
		// LinkedHashMap used for ordering
		tableOfContents = new LinkedHashMap<String, String>();
		tableOfContents.put("Introduction", "index.html");
		tableOfContents.put("While-Loop", "while.html");
		tableOfContents.put("If-Statement", "if.html");
		tableOfContents.put("Assertion", "assertion.html");
		tableOfContents.put("Variables", "variables.html");

		tags = new HashMap<String, String>();
		tags.put("help", "index.html");
		tags.put("loop", "while.html");
		tags.put("while", "while.html");
		tags.put("if", "if.html");
		tags.put("conditional", "if.html");
		tags.put("assert", "assertion.html");
	}

	public String[] getTableOfContents() {
		return tableOfContents.keySet().toArray(new String[0]);
	}

	public String getHelpByTOC(String tocItem) {
		if (tableOfContents.containsKey(tocItem)) {
			return loadHelpFile(tableOfContents.get(tocItem));
		} else {
			return loadHelpFile("index.html");
		}
	}

	public String getHelpByTag(String tag) {
		return loadHelpFile(tags.get(tag));
	}

	public String[] getTags() {
		return tags.keySet().toArray(new String[0]);
	}
	
	private String getFileAsString(String filename) {
		InputStream in = MainFrame.class.getResourceAsStream(filename);
		if (in != null) {
			BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			String fileText = new String();
			try {
				while ((line = inReader.readLine()) != null) {
					fileText += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileText;
		} else {
			return null;
		}
	}

	private String loadHelpFile(String filename) {
		String helpText = getFileAsString("doc/" + filename);
		if (helpText != null) {
			return helpText;
		} else {
			return "<html><head><title>File not found</title></head><body>Helpfile not found.</body></html>";
		}
	}

	public String getSmallStyle() {
		String smallStyle = getFileAsString("doc/small.css");
		if (smallStyle != null) {
			return smallStyle;
		} else {
			return "";
		}
	}
	
	public String getDefaultStyle() {
		String defaultStyle = getFileAsString("doc/default.css");
		if(defaultStyle != null) {
			return defaultStyle;
		} else {
			return "";
		}
	}

	public static Help getInstance() {
		return help == null ? (help = new Help()) : help;
	}
}
