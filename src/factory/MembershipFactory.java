package factory;

import fitnessclub.domain;

public class MembershipFactory {

    public static domain.Membership createMembership(String type) {
        if (type.equalsIgnoreCase("monthly")) {
            return new domain.Membership.Builder()
                    .type("Monthly")
                    .duration(30)
                    .price(50)
                    .build();
        } else if (type.equalsIgnoreCase("yearly")) {
            return new domain.Membership.Builder()
                    .type("Yearly")
                    .duration(365)
                    .price(500)
                    .build();
        }
        return null;
    }
}
