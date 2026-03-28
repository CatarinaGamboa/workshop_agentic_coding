package agentic.defaultmutabletreenode.run_2.defaultmutabletreenode;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

@ExternalRefinementsFor("javax.swing.tree.DefaultMutableTreeNode")
@StateSet({"allowschildren", "nochildren", "maybeallowschildren"})
public interface DefaultMutableTreeNodeRefinements {

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode();

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject);

    @StateRefinement(to = "maybeallowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject, boolean allowsChildren);

    @StateRefinement(from = "allowschildren(this)", to = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)", to = "maybeallowschildren(this)")
    public void add(MutableTreeNode newChild);

    @StateRefinement(from = "allowschildren(this)", to = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)", to = "maybeallowschildren(this)")
    public void insert(MutableTreeNode newChild, @Refinement("childIndex >= 0") int childIndex);

    @StateRefinement(from = "allowschildren(this)", to = "nochildren(this)")
    @StateRefinement(from = "nochildren(this)", to = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)", to = "maybeallowschildren(this)")
    public void setAllowsChildren(boolean allows);

    public void remove(@Refinement("childIndex >= 0") int childIndex);

    public void remove(MutableTreeNode aChild);

    public TreeNode getChildAt(@Refinement("index >= 0") int index);

    @Refinement("_ >= 0")
    public int getChildCount();

    @Refinement("_ >= -1")
    public int getIndex(TreeNode aChild);

    @Refinement("_ >= 0")
    public int getDepth();

    @Refinement("_ >= 0")
    public int getLevel();

    public TreeNode[] getPathToRoot(TreeNode aNode, @Refinement("depth >= 0") int depth);

    @Refinement("_ >= 1")
    public int getSiblingCount();

    @Refinement("_ >= 1")
    public int getLeafCount();

}
