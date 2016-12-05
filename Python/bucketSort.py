def bucketSort(A):
	bucket = [[]]  # create an empty bucket

	# put array elements in different buckets
	for i in range(0, len(A)):
		bucket_index = len(A) * A[i]
		bucket[bucket_index] = bucket_index


	return bucket

arr = [0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434]
arr = bucketSort(arr)

print arr	
