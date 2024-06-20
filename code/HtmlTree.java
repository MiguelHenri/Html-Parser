import java.util.LinkedList;
import java.util.Queue;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

/*
 * This class represents the HTML tree itself.
 */
public class HtmlTree {
    // Attributes
    private String htmlString;
    private HtmlNode rootNode;
    
    // Constructor
    public HtmlTree(String HtmlString) {
        this.htmlString = HtmlString;
        this.rootNode = null;
    }

    // This function builds the HTML tree from the HTML string
    public void buildHtmlTree() {

        // Variables used to iterate HTML line by line
        StringReader stringReader = new StringReader(htmlString);
        Scanner htmlScanner = new Scanner(stringReader);

        // Stack used to build Tree
        Stack<HtmlNode> stackNode = new Stack<>();

        // Iterating HTML line by line
        while (htmlScanner.hasNextLine()) {

            // Reading line and removing blank space
            String line = htmlScanner.nextLine().trim();

            // Checking empty line
            if (line.isEmpty()) continue;

            // If is a Closing Tag
            if (line.startsWith("</")) {
                // Removes Node from the stack
                HtmlNode removed = stackNode.pop();
                
                // Checks if tags are the same
                String removedTag = line.substring(2, line.indexOf('>'));
                if (!removedTag.equals(removed.getTag())) {
                    htmlScanner.close();
                    throw new HtmlException("malformed HTML");
                }
            }
            // If is a New Tag
            else if (line.startsWith("<")) {
                // Reading the tag and creating node
                String newTag = line.substring(1, line.indexOf('>'));
                HtmlNode newNode = new HtmlNode(newTag);

                // Adding node to the tree
                if (rootNode == null) {
                    rootNode = newNode;
                }
                else {
                    // Getting the parent Node
                    HtmlNode parent = stackNode.peek();
                    // Adding newNode as child
                    parent.addChild(newNode);
                }

                // Pushing newNode to stack
                stackNode.push(newNode);
            }
            // Text
            else {
                // Getting last tag opened
                HtmlNode last = stackNode.peek();
                last.setText(line);
            }
            
        }

        htmlScanner.close();
        stringReader.close();
    }

    // This function uses BFS to get the text at the deepest HTML tree level
    public String getDeepestText() {

        String deepestText = "";
        int deepestTextLevel = -1;

        Queue<HtmlNode> queueNode = new LinkedList<>();
        queueNode.add(rootNode); // Starting from root node
        int currentLevel = 0;

        while (!queueNode.isEmpty()) {

            int levelSize = queueNode.size();

            // Iterating over all elements of current level
            for (int i = 0; i < levelSize; i++) {

                HtmlNode currentNode = queueNode.poll();

                if (currentLevel > deepestTextLevel && 
                    currentNode.getText() != "") {
                    
                    deepestTextLevel = currentLevel;
                    deepestText = currentNode.getText();
                }

                // Adding all children to queue
                for (HtmlNode child : currentNode.getChildren()) {
                    queueNode.add(child);
                }

            }

            currentLevel += 1;
        }

        return deepestText;
    }
}
