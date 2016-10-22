def win_simple_recursive(A, B, C):
	# if 2/3 piles are empty than you win right away b/c you take all that is left
	if not A and not B and C:
		return True
	if not A and B and not C:
		return True
	if A and not B and not C:
		return True

	# Go through pile A and check cases
	for i in range(1, A + 1):
		if not win_simple_recursive(A - i, B, C):
			return True
		# Go through pile B and check cases
	for j in range(1, B + 1):
		if not win_simple_recursive(A, B - j, C):
			return True
		#  Go through pile C and check cases
	for k in range(1, C + 1):
		if not win_simple_recursive(A, B, C - k):
			return True
	return False

def win_memo_recursive(A, B, C, cache):
	# if 2/3 piles are empty than you win right away b/c you take all that is left
	if not A and not B and C:
		return True
	if not A and B and not C:
		return True
	if A and not B and not C:
		return True

	# Check if visited
	if not cache[A, B, C]:
		# Go through pile A and check cases
		for i in range(1, A + 1):
			if not win_memo_recursive(A - i, B, C, cache):
				return True
			# Go through pile B and check cases
		for j in range(1, B + 1):
			if not win_memo_recursive(A, B - j, C, cache):
				return True
			#  Go through pile C and check cases
		for k in range(1, C + 1):
			if not win_memo_recursive(A, B, C - k, cache):
				return True
	return False


def memoize(memo_function):
	# Store visited values
	cache = {}


	def helper(x, y, z):  # Using decorator to to check visited values

		# Initializing the list/dictionary
		for i in range(x + 1):
			for j in range(y + 1):
				for k in range(z + 1):
					cache[i, j, k] = False
		# if (x and y and z) not in cache: # If not visited
		if [(x, y, z)] != cache.keys():
			cache[x, y, z] = memo_function(x, y, z, cache)
		return cache[x, y, z]

	return helper


def win_dp(A, B, C):  # win dynamic programming approach
	# Using a dictionary to simulate a 3d array/list
	cache = {}

	# Initializing the list/dictinoary
	for i in range(A + 1):
		for j in range(B + 1):
			for k in range(C + 1):
				cache[i, j, k] = False

	# Scan the whole list (3d list)
	for x in range(0, A + 1):
		for y in range(0, B + 1):
			for z in range(C + 1):
				if x == 0 and y == 0 and z == 0:  # Ignore the origin
					continue

				# Scan the list in the x direction when thinking of it as a grid
				for i in range(1, x + 1):
					if not cache[x - i, y, z]:
						cache[x, y, z] = True
						break

				# Scan the list in the y direction when thinking of it as a grid
				if not cache[x, y, z]:
					for j in range(1, y + 1):
						if not cache[x, y - j, z]:
							cache[x, y, z] = True
							break

				# Scan the list in the z direction when thinking of it as a grid
				if not cache[x, y, z]:
					for k in range(1, z + 1):
						if not cache[x, y, z - k]:
							cache[x, y, z] = True
							break

	return cache[A, B, C]


def test_small_problems(run_problem_this_many_times, max_pile_size):
	import random
	matches = {}  # Stores the results of the functions

	#  Runs the function the number this many times
	for i in range(run_problem_this_many_times):
		#  Generate new pile size
		a = random.randint(1, max_pile_size)
		b = random.randint(1, max_pile_size)
		c = random.randint(1, max_pile_size)
		print "testing with values: " + str(a) + " " + str(b) + " " + str(c)

		#  The variables below are acronyms to the methods they call
		wsr = win_simple_recursive(a, b, c)
		wd = win_dp(a, b, c)

		# To keep track of position memoize receives function win_simple_recursive
		win_memoizing = memoize(win_memo_recursive)
		wm = win_memoizing(a, b, c)

		#  Store results for viewing
		matches[a, b, c] = [wsr, wm, wd]
		if wsr == wm == wd:
			print "They all returned the same thing: " + str(wsr)
		else:
			print "NOT A MATCH, A = " + str(a) + " B = " + str(b) + " C = " + str(c)

	print "Matches"
	print matches


def test_large_problems(run_problem_this_many_times, max_pile_size):
	import random
	matches = {}  # Stores the results of the functions

	#  Runs the function the number this many times
	for i in range(run_problem_this_many_times):
		#  Generate new pile size
		a = random.randint(1, max_pile_size)
		b = random.randint(1, max_pile_size)
		c = random.randint(1, max_pile_size)
		print "testing with values: " + str(a) + " " + str(b) + " " + str(c)

		#  The variables below are acronyms to the methods they call
		wd = win_dp(a, b, c)

		# To keep track of position memoize receives function win_memo
		win_memoizing = memoize(win_memo_recursive)
		wm = win_memoizing(a, b, c)

		#  Store results for viewing
		matches[a, b, c] = [wm, wd]
		if wm == wd:
			print "They all returned the same thing: " + str(wm)
		else:
			print "NOT A MATCH, A = " + str(a) + " B = " + str(b) + " C = " + str(c)

	print "Matches"
	print matches


if __name__ == "__main__":
	print "Starting Small problems"
	test_small_problems(run_problem_this_many_times=100, max_pile_size=5)
	print "Starting Large Problems"
	test_large_problems(run_problem_this_many_times=100, max_pile_size=9)
	print "Done"
