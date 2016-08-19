package org.thebubbleindex.swing;

import java.util.List;
import javax.swing.SwingWorker;

import org.thebubbleindex.data.UpdateData;
import org.thebubbleindex.logging.Logs;
import org.thebubbleindex.util.Utilities;

/**
 *
 * @author green
 */
public class UpdateWorker extends SwingWorker<Boolean, String> {

	final private GUI gui;
	final private String quandlKey;

	public UpdateWorker(final GUI gui, final String quandlKey) {
		this.gui = gui;
		this.quandlKey = quandlKey;
	}

	@Override
	protected Boolean doInBackground() {
		Logs.myLogger.info("Update button clicked");

		new UpdateData(this, quandlKey);
		return true;
	}

	@Override
	public void done() {
		gui.resetGUI();
	}

	public void publishText(final String text) {
		publish(text);
	}

	@Override
	protected void process(final List<String> textList) {
		for (final String text : textList)
			Utilities.displayOutput(text, false);
	}

}