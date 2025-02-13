package ArbolB;

import java.util.ArrayList;
import java.util.List;

public class BTreeNode {
    List<Integer> keys;
    List<BTreeNode> children;
    boolean isLeaf;

    public BTreeNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }
}
