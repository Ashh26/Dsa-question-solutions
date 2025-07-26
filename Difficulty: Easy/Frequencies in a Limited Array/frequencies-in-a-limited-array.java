class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        // code here
       int n = arr.length;
        int[] freq = new int[n + 1]; // use 1-based indexing

        for (int num : arr) {
            if (num >= 1 && num <= n) {
                freq[num]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(freq[i]);
        }

        return result;
    }
}
