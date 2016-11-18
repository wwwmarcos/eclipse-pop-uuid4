package popuuid4.handlers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// MessageDialog.openInformation(window.getShell(), "PopUUID4", UUID.randomUUID().toString());
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
