int factorial_loop(int x) {
	
	if(x < 2) {
		return 1; // 0! = 1
	}
	int total = 1;
	for(int i = x; i > 1; i--) {
		total = total * i;
	}
	
	return  total;
}

int factorial_recursive(int x) {
	
	if(x < 2) {
		return 1;
	}
	
	return x * factorial_recursive(x - 1);
}
