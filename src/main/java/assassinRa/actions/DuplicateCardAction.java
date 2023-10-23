package assassinRa.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

public class DuplicateCardAction extends AbstractGameAction {
    private AbstractPlayer player;
    private int copiesAmount;
    private CardGroup fromGroup;
    private CardGroup toGroup;

    public DuplicateCardAction(AbstractPlayer player, int copiesAmount, CardGroup fromGroup, CardGroup toGroup) {
        this.player = player;
        this.actionType = ActionType.CARD_MANIPULATION; // Adjust the action type as needed
        this.duration = Settings.ACTION_DUR_XFAST;
        this.copiesAmount = copiesAmount;
        this.fromGroup = fromGroup;
        this.toGroup = toGroup;
    }

    @Override
    public void update() {
        if (duration == Settings.ACTION_DUR_XFAST) {
            if (!fromGroup.isEmpty()) {
                // Open the card selection screen
                AbstractDungeon.gridSelectScreen.open(fromGroup, 1, "Select a card to duplicate.", false);

                this.tickDuration();
                return;
            }
        } else {
            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                // Duplicate the selected card
                AbstractCard selectedCard = AbstractDungeon.gridSelectScreen.selectedCards.get(0).makeStatEquivalentCopy();
                if(toGroup.type == CardGroup.CardGroupType.DRAW_PILE){
                    addToTop(new MakeTempCardInDrawPileAction(selectedCard, copiesAmount, true, true));
                }
                else if(toGroup.type == CardGroup.CardGroupType.DISCARD_PILE){
                    addToTop(new MakeTempCardInDiscardAction(selectedCard, copiesAmount));
                }
                else if(toGroup.type == CardGroup.CardGroupType.HAND){
                    addToTop(new MakeTempCardInHandAction(selectedCard, copiesAmount));
                }

                // Reset the grid select screen
                AbstractDungeon.gridSelectScreen.selectedCards.clear();
            }
        }
        this.isDone = true;
    }
}