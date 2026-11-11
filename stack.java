#program no 739
#time complexity O(n)
#space complexity O(n)
class Solution(object):
    def dailyTemperatures(self, temperatures):
        n=len(temperatures)

        ans=[0]*n
        stack=[]

        for i in range(n):
            while stack and temperatures[i]>temperatures[stack[-1]]:
                prev=stack.pop()
                ans[prev]=i-prev
            
            stack.append(i)

        return ans
        