package insurancePolicy;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class InsurancePolicyManager {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    // Constructor for InsurancePolicyManager
    public InsurancePolicyManager() {
        // Initialize if needed (currently no initialization required)
    }

    // 1. Add Policy
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // 2. Retrieve all unique policies
    public void retrieveAllPolicies() {
        System.out.println("HashSet Policies: ");
        hashSet.forEach(System.out::println);
        System.out.println("LinkedHashSet Policies: ");
        linkedHashSet.forEach(System.out::println);
        System.out.println("TreeSet Policies: ");
        treeSet.forEach(System.out::println);
    }

    // 3. Retrieve policies expiring soon (within the next 30 days)
    public void retrieveExpiringPolicies() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date futureDate = calendar.getTime();

        System.out.println("Policies expiring soon (within 30 days): ");
        for (Policy policy : hashSet) {
            if (policy.getExpiryDate().before(futureDate)) {
                System.out.println(policy);
            }
        }
    }

    // 4. Retrieve policies based on coverage type
    public void retrievePoliciesByCoverageType(String coverageType) {
        System.out.println("Policies with coverage type " + coverageType + ": ");
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // 5. Retrieve duplicate policies based on policy number
    public void retrieveDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        System.out.println("Duplicate Policies: ");
        for (Policy policy : hashSet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // 6. Performance Comparison (Add, Remove, Search)
    public void comparePerformance() {
        System.out.println("Performance Comparison:");

        // 1. Adding policies (measure time)
        long startTime = System.nanoTime();
        addPolicy(new Policy("P001", "John Doe", new Date(), "Health", 500.0));
        long endTime = System.nanoTime();
        long durationHashSet = endTime - startTime;

        startTime = System.nanoTime();
        addPolicy(new Policy("P002", "Jane Smith", new Date(), "Auto", 300.0));
        endTime = System.nanoTime();
        long durationLinkedHashSet = endTime - startTime;

        startTime = System.nanoTime();
        addPolicy(new Policy("P003", "Mary Johnson", new Date(), "Home", 400.0));
        endTime = System.nanoTime();
        long durationTreeSet = endTime - startTime;

        System.out.println("Add Policy Time (HashSet): " + durationHashSet + " ns");
        System.out.println("Add Policy Time (LinkedHashSet): " + durationLinkedHashSet + " ns");
        System.out.println("Add Policy Time (TreeSet): " + durationTreeSet + " ns");

        // 2. Remove policy (measure time)
        Policy policyToRemove = new Policy("P001", "John Doe", new Date(), "Health", 500.0);
        startTime = System.nanoTime();
        hashSet.remove(policyToRemove);
        endTime = System.nanoTime();
        System.out.println("Remove Policy Time (HashSet): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSet.remove(policyToRemove);
        endTime = System.nanoTime();
        System.out.println("Remove Policy Time (LinkedHashSet): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSet.remove(policyToRemove);
        endTime = System.nanoTime();
        System.out.println("Remove Policy Time (TreeSet): " + (endTime - startTime) + " ns");

        // 3. Search for policy (measure time)
        startTime = System.nanoTime();
        hashSet.contains(policyToRemove);
        endTime = System.nanoTime();
        System.out.println("Search Policy Time (HashSet): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSet.contains(policyToRemove);
        endTime = System.nanoTime();
        System.out.println("Search Policy Time (LinkedHashSet): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSet.contains(policyToRemove);
        endTime = System.nanoTime();
        System.out.println("Search Policy Time (TreeSet): " + (endTime - startTime) + " ns");
    }

    // Main method to run the program
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Add some policies
        manager.addPolicy(new Policy("P001", "John Doe", new Date(), "Health", 500.0));
        manager.addPolicy(new Policy("P002", "Jane Smith", new Date(), "Auto", 300.0));
        manager.addPolicy(new Policy("P003", "Mary Johnson", new Date(), "Home", 400.0));

        // Retrieve all policies
        manager.retrieveAllPolicies();

        // Retrieve policies expiring soon
        manager.retrieveExpiringPolicies();

        // Retrieve policies based on coverage type
        manager.retrievePoliciesByCoverageType("Health");

        // Retrieve duplicate policies
        manager.retrieveDuplicatePolicies();

        // Perform performance comparison
        manager.comparePerformance();
    }
}

