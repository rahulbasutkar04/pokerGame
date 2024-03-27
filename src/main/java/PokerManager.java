public class PokerManager {

    private int deck;
    public PokerManager(int deck) {
        this.deck=deck;
    }


    public void assignDeckToPlayer(int numberOfDeck) throws InvalidNumberOfDeckException {
        if(numberOfDeck<=0) throw new InvalidNumberOfDeckException("zero or less than this can not be allocate.");
        if(numberOfDeck>1) throw new InvalidNumberOfDeckException("More than one deck can not allocate.");
         deck--;
    }

    public int getDeck() {
        return deck;
    }
}
