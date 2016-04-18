public void sort(Comparable[] a) {
  shuffle(a); //  这个非常重要哦；
  int N = a.length;
  sort(a, 0, N - 1);
}
private void sort(Comparable[] a, int low, int high) {
  if (high <= low) return;
  int j = partition(a, low, high);
  sort(a, low, j - 1);
  sort(a, j+1, high);  //虽然影响不大，但是j可以不包含在任何一部分中
}

private int partition(Comparable[] a, int low, int high) {
  /*int*/ Comparable pivot = a[low];
  int i = low;
  int j = high + 1;
  while(true) {
    while(less(a[++i],pivot)) {
      if (i == high) break;
    }
    while(less(pivot, a[--j])) {
      if (j == low) break;
    }
     
    if (i >= j) break;
    swap(a, i ,j);
  }
  swap(a, low, j);
}