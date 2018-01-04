package spil;

public class ModelController {
    private static final ModelController modelController = new ModelController();
    private Player[] players;
    private Board board;
    private Dice dice;

    private ModelController(){}

    public static ModelController getInstance()
    {
        return modelController;
    }

    public Board getBoard() {
        return board;
    }
}
