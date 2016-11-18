package popuuid4.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class Handler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		copyToClipboard(UUID.randomUUID().toString());
		return null;
	}

	public void copyToClipboard(String str) {
		Clipboard clipboard = builClipBoard();
		clipboard.setContents(new StringSelection(str), null);
	}

	private Clipboard builClipBoard() {
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		Clipboard systemClipboard = defaultToolkit.getSystemClipboard();
		return systemClipboard;
	}
}
