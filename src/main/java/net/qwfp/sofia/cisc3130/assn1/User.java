package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Defines the user interface <br>
 * Application follows a Read-Evaluate-Print-Loop (REPL) pattern
 */
public class User {
    /**
     * The collection of data structures.
     * Should contain only Stacks, Queues, and Deques which all extend ArrayList.
     * Since this program accepts user input, only Strings will be accepted.
     */
    private ArrayList<ArrayList<String>> collection;

    /**
     * Shows how to use the program
     */
    private final static String helpString =
        "Available commands:" +System.lineSeparator()+
        "- add <stack|queue|deque> <comma-separated collection of items>:" +System.lineSeparator()+
        "- list" +System.lineSeparator()+
        "- remove <item index>" +System.lineSeparator()+
        "- addData <item index> <comma-separated collection of items>:" +System.lineSeparator()+
        "- print <item index>" +System.lineSeparator()+
        "- exit" + System.lineSeparator();

    /**
     * Read-Evaluate-Print-Loop
     * A standard form for an interactive interpreter
     */
    public void REPL() {
        String input = "";
        String output;
        collection = new ArrayList<>();

        while (!input.contains(mainCommand.EXIT.toString())) {
            output = "";
            // Read
            input = IO.readln(
                helpString +
                "DSprogassn1> "
            ).trim();
            String[] commandParts = input.split("\\s+", 3);

            // Evaluate
            mainCommand command = readCommand(commandParts[0]);
            switch (command) {
                case mainCommand.ADD -> {
                    // add should have
                    // 1. add, 2. datatype, 3. items
                    if (commandParts.length < 3) {
                        break;
                    }
                    Integer newCollectionSize = addItem(
                        commandParts[1], // this should contain the type of object to create
                        itemStringToArrayList(commandParts[2]) // this should contain a comma separated list of strings
                    );

                    // Should look something like
                    // stack 3 created
                    output = commandParts[1] + " " + newCollectionSize.toString() + " created";
                }
                case mainCommand.REMOVE -> {
                    // remove should have an index
                    if (commandParts.length < 2) {
                        break;
                    }
                    Integer indexToRemove = parseIndex(commandParts[1]);
                    if (indexToRemove != null) {
                        collection.remove(indexToRemove.intValue()); // this one was a pain to debug
                    }
                }
                case mainCommand.ADDDATA -> {
                    if (commandParts.length < 3) {
                        break;
                    }
                    Integer indexToAddTo = parseIndex(commandParts[1]);
                    ArrayList<String> inputElements = itemStringToArrayList(commandParts[2]);
                    addElementToItem(indexToAddTo, inputElements);
                }
                case mainCommand.LIST -> listItems(listCollection());
                case mainCommand.PRINT -> {
                    if (commandParts.length < 2) {
                        break;
                    }
                    Integer indexToPrint = parseIndex(commandParts[1]);
                    if (indexToPrint != null) {
                        output = printItem(collection.get(indexToPrint));
                    }
                }
                // I decided to leave in the help stub command in case
                // I decide to add the help text present in the prompt to a help command
                case mainCommand.HELP -> output = "";
                // do nothing; expected to exit
                case mainCommand.EXIT -> output = "";
            }

            // Print the output
            IO.println(output + System.lineSeparator());
        }
    }

    /**
     * Enumerates available commands
     */
    private enum mainCommand {
        /** Add data to an existing object */
        ADD,

        /** Add data to an existing object */
        ADDDATA,

        /** Remove an object */
        REMOVE,

        /** Remove data from an existing object */
        REMOVEDATA,

        /** List existing objects */
        LIST,       //

        /** Print the contents of an object */
        PRINT,

        /** Exit program */
        EXIT,

        /** TODO: Print help text */
        HELP;

        /**
         *
         * @return a string representaiton of the constant enumeration
         */
        public String toString() {
            return switch (this) {
                case ADD -> "add";
                case ADDDATA -> "addData";
                case REMOVE -> "remove";
                case REMOVEDATA -> "removeData";
                case LIST -> "list";
                case PRINT -> "print";
                case EXIT -> "exit";
                case HELP -> "help";
            };
        }
    }

    /**
     * Reads in unsanitized user input and returns the user's expected command
     * @param userInput this is expected to be a string provided by a user containing a command and data for the command
     * @return the command the user intends
     */
    private mainCommand readCommand(String userInput) {
        if (userInput.contains(mainCommand.EXIT.toString())) {
            return mainCommand.EXIT;
        }
        else if (userInput.contains(mainCommand.ADDDATA.toString())) {
            return mainCommand.ADDDATA;
        }
        else if (userInput.contains(mainCommand.ADD.toString())) {
            return mainCommand.ADD;
        }
        else if (userInput.contains(mainCommand.REMOVE.toString())) {
            return mainCommand.REMOVE;
        }
        else if (userInput.contains(mainCommand.LIST.toString())) {
            return mainCommand.LIST;
        }
        else if (userInput.contains(mainCommand.PRINT.toString())) {
            return mainCommand.PRINT;
        }
        return  mainCommand.HELP;
    }

    /**
     * Creates a new data structure containing items specified by user
     * @param collectionType The data structure the user intends to create
     * @param newItemCollection the collection in which the new item should be held
     * @return the last index of the collection
     */
    Integer addItem(String collectionType, ArrayList<String> newItemCollection) {
        // Our implemented classes extend ArrayList,
        // so we can declare this new item as an ArrayList before instantiation
        ArrayList<String> newItem = switch (collectionType.toLowerCase()) {
            case "stack" -> new Stack<>();
            case "queue" -> new Queue<>();
            case "deque" -> new Deque<>();
            default -> new Deque<>(); // just do a deque if there's somehow invalid input
        };

        // Since all our custom classes extend ArrayList, we can use ArrayList's addAll
        newItem.addAll(newItemCollection);

        // Add the new Stack, Queue, or Deque to the collection
        // And return the new size of the collection for printing
        collection.add(newItem);
        return collection.size()-1;
    }

    /**
     * Process a user-inputted string defining a list of items into an ArrayList
     * @param itemString a comma-separated list of items a user would like in a collection
     * @return the user-inputted strings as an ArrayList
     */
    static ArrayList<String> itemStringToArrayList(String itemString) {
        return new ArrayList<>(Arrays.asList(itemString.trim().split(",")));
    }

    /**
     * Prints a given ArrayList of strings.
     * Meant to be used with listCollection()
     * @param items items to be printed to stdout
     */
    private void listItems(ArrayList<String> items) {
        for (String item : items) {
            IO.println(item);
        }
    }

    /**
     * Return a string containing the list of structures in our collection along with its type, and size
     * @return collection type, item index, item size
     */
    private ArrayList<String> listCollection() {
        /* Defines the string representation of an item to be printed
        / Item key: %d
        / Item size: %d
        */
        String collectionItemFormatString = "Item: %s %d, Size: %d";
        ArrayList<String> collectionRepresentation = new ArrayList<>();

        for (int index = 0; index < collection.size(); index++) {
            collectionRepresentation.add(
                    String.format(
                            collectionItemFormatString,
                            collection.get(index).getClass(),
                            index,
                            collection.get(index).size()
                    )
            );
        }

        return collectionRepresentation;
    }

    /**
     * Validates that the user has inputted a valid index
     * @param potentialIndex a string containing a valid index to an item in the collection
     * @return a validated index if a valid integer is inputted, otherwise null
     */
    private Integer parseIndex(String potentialIndex) {
        int returnIndex;
        // Validate that the inputted index represents an integer
        // Return null
        try {
            returnIndex = Integer.parseInt(potentialIndex);
        } catch (NumberFormatException e) {
            return null;
        }

        // return null for invalid index numbers
        if (returnIndex < 0 || returnIndex > collection.size()) {
            return null;
        }

        return returnIndex;
    }

    /**
     * Prints the contents of a collection
     * @param collectionItem a Stack, Queue or Deque (or anything that is ArrayList shaped)
     * @return the contents of a stack, queue, or deque as returned by its iterator separated by line separators
     */
    private String printItem(ArrayList<String> collectionItem) {

        // Create copy of item, since popping from queue, dequeuing is destructive
        ArrayList<String> itemCopy = switch (collectionItem) {
            case Stack<String> stack -> new Stack<>(stack);
            case Queue<String> queue -> new Queue<>(queue);
            case Deque<String> deque -> new Deque<>(deque);
            default -> new Deque<>(collectionItem);
        };

        // turns out there's a warning about concatenating plain strings in a loop
        // so StringBuilder should be used here
        StringBuilder generatedOutput = new StringBuilder();
        for (String elementOfItem : itemCopy) {
            generatedOutput.append(elementOfItem).append(System.lineSeparator());
        }
        return generatedOutput.toString();
    }

    /**
     * Adds a user-submitted list of elements to a collection
     * @param itemIndex the index of the item that will have data added
     * @param inputElements the data to be added to
     */
    private void addElementToItem(int itemIndex, ArrayList<String> inputElements) {
        for (String inputElement : inputElements) {
            collection.get(itemIndex).add(inputElement);
        }
    }
}