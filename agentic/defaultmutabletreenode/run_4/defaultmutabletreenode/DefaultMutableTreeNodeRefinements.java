package agentic.defaultmutabletreenode.run_4.defaultmutabletreenode;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

@ExternalRefinementsFor("javax.swing.tree.DefaultMutableTreeNode")
@StateSet({"allowschildren", "nochildren", "maybeallowschildren"})
public interface DefaultMutableTreeNodeRefinements {

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode();

    @StateRefinement(to = "allowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject);

    @StateRefinement(to = "maybeallowschildren(this)")
    public void DefaultMutableTreeNode(Object userObject, boolean allowsChildren);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void insert(MutableTreeNode newChild, @Refinement("childIndex >= 0") int childIndex);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void remove(@Refinement("childIndex >= 0") int childIndex);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void setParent(MutableTreeNode newParent);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getParent();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getChildAt(@Refinement("index >= 0") int index);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public @Refinement("_ >= 0") int getChildCount();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public @Refinement("_ >= -1") int getIndex(TreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> children();

    @StateRefinement(from = "allowschildren(this)", to = "nochildren(this)")
    @StateRefinement(from = "nochildren(this)", to = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void setAllowsChildren(boolean allows);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean getAllowsChildren();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void setUserObject(Object userObject);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Object getUserObject();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void removeFromParent();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void remove(MutableTreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void removeAllChildren();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public void add(MutableTreeNode newChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeAncestor(TreeNode anotherNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeDescendant(DefaultMutableTreeNode anotherNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getSharedAncestor(DefaultMutableTreeNode aNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeRelated(DefaultMutableTreeNode aNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public @Refinement("_ >= 0") int getDepth();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public @Refinement("_ >= 0") int getLevel();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode[] getPath();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode[] getPathToRoot(TreeNode aNode, @Refinement("depth >= 0") int depth);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Object[] getUserObjectPath();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getRoot();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isRoot();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getNextNode();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getPreviousNode();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> preorderEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> postorderEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> breadthFirstEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> depthFirstEnumeration();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Enumeration<TreeNode> pathFromAncestorEnumeration(TreeNode ancestor);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeChild(TreeNode aNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getFirstChild();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getLastChild();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getChildAfter(TreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public TreeNode getChildBefore(TreeNode aChild);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isNodeSibling(TreeNode anotherNode);

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public @Refinement("_ >= 1") int getSiblingCount();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getNextSibling();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getPreviousSibling();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public boolean isLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getFirstLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getLastLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getNextLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public DefaultMutableTreeNode getPreviousLeaf();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public @Refinement("_ >= 1") int getLeafCount();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public String toString();

    @StateRefinement(from = "allowschildren(this)")
    @StateRefinement(from = "nochildren(this)")
    @StateRefinement(from = "maybeallowschildren(this)")
    public Object clone();

}
