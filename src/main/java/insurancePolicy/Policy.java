package insurancePolicy;

import java.util.Date;

public class Policy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor to initialize the policy
    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getter methods
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate
                + ", Coverage Type: " + coverageType + ", Premium Amount: " + premiumAmount;
    }

    // equals and hashCode methods to compare policies based on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}
