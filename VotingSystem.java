package collections;

import java.util.*;

public class VotingSystem {

    HashMap<String, Integer> voteCountMap = new HashMap<>();
    LinkedHashMap<String, String> voterMap = new LinkedHashMap<>();

    public void castVote(String voterName, String candidateName) {
        if (voterMap.containsKey(voterName)) {
            System.out.println("Voter " + voterName + " has already voted.");
            return;
        }

        voterMap.put(voterName, candidateName);
        voteCountMap.put(candidateName, voteCountMap.getOrDefault(candidateName, 0) + 1);
        System.out.println("Vote casted by " + voterName + " for " + candidateName);
    }

    public void showVotingOrder() {
        System.out.println("\nVoting Order:");
        for (Map.Entry<String, String> entry : voterMap.entrySet()) {
            System.out.println(entry.getKey() + " voted for " + entry.getValue());
        }
    }

    public void showResultsSortedByCandidate() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCountMap);
        System.out.println("\nVoting Results (Sorted by Candidate):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice", "John");
        votingSystem.castVote("Bob", "Alice");
        

        votingSystem.showVotingOrder();
        votingSystem.showResultsSortedByCandidate();
    }
}

