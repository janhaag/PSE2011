package misc;

public class Settings {
	private int timeout;
	private int memoryLimit;
	private Settings settings;
	private boolean settingsChanged;
	private Settings() {
		this.settingsChanged = false;
		loadSettings();
	}
	public Settings getInstance() {
		return this.settings == null ? (this.settings = new Settings()) : this.settings;
	}
	public int getTimeout() {
		return this.timeout;
	}
	public int getMemoryLimit() {
		return this.memoryLimit;
	}
	public void setTimeout(int timeout) {
		if(this.timeout != timeout) {
			this.timeout = timeout;
			this.settingsChanged = true;
		}
	}
	public void setMemoryLimit(int memoryLimit) {
		if(this.memoryLimit != memoryLimit) {
			this.memoryLimit = memoryLimit;
			this.settingsChanged = true;
		}
	}
	public boolean settingsChanged() {
		return this.settingsChanged;
	}
	public void saveSettings() {
		this.settingsChanged = false;
		//TODO Settings in Datei schreiben
	}
	private void loadSettings() {
		//TODO Settings aus Datei laden
		this.memoryLimit = 99;
		this.timeout = 99;
	}
}
