package agentic.defaultmutabletreenode.run_3.defaultmutabletreenode;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

@RefinementAlias("NonNegative(int x) { x >= 0 }")
@ExternalRefinementsFor("javax.swing.tree.DefaultMutableTreeNode")
@StateSet({"allowschildren", "leafonly", "maybeallowschildren"})
public interface DefaultMutableTreeNodeRefinements {

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode();

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject);

    @StateRefinement(to = "maybeallowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject, boolean allowsChildren);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void add(MutableTreeNode newChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void insert(MutableTreeNode newChild, @Refinement("NonNegative(childIndex)") int childIndex);

    @StateRefinement(from = "allowschildren(this)", to = "leafonly(this)")
    @StateRefinement(from = "leafonly(this)", to = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)", to = "allowschildren(this)")
    public void setAllowsChildren(boolean allows);

    public void remove(@Refinement("NonNegative(childIndex)") int childIndex);

    public void remove(MutableTreeNode aChild);

    public void setParent(MutableTreeNode newParent);

    public TreeNode getParent();

    public TreeNode getChildAt(@Refinement("NonNegative(index)") int index);

    @Refinement("NonNegative(_)")
    public int getChildCount();

    @Refinement("_ >= -1")
    public int getIndex(TreeNode aChild);

    public Enumeration<TreeNode> children();

    public boolean getAllowsChildren();

    public void setUserObject(Object userObject);

    public Object getUserObject();

    public void removeFromParent();

    public void removeAllChildren();

    public boolean isNodeAncestor(TreeNode anotherNode);

    public boolean isNodeDescendant(DefaultMutableTreeNode anotherNode);

    public TreeNode getSharedAncestor(DefaultMutableTreeNode aNode);

    public boolean isNodeRelated(DefaultMutableTreeNode aNode);

    @Refinement("NonNegative(_)")
    public int getDepth();

    @Refinement("NonNegative(_)")
    public int getLevel();

    public TreeNode[] getPath();

    public TreeNode[] getPathToRoot(TreeNode aNode, @Refinement("NonNegative(depth)") int depth);

    public Object[] getUserObjectPath();

    public TreeNode getRoot();

    public boolean isRoot();

    public DefaultMutableTreeNode getNextNode();

    public DefaultMutableTreeNode getPreviousNode();

    public Enumeration<TreeNode> preorderEnumeration();

    public Enumeration<TreeNode> postorderEnumeration();

    public Enumeration<TreeNode> breadthFirstEnumeration();

    public Enumeration<TreeNode> depthFirstEnumeration();

    public Enumeration<TreeNode> pathFromAncestorEnumeration(TreeNode ancestor);

    public boolean isNodeChild(TreeNode aNode);

    public TreeNode getFirstChild();

    public TreeNode getLastChild();

    public TreeNode getChildAfter(TreeNode aChild);

    public TreeNode getChildBefore(TreeNode aChild);

    public boolean isNodeSibling(TreeNode anotherNode);

    @Refinement("_ >= 1")
    public int getSiblingCount();

    public DefaultMutableTreeNode getNextSibling();

    public DefaultMutableTreeNode getPreviousSibling();

    public boolean isLeaf();

    public DefaultMutableTreeNode getFirstLeaf();

    public DefaultMutableTreeNode getLastLeaf();

    public DefaultMutableTreeNode getNextLeaf();

    public DefaultMutableTreeNode getPreviousLeaf();

    @Refinement("_ >= 1")
    public int getLeafCount();

    public String toString();

    public Object clone();

}
