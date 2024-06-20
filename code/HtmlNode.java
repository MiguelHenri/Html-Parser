import java.util.List;
import java.util.ArrayList;

/* 
 * This class represents a HTML tree node.
 * Each node has a tag (key), text (value), and its children.
 */
public class HtmlNode {
    // Attributes
    private String tag;
    private String text;
    private List<HtmlNode> children;

    // Constructor
    public HtmlNode(String tag) {
        this.tag = tag;
        this.text = "";
        this.children = new ArrayList<>();
    }

    public void addChild(HtmlNode node) {
        children.add(node);
    }

    public List<HtmlNode> getChildren() {
        return children;
    }

    public void setText(String txt) {
        text = txt;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return text;
    }
}
