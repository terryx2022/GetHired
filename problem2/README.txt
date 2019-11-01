* Solution:
	- This is an in-place linear-time solution after converting the input text to an string array (splitted by space " ")
	- No need for additional data structure if input is already a string array
* Specifics
	- Uses a "fast" pointer to linearly scan the array, during which the desired pattern (successive duplicate) will be found.
	- Swaps all desired pattern to the front of the array, and uses a "slow" pointer to keep track of where the result subarray ends.
* Complexity: (n is the number of strings)
	- Time: linear scan -> O(n)
	- Space: in-place operation -> O(1)

* Implementation:
	- There are two versions of implementation (Java, PHP), which both include unit tests.
	- My primary language is Java so I first solved the problem with Java and made sure it worked
	- Then I learned PHP on demand as you preferred and developed another implementation.
