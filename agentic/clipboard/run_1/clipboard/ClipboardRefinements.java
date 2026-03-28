package agentic.clipboard.run_1.clipboard;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.Transferable;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.datatransfer.Clipboard")
@StateSet({"available", "unavailable"})
public interface ClipboardRefinements {

    @StateRefinement(to = "available(this)")
    public void Clipboard(String name);

    public String getName();

    public void addFlavorListener(FlavorListener listener);

    public void removeFlavorListener(FlavorListener listener);

    public FlavorListener[] getFlavorListeners();

    @StateRefinement(from = "available(this)")
    public DataFlavor[] getAvailableDataFlavors();

    @StateRefinement(from = "available(this)")
    public Transferable getContents(Object requestor);

    @StateRefinement(from = "available(this)")
    public Object getData(DataFlavor flavor);

    @StateRefinement(from = "available(this)")
    public boolean isDataFlavorAvailable(DataFlavor flavor);

    @StateRefinement(from = "available(this)", to = "unavailable(this)")
    @StateRefinement(from = "unavailable(this)", to = "available(this)")
    public void setContents(Transferable contents, ClipboardOwner owner);

}
