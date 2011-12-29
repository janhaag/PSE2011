package misc;

/**
 * This class provides an instance for reading and writing settings into an external
 * file.
 * 
 * This class uses the Singleton-Pattern to ensure a problem-free read/write access to
 * the external setting file. You may get the instance of this class with:
 * {@link Settings#getInstance()}.
 * 
 * @version 1.0
 */
public class Settings {
	/**
	 * the timeout time of the verifier
	 */
	private int timeout;
	/**
	 * the maximum amount of memory which can be used by the verifier
	 */
	private int memoryLimit;
	/**
	 * instance of this class
	 */
	private Settings settings;
	/**
	 * indicates whether the settings have been changed
	 */
	private boolean settingsChanged;
	/**
	 * Constructs a new instance of this class.
	 */
	private Settings() {
		this.settingsChanged = false;
		loadSettings();
	}
	/**
	 * Returns the instance of this class.
	 * 
	 * The instance will be created if it doesn't exist already.
	 * 
	 * @return the instance of this class
	 */
	public Settings getInstance() {
		return this.settings == null ? (this.settings = new Settings()) : this.settings;
	}
	/**
	 * Returns the timeout time for the verifier.
	 * 
	 * @return the timeout time for the verifier
	 */
	public int getTimeout() {
		return this.timeout;
	}
	/**
	 * Returns the maximum amount of memory which may be used by the verifier.
	 * 
	 * @return the maximum amount of memory for the verifier
	 */
	public int getMemoryLimit() {
		return this.memoryLimit;
	}
	/**
	 * Sets the timeout time to the specified value.
	 * 
	 * @param timeout the new timeout time
	 */
	public void setTimeout(int timeout) {
		if(this.timeout != timeout) {
			this.timeout = timeout;
			this.settingsChanged = true;
		}
	}
	/**
	 * Sets the maximum amount of memory which may be used by the verifier to the
	 * specified value.
	 * 
	 * @param memoryLimit the maximum amount of memory usable by the verifier
	 */
	public void setMemoryLimit(int memoryLimit) {
		if(this.memoryLimit != memoryLimit) {
			this.memoryLimit = memoryLimit;
			this.settingsChanged = true;
		}
	}
	/**
	 * Returns <code>true</code> when the settings have been changed and <code>false</code>
	 * otherwise.
	 * 
	 * @return <code>true</code> when the settings have been changed, <code>false</code> otherwise
	 */
	public boolean settingsChanged() {
		return this.settingsChanged;
	}
	/**
	 * Saves the settings in an external file. The settings will not be saved if they
	 * are unchanged (@see {@link Settings#settingsChanged()}).
	 */
	public void saveSettings() {
		this.settingsChanged = false;
		//TODO Settings in Datei schreiben
	}
	/**
	 * Loads the settings from an external file.
	 */
	private void loadSettings() {
		//TODO Settings aus Datei laden
		this.memoryLimit = 99;
		this.timeout = 99;
	}
}
