package ArbolNArio;

import java.util.ArrayList;
import java.util.List;

public class NAryNode {
    String value;
    List<NAryNode> children;

    public NAryNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
