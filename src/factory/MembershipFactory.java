package factory;

import entities.Membership;

public class MembershipFactory {

    public static Membership createMembership(String type) {
        if (type.equalsIgnoreCase("monthly")) {
            return new Membership.Builder()
                    .type("Monthly")
                    .duration(30)
                    .price(50)
                    .build();
        } else if (type.equalsIgnoreCase("yearly")) {
            return new Membership.Builder()
                    .type("Yearly")
                    .duration(365)
                    .price(500)
                    .build();
        }
        return null;
    }
}
