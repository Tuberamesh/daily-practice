
#problem 16
#code to find the sum of three integers in an array that is closest to a given target
#time complexity: O(n^2), where n is the length of the input array. We sort the array in O(n log n) time and then use a two-pointer approach to find the closest sum in O(n^2) time.
#space complexity: O(1), as we are using a constant amount of extra space.
class Solution:
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        nums.sort()
        closest = float('inf')

        for i in range(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1

            while left < right:
                total = nums[i] + nums[left] + nums[right]

                if abs(total - target) < abs(closest - target):
                    closest = total

                if total < target:
                    left += 1
                elif total > target:
                    right -= 1
                else:
                    return total

        return closest

#problem 17
#code to find all possible letter combinations that the number could represent on a phone keypad
#time complexity: O(4^n * n), where n is the length of the input digits. The maximum number of combinations is 4^n, and for each combination, we spend O(n) time to build the string.
#space complexity: O(n), where n is the length of the input digits. The space used by the recursion stack can go up to n in the worst case.
class Solution:
    def letterCombinations(self, digits: str) -> list[str]:

        if not digits:
            return []

        phone = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }

        result = []

        def backtrack(index, current):

            if index == len(digits):
                result.append(current)
                return

            letters = phone[digits[index]]

            for letter in letters:
                backtrack(index + 1, current + letter)

        backtrack(0, "")

        return result