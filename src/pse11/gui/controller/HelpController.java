package gui.controller;

import gui.HelpBox;
import gui.HelpFrame;
import misc.Help;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class HelpController {
	private Help help;
	private HelpFrame helpFrame;
	private HelpBox helpBox;

	public HelpController(Help help, HelpBox helpBox) {
		this.help = help;
		this.helpBox = helpBox;
		helpBox.addSelectionListener(new HelpBoxSearchListener());
	}

	public void setHelpFrame(HelpFrame helpFrame) {
		this.helpFrame = helpFrame;
	}

	public String[] getTableOfContents() {
		return this.help.getTableOfContents();
	}

	public SelectionListener getHelpFrameListSelectionListener() {
		return new HelpFrameListSelectionListener();
	}

	private class HelpBoxSearchListener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent e) {
			String search = helpBox.getSearchText();
			if (search != null && !(search.equals(""))) {
				String similarTag = findSimilarTag(search, help.getTags());
				String helpText = help.getHelpByTag(similarTag);

				String styleSheet = help.getSmallStyle();
				helpText = helpText.replaceAll("<head>", "<head><style type=\"text/css\"><!--" + styleSheet + "--></style>");
				helpBox.setText(helpText);
			}
		}

		public String findSimilarTag(String search, String[] tags) {
			// calculate Levenshtein distance to every tag and return tag with
			// lowest distance
			String similarTag = "";
			int similarDistance = Integer.MAX_VALUE;
			for (int i = 0; i < tags.length; i++) {
				int dist = distance(search, tags[i]);
				if (dist < similarDistance) {
					similarTag = tags[i];
					similarDistance = dist;
				}
			}
			return similarTag;
		}

		private int distance(String a, String b) {
			// Levenshtein distance between String a and b
			if (a == null || b == null) {
				throw new NullPointerException();
			}
			int d[][] = new int[a.length() + 1][b.length() + 1];
			for (int i = 0; i <= a.length(); i++) {
				d[i][0] = i;
			}
			for (int i = 0; i <= b.length(); i++) {
				d[0][i] = i;
			}

			for (int i = 1; i <= a.length(); i++) {
				for (int j = 1; j <= b.length(); j++) {
					if (a.charAt(i - 1) == b.charAt(j - 1)) {
						d[i][j] = d[i - 1][j - 1];
					} else {
						d[i][j] = Math.min(d[i - 1][j] + 1, Math.min(d[i][j - 1] + 1, d[i - 1][j - 1] + 1));
					}
				}
			}

			return d[a.length()][b.length()];
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			return;
		}
	}

	private class HelpFrameListSelectionListener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent e) {
			String[] selection = helpFrame.getList().getSelection();
			if (selection.length == 1) {
				String helpText = help.getHelpByTOC(selection[0]);
				String styleSheet = help.getDefaultStyle();
				helpText = helpText.replaceAll("<head>", "<head><style type=\"text/css\"><!--" + styleSheet + "--></style>");
				helpFrame.setText(helpText);
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			return;
		}
	}
}
