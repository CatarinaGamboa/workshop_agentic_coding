package agentic.defaultmutabletreenode.run_5.defaultmutabletreenode;

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
@StateSet({"allowschildren", "doesnotallowchildren", "maybeallowschildren"})
public interface DefaultMutableTreeNodeRefinements {

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode();

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject);

    @StateRefinement(to = "maybeallowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject, boolean allowsChildren);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void insert(MutableTreeNode newChild, @Refinement("NonNegative(childIndex)") int childIndex);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void remove(MutableTreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void remove(@Refinement("NonNegative(childIndex)") int childIndex);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void removeAllChildren();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void add(MutableTreeNode newChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void setParent(MutableTreeNode newParent);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void setUserObject(Object userObject);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void removeFromParent();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getParent();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getChildAt(@Refinement("NonNegative(index)") int index);

    @Refinement("NonNegative(_)")
    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public int getChildCount();

    @Refinement("_ >= -1")
    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public int getIndex(TreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> children();

    @StateRefinement(from = "allowschildren(this)", to = "doesnotallowchildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)", to = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)", to = "allowschildren(this)")
    public void setAllowsChildren(boolean allows);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean getAllowsChildren();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeAncestor(TreeNode anotherNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeDescendant(DefaultMutableTreeNode anotherNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getSharedAncestor(DefaultMutableTreeNode aNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeRelated(DefaultMutableTreeNode aNode);

    @Refinement("NonNegative(_)")
    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public int getDepth();

    @Refinement("NonNegative(_)")
    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public int getLevel();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode[] getPath();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode[] getPathToRoot(TreeNode aNode, @Refinement("NonNegative(depth)") int depth);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Object[] getUserObjectPath();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getRoot();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isRoot();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getNextNode();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getPreviousNode();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> preorderEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> postorderEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> breadthFirstEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> depthFirstEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> pathFromAncestorEnumeration(TreeNode ancestor);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeChild(TreeNode aNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getFirstChild();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getLastChild();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getChildAfter(TreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getChildBefore(TreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeSibling(TreeNode anotherNode);

    @Refinement("_ >= 1")
    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public int getSiblingCount();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getNextSibling();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getPreviousSibling();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getFirstLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getLastLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getNextLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getPreviousLeaf();

    @Refinement("_ >= 1")
    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public int getLeafCount();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public String toString();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Object clone();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "doesnotallowchildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Object getUserObject();

}
