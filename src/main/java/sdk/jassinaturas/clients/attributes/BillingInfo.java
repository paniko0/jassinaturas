package sdk.jassinaturas.clients.attributes;

import java.util.List;

public class BillingInfo {
    private CreditCard creditCard;
    private List<CreditCard> creditCards;

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public BillingInfo withCreditCard(final CreditCard creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    @Override
    public String toString() {
        return "BillingInfo [creditCard=" + creditCard + ", creditCards=" + creditCards + "]";
    }

}
