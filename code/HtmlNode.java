import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a HTML tree Node.
 * Each node has a tag (key), text, and its children.
 */
public class HtmlNode {
    
    private String tag;
    private String text;
    private List<HtmlNode> children;

    /**
     * Creates a new HtmlNode
     * 
     * @param tag the HTML tag
     */
    public HtmlNode(String tag) {
        this.tag = tag;
        this.text = "";
        this.children = new ArrayList<>();
    }

    /**
     * Adds a child to the node
     * @param node child
     */
    public void addChild(HtmlNode node) {
        children.add(node);
    }

    /**
     * Gets all node's children
     * @return children List
     */
    public List<HtmlNode> getChildren() {
        return children;
    }

    /**
     * Sets the node text
     * @param txt the text
     */
    public void setText(String txt) {
        text = txt;
    }

    /**
     * Gets the node text
     * @return txt the text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the node tag
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return text;
    }
}
