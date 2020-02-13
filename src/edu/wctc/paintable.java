package edu.wctc;

public interface paintable {

    double PREMIUM_PAINT_COST_PER_GALLON = 65.99;

    double STANDARD_PAINT_COST_PER_GALLON = 25.99;

    // Cost to paint using premium paint?

    default double getPremiumCost() {
        return PREMIUM_PAINT_COST_PER_GALLON;
    }

    // Cost to paint using standard paint?


    default double getStandardCost() {
        return STANDARD_PAINT_COST_PER_GALLON;
    }

}

