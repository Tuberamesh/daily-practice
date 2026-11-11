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
        
#program no 155
#time complexity O(1)
#space complexity O(n)
def push(self, val: int) -> None:
        self.stack.append(val)

        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        val = self.stack.pop()

        if val == self.min_stack[-1]:
            self.min_stack.pop()