static class Symbol{
	public double freq;
	public char s;
	public String bitPattern;

	public static class BTree extends Comparable<Btree>{
		double freq;
		Symbol s;
		BTree left, right;

		public BTree(double d, Symbol sym, BTree l, BTree r){
			freq = d;
			s = sym;
			left = l;
			right = r;
		}


		@override
		public int compareTo(BTree b){
			return Double.compare(freq, b.freq);
		}

		public static void huffmanEncoding(List<Symbol> symbols){
			PriorityQueue<Btree> minHeap = new PriorityQueue<>();
			
			for(Symbol s : symbols){
				minHeap.add(new BTree(s.freq, s, null, null))
			}
			while(minHeap.size() > 1){
				BTree l = minHeap.remove();
				BTree r = minHeap.remove();
				minHeap.add(l.freq + r.freq, null, null);
			}
		}

		public static void assign(BTree root, String str){
			if(root != null){
				//leaf
				if(root.s != null){
					root.s.bitPattern = str;
				}
				else {
					assign(root.left, str + "0");
					assign(root.right, str + "1");
				}
			}
		}
	}

}