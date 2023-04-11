package command;

import command.addCommand.*;
import command.deleteCommand.*;
import command.editCommand.*;
import command.filter.*;

import java.util.HashMap;

import static servlet.Constants.*;

public final class CommandFactory {
    public static final String CATEGORY_EDIT_COMMAND = "categoryEditCommand";
    public static final String PRODUCER_EDIT_COMMAND = "producerEditCommand";
    public static final String MODEL_EDIT_COMMAND = "modelEditCommand";
    public static final String TYPE_EDIT_COMMAND = "typesEditCommand";
    public static final String STORE_EDIT_COMMAND = "storeEditCommand";
    public static final String TECH_EDIT_COMMAND = "techEditCommand";
    public static final String CATEGORY_ADD_COMMAND = "categoryAddCommand";
    public static final String MODEL_ADD_COMMAND = "modelAddCommand";
    public static final String TYPE_ADD_COMMAND = "typeAddCommand";
    public static final String PRODUCER_ADD_COMMAND = "producerAddCommand";
    public static final String STORE_ADD_COMMAND = "storeAddCommand";
    public static final String TECH_ADD_COMMAND = "techAddCommand";
    public static final String MODEL_DELETE_COMMAND = "modelDeleteCommand";
    public static final String PRODUCER_DELETE_COMMAND = "producerDeleteCommand";
    public static final String CATEGORY_DELETE_COMMAND = "categoryDeleteCommand";
    public static final String STORE_DELETE_COMMAND = "storeDeleteCommand";
    public static final String TYPE_DELETE_COMMAND = "typeDeleteCommand";
    public static final String TECH_DELETE_COMMAND = "techDeleteCommand";
    public static final String FIND_BY_CATEGORY = "findByCategory";
    public static final String FIND_BY_PRICE = "findByPrice";
    public static final String FIND_BY_MODEL = "findByModel";
    public static final String FIND_BY_PRODUCER = "findByProducer";
    public static final String SORT_ASC = "SortAsc";
    private static CommandFactory instance;
    private static final HashMap<String, Command> commands = new HashMap<>();

    private CommandFactory(){
        commands.put(CATEGORY_EDIT_COMMAND, new CategoryEditCommand());
        commands.put(PRODUCER_EDIT_COMMAND, new ProducerEditCommand());
        commands.put(SELECT,new SelectCommand());
        commands.put(TYPE_EDIT_COMMAND,new TypesEditCommand());
        commands.put(CATEGORY_DELETE_COMMAND, new CategoryDeleteCommand());
        commands.put(CATEGORY_ADD_COMMAND, new CategoryAddCommand());
        commands.put(PRODUCER_DELETE_COMMAND, new ProducerDeleteCommand());
        commands.put(PRODUCER_ADD_COMMAND, new ProducerAddCommand());
        commands.put(TYPE_ADD_COMMAND, new TypeAddCommand());
        commands.put(TYPE_DELETE_COMMAND, new TypeDeleteCommand());
        commands.put(MODEL_ADD_COMMAND, new ModelAddCommand());
        commands.put(MODEL_DELETE_COMMAND, new ModelDeleteCommand());
        commands.put(MODEL_EDIT_COMMAND, new ModelEditCommand());
        commands.put(TECH_ADD_COMMAND, new TechniqueAddCommand());
        commands.put(TECH_DELETE_COMMAND, new TechniqueDeleteCommand());
        commands.put(TECH_EDIT_COMMAND, new TechEditCommand());
        commands.put(SORT_ASC, new SortAscCommand());
        commands.put(STORE_ADD_COMMAND, new StoreAddCommand());
        commands.put(STORE_DELETE_COMMAND, new StoreDeleteCommand());
        commands.put(STORE_EDIT_COMMAND, new StoreEditCommand());
        commands.put(FIND_BY_CATEGORY, new FindByCategoryCommand());
        commands.put(FIND_BY_MODEL, new FindByModelCommand());
        commands.put(FIND_BY_PRICE, new FindByPrice());
        commands.put(FIND_BY_PRODUCER, new FindByProducerCommand());
    }
    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(String value) {
        return commands.get(value);
    }
}
