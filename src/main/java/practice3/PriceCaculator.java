package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {
    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    private BigDecimal subTotal;

    public PriceCaculator(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts, BigDecimal tax, BigDecimal subTotal) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = tax;
        this.subTotal = subTotal;
    }

    public BigDecimal caculator(){
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }

        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }

        return subTotal.add(subTotal.multiply(tax));
    }


}
