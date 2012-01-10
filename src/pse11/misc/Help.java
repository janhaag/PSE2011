package misc;

public class Help {
	private Help help;
	//TODO evt hashmap
	private String text[];
	private Help() {
		String helpText = this.loadHelp();
		this.text = this.parseText(helpText);
	}
	public Help getInstance() {
		return help == null ? (this.help = new Help()) : this.help; 
	}
	private String loadHelp() {
		//TODO Lesen
		return null;
	}
	private String[] parseText(String text) {
		return null;
	}
}
