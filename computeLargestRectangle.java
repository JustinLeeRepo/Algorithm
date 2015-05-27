public static int computeLargestRectangle(List<Integer> A){
	Stack<Integer> s = new Stack<>();
	int result = Integer.MIN_VALUE;

	for(int i = 0; i < A.size(); i++){
		while(!s.isEmpty()){
			s.push(i);
		}
	}
	return result;	
}