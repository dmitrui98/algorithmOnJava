package common.data.structure;

public class TreeNode<T> {
    public T item;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        String l = left == null ? "null" : left.item.toString();
        String r = right == null ? "null" : right.item.toString();
        return String.format("Node(%s); left: %s; right: %s", item, l, r);
    }
}
